package net.bounceme.dur.usenet.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

/*
 * public void persist(Msg message) {
    LOG.info("\t" + message);
    LOG.info("isOpen?" + em.isOpen());
    em.getTransaction().begin();
    int id = message.getId();
    Query q = em.createQuery("SELECT  n "
            + "FROM Notes n WHERE n.messageId = :messageId "
            + "AND n.group = :group");
    List results = q.getResultList();
    em.getTransaction().commit();
    for (Object o : results) {
        LOG.info("object is \n\n" + o);
    }
}

}
 */
public class CommentsDefaultListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(CommentsDefaultListModel.class.getName());

    public CommentsDefaultListModel() {
    }

    public CommentsDefaultListModel(MessageBean messageBean) {
        try {
            load(messageBean);
        } catch (Exception ex) {
            Logger.getLogger(CommentsDefaultListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    private void load(MessageBean messageBean) throws Exception {
        LOG.fine("loading.." + messageBean);
    }
}
