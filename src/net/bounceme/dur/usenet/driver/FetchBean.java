package net.bounceme.dur.usenet.driver;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
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

        Runtime runtime = Runtime.getRuntime();
        long maxMemory = runtime.maxMemory();
        long allocatedMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long totalFreeMemory = freeMemory + (maxMemory - allocatedMemory);
        long usedMemory = maxMemory - totalFreeMemory;

        LOG.info("max " + maxMemory);
        LOG.info("allocatedMemory " + allocatedMemory);
        LOG.info("freeMemory " + freeMemory);
        LOG.info("totalFreeMemory " + totalFreeMemory);
        LOG.info("useMemory " + usedMemory);

        List<Folder> subscribed = u.getFolders();
        LOG.info(subscribed.toString());
        DatabaseUtils database = new DatabaseUtils();
        for (Folder folder : subscribed) {
            List<Message> messages = u.getMessages(folder.getFullName());
            int max = database.getMaxMessageNumber(folder);
            for (Message message : messages) {
                if (message.getMessageNumber() > max) {
                    LOG.info(message.getSubject());
                    database.persistArticle(message, folder);
                }
            }
        }
        database.close();
        LOG.info("**************************done");
    }
}
