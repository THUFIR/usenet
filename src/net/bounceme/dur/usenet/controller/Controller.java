package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import javax.swing.ListModel;
import net.bounceme.dur.usenet.model.Usenet;
import net.bounceme.dur.usenet.swing.PanelWithTabs;

public class Controller {

    private static final Logger LOG = Logger.getLogger(PanelWithTabs.class.getName());
    private Usenet usenet = Usenet.INSTANCE;

    public Controller() {
    }

    @SuppressWarnings("unchecked")
    public DefaultListModel getFolders() {
        List<Folder> folders = usenet.getFolders();
        DefaultListModel defaultListModel = new DefaultListModel();
        for (Folder folder : folders) {
            defaultListModel.addElement(folder);
        }
        return defaultListModel;
    }
}
