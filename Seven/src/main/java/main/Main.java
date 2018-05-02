/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import database.HighscoreData;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import static javafx.application.Application.launch;
/**
 *
 * @author Roni
 */

import javafx.application.Application;
import javafx.stage.Stage;
import ui.UIController;

/**
 *
 * @author Roni
 */
public class Main extends Application {
    
    private HighscoreData scores;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void init() throws FileNotFoundException, IOException {
        Properties properties = new Properties();

        properties.load(new FileInputStream("config.properties"));
        
        String scoreFile = properties.getProperty("scoreFile");

        scores = new HighscoreData(scoreFile);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UIController ui = new UIController(scores);
        ui.start(primaryStage);
    }
}
