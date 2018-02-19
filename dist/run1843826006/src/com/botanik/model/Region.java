package com.botanik.model;

/**
 *
 * @author teyyub Aug 1, 2016 9:32:28 AM
 */
public class Region {

    private Number id;
    private String name;

    public Region(String name) {
        this.name = name;
    }

    public Region() {
    }

    public Number getId() {
        return id;
    }

    public void setId(Number id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
