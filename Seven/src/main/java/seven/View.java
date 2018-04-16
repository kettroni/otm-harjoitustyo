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
public class View {
    private final Scanner scanner;

    public View() {
        scanner = new Scanner(System.in);
    }
    public void menu() {
        System.out.println("            'Seven' - Menu               ");
        System.out.println("-----------------------------------------");
        System.out.println("Start game............................[1]");
        System.out.println("Rules.................................[2]");
        System.out.println("Quit..................................[3]");
        System.out.println("Type out the command number here and press enter: ");
    }
    
    public void rules() {
        System.out.println("            'Seven' - Rules               ");
        System.out.println("Input integers in ascending order.\n"
                + "First type 1 and press 'Enter', then proceed with 2 and press 'Enter' and so on. \n"
                + "There are 'prohibited' numbers which you're not allowed to type in, and these are the following: \n"
                + "     1) any number divisible by the number 7 \n"
                + "     2) any number that includes the number 7 \n"
                + "     3) any number that includes more than one occurence of a specific number, ex. '11', '22', '343' etc. \n"
                + "Instead of typing any of these forbidden numbers, just press 'Enter' and continue to the next integer. \n"
                + "Notice that there can be multiple 'skips' in a row. \n"
                + "The game ends when you don't input a right number or you don't skip at the right time.");
        System.out.println();
        System.out.println();
        System.out.println("Type 1 and 'Enter' to go back to menu");
        String param = scanner.nextLine();
        while (!param.equals("1")) {
            System.out.println("Wrong input, type '1' and press 'Enter'");
            param = scanner.nextLine();
        }
    }

    public int validate(String params) {
        int mode;
        try {
            mode = Integer.parseInt(params);
            if (mode < 1 || mode > 3) {
                System.out.println("Wrong input, try again");
                return 0;
            }
            return mode;
        } catch (NumberFormatException e) {
            System.out.println("Wrong input, try again");
            return 0;
        }
    }
}
