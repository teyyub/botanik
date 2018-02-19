package com.botanik.model;

import java.io.Serializable;

/**
 *
 * @author teyyub Aug 1, 2016 12:03:34 PM
 */
public class Base implements Serializable{

    private Number id;
    private String name;
    private String daoStatus;

    public Base(Number id, String name, String daoStatus) {
        this.id = id;
        this.name = name;
        this.daoStatus = daoStatus;
    }

    public Base(Number id, String name) {
        this.id = id;
        this.name = name;
    }

    public Base() {
    }

    public Base(String name) {
        this.name = name;
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

    public String getDaoStatus() {
        return daoStatus;
    }

    public void setDaoStatus(String daoStatus) {
        this.daoStatus = daoStatus;
    }

    @Override
    public String toString() {
        return name;
    }
 
    
    
}
