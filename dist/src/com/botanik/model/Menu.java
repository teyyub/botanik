package com.botanik.model;

/**
 *
 * @author teyyub
 */
public class Menu extends Base{
    private String page_name;
    private int parent;

    public String getPage_name() {
        return page_name;
    }

    public void setPage_name(String page_name) {
        this.page_name = page_name;
    }

    public int getParent() {
        return parent;
    }

    public void setParent(int parent) {
        this.parent = parent;
    }
    
}
