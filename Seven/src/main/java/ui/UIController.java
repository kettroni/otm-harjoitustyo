/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import database.HighscoreData;
import javafx.application.Application;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import utilities.GameMechanics;

/**
 * Controls all different views by calling its own different methods.
 *
 * @author Roni
 */
public class UIController extends Application {

    public HighscoreData scores;

    public UIController(HighscoreData score) {
        scores = score;
    }

    /**
     * Initializes the game, calls for menu() method
     *
     * @param primaryStage
     * @throws Exception
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Seven - The Game");
        menu(primaryStage);
    }

    /**
     * Sets the scene to MenuView
     *
     * @param primaryStage
     * @throws Exception
     */
    public void menu(Stage primaryStage) throws Exception {
        MenuView menu = new MenuView(this);
        menu.start(primaryStage);
    }

    /**
     * Starts the game by setting the scene in to GameView, also passes int a,
     * which is the "current" value in utilities.GameMechanics
     *
     * @param primaryStage
     * @param a the current value in the iteration
     * @see utilities.GameMechanics
     * @throws Exception
     */
    public void startGame(Stage primaryStage, int a) throws Exception {
        GameView gv = new GameView(this, a);
        gv.start(primaryStage);
    }

    /**
     * Creates a GameMechanics object and passes the value 'current' and the
     * users input on the textfield from GameView to GameMechanics object. This
     * method is called until GameMechanics.start returns false (due to
     * incorrect textfield value compared to current). Then sets view to
     * LoseScreen.
     *
     * @param primaryStage
     * @param current
     * @param tf
     * @throws Exception
     */
    public void iterate(Stage primaryStage, int current, TextField tf) throws Exception {
        String answer = tf.getText();
        GameMechanics gm = new GameMechanics(current);

        if (gm.start(answer)) {
            current++;
            startGame(primaryStage, current);
        } else {
            loseScreen(primaryStage, gm.getCause(), current);
        }
    }

    /**
     * Sets scene to LoseView
     *
     * @param primaryStage
     * @param cause
     * @param current
     * @throws Exception
     */
    public void loseScreen(Stage primaryStage, String cause, int current) throws Exception {
        LoseView lv = new LoseView(this, cause, current);
        lv.start(primaryStage);
    }

    /**
     * Sets scene to HelpView
     *
     * @param primaryStage
     * @throws Exception
     */
    public void showHelp(Stage primaryStage) throws Exception {
        HelpView hv = new HelpView(this);
        hv.start(primaryStage);
    }

    /**
     * Sets scene to HighscoreView
     *
     * @param primaryStage
     * @throws Exception
     */
    public void showHighScores(Stage primaryStage) throws Exception {
        HighscoreView highV = new HighscoreView(this);
        highV.start(primaryStage);
    }
}
