package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.model.Author;
import com.botanik.model.Family;
import com.botanik.model.Species;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Feb 15, 2018 11:57:08 AM Expression teyyub is undefined on line 28,
 * column 30 in Templates/UnitTests/JUnit4TestClass.java.
 */
public class AuthorDAOJDBCIT {

    AuthorDAOJDBC instance;

    public AuthorDAOJDBCIT() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new AuthorDAOJDBC();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of saveAuthor method, of class AuthorDAOJDBC.
     */
    @Test
    public void testSaveAuthor() {
        /*helelik  bildiyim kimi yaziram amma vaxt olduqca refactor edecem */
        String SQL_SAVE_AUTHOR = "insert into author(name ,brummit,status) values(?,?,?)";
        Author author = new Author("teyyub", "aliyev");
        author.setDaoStatus("a");
        Number id = 0;
        Number author_id = -1;
        PreparedStatement ps = null;
        Connection conn = null;
        ResultSet rs = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {author.getName(), author.getBrummit(),author.getDaoStatus()};
             ps = prepareStatement(conn, SQL_SAVE_AUTHOR, true, values);
            ps.execute();
            rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            }
            
            author_id = instance.authorByName(author.getName()).getId();
//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveResions " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }

 
        assertEquals(id, author_id);
//        instance.deleteAuthorByID(id);
    }

    /**
     * Test of getAuthors method, of class AuthorDAOJDBC.
     */
    @Test
    public void testGetAuthors() {
        System.out.println("getAuthors");

        List<Author> expResult = null;
        List<Author> result = instance.getAuthors();
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of getFamilies method, of class AuthorDAOJDBC.
     */
    @Test
    public void testGetFamilies() {
        System.out.println("getFamilies");

        List<Family> expResult = null;
        List<Family> result = instance.getFamilies();
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of saveFamily method, of class AuthorDAOJDBC.
     */
    @Test
    public void testSaveFamily() {
        System.out.println("saveFamily");
        Family family = null;

        instance.saveFamily(family);

        fail("The test case is a prototype.");
    }

    /**
     * Test of getSpecies method, of class AuthorDAOJDBC.
     */
    @Test
    public void testGetSpecies() {
        System.out.println("getSpecies");

        List<Species> expResult = null;
        List<Species> result = instance.getSpecies();
        assertEquals(expResult, result);

        fail("The test case is a prototype.");
    }

    /**
     * Test of saveSpecies method, of class AuthorDAOJDBC.
     */
    @Test
    public void testSaveSpecies() {
        System.out.println("saveSpecies");
        Species species = null;

        instance.saveSpecies(species);

        fail("The test case is a prototype.");
    }

}
