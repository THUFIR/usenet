package net.bounceme.dur.usenet.model;

//dummy comment  now in group_page

public final class MessageBean {

    private int id;
    private String subject;
    private String content;
    private String group;
    private String note;

    public MessageBean() {
    }

    public MessageBean(int id, String subject, String content) {
        setId(id);
        setSubject(subject);
        setContent(content);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
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

    @Override
    public String toString() {
        String s = "" + group + id + note;
        return s;
    }
}
