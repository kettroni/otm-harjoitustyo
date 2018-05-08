/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

/**
 * Class for specific format information, used to compare also
 * @author Roni
 */
public class User implements Comparable<User> {

    private String username;
    private int highscore;

    /**
     * Sets initial values for username and high score
     * @param name
     * @param score 
     */
    public User(String name, int score) {
        username = name;
        highscore = score;
    }
    public void setScore(int number) {
        highscore = number;
    }

    public int getScore() {
        return highscore;
    }

    public String getUsername() {
        return username;
    }

    /**
     * Formats the included data in a specific format
     * @return String representation of the User object
     */
    @Override
    public String toString() {
        return username + "   " + highscore;
    }

    /**
     * compares two Users by their high score
     * @param t the other user which is compared to
     * @return integer which is the difference of the scores
     */
    @Override
    public int compareTo(User t) {
        return (this.highscore - t.getScore());
    }
    
    public boolean equals(User t) {
        return t.getUsername().equals(getUsername());
    }
}
