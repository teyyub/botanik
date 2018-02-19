package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import static com.botanik.dao.DAOUtil.toSqlDate;
import com.botanik.dao.intf.SpecimenDAO;
import com.botanik.model.SearchModel;
import com.botanik.model.Specimen;
import com.botanik.model.SpecimenSaveModel;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 5, 2018 , 6:09:32 PM
 */
public class SpecimenDAOJDBC implements SpecimenDAO {

    @Override
    public void saveSpecimen(Specimen specimen) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
                conn.setAutoCommit(false);//start transaction
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

//            SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd.MM.yyyy");
//
//            String date = DATE_FORMAT.format(new Date());
            Object[] values = {specimen.getInstitution_id(), specimen.getStatus_id(), specimen.getCountry_id(),
                specimen.getRegion_id(), specimen.getVoucher_id(), specimen.getType_id(), specimen.getCollection_id(),
                specimen.getHerba_no(), specimen.getTaxon_id(), specimen.getDef_Ref_conf(),
                specimen.getIden_history(), specimen.getTypified_id(), specimen.getFirst_collector_id(), specimen.getAdd_collector_id(),
                toSqlDate(specimen.getBeginDate()), toSqlDate(specimen.getEndDate()),
                specimen.getNumber(), specimen.getLocality(), specimen.getAnnotation(), specimen.getNote(),
                specimen.getLiterature(), specimen.getStatus(), specimen.getImage_folder(), toSqlDate(new Date())};

            String SQL_STRING = "insert into specimen(institute_id ,status_id , country_id, region_id, "
                    + " voucher_id, type_id, collection_id , "
                    + "herba_no, taxon_id, def_ref_conf, ident_history, typefied, first_collector_id, add_collector_id, begin_date, end_date,"
                    + "number, locality, annotation ,note, literature,  status , image_folder,create_date)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            ps = prepareStatement(conn, SQL_STRING, true, values);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            System.out.println("key = "+key);

            Object[] gmapValue = {
                gen_id,
                specimen.getN1(),
                specimen.getN2(),
                specimen.getN3(),
                specimen.getE1(),
                specimen.getE2(),
                specimen.getE3(),
                toSqlDate(new Date()),
                "a"};
            String SQL_MAP = "insert into gmap(specimen_id,lat_deg,lat_min,lat_sec,long_deg,long_min,long_sec,create_date,status)values(?,?,?,?,?,?,?,?,?)";

            ps = prepareStatement(conn, SQL_MAP, gmapValue);
            ps.execute();
            conn.commit(); //end transaction

        } catch (SQLException e) {
            System.err.println("exception in saveSpecimen " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public List<Specimen> getSpecimenBy(Specimen specimen) {
        List<Specimen> specimens = new ArrayList<>();

        String SQL_GETSPECIMEN = " select * from specimen ";

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

        return specimens;

    }

    private Specimen mapSpecimen(ResultSet rs) throws SQLException {
        Specimen specimen = new Specimen();
        specimen.setTaxonName(rs.getString(1));
        specimen.setCollectorName(rs.getString(2));
        specimen.setBeginDate(rs.getDate(3));
        specimen.setCollectionName(rs.getString(7));
        return specimen;
    }

    @Override
    public List<Specimen> getSpecimenByModel(SearchModel model) {
        List<Specimen> specimens = new ArrayList<>();

        String SQL_GETSPECIMEN = " SELECT  g.name  as taxon_name , fc.name as  collector_name , s.begin_date ,con.name as country_name , s.locality , tt.name as type_name  ,collec.name as collection_name"
                + "  from (((( ( specimen s  left join taxon t on s.taxon_id = t.id) "
                + " left join genus g on g.id = t.genus_id)"
                + " left join collector fc on fc.id = s.first_collector_id  )"
                + " left join country con on con.id = s.country_id)"
                + " left join t_type tt on tt.id = s.type_id )"
                + " left join collection collec on collec.id = s.collection_id"
                + " where  g.name = ?  ";

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
            Object[] values = {model.taxon()};//, model.family(), model.number(), model.date(), model.countryId(), model.region_id()};
            ps = prepareStatement(conn, SQL_GETSPECIMEN, values);
            rs = ps.executeQuery();
            while (rs.next()) {
                specimens.add(mapSpecimen(rs));
            }

        } catch (SQLException e) {
            System.out.println("exception in getSpecimenByModel " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

        return specimens;

    }

    @Override
    public void saveSpecimen(SpecimenSaveModel model) {
        PreparedStatement ps = null;
        Connection conn = null;
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
                conn.setAutoCommit(false);//start transaction
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }

            Object[] values = {model.institutionId(), model.statusId(), model.countryId(),
                model.regionId(), model.voucherId(), model.typeId(), model.collectionId(),
                model.herbaNo(), model.taxonId(), model.detRefConf(),
                model.idenHistory(), model.typified(), model.firstCollectorId(), model.addCollectorId(),
                toSqlDate(model.beginDate()), toSqlDate(model.endDate()),
                model.locality(), model.annotation(), model.note(),
                model.literature(), toSqlDate(new Date())};

            String SQL_STRING = "insert into specimen(institute_id ,status_id , country_id, region_id, "
                    + " voucher_id, type_id, collection_id , "
                    + "herba_no, taxon_id, def_ref_conf, ident_history, typefied, first_collector_id, add_collector_id, begin_date, end_date,"
                    + "locality, annotation ,note, literature, create_date)"
                    + " values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) ";

            ps = prepareStatement(conn, SQL_STRING, true, values);
            ps.execute();
            ResultSet rs = ps.getGeneratedKeys();
            int gen_id = rs.next() ? rs.getInt(1) : 0;
//            System.out.println("key = "+key);

            Object[] gmapValue = {
                gen_id,
                model.gmap().getLatitudeDegree(),
                model.gmap().getLatitudeMinute(),
                model.gmap().getLatitudeSecond(),
                model.gmap().getLongitudeDegree(),
                model.gmap().getLongitudeMinute(),
                model.gmap().getLongitudeSecond(),
                toSqlDate(new Date()),
                "a"};
            String SQL_MAP = "insert into gmap(specimen_id,lat_deg,lat_min,lat_sec,long_deg,long_min,long_sec,create_date,status)values(?,?,?,?,?,?,?,?,?)";

            ps = prepareStatement(conn, SQL_MAP, gmapValue);
            ps.execute();
            conn.commit(); //end transaction

        } catch (SQLException e) {
            System.err.println("exception in saveSpecimen " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }

}
