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
public class TextInterface {

    public Scanner scanner;
    private int mode = 0;
    private boolean on;
    private View view;
    private GameMechanics game;

    public TextInterface() {
        scanner = new Scanner(System.in);
        on = false;
        view = new View();
        game = new GameMechanics();
    }

    public void run() {
        on = true;
        while (on) {
            
            menu();
            
            switch (mode) {
                case 1:
                    play();
                    break;
                case 2:
                    rules();
                    break;
                case 3:
                    on = false;
                    break;
            }

        }
    }
    
    public void menu() {
        view.menu();
        String params = scanner.next();
        mode = view.validate(params);
    }
    
    public void play() {
        game.start();
    }
    
    public void rules() {
        view.rules();
    }

    
}
