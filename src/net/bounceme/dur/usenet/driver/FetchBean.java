package net.bounceme.dur.usenet.driver;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;
import net.bounceme.dur.usenet.model.Usenet;

public class FetchBean {

    private static final Logger LOG = Logger.getLogger(FetchBean.class.getName());
    private Usenet u = Usenet.INSTANCE;
    private DatabaseUtils database = new DatabaseUtils();
    private List<Folder> subscribed;

    public static void main(String[] args) {
        try {
            FetchBean main = new FetchBean();
        } catch (Exception ex) {
            Logger.getLogger(FetchBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public FetchBean() throws Exception {
        subscribed = u.getFolders();
        LOG.info(subscribed.toString());
        for (Folder folder : subscribed) {
            //load(folder);
            pageOfArticles(folder);
        }
        database.close();
        LOG.info("**************************done");
    }

    private void load(Folder folder) throws Exception {
        List<Message> messages = u.getMessages(folder.getFullName());
        int maxMessageNumber = database.getMaxMessageNumber(folder);
        for (Message message : messages) {
            if (message.getMessageNumber() > maxMessageNumber) {
                LOG.info(message.getSubject());
                database.persistArticle(message, folder);
            }
        }
    }

    private void pageOfArticles(Folder folder) {
        int maxMessageNumber = database.getMaxMessageNumber(folder);
        Page page = new Page(folder, maxMessageNumber);
        List<Article> articles = database.getRangeOfArticles(page);
    }
}
