package net.bounceme.dur.usenet.swing;

import java.util.List;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.DatabaseUtils;
import net.bounceme.dur.usenet.model.Newsgroup;

class NewsgroupListModel extends DefaultListModel {

    private static final Logger LOG = Logger.getLogger(NewsgroupListModel.class.getName());
    private DatabaseUtils database = DatabaseUtils.INSTANCE;
    private List<Newsgroup> newsgroups = null;

    @SuppressWarnings("unchecked")
    public NewsgroupListModel() {
        newsgroups = database.getNewsgroups();
        for (Newsgroup newsgroup : newsgroups) {
            addElement(newsgroup);
        }
        LOG.fine(newsgroups.toString());
    }

    @Override
    public String toString() {
        return newsgroups.toString();
    }
}
