package com.botanik.model;

/**
 *
 * @author teyyub , Feb 2, 2018 , 12:20:37 PM
 */
public class Type extends Base {

    public Type() {
    }

    public Type(String name) {
        super(name);
    }

    public Type(Number id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
