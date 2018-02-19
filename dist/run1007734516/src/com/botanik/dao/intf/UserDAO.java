package com.botanik.dao.intf;

import com.botanik.model.User;

/**
 *
 * @author teyyub , Feb 13, 2018 , 4:54:32 PM
 */
public interface UserDAO {

    public User user(String username, String password);

    public boolean checkUser(String username, String password);

}
