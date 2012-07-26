package net.bounceme.dur.usenet.swing;

//time to pass objects around in view

import java.util.logging.Logger;
import net.bounceme.dur.usenet.controller.Controller;

public class PanelWithTabs extends javax.swing.JPanel {

    private static final Logger LOG = Logger.getLogger(PanelWithTabs.class.getName());
    private Controller controller = Controller.getInstance();

    public PanelWithTabs() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        groupArticleDatabase = new javax.swing.JTabbedPane();
        groupSelect = new net.bounceme.dur.usenet.swing.Groups();
        articleSelect = new net.bounceme.dur.usenet.swing.Messages();
        databaseJPanel = new net.bounceme.dur.usenet.swing.Comments();

        setLayout(new java.awt.BorderLayout());

        groupArticleDatabase.setTabPlacement(javax.swing.JTabbedPane.RIGHT);
        groupArticleDatabase.addTab("GroupSelect", groupSelect);
        groupArticleDatabase.addTab("ArticleList", articleSelect);
        groupArticleDatabase.addTab("Database", databaseJPanel);

        add(groupArticleDatabase, java.awt.BorderLayout.CENTER);
        groupArticleDatabase.getAccessibleContext().setAccessibleName("GroupSelect");
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.bounceme.dur.usenet.swing.Messages articleSelect;
    private net.bounceme.dur.usenet.swing.Comments databaseJPanel;
    private javax.swing.JTabbedPane groupArticleDatabase;
    private net.bounceme.dur.usenet.swing.Groups groupSelect;
    // End of variables declaration//GEN-END:variables
}
