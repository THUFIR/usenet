package net.bounceme.dur.usenet.controller;

import java.util.logging.Logger;

public class Marker {

    private static final Logger LOG = Logger.getLogger(Marker.class.getName());
    private int start = 5;
    private int end = 5;
    private String group = "";

    private Marker() {
    }

    public Marker(String g, int s, int e) {
        setGroup(g);
        setStart(s);
        setEnd(e);
        LOG.fine(toString());
    }

    @Override
    public final String toString() {
        String s = "\n\nstart " + getStart() + "\nend " + getEnd() + "\ngroup " + getGroup() + "\n\n";
        return s;
    }

    public int getStart() {
        return start;
    }

    private void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    private void setEnd(int end) {
        this.end = end;
    }

    public String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }
}
