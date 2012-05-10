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
        populateList();
    }
    
    private void populateList() {
        LOG.fine("open?" + em.isOpen());
        em.getTransaction().begin();
        LOG.fine("trying to populate.....");
        Query q = em.createNamedQuery("Notes.getByIdAndGroup");
        LOG.fine(q.toString());
        List results = q.getResultList();
        for (Object o : results) {
            LOG.warning("object is \n\n" + o);
        }
        em.getTransaction().commit();
    }
    
    public void get(Msg message) {
        
    }
}
