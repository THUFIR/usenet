package net.bounceme.dur.usenet.swing;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.Controller;

public class ArticleList extends javax.swing.JPanel implements Observer {

    private static final Logger LOG = Logger.getLogger(ArticleList.class.getName());
    private Controller controller = Controller.getInstance();
    private DefaultListModel defaultListModel;
    
    public ArticleList() {
        controller.addObserver(this);
        defaultListModel = controller.getArticleList();
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();

        setLayout(new java.awt.BorderLayout());

        jList1.setModel(defaultListModel);
        jScrollPane1.setViewportView(jList1);

        add(jScrollPane1, java.awt.BorderLayout.WEST);

        jScrollPane2.setViewportView(jTextPane1);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList jList1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextPane jTextPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void update(Observable o, Object arg) {
        LOG.severe("trying to observe.." + arg);
        LOG.severe(controller.getGroup());
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}
