package net.bounceme.dur.usenet.swing;

import java.util.logging.Logger;

public final class NoteBean {

    private static final Logger LOG = Logger.getLogger(NoteBean.class.getName());
    private int id;
    private String group;
    private String note;

    public NoteBean() {
        LOG.fine(toString());
    }

    NoteBean(int id, String group, String note) {
        setId(id);
        setGroup(group);
        setNote(note);
        LOG.fine(toString());
    }

    @Override
    public String toString() {
        String s = "\n\n" + id + group + note;
        return s;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
