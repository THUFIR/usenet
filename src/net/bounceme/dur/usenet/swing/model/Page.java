package net.bounceme.dur.usenet.swing.model;

import java.util.logging.Logger;

public class Page {

    private static final Logger LOG = Logger.getLogger(Page.class.getName());
    private int start = 15;
    private int end = 100;
    private String group = "";

    private Page() {
    }

    public Page(String group, int start) {
        setGroup(group);
        setStart(start);
        setEnd(start + 10);
        LOG.fine(toString());
    }

    @Override
    public final String toString() {
        String s = "\n\n****\npage is\nstart " + getStart() + "\ngroup " + getGroup() + "\n" + getEnd() + "\n\n\n****\n";
        return s;
    }

    public int getStart() {
        return start;
    }

    private void setStart(int start) {
        if (start > 0) {
            this.start = start;
        } else {
            start = 1;
        }
    }

    public String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }

    private void setEnd(int end) {
        this.end = end;
    }

    public int getEnd() {
        return end;
    }
}
