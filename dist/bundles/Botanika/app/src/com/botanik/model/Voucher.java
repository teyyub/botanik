package com.botanik.model;

/**
 *
 * @author teyyub Aug 11, 2016 3:36:21 PM
 */
public class Voucher extends Base {

    public Voucher() {
    }

    public Voucher(String name) {
        super(name);
    }

    public Voucher(Number id, String name) {
        super(id, name);
    }

    @Override
    public String toString() {
        return super.getName();
    }
}
