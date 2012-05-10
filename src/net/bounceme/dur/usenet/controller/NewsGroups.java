package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import net.bounceme.dur.usenet.swing.model.MyListModel;

public enum NewsGroups {

    INSTANCE;
    private final static Logger LOG = Logger.getLogger(NewsGroups.class.getName());
     private static final Level LEVEL = Level.INFO;
    private List<Folder> folders;
    private String group;
    private MyListModel model;

    NewsGroups() {
    }

    public void loadFoldersList(List<Folder> folders) {
        setFolders(folders);
        LOG.log(LEVEL, "folders {0}", folders.size());
    }


    @Override
    public String toString() {
        String s = " ";
        for (Folder f : getFolders()) {
            String name = f.getName();
            s = s + name;
        }
        return s;
    }

    private void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    private List<Folder> getFolders() {
        return folders;
    }

    public String getGroup() {
        LOG.log(LEVEL, "GROUP IS {0}", group);
        return group;
    }

    public void setGroup(String group) {
        LOG.log(LEVEL, "trying...{0}", group);
        for (Folder f : folders) {
            LOG.log(LEVEL, f.getFullName());
            if (f.getFullName().equals(group)) {
                this.group = group;
            }
        }
        getGroup();
    }
}