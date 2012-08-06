package net.bounceme.dur.usenet.swing;

import java.util.List;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Article;

class ArticleListModel extends DefaultListModel {

    public ArticleListModel() {
    }

   
    @SuppressWarnings("unchecked")
    ArticleListModel(List<Article> articles) {
        for (Article article : articles) {
            addElement(article);
        }
    }

}
