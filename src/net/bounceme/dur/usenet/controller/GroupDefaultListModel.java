package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;

public class GroupDefaultListModel extends DefaultListModel {
    
    private static final Logger LOG = Logger.getLogger(GroupDefaultListModel.class.getName());
    private Usenet usenet = Usenet.INSTANCE;
    
    public GroupDefaultListModel(){
        loadFolders();
    }
    
    @SuppressWarnings("unchecked")
    private void loadFolders() {
        List<Folder> usenetFolderList = usenet.getFolders();
        for (Folder folder : usenetFolderList) {
            this.addElement(folder);
        }
        LOG.info(this.toString());
    }
}
