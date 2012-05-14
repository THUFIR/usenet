
package net.bounceme.dur.usenet.model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractListModel;

public class MyListModel extends AbstractListModel {

    
    private static final Logger LOG = Logger.getLogger(MyListModel.class.getName());
    private static final Level LEVEL = Level.INFO;
    private List<String> foo = new ArrayList<>();
    
    @Override
    public int getSize() {
        return foo.size();
    }

    @Override
    public Object getElementAt(int index) {
        return foo.get(index);
    }
    
}
