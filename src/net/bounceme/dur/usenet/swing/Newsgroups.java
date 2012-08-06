package net.bounceme.dur.usenet.swing;

import javax.swing.ListModel;
import net.bounceme.dur.usenet.model.Newsgroup;

public class Newsgroups extends javax.swing.JPanel {

    @SuppressWarnings("unchecked")
    public Newsgroups() {
        initComponents();
        ListModel myList = new NewsgroupListModel();
        newsgroupsJList.setModel(myList);
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
        newsgroupsJList = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        newsgroupsJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        newsgroupsJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        newsgroupsJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                newsgroupsJListMouseReleased(evt);
            }
        });
        newsgroupsJList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                newsgroupsJListKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(newsgroupsJList);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void newsgroupsJListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_newsgroupsJListKeyReleased
        newsgroupSelected();
    }//GEN-LAST:event_newsgroupsJListKeyReleased

    private void newsgroupsJListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_newsgroupsJListMouseReleased
        newsgroupSelected();
    }//GEN-LAST:event_newsgroupsJListMouseReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList newsgroupsJList;
    // End of variables declaration//GEN-END:variables

    private void newsgroupSelected() {
        Newsgroup newsgroup = (Newsgroup) newsgroupsJList.getSelectedValue();
        this.firePropertyChange("newsgroup", null, newsgroup);
    }
}
