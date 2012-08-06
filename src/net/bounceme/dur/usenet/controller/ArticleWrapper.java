package net.bounceme.dur.usenet.controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;
import net.bounceme.dur.usenet.model.Usenet;

public class ArticleWrapper {

    private static final Logger LOG = Logger.getLogger(ArticleWrapper.class.getName());
    private Usenet u = Usenet.INSTANCE;
    private String newsgroup = "dummy newsgroup";
    private String subject = "dummy subject";
    private String content = "dummy content";
    private int messageNumber = 1;

    public ArticleWrapper(Article article,Newsgroup newsgroup) {
        LOG.info("newsgroup..\n" + newsgroup + "\n article\t" + article);
        try {
            Message message = u.getMessage(newsgroup, article);
            this.newsgroup = message.getFolder().getFullName();
            subject = message.getSubject();
            content = message.getContent().toString();
            messageNumber = message.getMessageNumber();
        } catch (IOException | MessagingException | NullPointerException ex) {
            Logger.getLogger(ArticleWrapper.class.getName()).log(Level.SEVERE, null, ex);
        }
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
