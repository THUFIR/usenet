package net.bounceme.dur.usenet.swing;

import java.util.logging.Logger;
import javax.mail.Folder;
import javax.swing.ListModel;
import net.bounceme.dur.usenet.controller.Controller;
import net.bounceme.dur.usenet.controller.GroupDefaultListModel;

public class GroupSelect extends javax.swing.JPanel {

    private static final Logger LOG = Logger.getLogger(GroupSelect.class.getName());
    private Controller controller = Controller.getInstance();
    private ListModel groups = new GroupDefaultListModel();

    @SuppressWarnings("unchecked")
    public GroupSelect() {
        initComponents();
        //groupJList.setSelectedIndex(0);
        //controller.setGroup(groupJList.getSelectedValue().toString());

        //foo = new ListSelectionEvent();
        //groupJListValueChanged(foo);
        /*
         * ListSelectionEvent(Object source, int firstIndex, int lastIndex,
         * boolean isAdjusting) Represents a change in selection status between
         * firstIndex and lastIndex, inclusive.
         */
        //ListSelectionEvent evt = new ListSelectionEvent(groupJList.class.getName(),1,1,true);
        //groupJListValueChanged(evt);
        LOG.fine("should be changed!");
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
        groupJList = new javax.swing.JList();

        setLayout(new java.awt.BorderLayout());

        groupJList.setModel(groups);
        groupJList.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        groupJList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                groupJListValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(groupJList);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void groupJListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_groupJListValueChanged
        LOG.fine("selected: " + groupJList.getSelectedValue());
        //controller.setGroup(groupJList.getSelectedValue().toString());
        Folder folder = (Folder) groupJList.getSelectedValue();
        controller.setFolder(folder);
    }//GEN-LAST:event_groupJListValueChanged
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList groupJList;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
