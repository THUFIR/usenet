package net.bounceme.dur.usenet.controller;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import net.bounceme.dur.usenet.swing.model.MyListModel;

public enum Usenet {

    INSTANCE;
    private final Level LEVEL = Level.INFO;
    private final Logger LOG = Logger.getLogger(Usenet.class.getName());
    private Properties props = new Properties();
    private List<Message> messages = new ArrayList<>();
    private MyListModel mlm = new MyListModel();
    private boolean loaded = false;
    private Folder folder = null;
    private Folder root = null;
    private List<Folder> folders = null;
    private Store store = null;

    Usenet() {
        LOG.fine("controller..");
        props = PropertiesReader.getProps();
        if (!loaded) {
            try {
                loaded = connect();
            } catch (Exception ex) {
                Logger.getLogger(Usenet.class.getName()).log(Level.SEVERE, "FAILED TO LOAD MESSAGES", ex);
            }
        }
    }

    private boolean connect() throws Exception {
        LOG.fine("Usenet.connect..");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);
        store = session.getStore(new URLName(props.getProperty("nntp.host")));
        store.connect();
        root = store.getDefaultFolder();
        setFolders(Arrays.asList(root.listSubscribed()));
        //ng.loadFoldersList(Arrays.asList(root.list()));
        //setGroup(ng.getFoldersListModel().getElementAt(0).toString());
        return true;
    }

    private void logMessages() throws MessagingException {
        LOG.fine("NewsServer.logMessages..");
        for (Message m : messages) {
            LOG.log(Level.FINER, "***** {0} {1}", new Object[]{m.getMessageNumber(), m.getSubject()});
        }
    }

    public List<Message> getMessages(Marker m) {
        LOG.fine("NewsServer.getMessages "+ m.toString());
        try {
            messages = Arrays.asList(folder.getMessages(m.getStart(), m.getEnd()));
            Collections.reverse(messages);
            logMessages();
        } catch (MessagingException ex) {
            Logger.getLogger(Usenet.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Collections.unmodifiableList(messages);
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public List<Folder> getFolders() {
        return Collections.unmodifiableList(folders);
    }
}