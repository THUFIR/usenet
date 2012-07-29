package net.bounceme.dur.usenet.controller;

//which branch?

import java.io.IOException;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.mail.MessagingException;

public class MessageBean {

    private String group;
    private String subject;
    private String content;
    private int number;
    private Date sent;
    

    public MessageBean() {
        
    }

    public MessageBean(Message message) {
        try {
            group = message.getFolder().getFullName();
            subject = message.getSubject();
            content = message.getContent().toString();
            number = message.getMessageNumber();
            sent = message.getSentDate();
        } catch (IOException | MessagingException ex) {
            Logger.getLogger(MessageBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public MessageBean(Folder folder) {
        group = folder.getFullName();
    }

    @Override
    public String toString() {
        return getSubject();
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }

}
