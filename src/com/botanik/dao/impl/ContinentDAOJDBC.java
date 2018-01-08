package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.callableStatement;
import static com.botanik.dao.DAOUtil.close;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Continent;
import com.botanik.model.Country;
import com.botanik.model.Region;
import java.io.IOException;
//import com.project.model.Continent;
//import com.botanik.model.Country;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub Aug 1, 2016 9:21:14 AM
 */
public class ContinentDAOJDBC implements ContinentDAO {

//    private final DAOFactory daoFactory;
//
//    public ContinentDAOJDBC(DAOFactory daoFactory) {
//        this.daoFactory = daoFactory;
//    }
    @Override
    public List<Continent> getContinents() {
        List<Continent> continents = new ArrayList<>();
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            rs = s.executeQuery("select * from continent");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                continents.add(mapContinent(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return continents;
    }

    private Continent mapContinent(ResultSet rs) throws SQLException {
        Continent c = new Continent();
        c.setId(rs.getLong(1));
        c.setName(rs.getString(2));
        return c;
    }
    
     private Country mapCountry(ResultSet rs) throws SQLException {
        Country  c = new Country();
        c.setId(rs.getLong(1));
        c.setName(rs.getString(2));
        return c;
    }

     private Region  mapRegion(ResultSet rs) throws SQLException {
        Region  c = new Region();
        c.setId(rs.getLong(1));
        c.setName(rs.getString(2));
        return c;
    }
     
    @Override
    public List<Country> getCountries() {
        List<Country> countrys = new ArrayList<>();
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            rs = s.executeQuery("select * from Country");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                countrys.add(mapCountry(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return countrys;
    }
@Override
    public List<Region> getRegions() {
        List<Region> regions = new ArrayList<>();
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            rs = s.executeQuery("select * from region");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                regions.add(mapRegion(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return regions;
    }
}
