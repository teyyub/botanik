package com.botanik.model;

import java.util.Date;

/**
 *
 *@author teyyub  Sep 10, 2016 11:51:26 AM
 */
public class Rule extends Base{
  private Date insert_date;

    public Date getInsert_date() {
        return insert_date;
    }

    public void setInsert_date(Date insert_date) {
        this.insert_date = insert_date;
    }
  
}
