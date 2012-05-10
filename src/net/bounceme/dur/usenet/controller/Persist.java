package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

class Persist {

    
    private static final long serialVersionUID = 1L;
    private static final Logger LOG = Logger.getLogger(Persist.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;
    private String PERSISTENCE_UNIT_NAME = "nntpPU";
    
    public Persist() {
        emf = Persistence.createEntityManagerFactory(PERSISTENCE_UNIT_NAME);
        em = emf.createEntityManager();
        LOG.fine("entity manager made???" + em.isOpen());
        populateList();
    }

    private void populateList() {
        LOG.fine("open?" + em.isOpen());
        em.getTransaction().begin();
        LOG.fine("trying to populate.....");
        Query q = em.createNamedQuery("NoteBean.findAll");
        LOG.fine(q.toString());
        List results = q.getResultList();
        em.getTransaction().commit();
    }
}
