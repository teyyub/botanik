package com.botanik.dao;

import com.botanik.dao.DAOConfigurationException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
 

/**
 *
 * @author teyyub Mar 13, 2016 12:44:57 PM
 */
public class DAOProperties {

    private static final String PROPERTIES_FILE = "dao.properties";
    private static final Properties PROPERTIES = new Properties();

    static {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();

        InputStream propertiesFile = classLoader.getResourceAsStream(PROPERTIES_FILE);
//        propertiesFile = ec.getResourceAsStream(PROPERTIES_FILE);
                
        if (propertiesFile == null) {
            throw new DAOConfigurationException(
                    "Properties file '" + PROPERTIES_FILE + "' is missing in classpath.");
        }
        try {
            PROPERTIES.load(propertiesFile);
        } catch (IOException e) {
            throw new DAOConfigurationException(
                    "Cannot load properties file '" + PROPERTIES_FILE + "'.", e);
        }
    }

    // Vars ---------------------------------------------------------------------------------------
    private String specificKey;

    public DAOProperties(String specificKey) throws DAOConfigurationException {
        this.specificKey = specificKey;
    }

    public String getProperty(String key, boolean mandatory) throws DAOConfigurationException {
        String fullKey = specificKey + "." + key;
        String property = PROPERTIES.getProperty(fullKey);

        if (property == null || property.trim().length() == 0) {
            if (mandatory) {
                throw new DAOConfigurationException("Required property '" + fullKey + "'"
                        + " is missing in properties file '" + PROPERTIES_FILE + "'.");
            } else {
                // Make empty value null. Empty Strings are evil.
                property = null;
            }
        }

        return property;
    }

}
