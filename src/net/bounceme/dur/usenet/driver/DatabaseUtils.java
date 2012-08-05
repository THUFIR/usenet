package net.bounceme.dur.usenet.driver;

import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.*;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;

class DatabaseUtils {

    private static final Logger LOG = Logger.getLogger(DatabaseUtils.class.getName());
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("USENETPU");
    private EntityManager em = emf.createEntityManager();

    public int getMax(Folder folder) {
        int max = 0;
        String ng = folder.getFullName();
        String queryString = "select max(article.messageNumber) from Article article left join article.newsgroup newsgroup where newsgroup.newsgroup = '" + ng + "'";
        try {
            max = (Integer) em.createQuery(queryString).getSingleResult();
        } catch (Exception e) {
            LOG.info("setting max to zero");
        }
        LOG.severe(folder.getFullName() + "\t" + max);
        return max;
    }

    public void persistArticle(Message message, Folder folder) {
        em.getTransaction().begin();
        String fullNewsgroupName = folder.getFullName();
        Newsgroup newsgroup = null;
        int max = getMax(folder);
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
        }
        Article article = new Article(message, newsgroup);
        em.persist(article);
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();//necessary?
    }
}
