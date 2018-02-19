package com.botanik.model;

/**
 *
 *@author teyyub  Aug 12, 2016 12:31:59 AM
 */
public class Institution extends Base{

    public Institution() {
    }

    public Institution(String name) {
        super(name);
    }

    public Institution(Number id, String name, String daoStatus) {
        super(id, name, daoStatus);
    }

    public Institution(Number id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return super.getName(); 
    }
   
    
}
