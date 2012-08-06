package net.bounceme.dur.usenet.swing;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.ArticleNewsgroup;
import net.bounceme.dur.usenet.controller.DatabaseUtils;
import net.bounceme.dur.usenet.controller.Page;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;

class ArticleListModel extends DefaultListModel {

    private DatabaseUtils database = DatabaseUtils.INSTANCE;

    @SuppressWarnings("unchecked")
    public ArticleListModel(Newsgroup newsgroup) throws IOException, MessagingException {
        Page page = new Page(newsgroup);
        List<Article> articles = database.getRangeOfArticles(page);
        for (Article article : articles) {
            ArticleNewsgroup articleNewsgroup = new ArticleNewsgroup(newsgroup, article);
            this.addElement(articleNewsgroup);
        }
    }
}
