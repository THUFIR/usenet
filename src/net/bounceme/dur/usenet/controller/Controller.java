package net.bounceme.dur.usenet.controller;

import java.util.Observable;
import java.util.logging.Logger;

public class Controller extends Observable {

    private static final Logger LOG = Logger.getLogger(Controller.class.getName());
    private String group;
    private static Controller instance;

    protected Controller() {
    }

    public static Controller getInstance() {
        if (instance == null) {
            instance = new Controller();
        }
        return instance;
    }


    public void setGroup(String selectedValue) {
        group = selectedValue;
        LOG.fine(group);
        notifyObservers();
    }

    public String getGroup() {
        return group;
    }

}
