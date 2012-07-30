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
import net.bounceme.dur.usenet.model.Articles;
import net.bounceme.dur.usenet.model.Newsgroups;
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
        List<Newsgroups> subscribed = getFolders();
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();
        for (Newsgroups newsgroup : subscribed) {
            persistNewsgroups(em, newsgroup);
        }
        for (Newsgroups n : subscribed) {
            LOG.info("******" + n);
            List<Message> messages = u.getMessages(n.getNewsgroup());
            LOG.info(messages.size()+ " messages");
            for (Message message : messages) {
                LOG.info("message "+ message.getMessageNumber());
                Articles article = new Articles(message);                
                persistArticles(em, article);
            }
        }
        em.close();
    }

    private void persistArticles(EntityManager em, Articles article) {
        LOG.fine(article.toString());
        TypedQuery<Articles> query = em.createQuery("SELECT a FROM Articles a", Articles.class);
        List<Articles> results = query.getResultList();
        if (isUniqueArticle(article, results)) {
            em.getTransaction().begin();
            em.persist(article);
            em.getTransaction().commit();
        }
    }

    private void persistNewsgroups(EntityManager em, Newsgroups newNewsgroup) {
        LOG.fine(newNewsgroup.toString());
        TypedQuery<Newsgroups> query = em.createQuery("SELECT n FROM Newsgroups n", Newsgroups.class);
        List<Newsgroups> results = query.getResultList();
        if (isUniqueNewsgroup(newNewsgroup, results)) {
            em.getTransaction().begin();
            em.persist(newNewsgroup);
            em.getTransaction().commit();
        }
    }

    private boolean isUniqueNewsgroup(Newsgroups newNewsgroup, Iterable<Newsgroups> results) {
        LOG.fine(results.toString());
        for (Newsgroups existingNewsgroup : results) {
            if ((existingNewsgroup.getNewsgroup().equals(newNewsgroup.getNewsgroup()))) {
                return false;
            }
        }
        LOG.fine(newNewsgroup + "\tnew");
        return true;
    }

    private List<Newsgroups> getFolders() {
        List<Folder> folders = u.getFolders();
        List<Newsgroups> newsgroups = new ArrayList<>();
        for (Folder folder : folders) {
            Newsgroups newsgroup = new Newsgroups(folder);
            newsgroups.add(newsgroup);
        }
        LOG.fine(newsgroups.toString());
        return newsgroups;
    }

    private boolean isUniqueArticle(Articles article, List<Articles> articles) {
        LOG.fine(articles.toString());
        for (Articles a : articles) {
            if (a.getId().equals(article.getId())) {
                return false;
            }
        }
        LOG.fine(article + "\tnew");
        return true;
    }
}
