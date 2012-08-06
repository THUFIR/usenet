package net.bounceme.dur.usenet.model;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.*;
import net.bounceme.dur.usenet.driver.Page;

public enum Usenet {

    INSTANCE;
    private final Logger LOG = Logger.getLogger(Usenet.class.getName());
    private Properties props = new Properties();
    private Folder root = null;
    private Store store = null;
    private List<Folder> folders = new ArrayList<>();
    private Folder folder = null;

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
        session.setDebug(true);
        store = session.getStore(new URLName(props.getProperty("nntp.host")));
        store.connect();
        root = store.getDefaultFolder();
        setFolders(Arrays.asList(root.listSubscribed()));
    }

    public void foo(String ng) throws Exception {
        folder = root.getFolder(ng);
        LOG.fine("opened the folder!!!!!");
        folder.open(Folder.READ_ONLY);
    }

    public List<Message> getMessages(Newsgroup newsgroup) throws Exception {
        LOG.fine("fetching.." + newsgroup);
        folder = root.getFolder(newsgroup.getNewsgroup());
        LOG.fine("opened the folder!!!!!");
        folder.open(Folder.READ_ONLY);
        LOG.fine("opened: " + folder.getFullName());
        LOG.fine("opened: " + folder.getFullName());
        LOG.fine("opened: " + folder.getFullName());
        List<Message> messages = Arrays.asList(folder.getMessages());
        LOG.fine("..fetched " + folder);
        return messages;
    }

    public List<Folder> getFolders() {
        LOG.fine("folders " + folders);
        return Collections.unmodifiableList(folders);
    }

    private void setFolders(List<Folder> folders) {
        this.folders = folders;
    }

    //public Message getMessage(String newsgroup, int i) {
    public Message getMessage(Page page) {
        String newsgroup = page.getFolderFullName();
        int i = page.getMax();
        Message message = null;
        try {
            LOG.fine("fetching.." + newsgroup);
            folder = root.getFolder(newsgroup);
            folder.open(Folder.READ_ONLY);
            LOG.fine("" + message.getSubject().toString());
            return folder.getMessage(i);
        } catch (MessagingException ex) {
            Logger.getLogger(Usenet.class.getName()).log(Level.FINE, null, ex);
        } finally {
            LOG.fine(newsgroup + "\t\tnull message ");
            return message;//crummy

        }
    }

    public Message getMessage(Page page, Article article) {
        LOG.info("page..\n" + page + "\n article\t" + article);
        String newsgroup = page.getFolderFullName();
        int i = article.getMessageNumber();
        Message message = null;
        try {
            folder = root.getFolder(newsgroup);
            folder.open(Folder.READ_ONLY);
            LOG.fine("" + message.getSubject().toString());
            return folder.getMessage(i);
        } catch (MessagingException ex) {
            Logger.getLogger(Usenet.class.getName()).log(Level.FINE, null, ex);
        } finally {
            LOG.fine(newsgroup + "\t\tnull message ");
            return message;//crummy
        }
    }
}
