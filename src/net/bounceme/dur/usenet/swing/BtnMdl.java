package net.bounceme.dur.usenet.swing;

import javax.swing.DefaultButtonModel;

public class BtnMdl extends DefaultButtonModel {

    private Msg message;

    BtnMdl(Msg message) {
        this.message = message;
    }

    public Msg getMessage() {
        return message;
    }
}