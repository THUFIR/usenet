package net.bounceme.dur.usenet.driver;

import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.*;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;

class DatabaseUtils {

    private static final Logger LOG = Logger.getLogger(DatabaseUtils.class.getName());

    public void persistArticle(Message message, Folder folder) {
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();
        String fullNewsgroupName = folder.getFullName();
        Newsgroup newsgroup = null;
        TypedQuery<Newsgroup> query = em.createQuery("SELECT n FROM Newsgroup n WHERE n.newsgroup = :newsGroupParam", Newsgroup.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        try {
            newsgroup = query.getSingleResult();
            LOG.info("found " + query.getSingleResult()); //ok
        } catch (javax.persistence.NoResultException e) {
            LOG.info("\ncould not find " + fullNewsgroupName); //ok
            newsgroup = new Newsgroup(folder);
            em.persist(newsgroup);
        } catch (NonUniqueResultException e) {
            LOG.info("\nshould never happen\t" + fullNewsgroupName); //not ok
        }
        Article article = new Article(message, newsgroup);//what if newsgroup ==null?
        em.persist(article);
        em.close();
    }
}
