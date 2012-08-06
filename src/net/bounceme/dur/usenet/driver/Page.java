package net.bounceme.dur.usenet.driver;

import javax.mail.Folder;
import net.bounceme.dur.usenet.model.Newsgroup;

public class Page {

    private String folderFullName;
    private int min;
    private int max;
    private int delta = 20;

    private Page() {
    }

    
    public Page(Newsgroup folder, int max) {
        folderFullName = folder.getNewsgroup();
        this.max = Math.abs(max);
        int tempMin = max - delta;
        min = (tempMin > 0) ? tempMin : 1;
    }
    
    public Page(Folder folder, int max) {
        folderFullName = folder.getFullName();
        this.max = Math.abs(max);
        int tempMin = max - delta;
        min = (tempMin > 0) ? tempMin : 1;
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
}
