package net.bounceme.dur.usenet.swing;

import net.bounceme.dur.usenet.controller.ArticleWrapper;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.DatabaseUtils;
import net.bounceme.dur.usenet.controller.Page;
import net.bounceme.dur.usenet.model.Article;

class ArticleListModel extends DefaultListModel {

    private DatabaseUtils database = DatabaseUtils.INSTANCE;

    @SuppressWarnings("unchecked")
    public ArticleListModel(Page page) {
        List<Article> articles = database.getRangeOfArticles(page);
        for (Article article : articles) {
            try {
                ArticleWrapper aw = new ArticleWrapper(page,article);
                this.addElement(aw);
            } catch (Exception ex) {
                Logger.getLogger(ArticleListModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
