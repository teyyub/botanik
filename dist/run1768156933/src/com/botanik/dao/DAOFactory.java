package com.botanik.dao;

import com.botanik.dao.DAOConfigurationException;
 
 
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 *
 * @author teyyub Mar 13, 2016 12:47:17 PM
 */
public abstract class DAOFactory implements Serializable{

    private static final String PROPERTY_URL = "url";
    private static final String PROPERTY_DRIVER = "driver";
    private static final String PROPERTY_USERNAME = "username";
    private static final String PROPERTY_PASSWORD = "password";

    // Actions ------------------------------------------------------------------------------------
//    public static DAOFactory getInstance(String name) throws DAOConfigurationException {
//        if (name == null) {
//            throw new DAOConfigurationException("Database name is null.");
//        }
//
//        DAOProperties properties = new DAOProperties(name);
//        String url = properties.getProperty(PROPERTY_URL, true);
//        String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
//        String password = properties.getProperty(PROPERTY_PASSWORD, false);
//        String username = properties.getProperty(PROPERTY_USERNAME, password != null);
//
//        DAOFactory instance;
//
//        // If driver is specified, then load it to let it register itself with DriverManager.
//        if (driverClassName != null) {
//            try {
//                Class.forName(driverClassName);
//            } catch (ClassNotFoundException e) {
//                throw new DAOConfigurationException(
//                        "Driver class '" + driverClassName + "' is missing in classpath.", e);
//            }
//            instance = new DriverManagerDAOFactory(url, username, password);
//        } // Else assume URL as DataSource URL and lookup it in the JNDI.
//        else {
//            DataSource dataSource;
//            try {
//                dataSource = (DataSource) new InitialContext().lookup(url);
//            } catch (NamingException e) {
//                throw new DAOConfigurationException(
//                        "DataSource '" + url + "' is missing in JNDI.", e);
//            }
//            if (username != null) {
//                instance = new DataSourceWithLoginDAOFactory(dataSource, username, password);
//            } else {
//                instance = new DataSourceDAOFactory(dataSource);
//            }
//        }
//
//        return instance;
//    }

       public static DAOFactory getInstance(String name) throws DAOConfigurationException {
     
        if (name == null) {
            throw new DAOConfigurationException("Database name is null.");
        }

        DAOProperties properties = new DAOProperties(name);
        String url = properties.getProperty(PROPERTY_URL, true);
        String driverClassName = properties.getProperty(PROPERTY_DRIVER, false);
        String password = properties.getProperty(PROPERTY_PASSWORD, false);
        String username = properties.getProperty(PROPERTY_USERNAME, password != null);

        DAOFactory instance;

        // If driver is specified, then load it to let it register itself with DriverManager.
        if (driverClassName != null) {
            try {
                Class.forName(driverClassName);
            } catch (ClassNotFoundException e) {
                throw new DAOConfigurationException(
                        "Driver class '" + driverClassName + "' is missing in classpath.", e);
            }
            instance = new DriverManagerDAOFactory(url, username, password);
        } // Else assume URL as DataSource URL and lookup it in the JNDI.
        else {
            DataSource dataSource;
            try {
                dataSource = (DataSource) new InitialContext().lookup(url);
            } catch (NamingException e) {
                throw new DAOConfigurationException(
                        "DataSource '" + url + "' is missing in JNDI.", e);
            }
            if (username != null) {
                instance = new DataSourceWithLoginDAOFactory(dataSource, username, password);
            } else {
                instance = new DataSourceDAOFactory(dataSource);
            }
        }

        return instance;
    }
    
    public abstract Connection getConnection() throws SQLException;

    // DAO implementation getters -----------------------------------------------------------------
    /**
     * Returns the User DAO associated with the current DAOFactory.
     *
     * @return The User DAO associated with the current DAOFactory.
     */
//    public AuthorDAO getAuthorDAO() {
//        return new AuthorDAOJDBC(this);
//    }
//
//    public LiteratureDAO getLiteratureDAO() {
//        return new LiteratureDAOJDBC(this);
//    }
//
//    public SpecimenDAO getSpecimenDAO() {
//        return new SpecimenDAOJDBC(this);
//    }
//
//    public EpithetDAO getEpithetDAO() {
//        return new EpithetDAOJDBC(this);
//    }
//
//    public MenuDAO getMenuDAO() {
//        return new MenuDAOJDBC(this);
//    }
//
//    public MessageDAO getMessageDAO() {
//        return new MessageDAOJDBC(this);
//    }
//    public ServiceDAO getServiceDAO() {
//        return new ServiceDAOJDBC(this);
//    }
//
//    public MenuDAO getMenuDAO() {
//        return new MenuDAOJDBC(this);
//    }
//
//    public CustomerDAO getCustomerDAO() {
//        return new CustomerDAOJDBC(this);
//    }
//
//    public ReservDAO getReservDAO() {
//        return new ReservDAOJDBC(this);
//    }
//
//    public ReportDAO getReportDAO() {
//        return new ReportDAOJDBC(this);
//    }
//    

//    public UserDAO getUserDAO() {
//        return new UserDAOJDBC(this);
//    }
//
//    public OperationDAO getOperationDAO() {
//       return new OperationDaoJDBC(this);
//    }
//    
//    public DiscountDAO getDiscountDAO() {
//        return new DiscountDAOJDBC(this);
//    }
//
//    public RuleDAO getRuleDAO(){
//      return new RuleDAOJDBC(this);
//    }   

    // You can add more DAO implementation getters here.
}

// Default DAOFactory implementations -------------------------------------------------------------
/**
 * The DriverManager based DAOFactory.
 */
class DriverManagerDAOFactory extends DAOFactory {

    private String url;
    private String username;
    private String password;

    DriverManagerDAOFactory(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }
}

/**
 * The DataSource based DAOFactory.
 */
class DataSourceDAOFactory extends DAOFactory {

    private DataSource dataSource;

    DataSourceDAOFactory(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}

/**
 * The DataSource-with-Login based DAOFactory.
 */
class DataSourceWithLoginDAOFactory extends DAOFactory {

    private DataSource dataSource;
    private String username;
    private String password;

    DataSourceWithLoginDAOFactory(DataSource dataSource, String username, String password) {
        this.dataSource = dataSource;
        this.username = username;
        this.password = password;
    }

    @Override
    public Connection getConnection() throws SQLException {
        return dataSource.getConnection(username, password);
    }
}
