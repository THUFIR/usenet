package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;

public class CommentsDefaultListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(CommentsDefaultListModel.class.getName());
    private Usenet usenet = Usenet.INSTANCE;

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
