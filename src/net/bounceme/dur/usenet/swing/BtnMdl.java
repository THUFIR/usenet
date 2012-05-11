package net.bounceme.dur.usenet.swing;

import javax.swing.DefaultButtonModel;

public class BtnMdl extends DefaultButtonModel {

    private NoteBean message;

    BtnMdl(NoteBean message) {
        this.message = message;
    }

    public NoteBean getMessage() {
        return message;
    }
}
