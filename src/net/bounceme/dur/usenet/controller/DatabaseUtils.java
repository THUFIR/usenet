package net.bounceme.dur.usenet.controller;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.persistence.*;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;
import net.bounceme.dur.usenet.model.Usenet;

public enum DatabaseUtils {

    INSTANCE();
    private static final Logger LOG = Logger.getLogger(DatabaseUtils.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("USENETPU");
    private EntityManager em = emf.createEntityManager();
    private Usenet u = Usenet.INSTANCE;

    public void rebuild() throws Exception {
        LOG.info("starting..");
        em.getTransaction().begin();
        List<Folder> folders = u.getFolders();
        for (Folder folder : folders) {
            Newsgroup newsgroup = new Newsgroup(folder);
            List<Message> messages = u.getMessages(newsgroup);
            for (Message message : messages) {
                Article article = new Article(message, newsgroup);
                persistArticle(article, newsgroup);
            }
        }
        em.getTransaction().commit();
        LOG.info("..finished");
    }

    public List<Newsgroup> getNewsgroups() {
        String queryString = "select n from Newsgroup n";
        TypedQuery<Newsgroup> query = em.createQuery(queryString, Newsgroup.class);
        List<Newsgroup> newsgroups = query.getResultList();
        LOG.fine(newsgroups.toString());
        return newsgroups;
    }

    private void persistNewsgroup(Newsgroup newsgroup) {
        LOG.fine("trying" + newsgroup);
        List<Newsgroup> newsgroups = getNewsgroups();
        boolean unique = true;
        for (Newsgroup n : newsgroups) {
            if (n.getNewsgroup().equals(newsgroup.getNewsgroup())) {
                unique = false;
            }
        }
        if (unique) {
            em.persist(newsgroup);
            LOG.fine("persisted" + newsgroup);
        }
    }

    //SELECT MAX(MESSAGENUMBER) FROM articles LEFT OUTER JOIN newsgroups ON articles.NEWSGROUP_ID=newsgroups.ID  WHERE newsgroups.NEWSGROUP = "gwene.com.economist";
    public int getMaxMessageNumber(Newsgroup newsgroup) {
        int maxMessageNumber = 0;
        String queryString = "select max(article.messageNumber) from Article article left join article.newsgroup newsgroup where newsgroup.newsgroup = '" + newsgroup + "'";
        try {
            maxMessageNumber = (Integer) em.createQuery(queryString).getSingleResult();
        } catch (Exception e) {
            LOG.severe("setting max to zero for " + newsgroup);
        }
        LOG.fine(newsgroup + "\t" + maxMessageNumber);
        return maxMessageNumber;
    }

    //SELECT * FROM articles LEFT OUTER JOIN newsgroups ON articles.NEWSGROUP_ID=newsgroups.ID  WHERE newsgroups.NEWSGROUP = "gwene.com.economist" AND articles.ID BETWEEN 450 AND 500;   
    public List<Article> getRangeOfArticles(Page page) {
        String fullNewsgroupName = page.getFolderFullName();
        int minRange = page.getMin();
        int maxRange = page.getMax();
        String queryString = "select article from Article article left join article.newsgroup newsgroup where newsgroup.newsgroup = :newsGroupParam and article.messageNumber between :minRange and :maxRange";
        TypedQuery<Article> query = em.createQuery(queryString, Article.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        query.setParameter("minRange", minRange);
        query.setParameter("maxRange", maxRange);
        List<Article> articles = query.getResultList();
        return articles;
    }

    private void persistArticle(Article article, Newsgroup newsgroup) throws NonUniqueResultException, NoResultException, IOException, MessagingException {
        persistNewsgroup(newsgroup);
        String fullNewsgroupName = newsgroup.getNewsgroup();
        String queryString = "select article from Article article left join article.newsgroup newsgroup where newsgroup.newsgroup = :newsGroupParam";
        TypedQuery<Article> query = em.createQuery(queryString, Article.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        List<Article> articles = query.getResultList();
        boolean unique = true;
        for (Article a : articles) {
            if (a.getMessageNumber() == article.getMessageNumber()) {
                unique = false;
            }
        }
        if (unique) {
            em.persist(article);
        }
        LOG.fine("\n\n\narticle\n" + article);
    }

    public void close() {
        em.close();
        emf.close();//necessary?
    }
}
