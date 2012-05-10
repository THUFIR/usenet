package net.bounceme.dur.usenet.controller;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import net.bounceme.dur.usenet.swing.model.MyListModel;

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
    private Marker marker = null;
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
        setMarker(new Marker(group, 0, 0));
        return true;
    }

    private void loadFolder() throws Exception {
        folder = root.getFolder(marker.getGroup());
        folder.open(Folder.READ_ONLY);
    }

    private void logMessages() throws MessagingException {
        LOG.fine("NewsServer.logMessages..");
        for (Message m : messages) {
            LOG.log(Level.FINER, "***** {0} {1}", new Object[]{m.getMessageNumber(), m.getSubject()});
        }
    }

    public List<Message> getMessages(Marker m) throws Exception {
        LOG.fine("trying.. " + m.toString());
        setMarker(m);
        loadFolder();
        messages = Arrays.asList(folder.getMessages(getMarker().getStart(), getMarker().getEnd()));
        Collections.reverse(messages);
        logMessages();
        return Collections.unmodifiableList(messages);
    }

    public List<Folder> getFolders() {
        return Collections.unmodifiableList(folders);
    }

    public void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    private Marker getMarker() {
        return marker;
    }

    private void setMarker(Marker marker) {
        LOG.fine("current Marker " + getMarker());
        for (Folder f : folders) {
            String knownGood = f.getFullName();
            String newGroup = marker.getGroup();
            if (knownGood.equalsIgnoreCase(newGroup)) {
                LOG.fine("setting " + newGroup);
                this.marker = marker;
            } else {
                LOG.fine("rejected " + newGroup);
            }
        }
        LOG.fine("finished setMarker " + getMarker());
    }
}