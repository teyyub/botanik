package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.prepareStatement;
import static com.botanik.dao.DAOUtil.toSqlDate;
import com.botanik.model.Specimen;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author Feb 5, 2018 6:55:22 PM Expression teyyub is undefined on line 28,
 * column 30 in Templates/UnitTests/JUnit4TestClass.java.
 */
public class SpecimenDAOJDBCTest {

    public SpecimenDAOJDBCTest() {
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
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    @Test
    public void testDateInsert() throws SQLException {
        Statement s = null;
        Connection conn = null;

        try {
            conn = DAOUtil.getUcanaccessConnection();
        } catch (IOException | ClassNotFoundException ex) {
//                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
        }
//            conn.setAutoCommit(true);
        Object[] values = {};
        s = conn.createStatement();
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("MM/dd/yyyy");

        String date = DATE_FORMAT.format(new Date());

        System.out.println("date = " + date);

        s.executeUpdate("insert into specimen(begin_date) values(#02/07/2016#)");

        String sql = "INSERT INTO specimen (begin_date) VALUES (?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setDate(1, java.sql.Date.valueOf("2016-05-31"));
        ps.executeUpdate();

    }

    @Test
    public void test1() {

        Connection conn = null;
        PreparedStatement ps =null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {

            }

            Specimen specimen = new Specimen();
            specimen.setInstitution_id(1);
            specimen.setCollection_id(2);
            specimen.setAdd_collector_id(3);
            specimen.setFirst_collector_id(4);
            specimen.setHerba_no("1234N");
            specimen.setType_id(5);
            specimen.setVoucher_id(6);
            specimen.setStatus_id(7);
            specimen.setCountry_id(8);
            specimen.setTaxon_id(9);
            specimen.setDef_Ref_conf("set1");
            specimen.setTypified_id("typified");
            specimen.setIden_history("ident");
            specimen.setImage_folder("C:/Botanika/image");            
                    
            specimen.setN1(Double.valueOf("49"));
            specimen.setN2(Double.valueOf("34"));
            specimen.setN3(Double.valueOf("0"));
            specimen.setE1(Double.valueOf("34"));
            specimen.setE2(Double.valueOf("24"));
            specimen.setE3(Double.valueOf("0"));
            
             String SQL_STRING = "insert into specimen(institute_id ,status_id , country_id, region_id, "
                                                    + " voucher_id, type_id, collection_id , herba_no, taxon_id, def_ref_conf, ident_history, "
                                                    + "typefied, first_collector_id, add_collector_id, begin_date, end_date,"
                                                    + "number, locality, annotation ,note, literature,image_folder,status,create_date)"
                                                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

             Object[] values = {specimen.getInstitution_id(), specimen.getStatus_id(), specimen.getCountry_id(),
                specimen.getRegion_id(), specimen.getVoucher_id(), specimen.getType_id(), specimen.getCollection_id(),
                specimen.getHerba_no(), specimen.getTaxon_id(), specimen.getDef_Ref_conf(),
                specimen.getIden_history(), specimen.getTypified_id(), specimen.getFirst_collector_id(), specimen.getAdd_collector_id(),
                toSqlDate(specimen.getBeginDate()), toSqlDate(specimen.getEndDate()),
                specimen.getNumber(), specimen.getLocality(), specimen.getAnnotation(), specimen.getNote(),
                specimen.getLiterature(), specimen.getImage_folder(),specimen.getStatus(),toSqlDate(specimen.getDate())};
             
            ps = prepareStatement(conn, SQL_STRING, true, values);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            System.out.println("key = "+key);

            Object[] gmapValue = {
                gen_id,             //1
                specimen.getN1(),  //2 
                specimen.getN2(),  //3
                specimen.getN3(), //4
                specimen.getE1(), //5
                specimen.getE2(), //6
                specimen.getE3(), //6
                new Date(), //8
                "a"}; //9
            String SQL_MAP = "insert into gmap(specimen_id, lat_deg, lat_min, lat_sec, long_deg, long_min, long_sec, create_date ,status)values(?,?,?,?,?,?,?,?,?)";

            ps = prepareStatement(conn, SQL_MAP, gmapValue);
            ps.execute();

//            prepareStatement(conn, SQL_STRING, values);

        } catch (SQLException e) {
            System.err.println("exception in saveSpecimen " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
//            close(conn);
        }
    }

    @Test
    public void test() {
        double d = 0.051;
        DecimalFormat df = new DecimalFormat("#.######");
        System.out.println(df.format(d));

        double PI = 3.1415;
        DecimalFormat df1 = new DecimalFormat("###.######");
        System.out.println(df1.format(PI));

    }
}
