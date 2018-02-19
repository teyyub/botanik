package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import com.botanik.dao.intf.GenusDAO;
import com.botanik.model.Family;
import com.botanik.model.Genus;
import com.botanik.model.Taxon;
import java.io.IOException;
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
 * @author teyyub , Feb 4, 2018 , 2:56:25 PM
 */
public class GenusDAOJDBC implements GenusDAO {

    private Taxon mapTaxon(ResultSet rs) throws SQLException {
        Taxon a = new Taxon();
        a.setId(rs.getLong(1));
        a.setName(rs.getString(2));
        return a;
    }

    private Genus mapGenus(ResultSet rs) throws SQLException {
        Genus g = new Genus();
        g.setId(rs.getLong(1));
        g.setName(rs.getString(2));
        g.setFull_name(rs.getString(2)+" "+rs.getString(3)+" " +rs.getString(4));                
        return g;
    }

    @Override
    public void saveGenus(Genus genus) {
//        ResultSet rs = null;
        Statement s = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            s = conn.createStatement();

            s.executeUpdate("insert into genus(name ,author_id,family_id,taxon_id,ref_no,addition,hybrid,accepted,remarks,status) values('"
                    + genus.getName() + "','" + genus.getAuthor_id() + "','" + genus.getFamily_id() + "','" + genus.getTaxon_id() + "','" + genus.getRef_no()
                    + "','" + genus.getAddition() + "','" + genus.isHybrid() + "','" + genus.isAccepted() + "','" + genus.getRemarks()
                    + "','a');");

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveGenus " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s);
        }
    }

    @Override
    public List<Taxon> getTaxonList() {
        List<Taxon> taxons = new ArrayList<>();
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
            rs = s.executeQuery("select * from taxon");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                taxons.add(mapTaxon(rs));
            }

        } catch (SQLException e) {
            System.out.println("exception in getFamily " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return taxons;
    }

    @Override
    public List<Genus> getGenuses() {
        List<Genus> genuses = new ArrayList<>();
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
            rs = s.executeQuery("select  g.id, g.name, a.name as author  ,f.name as family  from  (genus g\n"
                    + " left join family f on g.family_id = f.id)\n"
                    + "  left join author  a on  g.author_id = a.id  ");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                genuses.add(mapGenus(rs));
            }

        } catch (SQLException e) {
            System.out.println("exception in getGenus " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return genuses;
    }

}
