package net.bounceme.dur.usenet.model;

import javax.swing.DefaultBoundedRangeModel;
import net.bounceme.dur.usenet.swing.Usenet;

public class MyBoundedRangeModel extends DefaultBoundedRangeModel {

    private Usenet usenet = Usenet.INSTANCE;

    public MyBoundedRangeModel() {
        this.setMaximum(100);
        this.setMinimum(1);
    }
}
