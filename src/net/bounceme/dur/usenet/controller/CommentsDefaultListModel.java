package net.bounceme.dur.usenet.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;

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
