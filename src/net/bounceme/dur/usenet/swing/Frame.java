package net.bounceme.dur.usenet.swing;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.DefaultListModel;
import net.bounceme.dur.usenet.controller.Marker;
import net.bounceme.dur.usenet.controller.Persist;
import net.bounceme.dur.usenet.controller.Usenet;

public class Frame extends javax.swing.JFrame {

    private final static Logger LOG = Logger.getLogger(Usenet.class.getName());
    private Usenet u = Usenet.INSTANCE;

    @SuppressWarnings("unchecked")
    public Frame() {
        initComponents();
        load();
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
        panelWithList1 = new net.bounceme.dur.usenet.swing.PanelWithList();
        panelWithTable1 = new net.bounceme.dur.usenet.swing.PanelWithTable();
        panelWithText1 = new net.bounceme.dur.usenet.swing.PanelWithText();
        panelWithSlider1 = new net.bounceme.dur.usenet.swing.PanelWithSlider();

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
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 960, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(527, Short.MAX_VALUE)
                .addComponent(panelWithSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 508, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );

        java.awt.Dimension screenSize = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        setBounds((screenSize.width-994)/2, (screenSize.height-632)/2, 994, 632);
    }// </editor-fold>//GEN-END:initComponents

    private void panelWithList1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelWithList1PropertyChange
        Object newValue = evt.getNewValue();
        String group = newValue.toString();
        if (evt.getPropertyName().equals("list")) {
            panelWithText1.setJTextArea(group);
        }
        int slider = panelWithSlider1.getValue();
        setMarker(new Marker(group, slider));
    }//GEN-LAST:event_panelWithList1PropertyChange

    private void panelWithSlider1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelWithSlider1PropertyChange
        int slider = 1;
        if (evt.getPropertyName().equals("slider")) {
            slider = (int) evt.getNewValue();
        }
        String group = panelWithList1.getGroup();
        setMarker(new Marker(group, slider));
    }//GEN-LAST:event_panelWithSlider1PropertyChange

    private void panelWithTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_panelWithTable1PropertyChange
        if (evt.getPropertyName().equals("message")) {
            Msg msg = (Msg) evt.getNewValue();
            int id = msg.getId();
            String group = panelWithList1.getGroup();
            String subject = msg.getSubject();
            String content = msg.getContent();
            Msg message = new Msg(id, group, subject, content);
            Persist p = Persist.INSTANCE;
            p.persist(message);
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
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Frame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
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
    private net.bounceme.dur.usenet.swing.PanelWithList panelWithList1;
    private net.bounceme.dur.usenet.swing.PanelWithSlider panelWithSlider1;
    private net.bounceme.dur.usenet.swing.PanelWithTable panelWithTable1;
    private net.bounceme.dur.usenet.swing.PanelWithText panelWithText1;
    // End of variables declaration//GEN-END:variables

    @SuppressWarnings("unchecked")
    private void load() {
        List<Folder> folders = u.getFolders();
        DefaultListModel defaultListModel = new DefaultListModel();
        for (Folder f : folders) {
            String z = f.getFullName();
            defaultListModel.addElement(z);
        }
        LOG.fine(defaultListModel.toString());
        panelWithList1.setJList(defaultListModel);
    }

    private void setMarker(Marker marker) {
        try {
            panelWithTable1.setMessages(marker);
        } catch (Exception ex) {
            Logger.getLogger(Frame.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
