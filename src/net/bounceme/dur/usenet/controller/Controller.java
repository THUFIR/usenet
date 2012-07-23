package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;
import net.bounceme.dur.usenet.swing.PanelWithTabs;

public class Controller extends Observable {

    private static final Logger LOG = Logger.getLogger(PanelWithTabs.class.getName());
    private Usenet usenet = Usenet.INSTANCE;
    private String group;
    private static Controller instance;
    private DefaultListModel folders = new DefaultListModel();
    private DefaultListModel articles = new DefaultListModel();

    protected Controller() {
        setFolders();
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }

    public DefaultListModel getArticleList() {
        //List<Message> foo = usenet.getMessages();
        return articles;
    }

    public void setGroup(String selectedValue) {
        group = selectedValue;
        LOG.fine(group);
        notifyObservers();
    }

    public String getGroup() {
        return group;
    }

    @SuppressWarnings("unchecked")
    private void setFolders() {
        List<Folder> usenetFolderList = usenet.getFolders();
        for(Folder folder : usenetFolderList){
            folders.addElement(folder);
        }
        LOG.fine(folders.toString());
    }

    public DefaultListModel getFolders() {
        return folders;
    }
}
