package net.bounceme.dur.usenet.swing;

import java.io.IOException;
import java.util.List;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.ArticleNewsgroup;
import net.bounceme.dur.usenet.controller.Page;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.DatabaseUtils;
import net.bounceme.dur.usenet.model.Newsgroup;

class ArticleListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(ArticleListModel.class.getName());
    private DatabaseUtils database = DatabaseUtils.INSTANCE;
    private List<Article> articles;

    ArticleListModel(Page page) throws IOException, MessagingException {
        articles = database.getRangeOfArticles(page);
        Newsgroup newsgroup = new Newsgroup(page);
        load(newsgroup);
    }

    public ArticleListModel(Newsgroup newsgroup) throws IOException, MessagingException {
        articles = database.getAllArticles(newsgroup);
        load(newsgroup);
    }

    @SuppressWarnings("unchecked")
    private void load(Newsgroup newsgroup) throws IOException, MessagingException {
        for (Article article : articles) {
            ArticleNewsgroup articleNewsgroup = new ArticleNewsgroup(newsgroup, article);
            this.addElement(articleNewsgroup);
        }
        LOG.info(articles.toString());
    }
}
