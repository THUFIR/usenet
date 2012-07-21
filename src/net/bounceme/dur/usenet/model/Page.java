
package net.bounceme.dur.usenet.model;

public class Page {
    private int start;
    private int end;

    Page(String group, int max) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    Page(String fullName, int index, int count) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    String getGroup() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    
}
