package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.bounceme.dur.usenet.swing.Msg;

public enum Persist {

    INSTANCE;
    private final Logger LOG = Logger.getLogger(Persist.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;
    private String PERSISTENCE_UNIT_NAME = "USENETPU";

    Persist() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
        LOG.warning("entity manager made???" + em.isOpen());
    }

    public void persist(Msg message) {
        LOG.info("\t" + message);
        LOG.info("isOpen?" + em.isOpen());
        em.getTransaction().begin();
        int id = message.getId();
        TypedQuery<Notes> q = em.createQuery("SELECT DISTINCT n FROM Notes n WHERE n.messageId = :messageId AND n.newsGroup=:newsGroup", Notes.class);
        q.setParameter("messageId", message.getId()).setParameter("newsGroup", message.getGroup());
        List<Notes> results = q.getResultList();
        em.getTransaction().commit();
        for (Notes o : results) {
            LOG.info("object is \n\n" + o);
        }
        LOG.info("persist..\n\n" + results);
    }
}
