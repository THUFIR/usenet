package net.bounceme.dur.usenet.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;

/*
 * public void persist(Msg message) { LOG.info("\t" + message);
 * LOG.info("isOpen?" + em.isOpen()); em.getTransaction().begin(); int id =
 * message.getId(); Query q = em.createQuery("SELECT n " + "FROM Notes n WHERE
 * n.messageId = :messageId " + "AND n.group = :group"); List results =
 * q.getResultList(); em.getTransaction().commit(); for (Object o : results) {
 * LOG.info("object is \n\n" + o); } }
 *
 * }
 */
public class CommentsDefaultListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(CommentsDefaultListModel.class.getName());
    private EntityManagerFactory emf;
    private EntityManager em;

    public CommentsDefaultListModel() {
    }

    public CommentsDefaultListModel(MessageBean messageBean) {
        try {
            persist(messageBean);
        } catch (Exception ex) {
            Logger.getLogger(CommentsDefaultListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    
    private void persist(MessageBean messageBean) throws Exception {
        LOG.info("loading.." + messageBean);

        Messages message = new Messages(messageBean);
        
        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(message);
        em.getTransaction().commit();
    }
}
