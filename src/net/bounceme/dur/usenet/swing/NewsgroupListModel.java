package net.bounceme.dur.usenet.swing;

import java.util.List;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.DatabaseUtils;
import net.bounceme.dur.usenet.model.Newsgroup;

class NewsgroupListModel extends DefaultListModel {

    private DatabaseUtils database = DatabaseUtils.INSTANCE;

    @SuppressWarnings("unchecked")
    public NewsgroupListModel() {

        List<Newsgroup> newsgroups = database.getNewsgroups();
        for (Newsgroup newsgroup : newsgroups) {
            addElement(newsgroup);
        }
    }
}
