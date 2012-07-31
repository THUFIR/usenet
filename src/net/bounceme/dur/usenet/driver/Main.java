package net.bounceme.dur.usenet.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;
import net.bounceme.dur.usenet.model.Usenet;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private Usenet u = Usenet.INSTANCE;

    public static void main(String[] args) {
        try {
            Main main = new Main();
        } catch (Exception ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Main() throws Exception {
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        List<Newsgroup> subscribed = getFolders();
        em = emf.createEntityManager();
        for (Newsgroup newsgroup : subscribed) {
            persistNewsgroups(em, newsgroup);
            List<Message> messages = u.getMessages(newsgroup.getNewsgroup());
            LOG.fine(newsgroup + "  " + messages.size() + " messages");
            for (Message message : messages) {
                LOG.fine("message " + message.getMessageNumber());
                Article article = new Article(message);
                persistArticle(em, article);
            }
        }
        em.close();
    }

    private boolean isUniqueArticle(Article article, List<Article> articles) {
        LOG.fine(articles.toString());
        for (Article a : articles) {
            if (a.getSubject().equalsIgnoreCase(article.getSubject())) {
                return false;
            }
        }
        LOG.fine("new\t\t" + article);
        return true;
    }

    private void persistArticle(EntityManager em, Article article) {
        LOG.fine(article.toString());
        TypedQuery<Article> query = em.createQuery("SELECT a FROM Article a", Article.class);
        List<Article> results = query.getResultList();
        if (isUniqueArticle(article, results)) {
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
        }
    }

    private void persistNewsgroups(EntityManager em, Newsgroup newNewsgroup) {
        LOG.fine(newNewsgroup.toString());
        TypedQuery<Newsgroup> query = em.createQuery("SELECT n FROM Newsgroup n", Newsgroup.class);
        List<Newsgroup> results = query.getResultList();
        if (isUniqueNewsgroup(newNewsgroup, results)) {
            em.getTransaction().begin();
            em.persist(newNewsgroup);
            em.getTransaction().commit();
        }
    }

    private boolean isUniqueNewsgroup(Newsgroup newNewsgroup, Iterable<Newsgroup> results) {
        LOG.fine(results.toString());
        for (Newsgroup existingNewsgroup : results) {
            if ((existingNewsgroup.getNewsgroup().equals(newNewsgroup.getNewsgroup()))) {
                return false;
            }
        }
        LOG.fine(newNewsgroup + "\tnew");
        return true;
    }

    private List<Newsgroup> getFolders() {
        List<Folder> folders = u.getFolders();
        List<Newsgroup> newsgroups = new ArrayList<>();
        for (Folder folder : folders) {
            Newsgroup newsgroup = new Newsgroup(folder);
            newsgroups.add(newsgroup);
        }
        LOG.fine(newsgroups.toString());
        return newsgroups;
    }
}
