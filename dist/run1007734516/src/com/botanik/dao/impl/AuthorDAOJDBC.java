package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.AuthorDAO;
import com.botanik.model.Author;
import com.botanik.model.Family;
import com.botanik.model.Species;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 2, 2018 , 5:49:16 PM
 */
public class AuthorDAOJDBC implements AuthorDAO {

    @Override
    public void saveAuthor(Author author) {
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_SAVE_AUTHOR = "insert into author(name ,brummit,status) values(?,?)";
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {};
            ps = prepareStatement(conn, SQL_SAVE_AUTHOR, false, values);

            ps.executeQuery();//("insert into author(name ,brummit,status) values('" + author.getName() + "','" + author.getBrummit() + "','a');");

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveAuthor " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
    }

    @Override
    public List<Author> getAuthors() {
        List<Author> authors = new ArrayList<>();
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
            rs = s.executeQuery("select * from author");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                authors.add(mapAuthor(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return authors;
    }

    private Author mapAuthor(ResultSet rs) throws SQLException {
        Author a = new Author();
        a.setId(rs.getLong(1));
        a.setName(rs.getString(2));
        return a;
    }

    private Species mapSpecies(ResultSet rs) throws SQLException {
        Species s = new Species();
        s.setId(rs.getLong(1));
        s.setName(rs.getString(2));
        return s;
    }

    private Family mapFamily(ResultSet rs) throws SQLException {
        Family f = new Family();
        f.setId(rs.getLong(1));
        f.setName(rs.getString(2));
        return f;
    }

    @Override
    public List<Family> getFamilies() {
        List<Family> families = new ArrayList<>();
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
            rs = s.executeQuery("select * from family");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                families.add(mapFamily(rs));
            }

        } catch (SQLException e) {
            System.out.println("exception in getFamily " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return families;
    }

    @Override
    public void saveFamily(Family family) {
        ResultSet rs = null;
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

            s.executeUpdate("insert into family(name ,category_id,status) values('" + family.getName() + "','" + family.getCategory_id() + "','a');");

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveFamily " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }
    }

    @Override
    public List<Species> getSpecies() {
        List<Species> specieses = new ArrayList<>();
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
            rs = s.executeQuery("select * from species");
//            s.execute();
//            rs = s.getResultSet();
            while (rs.next()) {
                specieses.add(mapSpecies(rs));
            }

        } catch (SQLException e) {
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s, rs);
        }

        return specieses;
    }

    @Override
    public void saveSpecies(Species species) {

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

            s.executeUpdate("insert into species(name , status) values('" + species.getName() + "','a');");

//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveSpecies " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, s);
        }
    }

    @Override
    public Author authorByID(Number id) {
        Author author = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        String SQL_AUTHOR_BY_ID = "select * from author where id = ?";
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            ps = prepareStatement(conn, SQL_AUTHOR_BY_ID, false, values);

            rs = ps.executeQuery();//("insert into author(name ,brummit,status) values('" + author.getName() + "','" + author.getBrummit() + "','a');");
            while (rs.next()) {
                author = new Author(rs.getString(2), rs.getString(3));

            }
//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in saveAuthor " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
        return author;
    }

    @Override
    public Author authorByName(String name) {
        Author author = null;
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SQL_AUTHOR_BY_NAME = "select * from author where name = ?";
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {name};
            ps = prepareStatement(conn, SQL_AUTHOR_BY_NAME, false, values);

            rs = ps.executeQuery();//("insert into author(name ,brummit,status) values('" + author.getName() + "','" + author.getBrummit() + "','a');");
            while (rs.next()) {
                author = new Author(rs.getInt(1),rs.getString(2), rs.getString(3));

            }
//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in authorByName " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
        return author;
    }

    @Override
    public void deleteAuthorByID(Number id) {
         
        ResultSet rs = null;
        PreparedStatement ps = null;
        Connection conn = null;
        final String SQL_DELETE_AUTHOR_BY_ID = "delete * from author where id = ?";
        try {
            try {
                conn = DAOUtil.getUcanaccessConnection();
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(ContinentDAOJDBC.class.getName()).log(Level.SEVERE, null, ex);
            }
//            conn.setAutoCommit(true);
            Object[] values = {id};
            ps = prepareStatement(conn, SQL_DELETE_AUTHOR_BY_ID, false, values);

            ps.execute();
//            while (rs.next()) {
//                author = new Author(rs.getInt(1),rs.getString(2), rs.getString(3));
//
//            }
//            s.execute();
//            rs = s.getResultSet();
        } catch (SQLException e) {
            System.err.println("exception in authorByName " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps);
        }
//        return author;
    }

}
