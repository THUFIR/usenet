package net.bounceme.dur.usenet.driver;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import net.bounceme.dur.usenet.model.Usenet;

public class FetchBean {

    private static final Logger LOG = Logger.getLogger(FetchBean.class.getName());
    private Usenet u = Usenet.INSTANCE;

    public static void main(String[] args) {
        try {
            FetchBean main = new FetchBean();
        } catch (Exception ex) {
            Logger.getLogger(FetchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FetchBean() throws Exception {
        List<Folder> subscribed = u.getFolders();
        LOG.info(subscribed.toString());
        DatabaseUtils database = new DatabaseUtils();
        for (Folder folder : subscribed) {
            List<Message> messages = u.getMessages(folder.getFullName());
            //for (Message message : messages) {
            int max = (messages.size() > 9) ? 9 : messages.size();
            for (int i = 1; i < max; i++) {
                Message message = messages.get(i);
                LOG.fine(message.getSubject());
                database.persistArticle(message, folder);
            }
        }
        database.close();
        LOG.info("**************************done");
    }
}
