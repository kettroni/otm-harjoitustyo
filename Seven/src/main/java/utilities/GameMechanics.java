/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilities;

import java.util.HashSet;

/**
 *
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
     *
     * @param answer
     * @return
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
    
    public boolean checkIfNotSame(String guess) {
        return !guess.equals(Integer.toString(current));
    }

    public boolean checkIfNotSkipping(String a) {
        return !a.isEmpty();
    }

    public boolean divSeven() {
        return current % 7 == 0;
    }

    public boolean includesSeven() {
        return Integer.toString(current).contains("7");
    }

    public boolean appearsTwice() {
        String temp = Integer.toString(current);
        int len = temp.length();
        HashSet<String> set = new HashSet();
        for (int i = 0; i < len; i++) {
            set.add(temp.charAt(i) + "");
        }
        return set.size() < len;
    }

    public boolean lose() {
        cause = "            YOU LOST               \n"
                + "-----------------------------------\n"
                + "You Lost at " + current + ". \n"
                + "Caused by: " + cause;
        return false;
    }

    public String getCause() {
        return cause;
    }
}
