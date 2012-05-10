package net.bounceme.dur.usenet.controller;

import java.util.logging.Logger;

public class Marker {

    private static final Logger LOG = Logger.getLogger(Marker.class.getName());
    private int start = 0;
    private int end = 0;
    private String group = "";
    
    private Marker() {
    }

    public Marker(String g, int s, int e) {
        setGroup(g);
        setStart(s);
        setEnd(e);
        LOG.info(toString());
    }

    @Override
    public final String toString() {
        String s = "start " + getStart() + " end " + getEnd() + " " + getGroup();
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
