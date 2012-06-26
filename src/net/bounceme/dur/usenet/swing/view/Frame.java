package net.bounceme.dur.usenet.swing.view;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.mail.Message;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.model.MessageBean;
import net.bounceme.dur.usenet.model.Usenet;
import net.bounceme.dur.usenet.swing.model.MyBoundedRangeModel;
import net.bounceme.dur.usenet.swing.model.Page;

public class Frame extends javax.swing.JFrame {

    private final static Logger LOG = Logger.getLogger(Frame.class.getName());
    private Usenet usenet = Usenet.INSTANCE;

    public Frame() {
        initComponents();
        loadFoldersListModel();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        panelWithList1 = new net.bounceme.dur.usenet.swing.view.PanelWithList();
        panelWithTable1 = new net.bounceme.dur.usenet.swing.view.PanelWithTable();
        panelWithText1 = new net.bounceme.dur.usenet.swing.view.PanelWithText();
        panelWithSlider1 = new net.bounceme.dur.usenet.swing.view.PanelWithSlider();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jTabbedPane1.setTabPlacement(javax.swing.JTabbedPane.RIGHT);

        panelWithList1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelWithList1PropertyChange(evt);
            }
        });
        jTabbedPane1.addTab("tab1", panelWithList1);

        panelWithTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelWithTable1PropertyChange(evt);
            }
        });
        jTabbedPane1.addTab("tab2", panelWithTable1);
        jTabbedPane1.addTab("tab3", panelWithText1);

        panelWithSlider1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                panelWithSlider1PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelWithSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 819, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(153, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 948, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(24, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(710, Short.MAX_VALUE)
                .addComponent(panelWithSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 674, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(99, Short.MAX_VALUE)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-994)/2, (screenSize.height-815)/2, 994, 815);
    }// </editor-fold>//GEN-END:initComponents

    private void panelWithList1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelWithList1PropertyChange
        if (evt.getPropertyName().equals("list")) {
            Object newValue = evt.getNewValue();
            String group = newValue.toString();
            Page f = usenet.getFoo(group);
            /*Page p = new Page(group, 10);
            try {
                usenet.getMessages(p);
            } catch (Exception ex) {
                Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
            }
            int max = usenet.getMax();
            Page page = new Page(group, max);
            setSliderModel(page);*/
        }
    }//GEN-LAST:event_panelWithList1PropertyChange

    private void panelWithSlider1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelWithSlider1PropertyChange
        int slider = 1;
        if (evt.getPropertyName().equals("slider")) {
            slider = (int) evt.getNewValue();
            String group = panelWithList1.getGroup();
            setTableMessages(new Page(group, slider));
        }
    }//GEN-LAST:event_panelWithSlider1PropertyChange

    private void panelWithTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelWithTable1PropertyChange
        if (evt.getPropertyName().equals("message")) {
            Object o = evt.getNewValue();
            MessageBean message = (MessageBean) o;
            message.setGroup(panelWithList1.getGroup());
            panelWithText1.setMessage(message);
        }
    }//GEN-LAST:event_panelWithTable1PropertyChange

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /*
         * Set the Nimbus look and feel
         */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the
         * default look and feel. For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /*
         * Create and display the form
         */
        java.awt.EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTabbedPane jTabbedPane1;
    private net.bounceme.dur.usenet.swing.view.PanelWithList panelWithList1;
    private net.bounceme.dur.usenet.swing.view.PanelWithSlider panelWithSlider1;
    private net.bounceme.dur.usenet.swing.view.PanelWithTable panelWithTable1;
    private net.bounceme.dur.usenet.swing.view.PanelWithText panelWithText1;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("unchecked")
    private void loadFoldersListModel() {
        List<Folder> folders = usenet.getFolders();
        DefaultListModel defaultListModel = new DefaultListModel();
        for (Folder f : folders) {
            String fullGroupName = f.getFullName();
            defaultListModel.addElement(fullGroupName);
        }
        LOG.fine(defaultListModel.toString());
        panelWithList1.setJList(defaultListModel);
    }

    private void setTableMessages(Page page) {
        try {
            panelWithTable1.setMessages(page);
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void setSliderModel(Page page) {
        MyBoundedRangeModel model = new MyBoundedRangeModel(page);
        panelWithSlider1.setModel(model);
        setTableMessages(page);
    }
}
