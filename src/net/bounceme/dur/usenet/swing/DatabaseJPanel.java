/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.bounceme.dur.usenet.swing;

/**
 *
 * @author thufir
 */
public class DatabaseJPanel extends javax.swing.JPanel {

    /**
     * Creates new form DatabaseJPanel
     */
    public DatabaseJPanel() {
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

        center = new javax.swing.JPanel();
        commentWest = new javax.swing.JScrollPane();
        commentJList = new javax.swing.JList();
        commentCenter = new javax.swing.JScrollPane();
        commentJTextArea = new javax.swing.JTextArea();
        south = new javax.swing.JPanel();
        newCommentJButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setLayout(new javax.swing.BoxLayout(this, javax.swing.BoxLayout.LINE_AXIS));

        center.setLayout(new java.awt.BorderLayout());

        commentJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        commentWest.setViewportView(commentJList);

        center.add(commentWest, java.awt.BorderLayout.CENTER);

        commentJTextArea.setColumns(20);
        commentJTextArea.setRows(5);
        commentCenter.setViewportView(commentJTextArea);

        center.add(commentCenter, java.awt.BorderLayout.PAGE_START);

        south.setLayout(new java.awt.BorderLayout());

        newCommentJButton.setText("jButton1");
        south.add(newCommentJButton, java.awt.BorderLayout.EAST);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        south.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        center.add(south, java.awt.BorderLayout.PAGE_END);

        add(center);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel center;
    private javax.swing.JScrollPane commentCenter;
    private javax.swing.JList commentJList;
    private javax.swing.JTextArea commentJTextArea;
    private javax.swing.JScrollPane commentWest;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton newCommentJButton;
    private javax.swing.JPanel south;
    // End of variables declaration//GEN-END:variables
}
