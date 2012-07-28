package net.bounceme.dur.usenet.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Article;

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
        LOG.info("insert to database.." + messageBean);

        Article article = new Article(messageBean);

        emf = Persistence.createEntityManagerFactory("USENETPU");
        em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(article);
        em.getTransaction().commit();
    }
}
