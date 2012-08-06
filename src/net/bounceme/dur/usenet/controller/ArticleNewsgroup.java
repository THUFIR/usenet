package net.bounceme.dur.usenet.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;
import net.bounceme.dur.usenet.model.Usenet;

public class ArticleNewsgroup {

    private static final Logger LOG = Logger.getLogger(ArticleNewsgroup.class.getName());
    private Usenet u = Usenet.INSTANCE;
    private String newsgroup = "dummy newsgroup";
    private String subject = "dummy subject";
    private String content = "dummy content";
    private int messageNumber = 1;

    private ArticleNewsgroup() {
    }

    public ArticleNewsgroup(Newsgroup newsgroupEntity,Article articleEntity) throws IOException, MessagingException {
        LOG.fine("trying..\n\n" + newsgroupEntity + articleEntity);
        Message message = u.getMessage(newsgroupEntity, articleEntity);
        newsgroup = message.getFolder().getFullName();
        subject = message.getSubject();
        content = message.getContent().toString();
        messageNumber = message.getMessageNumber();
        LOG.fine("\narticleWrapper\t\t" + messageNumber + newsgroupEntity + articleEntity);
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
