package net.bounceme.dur.usenet.controller;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.bounceme.dur.usenet.model.MyListModel;

public enum NewsGroups {

    INSTANCE;
    private final static Logger LOG = Logger.getLogger(NewsGroups.class.getName());
    private static final Level LEVEL = Level.INFO;
    private MyListModel model;

    NewsGroups() {
    }

    @Override
    public String toString() {
        String s = " ";
        return s;
    }
}