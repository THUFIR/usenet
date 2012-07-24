package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;

public class MessagesDefaultListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(MessagesDefaultListModel.class.getName());
    private Usenet usenet = Usenet.INSTANCE;

    public MessagesDefaultListModel() {
    }

    public MessagesDefaultListModel(String folder) {
        try {
            load(folder);
        } catch (Exception ex) {
            Logger.getLogger(MessagesDefaultListModel.class.getName()).log(Level.SEVERE, null, ex);
            dummy(folder);
        }
    }

    @SuppressWarnings("unchecked")
    private void load(String folder) throws Exception {
        LOG.fine("loading.." + folder);
        this.clear();
        List<Message> messages = usenet.getMessages(folder);
        for (Message message : messages) {
            MessageBean messageBean = new MessageBean(message);
            this.addElement(messageBean);
            LOG.fine(messageBean.toString());
        }
        LOG.fine("..loaded");
    }

    private void dummy(String folder) {
        for (int i = 1; i < 9; i++) {
            this.addElement(i);
        }
    }
}
