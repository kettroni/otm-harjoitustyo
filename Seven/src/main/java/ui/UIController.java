/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilities.GameMechanics;

/**
 *
 * @author Roni
 */
public class UIController extends Application {
    /*
    This is for future when there will be a time limit, still testing.
    private boolean timeRanOut;
    */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Seven - The Game");
        menu(primaryStage);
    }

    public void menu(Stage primaryStage) throws Exception {
        MenuView menu = new MenuView(this);
        menu.start(primaryStage);
    }

    public void startGame(Stage primaryStage, int a) throws Exception {
        GameView gv = new GameView(this, a);
        gv.start(primaryStage);
    }

    public void iterate(Stage primaryStage, int current, TextField tf) throws Exception {
        String answer = tf.getText();
        GameMechanics gm = new GameMechanics(current);
        /*setTimeout(this, 10000);
        */
        if (gm.start(answer)) {
            if (/*timeRanOut*/false) {
                //loseScreen(primaryStage, gm.timeOutCause());
            } else {
                current++;
                startGame(primaryStage, current);
            }
        } else {
            loseScreen(primaryStage, gm.getCause());
        }
    }

    public void loseScreen(Stage primaryStage, String cause) throws Exception {
        LoseView lv = new LoseView(this, cause);
        lv.start(primaryStage);
    }

    public void showHelp(Stage primaryStage) throws Exception {
        HelpView hv = new HelpView(this);
        hv.start(primaryStage);
    }

    /*public void setNoTimeLeft() {
        timeRanOut = true;
    }

    public static void setTimeout(UIController ui, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                ui.setNoTimeLeft();
            } catch (Exception e) {
                System.out.println(e);
            }
        }).start();
    }
    */
    
}
