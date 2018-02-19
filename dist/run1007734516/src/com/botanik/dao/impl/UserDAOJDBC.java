package com.botanik.dao.impl;

import com.botanik.dao.DAOUtil;
import static com.botanik.dao.DAOUtil.close;
import static com.botanik.dao.DAOUtil.prepareStatement;
import com.botanik.dao.intf.UserDAO;
import com.botanik.model.User;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:55:22 PM
 */
public class UserDAOJDBC implements UserDAO {

    @Override
    public User user(String username, String password) {

        final String SQL_CHESK_USER = " select * from specimen ";

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
            Object[] values = {username, password};
            ps = prepareStatement(conn, SQL_CHESK_USER, values);
            rs = ps.executeQuery();
            if (!rs.next()) {

            }

        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

        return new User();

    }

    @Override
    public boolean checkUser(String username, String password) {
        final String SQL_CHESK_USER = " select * from specimen ";
        boolean found = false;
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
            Object[] values = {username, password};
            ps = prepareStatement(conn, SQL_CHESK_USER, values);
            rs = ps.executeQuery();
            if (rs.next()) {
                found = !found;
            }

        } catch (SQLException e) {
            System.out.println("exception in user " + e.getMessage());
//            daoUtils.getLogger().error(e);
        } finally {
            close(conn, ps, rs);
        }

        return found;
    }

}
