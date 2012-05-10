package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
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
        LOG.fine("entity manager made???" + em.isOpen());
    }

    public void get(Msg message) {
        LOG.info("open?" + em.isOpen());
        em.getTransaction().begin();
        int id = message.getId();
        Query q = em.createQuery("SELECT DISTINCT n "
                + "FROM Notes n WHERE n.messageId = :messageId "
                + "AND n.group=group");
        List results = q.getResultList();
        em.getTransaction().commit();
        for (Object o : results) {
            LOG.warning("object is \n\n" + o);
        }
    }
}
