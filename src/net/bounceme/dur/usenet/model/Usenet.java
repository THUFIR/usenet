package net.bounceme.dur.usenet.model;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import net.bounceme.dur.usenet.controller.PropertiesReader;
import net.bounceme.dur.usenet.swing.model.Marker;

public enum Usenet {

    INSTANCE;
    private final Logger LOG = Logger.getLogger(Usenet.class.getName());
    private Properties props = new Properties();
    private List<Message> messages = new ArrayList<>();
    private MyListModel mlm = new MyListModel();
    private boolean loaded = false;
    private Folder folder = null;
    private Folder root = null;
    //private List<Folder> folders = null;
    private Store store = null;
    private List<Folder> folders = new ArrayList<>();

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
        String group = getFolders().get(0).getFullName();
        Marker marker = new Marker(group, 20);
        return true;
    }

    private void loadFolder(Marker marker) throws Exception {
        folder = root.getFolder(marker.getGroup());
        folder.open(Folder.READ_ONLY);
        LOG.fine("folder: " + folder.getFullName() + " " + folder.getMessageCount());
    }

    private void logMessages(Marker marker) throws MessagingException {
        LOG.warning("logging as per " + marker);
        for (Message m : messages) {
            LOG.log(Level.INFO, "***** {0} {1}", new Object[]{m.getMessageNumber(), m.getSubject()});
        }
    }

    public List<Message> getMessages(Marker marker) throws Exception {
        LOG.fine("loading.. " + marker.toString());
        loadFolder(marker);
        messages = Arrays.asList(folder.getMessages(marker.getStart(), marker.getEnd()));
        //Collections.reverse(messages);
        return Collections.unmodifiableList(messages);
    }

    public List<Folder> getFolders() {
        return Collections.unmodifiableList(folders);
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

}