package net.bounceme.dur.usenet.controller;

import java.util.logging.Logger;

public class Marker {

    private static final Logger LOG = Logger.getLogger(Marker.class.getName());
    private int start = 15;
    private String group = "";

    private Marker() {
    }

    public Marker(String g, int s) {
        LOG.fine("trying to make marker:" + s + g);
        setGroup(g);
        setStart(s);
        LOG.fine(toString());
    }

    @Override
    public final String toString() {
        String s = "\n\n****\nmarker is\nstart " + getStart() + "\ngroup " + getGroup() + "\n\n\n****\n";
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

    int getEnd() {
        return start + 20;
    }
}
