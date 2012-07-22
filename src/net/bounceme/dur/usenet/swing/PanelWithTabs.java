package net.bounceme.dur.usenet.swing;

import java.util.logging.Logger;

public class PanelWithTabs extends javax.swing.JPanel {

    private static final Logger LOG = Logger.getLogger(PanelWithTabs.class.getName());

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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        groupSelect = new net.bounceme.dur.usenet.swing.GroupSelect();
        groupSelect2 = new net.bounceme.dur.usenet.swing.GroupSelect();
        jPanel1 = new javax.swing.JPanel();

        groupSelect.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                groupSelectPropertyChange(evt);
            }
        });

        groupSelect2.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                groupSelect2PropertyChange(evt);
            }
        });

        javax.swing.GroupLayout groupSelectLayout = new javax.swing.GroupLayout(groupSelect);
        groupSelect.setLayout(groupSelectLayout);
        groupSelectLayout.setHorizontalGroup(
            groupSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupSelectLayout.createSequentialGroup()
                .addGap(101, 101, 101)
                .addComponent(groupSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(79, Short.MAX_VALUE))
        );
        groupSelectLayout.setVerticalGroup(
            groupSelectLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(groupSelectLayout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(groupSelect2, javax.swing.GroupLayout.PREFERRED_SIZE, 276, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(28, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("GroupSelect", groupSelect);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 606, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 330, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 770, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 614, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(82, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 436, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(37, 37, 37)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 367, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(32, Short.MAX_VALUE)))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void groupSelect2PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_groupSelect2PropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_groupSelect2PropertyChange

    private void groupSelectPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_groupSelectPropertyChange
        LOG.warning("bog   " + evt);
    }//GEN-LAST:event_groupSelectPropertyChange
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private net.bounceme.dur.usenet.swing.GroupSelect groupSelect;
    private net.bounceme.dur.usenet.swing.GroupSelect groupSelect2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
