package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;

public class ArticleDefaultListModel extends DefaultListModel {
    
    private static final Logger LOG = Logger.getLogger(ArticleDefaultListModel.class.getName());
    private Usenet usenet = Usenet.INSTANCE;
    
    public ArticleDefaultListModel(){
        loadMessages();
    }
    
    private void loadMessages() {
        List<Folder> usenetFolderList = usenet.getFolders();
        for (Folder folder : usenetFolderList) {
            this.addElement(folder);
        }
        LOG.info(this.toString());
    }
}
