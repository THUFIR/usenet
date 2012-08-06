package net.bounceme.dur.usenet.swing;

import java.util.List;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.Newsgroup;

class NewsgroupListModel extends DefaultListModel {

    public NewsgroupListModel() {
    }

    
    @SuppressWarnings("unchecked")
    NewsgroupListModel(List<Newsgroup> newsgroups) {
        for (Newsgroup newsgroup : newsgroups) {
            addElement(newsgroup);
        }
    }
}
