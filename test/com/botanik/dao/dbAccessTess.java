 

package com.botanik.dao;

import static com.botanik.dao.DAOUtil.close;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertFalse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Feb 15, 2018 11:28:15 AM Expression teyyub is undefined on line 28, column 30 in Templates/UnitTests/JUnit4TestClass.java. 
 */
public class dbAccessTess {

    public dbAccessTess() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        
    }

    @After
    public void tearDown() {
    }
 
    @Test
    public void testConnection() throws SQLException, IOException, ClassNotFoundException{
        Connection conn  = null;
        try {
            conn = DAOUtil.getUcanaccessConnection();
            assertFalse(conn.isClosed());
        } finally {
            close(conn);
        }
    }
    @Test
    public void testExecute(){
        
    }

}