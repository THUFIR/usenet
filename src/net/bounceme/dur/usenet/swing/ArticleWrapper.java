package net.bounceme.dur.usenet.swing;

import java.util.logging.Logger;
import javax.mail.Message;
import net.bounceme.dur.usenet.driver.Page;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Usenet;

class ArticleWrapper {

    private static final Logger LOG = Logger.getLogger(ArticleWrapper.class.getName());
    private Usenet u = Usenet.INSTANCE;
    private String newsgroup;
    private String subject;
    private String content;
    private int messageNumber;

    ArticleWrapper(Page page,Article article) throws Exception {
        Message message = u.getMessage(page,article);
        newsgroup = message.getFolder().getFullName();
        subject = message.getSubject();
        content = message.getContent().toString();
        messageNumber = message.getMessageNumber();
    }

    public String getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(String newsgroup) {
        this.newsgroup = newsgroup;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getMessageNumber() {
        return messageNumber;
    }

    public void setMessageNumber(int messageNumber) {
        this.messageNumber = messageNumber;
    }

    @Override
    public String toString() {
        return subject;
    }
}
