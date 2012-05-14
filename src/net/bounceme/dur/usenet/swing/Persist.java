package net.bounceme.dur.usenet.swing;

import java.util.List;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import net.bounceme.dur.usenet.model.MessageBean;

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

    public List<Notes> getMessages(MessageBean messageBean) {
        LOG.fine("\t" + messageBean);
        Notes note = new Notes(messageBean);
        LOG.fine("isOpen?" + em.isOpen());
        em.getTransaction().begin();
        LOG.fine("transaction began..\n\n" + note);

        TypedQuery<Notes> q = em.createQuery("SELECT  n "
                + "FROM Notes n WHERE n.messageId = :messageId "
                + "AND n.newsGroup = :newsGroup", Notes.class);
        q.setParameter("messageId", messageBean.getId()).setParameter("newsGroup", messageBean.getGroup());
        List<Notes> results = q.getResultList();

        em.getTransaction().commit();
        LOG.fine("\n\nresults for\n\n" + messageBean + "..\n\n" + results + "\n\n");
        return results;
    }

    public void addMessageBean(MessageBean messageBean) {
        LOG.fine("\t" + messageBean);
        Notes note = new Notes(messageBean);
        LOG.fine("isOpen?" + em.isOpen());
        em.getTransaction().begin();
        LOG.fine("transaction began..\n\n" + note);
        em.persist(note);
        em.getTransaction().commit();
        LOG.fine("insert..\n\n" + note);
    }
}
