package com.botanik.model;

/**
 *
 * @author teyyub , Jan 7, 2018 , 1:19:16 PM
 */
public class Author extends Base {

    private String brummit;

    public Author() {
    }

    public Author(Number id, String brummit, String name) {
        super(id, name);
        this.brummit = brummit;
    }

    public Author(String brummit, String name) {
        super(name);
        this.brummit = brummit;
    }

    public String getBrummit() {
        return brummit;
    }

    public void setBrummit(String brummit) {
        this.brummit = brummit;
    }

    @Override
    public String toString() {
        return super.getName();
    }

}
