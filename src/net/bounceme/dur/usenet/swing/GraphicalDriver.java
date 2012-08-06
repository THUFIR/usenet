package net.bounceme.dur.usenet.swing;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import net.bounceme.dur.usenet.controller.Page;
import net.bounceme.dur.usenet.model.Newsgroup;

public class GraphicalDriver {

    private static final Logger LOG = Logger.getLogger(GraphicalDriver.class.getName());
    private Newsgroups n = new Newsgroups();
    private Articles a = new Articles();
    private Rebuild r = new Rebuild();

    public static void main(String[] args) {
        try {
            GraphicalDriver main = new GraphicalDriver();
        } catch (Exception ex) {
            Logger.getLogger(GraphicalDriver.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public GraphicalDriver() {

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //GraphicsEnvironment e = GraphicsEnvironment.getLocalGraphicsEnvironment();
        //frame.setMaximizedBounds(e.getMaximumWindowBounds());
        //frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);
        frame.setLayout(new BorderLayout());

        JTabbedPane tabs = new JTabbedPane();

        tabs.add(r);
        tabs.add(n);
        tabs.add(a);
        frame.add(tabs);


        n.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                try {
                    tabsEvent(evt);
                } catch (        IOException | MessagingException ex) {
                    Logger.getLogger(GraphicalDriver.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });

        frame.pack();
        frame.setVisible(true);
        LOG.fine("**************************done");
    }

    private void tabsEvent(PropertyChangeEvent evt) throws IOException, MessagingException {
        String event = evt.getPropertyName();
        switch (event.toLowerCase()) {
            case "newsgroup":
                Newsgroup newsgroup = (Newsgroup) evt.getNewValue();
                a.load(newsgroup);
                break;
            case "article":
                break;
            default:
                break;
        }



    }//end tabsEvent..
}
