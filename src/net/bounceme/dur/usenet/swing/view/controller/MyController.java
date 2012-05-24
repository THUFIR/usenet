package net.bounceme.dur.usenet.swing.view.controller;

import java.util.List;
import java.util.Observable;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.MessageBean;
import net.bounceme.dur.usenet.swing.Marker;
import net.bounceme.dur.usenet.swing.Usenet;

public class MyController extends Observable {

    private final static Logger LOG = Logger.getLogger(MyController.class.getName());
    private Usenet u = Usenet.INSTANCE;

    public MyController() {
    }

    public void foo() {
        setChanged();
        notifyObservers();
    }

    @SuppressWarnings("unchecked")
    public void load() {
        List<Folder> folders = u.getFolders();
        DefaultListModel defaultListModel = new DefaultListModel();
        for (Folder f : folders) {
            String z = f.getFullName();
            defaultListModel.addElement(z);
        }
        LOG.fine(defaultListModel.toString());
        //panelWithList1.setJList(defaultListModel);
    }

    public void setMarker(Marker marker) {
        //panelWithTable1.setMessages(marker);
    }

    public void panelWithList1PropertyChange(java.beans.PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("list")) {
            Object newValue = evt.getNewValue();
            String group = newValue.toString();
            //int slider = panelWithSlider1.getValue();
            //setMarker(new Marker(group, slider));
        }
    }

    public void panelWithSlider1PropertyChange(java.beans.PropertyChangeEvent evt) {
        int slider = 1;
        if (evt.getPropertyName().equals("slider")) {
            slider = (int) evt.getNewValue();
        }
        //String group = panelWithList1.getGroup();
        //setMarker(new Marker(group, slider));
    }

    public void panelWithTable1PropertyChange(java.beans.PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("message")) {
            Object o = evt.getNewValue();
            MessageBean message = (MessageBean) o;
            //message.setGroup(panelWithList1.getGroup());
            //panelWithText1.setMessage(message);
        }
    }
}
