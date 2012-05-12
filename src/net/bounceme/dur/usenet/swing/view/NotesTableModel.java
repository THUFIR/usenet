package net.bounceme.dur.usenet.swing.view;

import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;
import net.bounceme.dur.usenet.controller.Notes;

class NotesTableModel extends DefaultTableModel {

    public NotesTableModel() {
    }

    @SuppressWarnings("unchecked")
    public NotesTableModel(List<Notes> notes,MessageBean messageBean) {
        addColumn("group");
        addColumn("subject");
        addColumn("note");
        Vector v = new Vector();
        for(Notes n : notes){
            v.add(n.getNewsGroup());
            v.add(messageBean.getSubject());
            v.add(n.getNote());
        }
    }
}
