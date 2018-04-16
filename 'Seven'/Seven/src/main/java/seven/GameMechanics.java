/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package seven;

import java.util.*;

/**
 *
 * @author Roni
 */
public class GameMechanics {

    private int current;
    private boolean no;
    private Scanner scanner;
    private String cause;

    public GameMechanics() {
        current = 1;
        no = false;
        scanner = new Scanner(System.in);
    }

    public GameMechanics(int start) {
        current = start;
        no = false;
        scanner = new Scanner(System.in);
    }

    public void start() {
        beginning();
        while (true) {
            String guess = scanner.nextLine();
            if (divSeven()) {
                cause = "Divisible By 7";
                no = true;
                if (checkIfNotSkipping(guess)) {
                    break;
                }
            } else if (includesSeven()) {
                cause = "Includes 7";
                no = true;
                if (checkIfNotSkipping(guess)) {
                    break;
                }
            } else if (appearsTwice()) {
                cause = "Same appears twice";
                no = true;
                if (checkIfNotSkipping(guess)) {
                    break;
                }
            }

            if (!no) {
                cause = "\nYour input was: " + guess + "\n"
                        + "Expected value was: " + current;
                if (!guess.equals(Integer.toString(current))) {
                    break;
                }
            }

            no = false;
            current++;
        }
        
        lose();
    }
    
    public void beginning() {
        current = 1;
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("Welcome to 'Seven'! Start with number '1'");
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

    public void lose() {
        System.out.println("            YOU LOST               ");
        System.out.println("-----------------------------------");
        System.out.println("You Lost at " + current + ". \n" 
                + "Caused by: " + cause);
        System.out.println("");
        System.out.println("");
        System.out.println("");
    }
}
