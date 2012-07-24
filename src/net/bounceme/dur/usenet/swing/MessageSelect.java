package net.bounceme.dur.usenet.swing;

import java.util.Observable;
import java.util.Observer;
import java.util.logging.Logger;
import javax.swing.ListModel;
import net.bounceme.dur.usenet.controller.Controller;
import net.bounceme.dur.usenet.controller.MessageBean;
import net.bounceme.dur.usenet.controller.MessagesDefaultListModel;

public class MessageSelect extends javax.swing.JPanel implements Observer {

    private static final Logger LOG = Logger.getLogger(MessageSelect.class.getName());
    private Controller controller = Controller.getInstance();
    private ListModel messages = new MessagesDefaultListModel();
    private MessageBean messageBean = new MessageBean();

    public MessageSelect() {
        controller.addObserver(this);
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

        center = new javax.swing.JScrollPane();
        messageContent = new javax.swing.JTextPane();
        south = new javax.swing.JPanel();
        commentJButton = new javax.swing.JButton();
        west = new javax.swing.JScrollPane();
        messagesJList = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        messageContent.setContentType("text/html"); // NOI18N
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
        messagesJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                messagesJListValueChanged(evt);
            }
        });
        west.setViewportView(messagesJList);

        add(west, java.awt.BorderLayout.WEST);
    }// </editor-fold>//GEN-END:initComponents

    private void messagesJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_messagesJListValueChanged
        /*
         * ok, this shouldn't be a value changed listener!  try something else!
         * when this gets nulled or whatever by a change of group, it's in an
         * indeterminate state, neither one group nor another, and hence the
         * errors.
         * 
         * or so I infer.
         */
        LOG.warning("trying to get MessageBean..");
        messageBean = (MessageBean) messagesJList.getSelectedValue();
        LOG.warning(messageBean.toString());
        messageContent.setText(messageBean.getContent());
        LOG.fine("..got MessageBean: " + messageBean);
    }//GEN-LAST:event_messagesJListValueChanged

    private void commentJButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_commentJButtonActionPerformed
        LOG.fine("button clicked" + messageBean);
    }//GEN-LAST:event_commentJButtonActionPerformed
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
        LOG.warning("check controller, but getting null pointer sometimes" + arg);
        //messages = controller.getMessages();
        messages = new MessagesDefaultListModel(arg.toString());
        LOG.warning("how many messages? " + messages.getSize());
        messagesJList.setModel(messages);
        LOG.fine("loaded messages..");
    }
}
