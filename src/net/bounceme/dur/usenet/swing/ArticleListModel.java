package net.bounceme.dur.usenet.swing;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.ArticleWrapper;
import net.bounceme.dur.usenet.controller.DatabaseUtils;
import net.bounceme.dur.usenet.controller.Page;
import net.bounceme.dur.usenet.model.Article;
import net.bounceme.dur.usenet.model.Newsgroup;

class ArticleListModel extends DefaultListModel {

    private DatabaseUtils database = DatabaseUtils.INSTANCE;

    @SuppressWarnings("unchecked")
    public ArticleListModel(Page page) {
        Newsgroup newsgroup = new Newsgroup(page);
        List<Article> articles = database.getRangeOfArticles(page);
        for (Article article : articles) {
            try {
                ArticleWrapper aw = new ArticleWrapper(article,newsgroup);
                this.addElement(aw);
            } catch (Exception ex) {
                Logger.getLogger(ArticleListModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
