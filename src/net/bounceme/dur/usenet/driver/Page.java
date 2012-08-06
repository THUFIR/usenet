package net.bounceme.dur.usenet.driver;

import javax.mail.Folder;

public class Page {

    private Folder folder;
    private int min;
    private int max;
    private int delta = 20;

    private Page() {
    }

    public Page(Folder folder, int max) {
        this.folder = folder;
        this.max = Math.abs(max);
        int tempMin = max - delta;
        min = (tempMin > 0) ? tempMin : 1;
    }

    public Folder getFolder() {
        return folder;
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
}
