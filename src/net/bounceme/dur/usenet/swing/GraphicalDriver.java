package net.bounceme.dur.usenet.swing;

import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import net.bounceme.dur.usenet.controller.DatabaseUtils;
import net.bounceme.dur.usenet.controller.Page;
import net.bounceme.dur.usenet.model.Newsgroup;

public class GraphicalDriver {

    private static final Logger LOG = Logger.getLogger(GraphicalDriver.class.getName());
    private DatabaseUtils database = new DatabaseUtils();
    private List<Folder> subscribed;
    private Newsgroups n = new Newsgroups();
    private Articles a = new Articles();

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
        n.addPropertyChangeListener(null);

        tabs.add(n);
        tabs.add(a);
        frame.add(tabs);


        n.addPropertyChangeListener(new java.beans.PropertyChangeListener() {

            @Override
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tabsEvent(evt);
            }
        });

        frame.pack();
        frame.setVisible(true);
        LOG.fine("**************************done");
    }

    private void tabsEvent(PropertyChangeEvent evt) {
        String event = evt.getPropertyName();
        switch (event.toLowerCase()) {
            case "newsgroup":
                Newsgroup newsgroup = (Newsgroup) evt.getNewValue();
                Page page = new Page(newsgroup);
                //a.load(page);
                break;
            case "article":
                break;
            default:
                break;
        }



    }//end tabsEvent..
}
