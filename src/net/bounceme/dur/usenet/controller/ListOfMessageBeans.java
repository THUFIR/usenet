package net.bounceme.dur.usenet.controller;

import java.util.ArrayList;
import java.util.List;
import javax.mail.Message;
import net.bounceme.dur.usenet.model.MessageBean;
import net.bounceme.dur.usenet.model.Usenet;

public class ListOfMessageBeans {

    private List<MessageBean> messages = new ArrayList<>();
    private Usenet usenet = Usenet.INSTANCE;

    private void initialize(String group) throws Exception {
        Page page = new Page(group,10);
        List<Message> foo = usenet.getMessages(page);
    }
}
