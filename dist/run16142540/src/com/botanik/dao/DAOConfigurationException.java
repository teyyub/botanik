package com.botanik.dao;

/**
 *
 * @author teyyub Mar 13, 2016 12:28:51 PM
 */
public class DAOConfigurationException extends RuntimeException {

    public DAOConfigurationException(String message) {
        super(message);
    }
 
    public DAOConfigurationException(Throwable cause) {
        super(cause);
    }
 
    public DAOConfigurationException(String message, Throwable cause) {
        super(message, cause);
    }
}
