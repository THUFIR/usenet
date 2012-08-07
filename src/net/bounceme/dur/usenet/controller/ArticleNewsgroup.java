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
    private Message message = null;
    private Article article = null;
    private Newsgroup newsgroup = null;

    private ArticleNewsgroup() {
    }

    public ArticleNewsgroup(Newsgroup newsgroup,Article article) throws IOException, MessagingException {
        LOG.fine("trying..\n\n" + newsgroup + article);
        message = u.getMessage(newsgroup, article);
        this.article = article;
        this.newsgroup = newsgroup;
}
    @Override
    public String toString() {
        String returnVal = "frack";
        try {
            returnVal = message.getSubject().toString();
        } catch (MessagingException ex) {
            Logger.getLogger(ArticleNewsgroup.class.getName()).log(Level.SEVERE, null, ex);
        }
        return returnVal;
    }

    public Message getMessage() {
        return message;
    }

    public void setMessage(Message message) {
        this.message = message;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public Newsgroup getNewsgroup() {
        return newsgroup;
    }

    public void setNewsgroup(Newsgroup newsgroup) {
        this.newsgroup = newsgroup;
    }
}
