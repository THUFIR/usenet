package net.bounceme.dur.usenet.swing;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.driver.DatabaseUtils;
import net.bounceme.dur.usenet.driver.Page;
import net.bounceme.dur.usenet.model.Article;

class ArticleListModel extends DefaultListModel {

    private DatabaseUtils database = new DatabaseUtils();

    public ArticleListModel(Page page) {
        load(page);
    }

    @SuppressWarnings("unchecked")
    private void load(Page page) {
        List<Article> articles = database.getRangeOfArticles(page);
        for (Article article : articles) {
            try {
                ArticleWrapper aw = new ArticleWrapper(page,article);
            } catch (Exception ex) {
                Logger.getLogger(ArticleListModel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
