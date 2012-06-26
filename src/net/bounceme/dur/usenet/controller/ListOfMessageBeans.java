package net.bounceme.dur.usenet.controller;

import java.util.ArrayList;
import java.util.List;
import javax.mail.Folder;
import javax.mail.Message;
import net.bounceme.dur.usenet.model.MessageBean;
import net.bounceme.dur.usenet.model.Usenet;

public class ListOfMessageBeans {

    private List<MessageBean> messages = new ArrayList<>();
    private Usenet usenet = Usenet.INSTANCE;
 
    private void initializze() throws Exception {
        //Properties props = PropertiesReader.getProps();
        //String store = props.getProperty("nntp.host");
        //Page page = new Page();
        //foo();
        //List<Folder> f = Usenet.getFolders();
        List<Folder> folders = usenet.getFolders();
    }

    private void foo(Page page) throws Exception {
        List<Message> rawMessages = usenet.getMessages(page);
        messages.clear();
        for (Message m : rawMessages) {
            MessageBean mb = new MessageBean(m);
            messages.add(mb);
        }
    }
}
