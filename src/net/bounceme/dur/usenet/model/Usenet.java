package net.bounceme.dur.usenet.model;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;

public enum Usenet {

    INSTANCE;
    private final Logger LOG = Logger.getLogger(Usenet.class.getName());
    private Properties props = new Properties();
    //private List<Message> messages = new ArrayList<>();
    private Folder folder = null;
    private Folder root = null;
    private Store store = null;
    private List<Folder> folders = new ArrayList<>();
    private int max = 100;

    Usenet() {
        LOG.fine("controller..");
        props = PropertiesReader.getProps();
        try {
            connect();
        } catch (Exception ex) {
            Logger.getLogger(Usenet.class.getName()).log(Level.SEVERE, "FAILED TO LOAD MESSAGES", ex);
        }
    }

    private void connect() throws Exception {
        LOG.fine("Usenet.connect..");
        Session session = Session.getDefaultInstance(props);
        session.setDebug(false);
        store = session.getStore(new URLName(props.getProperty("nntp.host")));
        store.connect();
        root = store.getDefaultFolder();
        setFolders(Arrays.asList(root.listSubscribed()));
        /*
         * Folder f = root.listSubscribed()[0]; String group = f.getFullName();
         * Page p = new Page(group, getMax()); getMessages(p);
         */
    }

    public List<javax.mail.Message> getMessages(String group) throws Exception {
        LOG.fine("fetching.." + group);
        folder = root.getFolder(group);
        folder.open(Folder.READ_ONLY);
        List<javax.mail.Message> messages = Arrays.asList(folder.getMessages());
        LOG.fine("..fetched " + group);
        return messages;
    }

    public List<Folder> getFolders() {
        LOG.fine("folders " + folders);
        return Collections.unmodifiableList(folders);
    }

    private void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

}
