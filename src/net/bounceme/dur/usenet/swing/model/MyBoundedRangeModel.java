package net.bounceme.dur.usenet.swing.model;

import net.bounceme.dur.usenet.controller.Page;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultBoundedRangeModel;
import net.bounceme.dur.usenet.model.Usenet;

public class MyBoundedRangeModel extends DefaultBoundedRangeModel {

    private Usenet usenet = Usenet.INSTANCE;
    private final static Logger LOG = Logger.getLogger(MyBoundedRangeModel.class.getName());
    private static final Level LEVEL = Level.INFO;
    private Usenet u = Usenet.INSTANCE;

    public MyBoundedRangeModel() {
        LOG.fine("shouldn't happen..");
        this.setMaximum(99);
        this.setMinimum(1);
    }

    public MyBoundedRangeModel(Page page) {
        LOG.fine("good.." + page);
        this.setMaximum(page.getEnd());
        this.setMinimum(1);
    }

    @Override
    public String toString() {
        return "max " + this.getMaximum();
    }
}
