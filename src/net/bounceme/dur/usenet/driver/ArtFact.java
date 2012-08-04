package net.bounceme.dur.usenet.driver;

import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.*;
import net.bounceme.dur.usenet.model.Newsgroup;

class ArtFact {

    private static final Logger LOG = Logger.getLogger(ArtFact.class.getName());

    public void getArticle(Message message, Folder folder) {
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();
        String fullNewsgroupName = folder.getFullName();
        int messageNumber = message.getMessageNumber();
        Newsgroup newsgroup;
        TypedQuery<Newsgroup> query = em.createQuery("SELECT n FROM Newsgroup n WHERE n.newsgroup = :newsGroupParam", Newsgroup.class);
        query.setParameter("newsGroupParam", fullNewsgroupName);
        try {
            newsgroup = query.getSingleResult();
            LOG.info("found " + query.getSingleResult()); //ok
        } catch (javax.persistence.NoResultException e) {
            newsgroup = new Newsgroup(folder);
            LOG.info(e + "\ncould not find " + fullNewsgroupName); //ok
        } catch (NonUniqueResultException e) {
            LOG.info(e + "\nshould never happen\t" + fullNewsgroupName); //not ok
        }
    }
}
