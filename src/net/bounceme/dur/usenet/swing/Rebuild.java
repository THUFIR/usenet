/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bounceme.dur.usenet.swing;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.bounceme.dur.usenet.controller.DatabaseUtils;

/**
 *
 * @author thufir
 */
public class Rebuild extends javax.swing.JPanel {

    private DatabaseUtils db = DatabaseUtils.INSTANCE;

    public Rebuild() {
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

        rebuildButton = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        rebuildButton.setText("jButton1");
        rebuildButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rebuildButtonActionPerformed(evt);
            }
        });
        add(rebuildButton, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void rebuildButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rebuildButtonActionPerformed

        try {
            db.rebuild();
        } catch (Exception ex) {
            Logger.getLogger(Rebuild.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_rebuildButtonActionPerformed
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton rebuildButton;
    // End of variables declaration//GEN-END:variables
}
