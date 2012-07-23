package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Usenet;
import net.bounceme.dur.usenet.swing.PanelWithTabs;

public class Controller extends Observable  {

    private static final Logger LOG = Logger.getLogger(PanelWithTabs.class.getName());
    private static Usenet usenet = Usenet.INSTANCE;

    public static DefaultListModel getArticleList() {
        DefaultListModel dlm = new DefaultListModel();
        //List<Message> foo = usenet.getMessages();
        return dlm;
    }

    public Controller() {
    }

    @SuppressWarnings("unchecked")
    public static DefaultListModel getFolders() {
        List<Folder> folders = usenet.getFolders();
        DefaultListModel defaultListModel = new DefaultListModel();
        for (Folder folder : folders) {
            defaultListModel.addElement(folder);
        }
        return defaultListModel;
    }
}
