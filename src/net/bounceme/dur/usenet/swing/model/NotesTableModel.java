package net.bounceme.dur.usenet.swing.model;

import java.util.List;
import java.util.Vector;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import net.bounceme.dur.usenet.swing.Notes;

public class NotesTableModel extends DefaultTableModel {

    private final static Logger LOG = Logger.getLogger(NotesTableModel.class.getName());

    public NotesTableModel() {
    }

    @SuppressWarnings("unchecked")
    public NotesTableModel(List<Notes> notes, MessageBean messageBean) {
        addColumn("group");
        addColumn("subject");
        addColumn("note");
        for (Notes n : notes) {
            Vector v = new Vector();
            v.add(n.getNewsGroup());
            v.add(messageBean.getSubject());
            v.add(n.getNote());
            this.addRow(v);
        }
        LOG.warning(notes.toString());
    }
}
