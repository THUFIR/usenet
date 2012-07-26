package net.bounceme.dur.usenet.controller;

import java.util.Observable;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.ListModel;

public class Controller extends Observable {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    private Folder folder = null;
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
        LOG.fine(folder.getFullName());
        ListModel articles = new MessagesDefaultListModel(folder);
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

    public Folder getFolderFullName() {
        return folder;
    }

    public void setFolderFullName(Folder folder) {
        this.folder = folder;
        setChanged();
        notifyObservers(folder);
    }
}
