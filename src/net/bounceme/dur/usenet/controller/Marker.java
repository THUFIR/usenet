package net.bounceme.dur.usenet.controller;

public class Marker {

    private int start = 0;
    private int end = 0;
    private String group;

    /**
     * @return the start
     */
    public int getStart() {
        return start;
    }

    /**
     * @param start the start to set
     */
    public void setStart(int start) {
        this.start = start;
    }

    /**
     * @return the end
     */
    public int getEnd() {
        return end;
    }

    /**
     * @param end the end to set
     */
    public void setEnd(int end) {
        this.end = end;
    }

    /**
     * @return the group
     */
    public String getGroup() {
        return group;
    }

    /**
     * @param group the group to set
     */
    public void setGroup(String group) {
        this.group = group;
    }
    
    @Override
    public String toString(){
        String s = "start " + getStart() + " end " + getEnd() + " " + getGroup();
        return s;
    }
}
