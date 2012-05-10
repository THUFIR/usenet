package net.bounceme.dur.usenet.controller;

import java.util.logging.Logger;

public class Marker {

    private static final Logger LOG = Logger.getLogger(Marker.class.getName());
    private int start = 15;
    private int end = 20;
    private String group = "";

    private Marker() {
    }

    public Marker(String g, int s, int e) {
        setGroup(g);
        setStart(Math.abs(s));
        setEnd(Math.abs(e));
        LOG.fine(toString());
    }

    @Override
    public final String toString() {
        String s = "\n\n****\nmarker is\nstart " + getStart() + "\nend " + getEnd() + "\ngroup " + getGroup() + "\n\n\n****\n";
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

    public int getEnd() {
        return end;
    }

    private void setEnd(int end) {
        if (end > getStart()) {
            this.end = end;
        } else {
            this.end = getStart();
        }
    }

    public String getGroup() {
        return group;
    }

    private void setGroup(String group) {
        this.group = group;
    }
}
