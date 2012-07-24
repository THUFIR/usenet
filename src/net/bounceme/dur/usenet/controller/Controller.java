package net.bounceme.dur.usenet.controller;

import java.util.Observable;
import java.util.logging.Logger;
import javax.swing.ListModel;

public class Controller extends Observable {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    private String folderFullName = null;
    private static Controller instance;
    //private Folder folder = null;

    protected Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public ListModel getMessages() {
        LOG.info(folderFullName);
        ListModel articles = new MessagesDefaultListModel(folderFullName);
        return articles;
    }

    public String getContent() {
        String c = "some content";
        return c;
    }

    
    
    /*
     * public void setGroup(String selectedValue) {
     * group = selectedValue;
     * setChanged(); notifyObservers(); LOG.fine(group); }
     *
     * public String getGroup() { 
     * return group;
    }
     */
    
    /*
    public Folder getFolder() {
        return folder;
    }

    public void setFolder(Folder folder) {
        this.folder = folder;
        setChanged();
        notifyObservers();
    }*/

    public String getFolderFullName() {
        return folderFullName;
    }

    public void setFolderFullName(String folderFullName) {
        this.folderFullName = folderFullName;
        setChanged();
        notifyObservers(folderFullName);
    }
}
