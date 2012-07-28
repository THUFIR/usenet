package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Usenet;

public class MessagesDefaultListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(MessagesDefaultListModel.class.getName());
    private Usenet usenet = Usenet.INSTANCE;
    private EntityManagerFactory emf;
    private EntityManager em;

    public MessagesDefaultListModel() {
    }

    public MessagesDefaultListModel(Folder folder) {
        try {
            load(folder);
        } catch (Exception ex) {
            Logger.getLogger(MessagesDefaultListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private void load(Folder folder) throws Exception {
        LOG.fine("loading.." + folder);
        this.clear();
        List<Message> messages = usenet.getMessages(folder);
        for (Message message : messages) {
            MessageBean messageBean = new MessageBean(message);
            this.addElement(messageBean);
            persist(messageBean);
            em.close();
            LOG.fine(messageBean.toString());
        }
        LOG.fine("..loaded");
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
