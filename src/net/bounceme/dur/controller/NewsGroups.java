package net.bounceme.dur.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;

public enum NewsGroups {

    INSTANCE;
    private final Logger LOG = Logger.getLogger(NewsGroups.class.getName());
    private DefaultListModel foldersListModel;
    private List<Folder> folders;
    private String group;

    NewsGroups() {
    }

    public void loadFoldersList(List<Folder> folders) {
        setFolders(folders);
        LOG.log(Level.FINE, "folders {0}", folders.size());
        DefaultListModel dlm = new DefaultListModel();
        for (Folder f : getFolders()) {
            String name = f.getName();
            dlm.addElement(name);
            LOG.fine(name);
        }
        setFoldersListModel(dlm);
    }

    public DefaultListModel getFoldersListModel() {
        LOG.fine(foldersListModel.toString());
        return foldersListModel;
    }

    public void setFoldersListModel(DefaultListModel foldersListModel) {
        this.foldersListModel = foldersListModel;
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
        LOG.fine("GROUP IS " + group);
        return group;
    }

    public void setGroup(String group) {
        LOG.fine("trying..." + group);
        for (Folder f : folders) {
            LOG.fine(f.getFullName());
            if (f.getFullName().equals(group)) {
                this.group = group;
            }
        }
        getGroup();
    }
}