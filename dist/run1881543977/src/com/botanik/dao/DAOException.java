package com.botanik.dao;

/**
 *
 * @author teyyub Mar 13, 2016 12:24:38 PM
 */
public class DAOException extends RuntimeException {

    public DAOException(String message) {
        super(message);
    }

    public DAOException(Throwable cause) {
        super(cause);
    }
    public DAOException(String message, Throwable cause){
        super(message,cause);
    }
}
