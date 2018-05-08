/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import utilities.User;

/**
 *
 * @author Roni
 */

/**
 * This is used to edit the high score file and to create String type 
 * reprentations of the data. Also has a few methods for analyzing the data.
 * 
 * @param file   text files content
 *
 */
public class HighscoreData implements UserDao {

    private List<User> users;
    private String file;

    public HighscoreData(String file) {
        users = new ArrayList<>();
        this.file = file;
        load();
    }

    private void load() {
        try {
            Scanner reader = new Scanner(new File(file));
            while (reader.hasNextLine()) {
                String[] parts = reader.nextLine().split(";");
                User u = new User(parts[0], Integer.parseInt(parts[1]));
                users.add(u);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void save() {
        try {
            FileWriter writer = new FileWriter(new File(file));
            for (User user : users) {
                writer.write(user.getUsername() + ";" + user.getScore() + "\n");
            }
            writer.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * @return Returns a string which includes the top three (biggest score)
     * users each in a separate line.
     */
    public String getTopThree() {
        List<User> temp = users;
        Collections.sort(temp);
        Collections.reverse(temp);
        ArrayList<User> list = new ArrayList<>();
        if (temp.size() > 0) {
            list.add(temp.get(0));
        }
        if (temp.size() > 1) {
            list.add(temp.get(1));
        }
        if (temp.size() > 2) {
            list.add(temp.get(2));
        }

        String result = "";
        result = list.stream().map((a) -> a.toString() + "\n").reduce(result, String::concat);
        return result;
    }

    /**
     * 
     * @return returns a list of users
     */
    @Override
    public List<User> getAll() {
        return users;
    }

    /**
     * 
     * @param username
     * @return User with username same as the parameter. Returns
     * null if no user with given username was found.
     */
    @Override
    public User findByUsername(String username) {
        return users.stream().filter(u -> u.getUsername().equals(username)).findFirst().orElse(null);
    }

    /**
     * Adds the given user to the list of users if there is not already a user
     * by the same name. Name also has to be exactly 3 characters long.
     * If given an existing name, system will check if the new record is higher
     * than the original in the list, if it is, the number is updated.
     * 
     * @param user
     * @return returns the given user
     */
    @Override
    public User create(User user) {
        boolean exists = false;
        for (User a : users) {
            if (a.getUsername().equals(user.getUsername())) {
                if (a.getScore() < user.getScore()) {
                    a.setScore(user.getScore());
                }
                exists = true;
            }
        }

        if (!exists && (user.getUsername().length() == 3)) {
            users.add(user);
        }
        save();
        return user;
    }

}
