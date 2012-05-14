package net.bounceme.dur.usenet.swing;

import javax.swing.DefaultButtonModel;
import net.bounceme.dur.usenet.swing.model.MessageBean;

public final class BtnMdl extends DefaultButtonModel {

     private MessageBean message;


    public BtnMdl(MessageBean message) {
        setMessage(message);
    }

    public MessageBean getMessage() {
        return message;
    }

    public void setMessage(MessageBean message) {
        this.message = message;
    }


}
