package net.bounceme.dur.usenet.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Usenet;

public class FetchBean {

    private static final Logger LOG = Logger.getLogger(FetchBean.class.getName());
    private Usenet u = Usenet.INSTANCE;

    public static void main(String[] args) {
        try {
            FetchBean main = new FetchBean();
        } catch (Exception ex) {
            Logger.getLogger(FetchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FetchBean() throws Exception {
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();
        List<Folder> subscribed = u.getFolders();
        LOG.info(subscribed.toString());
        for (Folder folder : subscribed) {
            List<Message> messages = u.getMessages(folder.getFullName());
            for (Message message : messages) {
                Article article = new Article(message, folder);
                em.getTransaction().begin();
                em.persist(article);
                em.getTransaction().commit();
            }
        }
        em.close();
        LOG.info("**************************done");
    }
}
