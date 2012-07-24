package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;

public class MessageDefaultListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(MessageDefaultListModel.class.getName());
    private Usenet usenet = Usenet.INSTANCE;

    public MessageDefaultListModel() {
    }

    public MessageDefaultListModel(String group) {
        LOG.fine("new messages");
        try {
            load(group);
        } catch (Exception ex) {
            Logger.getLogger(MessageDefaultListModel.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @SuppressWarnings("unchecked")
    private void load(String group) throws Exception {
        this.clear();
        List<Message> messages = usenet.getMessages(group);
        for (Message message : messages) {
            this.addElement(message);
            LOG.fine(message.getSubject());
        }
    }
}
