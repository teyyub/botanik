/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.model.Specimen;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Feb 8, 2018 8:47:23 PM Expression teyyub is undefined on line 28,
 * column 30 in Templates/UnitTests/JUnit4TestClass.java.
 */
public class SpecimenDAOJDBCIT {

    public SpecimenDAOJDBCIT() {
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

    /**
     * Test of saveSpecimen method, of class SpecimenDAOJDBC.
     */
    @Test
    public void testSaveSpecimen() {
        System.out.println("saveSpecimen");
        Specimen specimen = new Specimen();
        SpecimenDAOJDBC instance = new SpecimenDAOJDBC();
        instance.saveSpecimen(specimen);
        
         
    }

     @Test
     public void testDateUtil(){
        
     }
    
    
    /**
     * Test of getSpecimenBy method, of class SpecimenDAOJDBC.
     * @return 
     */
    @Test
    public void testGetSpecimenBy() {
        Specimen specimen = new Specimen();
        
        List<Specimen> specimens = new ArrayList<>();
        
        String SQL_GETSPECIMEN = " select * from specimen where ";

        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {specimen.getTaxon_id(), specimen.getCountry_id(), specimen.getRegion_id()};
            ps = prepareStatement(conn, SQL_GETSPECIMEN, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                specimens.add(mapSpecimen(rs));
            }

        } catch (SQLException e) {
            System.out.println("exception in getSpecimen " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

         

    }
 
private Specimen mapSpecimen(ResultSet rs){
      Specimen specimen = new Specimen();
      
      return specimen;
    }
 
}
