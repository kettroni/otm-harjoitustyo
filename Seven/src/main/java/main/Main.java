/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
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
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        UIController ui = new UIController();
        ui.start(primaryStage);
    }
}
