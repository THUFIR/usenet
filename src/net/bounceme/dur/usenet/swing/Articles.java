package net.bounceme.dur.usenet.swing;

import javax.swing.ListModel;

public class Articles extends javax.swing.JPanel {

    @SuppressWarnings("unchecked")
    public Articles() {
        initComponents();
        articles.setPrototypeCellValue("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        west = new javax.swing.JScrollPane();
        articles = new javax.swing.JList();
        center = new javax.swing.JScrollPane();
        content = new javax.swing.JTextPane();

        setLayout(new java.awt.BorderLayout());

        articles.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        articles.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                articlesMouseReleased(evt);
            }
        });
        articles.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                articlesKeyReleased(evt);
            }
        });
        west.setViewportView(articles);

        add(west, java.awt.BorderLayout.WEST);

        center.setViewportView(content);

        add(center, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void articlesMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_articlesMouseReleased
        foo();
    }//GEN-LAST:event_articlesMouseReleased

    private void articlesKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_articlesKeyReleased
        foo();
    }//GEN-LAST:event_articlesKeyReleased

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList articles;
    private javax.swing.JScrollPane center;
    private javax.swing.JTextPane content;
    private javax.swing.JScrollPane west;
    // End of variables declaration//GEN-END:variables

    private void foo() {
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
