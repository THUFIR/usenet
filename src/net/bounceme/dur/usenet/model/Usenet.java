package net.bounceme.dur.usenet.model;


import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;

public enum Usenet {

    INSTANCE;
    private final Logger LOG = Logger.getLogger(Usenet.class.getName());
    private Properties props = new Properties();
    private List<Message> messages = new ArrayList<>();
    private boolean loaded = false;
    private Folder folder = null;
    private Folder root = null;
    private Store store = null;
    private List<Folder> folders = new ArrayList<>();
    private int max = 100;

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
        Folder f = root.listSubscribed()[0];
        String group = f.getFullName();
        Page p = new Page(group, getMax());
        getMessages(p);
        return true;
    }

    public List<Message> getMessages(Page page) throws Exception {
        LOG.fine(page.toString());
        folder = root.getFolder(page.getGroup());
        folder.open(Folder.READ_ONLY);
        setMax(folder.getMessageCount() - 100);
        messages = Arrays.asList(folder.getMessages(page.getStart(), page.getEnd()));
        return Collections.unmodifiableList(messages);
    }

    public List<Folder> getFolders() {
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

    public Page getPage(Folder folder) throws Exception {
        LOG.fine("connecting to " + folder);
        folder.open(Folder.READ_ONLY);
        int count = folder.getMessageCount() - 30;
        int index = 1;
        Page page = new Page(folder.getFullName(), index, count);
        return page;
    }
}