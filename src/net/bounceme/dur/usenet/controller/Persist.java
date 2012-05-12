package net.bounceme.dur.usenet.controller;

import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.bounceme.dur.usenet.swing.view.MessageBean;

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

    public void addMessageBean(MessageBean messageBean) {
        LOG.fine("\t" + messageBean);
        Notes note = new Notes(messageBean);
        LOG.fine("isOpen?" + em.isOpen());
        em.getTransaction().begin();
        LOG.warning("transaction began..\n\n" + note);
        em.persist(note);
        em.getTransaction().commit();
        LOG.fine("insert..\n\n" + note);
    }

    public void addNote(Notes note) {
        LOG.fine("\t" + note);
        LOG.fine("isOpen?" + em.isOpen());
        em.getTransaction().begin();
        LOG.fine("transaction began..\n\n" + note);
        em.persist(note);
        em.getTransaction().commit();
        LOG.fine("insert..\n\n" + note);
    }
}
