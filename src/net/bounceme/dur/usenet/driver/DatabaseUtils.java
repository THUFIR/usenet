package net.bounceme.dur.usenet.driver;

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

    public void persistArticle(Message message, Folder folder) {
        //do all the persistence here?
        em.getTransaction().begin();
        String fullNewsgroupName = folder.getFullName();
        Newsgroup newsgroup = null;
        TypedQuery<Newsgroup> query = em.createQuery("SELECT n FROM Newsgroup n WHERE n.newsgroup = :newsGroupParam", Newsgroup.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        try {
            newsgroup = query.getSingleResult();
            LOG.fine("found " + query.getSingleResult()); //ok
        } catch (javax.persistence.NoResultException e) {
            LOG.fine(e + "\ncould not find " + fullNewsgroupName); //ok
            newsgroup = new Newsgroup(folder);
            //it seems like the persist statement never executes...
            em.persist(newsgroup);  //how do I manually persist this?
        } catch (NonUniqueResultException e) {
            LOG.warning("\nshould never happen\t" + fullNewsgroupName); //not ok, should never execute
        }
        //need some mechanism to ensure that newsgroup is never a null reference
        //Newsgroup should never be instantiated with 
        Article article = new Article(message, newsgroup);
        em.persist(article); //never seems to execute..
        em.getTransaction().commit();
    }

    public void close() {
        em.close();
        emf.close();//necessary?
    }
}
