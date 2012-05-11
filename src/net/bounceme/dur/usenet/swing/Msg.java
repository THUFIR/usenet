package net.bounceme.dur.usenet.swing;

import java.util.logging.Logger;

public final class Msg {

    private static final Logger LOG = Logger.getLogger(Msg.class.getName());
    private int id;
    private String group;
    private String subject;
    private String content;

    Msg(int id, String group, String subject, String content) {
        setId(id);
        setGroup(group);
        setSubject(subject);
        setContent(content);
        LOG.fine(toString());
    }

    Msg(int id, String subject, String content) {
        setId(id);
        setSubject(subject);
        setContent(content);
        LOG.fine(toString());
    }

    @Override
    public String toString() {
        String s = "\n\n" + id + group + subject;
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
}