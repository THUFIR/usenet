package net.bounceme.dur.usenet.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.persistence.*;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;
import net.bounceme.dur.usenet.model.Usenet;

class DatabaseUtils {

    private static final Logger LOG = Logger.getLogger(DatabaseUtils.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("USENETPU");
    private EntityManager em = emf.createEntityManager();

    //SELECT MAX(MESSAGENUMBER) FROM articles LEFT OUTER JOIN newsgroups ON articles.NEWSGROUP_ID=newsgroups.ID  WHERE newsgroups.NEWSGROUP = "gwene.com.economist";
    public int getMaxMessageNumber(Folder folder) {
        int maxMessageNumber = 0;
        String newsgroup = folder.getFullName();
        String queryString = "select max(article.messageNumber) from Article article left join article.newsgroup newsgroup where newsgroup.newsgroup = '" + newsgroup + "'";
        try {
            maxMessageNumber = (Integer) em.createQuery(queryString).getSingleResult();
        } catch (Exception e) {
            LOG.severe("setting max to zero for " + newsgroup);
        }
        LOG.fine(folder.getFullName() + "\t" + maxMessageNumber);
        return maxMessageNumber;
    }

    //SELECT * FROM articles LEFT OUTER JOIN newsgroups ON articles.NEWSGROUP_ID=newsgroups.ID  WHERE newsgroups.NEWSGROUP = "gwene.com.economist" AND articles.ID BETWEEN 450 AND 500;   
    public List<Article> getRangeOfArticles(Page page) {
        String fullNewsgroupName = page.getFolder().getFullName();
        int minRange = page.getMin();
        int maxRange = page.getMax();
        //minRange = 554;
        //maxRange = 557;
        String queryString = "select article from Article article left join article.newsgroup newsgroup where newsgroup.newsgroup = :newsGroupParam and article.messageNumber between :minRange and :maxRange";
        TypedQuery<Article> query = em.createQuery(queryString, Article.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        query.setParameter("minRange", minRange);
        query.setParameter("maxRange", maxRange);
        List<Article> articles = query.getResultList();
        return articles;
    }

    public void persistArticle(Message message, Folder folder) {
        em.getTransaction().begin();
        String fullNewsgroupName = folder.getFullName();
        Newsgroup newsgroup = null;
        TypedQuery<Newsgroup> query = em.createQuery("SELECT n FROM Newsgroup n WHERE n.newsgroup = :newsGroupParam", Newsgroup.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        try {
            newsgroup = query.getSingleResult();
            LOG.fine("found " + query.getSingleResult());
        } catch (javax.persistence.NoResultException e) {
            LOG.fine(e + "\ncould not find " + fullNewsgroupName);
            newsgroup = new Newsgroup(folder);
            em.persist(newsgroup);
        } catch (NonUniqueResultException e) {
            LOG.warning("\nshould never happen\t" + fullNewsgroupName);
        } /*
         * finally { if (em.getTransaction().isActive()) {
         * em.getTransaction().rollback(); }
         */
        Article article = new Article(message, newsgroup);
        em.persist(article);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();//necessary?
    }
}
