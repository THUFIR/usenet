package net.bounceme.dur.usenet.driver;

import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.bounceme.dur.usenet.model.Newsgroups;
import net.bounceme.dur.usenet.model.Usenet;

public class NewMain {

    private static final Logger LOG = Logger.getLogger(NewMain.class.getName());
    private Usenet u = Usenet.INSTANCE;
    private EntityManagerFactory emf;
    private EntityManager em;

    public static void main(String[] args) {

        NewMain nm = new NewMain();
    }

    public NewMain() {
        //queryDB();
        folders();
    }

    private void queryDB() {
        TypedQuery<Newsgroups> query = em.createQuery("SELECT n FROM Newsgroups n", Newsgroups.class);
        List<Newsgroups> existingNewsgroups = query.getResultList();
        LOG.info(existingNewsgroups.toString());
    }

    private void folders() {
        List<Folder> folders = u.getFolders();
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();

        for (Folder folder : folders) {
            Newsgroups newN = new Newsgroups(folder);
            if (true) {
                em.getTransaction().begin();
                em.persist(newN);
                em.getTransaction().commit();
            }
        }
        em.close();
    }
}
