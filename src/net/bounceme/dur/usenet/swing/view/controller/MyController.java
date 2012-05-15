package net.bounceme.dur.usenet.swing.view.controller;

import java.util.Observable;

public class MyController extends Observable {

    public MyController() {
        String s = "OBSERVED!!!!!";
        setChanged();
        notifyObservers(s);
    }
}
