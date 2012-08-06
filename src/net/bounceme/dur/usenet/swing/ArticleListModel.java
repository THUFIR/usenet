package net.bounceme.dur.usenet.swing;

import java.util.List;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.driver.DatabaseUtils;
import net.bounceme.dur.usenet.model.Article;

class ArticleListModel extends DefaultListModel {

    
    private DatabaseUtils database = new DatabaseUtils();

    
    @SuppressWarnings("unchecked")
    public ArticleListModel() {
        List<Article> articles = database.getArticles();
        for (Article article : articles) {
            addElement(article);
        }
    }
   

}
