package net.bounceme.dur.usenet.swing.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultBoundedRangeModel;
import net.bounceme.dur.usenet.model.Usenet;

public class MyBoundedRangeModel extends DefaultBoundedRangeModel {

    private Usenet usenet = Usenet.INSTANCE;
    private final static Logger LOG = Logger.getLogger(MyBoundedRangeModel.class.getName());
    private static final Level LEVEL = Level.INFO;
    
    public MyBoundedRangeModel() {
        this.setMaximum(100);
        this.setMinimum(1);
//        LOG.log(LEVEL, usenet.getMessages(null));
    }
}
