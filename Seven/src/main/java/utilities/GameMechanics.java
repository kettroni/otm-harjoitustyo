/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.HashSet;

/**
 * This is created in every iteration, checks if user input is
 * the same as the current (right) answer. Also checks wheter the current
 * value is prohibited or not.
 * @author Roni
 */
public class GameMechanics {

    private int current;
    private boolean no;
    private String cause;

    public GameMechanics(int start) {
        current = start;
        no = false;
    }

    /**
     * This method takes the user input as String 'answer', checks if the current
     * is prohibited or not and if so then checks the answer is empty.
     * Then checks if the answer is equal to current.
     * @param answer
     * @return true if answer is correct. False if answer is 
     * incorrect.
     */
    final public boolean start(String answer) {
        String guess = answer;
        if (divSeven()) {
            cause = "Divisible By 7";
            no = true;
            if (checkIfNotSkipping(guess)) {
                return lose();
            }
        } else if (includesSeven()) {
            cause = "Includes 7";
            no = true;
            if (checkIfNotSkipping(guess)) {
                return lose();
            }
        } else if (appearsTwice()) {
            cause = "Same appears twice";
            no = true;
            if (checkIfNotSkipping(guess)) {
                return lose();
            }
        }
        if (!no) {
            if (checkIfNotSame(guess)) {
                cause = "\nYour input was: " + guess + "\n"
                        + "Expected value was: " + current;
                return lose();
            }
        }

        no = false;

        return true;
    }
    
    /**
     * Checks if guess is not equal to current.
     * @param guess
     * @return true if not equal. False if equal.
     */
    public boolean checkIfNotSame(String guess) {
        return !guess.equals(Integer.toString(current));
    }

    /**
     * Checks if guess is not an empty ("") String
     * @param a
     * @return true if a is not empty. Otherwise false. 
     */
    public boolean checkIfNotSkipping(String a) {
        return !a.isEmpty();
    }

    /**
     * Checks if the current value is divisible by seven
     * @return true if divisible by 7. Otherwise false.
     */
    public boolean divSeven() {
        return current % 7 == 0;
    }

    /**
     * Checks if the current value includes the number seven in it.
     * @return true if current includes 7. Otherwise false.
     */
    public boolean includesSeven() {
        return Integer.toString(current).contains("7");
    }

    /**
     * Checks if the current value has any number that appears 
     * at least twice in it.
     * @return true if appears twice. Otherwise false.
     */
    public boolean appearsTwice() {
        String temp = Integer.toString(current);
        int len = temp.length();
        HashSet<String> set = new HashSet();
        for (int i = 0; i < len; i++) {
            set.add(temp.charAt(i) + "");
        }
        return set.size() < len;
    }

    /*
    public String timeOutCause() {
        return "            YOU LOST               \n"
                + "-------------------------------\n"
                + "You Lost at " + current + ". \n"
                + "Caused by: Timeout (after 2 seconds)";
    }
    */
    
    /**
     * Sets cause to a specific format and returns false for start method.
     * @return false;
     */
    public boolean lose() {
        cause = "            YOU LOST               \n"
                + "-------------------------------\n"
                + "You Lost at " + current + ". \n"
                + "Caused by: " + cause;
        return false;
    }
    
    public String getCause() {
        return cause;
    }
}
