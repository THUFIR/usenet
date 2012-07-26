package net.bounceme.dur.usenet.swing;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.ListModel;
import net.bounceme.dur.usenet.controller.Controller;
import net.bounceme.dur.usenet.controller.MessageBean;
import net.bounceme.dur.usenet.controller.MessagesDefaultListModel;

public class MessageSelect extends javax.swing.JPanel implements Observer {

    private static final Logger LOG = Logger.getLogger(MessageSelect.class.getName());
    private Controller controller = Controller.getInstance();
    private ListModel messages = new MessagesDefaultListModel();
    private MessageBean messageBean = new MessageBean();

    @SuppressWarnings("unchecked")
    public MessageSelect() {
        controller.addObserver(this);
        initComponents();
        messagesJList.setPrototypeCellValue("xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        center = new javax.swing.JScrollPane();
        messageContent = new javax.swing.JTextPane();
        south = new javax.swing.JPanel();
        commentJButton = new javax.swing.JButton();
        west = new javax.swing.JScrollPane();
        messagesJList = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        center.setMinimumSize(new java.awt.Dimension(200, 100));

        messageContent.setContentType("text/html"); // NOI18N
        messageContent.setMinimumSize(new java.awt.Dimension(180, 80));
        messageContent.setPreferredSize(new java.awt.Dimension(210, 105));
        center.setViewportView(messageContent);

        add(center, java.awt.BorderLayout.CENTER);

        south.setLayout(new java.awt.BorderLayout());

        commentJButton.setText("comment");
        commentJButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                commentJButtonActionPerformed(evt);
            }
        });
        south.add(commentJButton, java.awt.BorderLayout.CENTER);

        add(south, java.awt.BorderLayout.SOUTH);

        messagesJList.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        messagesJList.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                messagesJListMouseReleased(evt);
            }
        });
        messagesJList.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                messagesJListKeyReleased(evt);
            }
        });
        west.setViewportView(messagesJList);

        add(west, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void commentJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentJButtonActionPerformed
        LOG.fine("button clicked" + messageBean);
    }//GEN-LAST:event_commentJButtonActionPerformed

    private void messagesJListKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_messagesJListKeyReleased
        userSelectedRow();
    }//GEN-LAST:event_messagesJListKeyReleased

    private void messagesJListMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_messagesJListMouseReleased
        userSelectedRow();
    }//GEN-LAST:event_messagesJListMouseReleased
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane center;
    private javax.swing.JButton commentJButton;
    private javax.swing.JTextPane messageContent;
    private javax.swing.JList messagesJList;
    private javax.swing.JPanel south;
    private javax.swing.JScrollPane west;
    // End of variables declaration//GEN-END:variables

    @Override
    @SuppressWarnings("unchecked")
    public void update(Observable o, Object arg) {
        LOG.fine("trying folder:  " + arg);
        //Folder folder = null;
        try {
            Folder folder = (Folder) arg;
            messages = new MessagesDefaultListModel(folder);
            LOG.fine("how many messages? " + messages.getSize());
            messagesJList.setModel(messages);
            LOG.fine("loaded messages..");
        } catch (Exception e) {  //err, class cast exception?
            LOG.fine("not a valid folder " + arg);
        }
    }

    private void userSelectedRow() {
        messageBean = (MessageBean) messagesJList.getSelectedValue();
        LOG.fine(messageBean.toString());
        messageContent.setText(messageBean.getContent());
        LOG.fine("..gotMessageBean: " + messageBean);
    }
}
