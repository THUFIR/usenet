package net.bounceme.dur.usenet.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import net.bounceme.dur.usenet.model.MessageBean;
import net.bounceme.dur.usenet.model.Usenet;

public class ListOfMessageBeans {

     private List<MessageBean> messages = new ArrayList<>();
    private Usenet usenet = Usenet.INSTANCE;

    ListOfMessageBeans() {
        try {
            List<Folder> folders = usenet.getFolders();
            Folder folder = folders.get(0);
            Page page = usenet.getPage(folder);
            loadMessages(page);
        } catch (Exception ex) {
            Logger.getLogger(ListOfMessageBeans.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void loadMessages(Page page) throws Exception {
        List<Message> rawMessages = usenet.getMessages(page);
        List<MessageBean> msgs = new ArrayList<>();
        for (Message m : rawMessages) {
            MessageBean mb = new MessageBean(m);
            msgs.add(mb);
        }
        setMessages(msgs);
    }

    public List<MessageBean> getMessages() {
        return messages;
    }

    public void setMessages(List<MessageBean> messages) {
        this.messages = messages;
    }
    
    
}
