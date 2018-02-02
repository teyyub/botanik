package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.callableStatement;
import static com.botanik.dao.DAOUtil.close;
import com.botanik.dao.intf.ContinentDAO;
import com.botanik.model.Collection;
import com.botanik.model.Continent;
import com.botanik.model.Country;
import com.botanik.model.Institution;
import com.botanik.model.Rank;
import com.botanik.model.Region;
import com.botanik.model.Status;
import com.botanik.model.Type;
import com.botanik.model.Voucher;
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
        Country c = new Country();
        c.setId(rs.getLong(1));
        c.setName(rs.getString(2));
        return c;
    }

    private Institution mapInstitution(ResultSet rs) throws SQLException {
        Institution ins = new Institution(rs.getLong(1), rs.getString(2));
        return ins;
    }

    private Voucher mapVoucher(ResultSet rs) throws SQLException {
        Voucher v = new Voucher(rs.getLong(1), rs.getString(2));
        return v;
    }

    private Type mapType(ResultSet rs) throws SQLException {
        Type t = new Type(rs.getLong(1), rs.getString(2));
        return t;
    }

    private Region mapRegion(ResultSet rs) throws SQLException {
        Region c = new Region();
        c.setId(rs.getLong(1));
        c.setName(rs.getString(2));
        return c;
    }

    private Rank mapRank(ResultSet rs) throws SQLException {
        Rank r = new Rank();
        r.setId(rs.getLong(1));
        r.setName(rs.getString(2));
        return r;
    }

    private Status mapTaxStatus(ResultSet rs) throws SQLException {
        Status s = new Status();
        s.setId(rs.getLong(1));
        if (!rs.getString(2).isEmpty()) {
            s.setName(rs.getString(2).trim());
        }
        return s;
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

    @Override
    public List<Rank> getRanks() {
        List<Rank> ranks = new ArrayList<>();
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            rs = s.executeQuery("select * from rank where status='a'");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                ranks.add(mapRank(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return ranks;
    }

    @Override
    public List<Status> getTaxStatus() {
        List<Status> statuses = new ArrayList<>();
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
            rs = s.executeQuery("select * from tax_status where status='a'");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                statuses.add(mapTaxStatus(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return statuses;
    }

    @Override
    public void saveResions(List<Region> regions) {

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
            for (Region r : regions) {
                s.executeUpdate("insert into tax_status(name ,status) values('" + r.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveResions " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public void saveContries(List<Country> country) {

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
            for (Country c : country) {
                s.executeUpdate("insert into country(name ,status) values('" + c.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in savecontry " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

    }

    @Override
    public void saveInstitution(List<Institution> institions) {
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            for (Institution ins : institions) {
                s.executeUpdate("insert into institution(name ,status) values('" + ins.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in save institution " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public void saveCollection(List<Collection> collections) {
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            for (Collection col : collections) {
                s.executeUpdate("insert into country(name ,status) values('" + col.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in save collection " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public void saveVoucher(List<Voucher> vouchers) {
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            for (Voucher v : vouchers) {
                s.executeUpdate("insert into voucher(name ,status) values('" + v.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in save voucher" + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public void saveTType(List<Type> types) {
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            for (Type t : types) {
                s.executeUpdate("insert into t_type(name ,status) values('" + t.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in savecontry " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public void saveStatus(List<Status> statuses) {
        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(false);
            Object[] values = {};
            s = conn.createStatement();
            for (Status sta : statuses) {
                s.executeUpdate("insert into country(name ,status) values('" + sta.getName() + "','a');");
            }

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in save statuses" + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public List<Institution> getInstitutionList() {
        List<Institution> institutions = new ArrayList<>();
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
            rs = s.executeQuery("select * from institution");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                institutions.add(mapInstitution(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return institutions;
    }

    @Override
    public List<Voucher> getVoucherList() {
        List<Voucher> vouchers = new ArrayList<>();
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
            rs = s.executeQuery("select * from institution");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                vouchers.add(mapVoucher(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return vouchers;
    }

    @Override
    public List<Type> getTTypesList() {
        List<Type> types = new ArrayList<>();
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
            rs = s.executeQuery("select * from t_type");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                types.add(mapType(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return types;
    }
}
