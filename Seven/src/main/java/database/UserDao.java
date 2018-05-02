/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.util.List;
import utilities.User;

/**
 *
 * @author Roni
 */
public interface UserDao {

    User create(User user);

    User findByUsername(String username);

    List<User> getAll();
}
