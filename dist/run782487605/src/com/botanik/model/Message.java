package com.botanik.model;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author teyyub
 */
public class Message implements Serializable{
    private Date dateSent;
    private String user;
    private String text;

    public Date getDateSent() {
        return dateSent;
    }

    public void setDateSent(Date dateSent) {
        this.dateSent = dateSent;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

     
    
    
}
