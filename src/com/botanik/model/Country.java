package com.botanik.model;

/**
 *
 * @author teyyub Aug 1, 2016 8:59:08 AM
 */
public class Country {

    private Number id;
    private String name;

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
