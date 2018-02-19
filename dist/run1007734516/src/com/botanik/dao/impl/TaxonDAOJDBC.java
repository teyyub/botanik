package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import com.botanik.dao.intf.TaxonDAO;
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
 * @author teyyub , Feb 5, 2018 , 10:05:37 AM
 */
public class TaxonDAOJDBC implements TaxonDAO {

    
      private Taxon mapTaxon(ResultSet rs) throws SQLException {
        Taxon t = new Taxon();
        t.setId(rs.getLong(1));
        t.setFull_name(rs.getString(2));
        return t;
    }
    
    @Override
    public void saveTaxon(Taxon taxon) {
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

            s.executeUpdate("insert into taxon(name ,genus_id,rank_id,tax_status_id,species_id,sub_species_id,variety_id,"
                    + "sub_variety_id,forma_id,sub_forma_id,"
                    + "author_id,sub_author_id,v_author_id,sv_author_id,f_author_id,sb_author_id,at_id,basionym_id,annotation,status) values('"
                    + taxon.getName() + "','" + taxon.getGenus_id() + "','" + taxon.getRank_id() + "','" + taxon.getTax_status_id() + "','" + taxon.getSpecies_id()
                    + "','" + taxon.getSub_species_id() + "','" + taxon.getVariety_id() + "','"
                    + taxon.getSub_variety_id() + "','" + taxon.getForma_id() + "','" + taxon.getSub_forma_id() + "','"
                    + taxon.getAuthor_id() + "','" + taxon.getSub_author_id() + "','" + taxon.getV_author_id() + "','" + taxon.getSv_author_id() + "','"
                    + taxon.getForma_id() + "','" + taxon.getSf_author_id() + "','" + taxon.getAccepted_taxon_id() + "','" + taxon.getBasionym_id() + "','" + taxon.getAnnotation()
                    + "','a');");

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveTaxon " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s);
        }
    }

    @Override
    public List<Taxon> getTaxon() {
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
            rs = s.executeQuery("select  g.id , g.name   from taxon t\n" +
                               "left join genus g on t.genus_id = g.id ");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                taxons.add(mapTaxon(rs));
            }

        } catch (SQLException e) {
            System.out.println("exception in getTaxon "+e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return taxons;
    }

}
