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

    public MessagesDefaultListModel(String group) {
        try {
            load(group);
        } catch (Exception ex) {
            Logger.getLogger(MessagesDefaultListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void load(String group) throws Exception {
        LOG.fine("loading.." + group);
        this.clear();
        List<Message> messages = usenet.getMessages(group);
        for (Message message : messages) {
            this.addElement(message.getSubject());
            LOG.fine(message.getSubject());
        }
        LOG.fine("..loaded");
    }
}
