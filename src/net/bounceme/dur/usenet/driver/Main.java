package net.bounceme.dur.usenet.driver;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.bounceme.dur.usenet.model.Newsgroups;
import net.bounceme.dur.usenet.model.Usenet;

public class Main {

    private static final Logger LOG = Logger.getLogger(Main.class.getName());
    private Usenet u = Usenet.INSTANCE;

    public static void main(String[] args) {
        Main main = new Main();
    }

    public Main() {
        List<Newsgroups> folderGroups = getFolders();
        EntityManagerFactory emf;
        EntityManager em;
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();
        for (Newsgroups n : folderGroups) {
            persist(em, n);
        }
        em.close();
    }

    private boolean queryDB(EntityManager em, Newsgroups ng) {
        String newsgroup = ng.getNewsgroup();
        TypedQuery<Newsgroups> query = em.createQuery("SELECT n FROM Newsgroups n WHERE n.newsgroup = :newsgroup", Newsgroups.class);
        Newsgroups result = query.getSingleResult();
        LOG.info("query result:\n" + result + "\ncompared to\n" + ng);
        return false;
    }

    private List<Newsgroups> getFolders() {
        List<Folder> folders = u.getFolders();
        List<Newsgroups> newsgroups = new ArrayList<>();
        for (Folder folder : folders) {
            Newsgroups newsgroup = new Newsgroups(folder);
            newsgroups.add(newsgroup);
        }
        LOG.info(newsgroups.toString());
        return newsgroups;
    }

    private void persist(EntityManager em, Newsgroups n) {
        if (queryDB(em, n)) {
            em.getTransaction().begin();
            em.persist(n);
            em.getTransaction().commit();
        }
    }
}
