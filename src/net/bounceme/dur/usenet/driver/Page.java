package net.bounceme.dur.usenet.driver;

import javax.mail.Folder;
import net.bounceme.dur.usenet.model.Newsgroup;

public class Page {

    private DatabaseUtils database = new DatabaseUtils();
     private String folderFullName;
     private int min;
     private int max;
     private int delta = 20;
     private int index;

    private Page() {
    }

    public Page(Newsgroup newsgroup) {
        folderFullName = newsgroup.getNewsgroup();
        max = database.getMaxMessageNumber(newsgroup);
        int tempMin = max - delta;
        min = (tempMin > 0) ? tempMin : 1;
    }


    @Override
    public String toString() {
        return getFolderFullName() + " max\t" + getMax();
    }

    public String getFolderFullName() {
        return folderFullName;
    }

    public void setFolderFullName(String folderFullName) {
        this.folderFullName = folderFullName;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getDelta() {
        return delta;
    }

    public void setDelta(int delta) {
        this.delta = delta;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
