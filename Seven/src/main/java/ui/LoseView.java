/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;
import utilities.User;

/**
 * View that includes: cause why the game was lost, possibility to save your score 
 * and then goes to HighscoreView, "Try again" -button, "Back to menu" -button
 * and "Quit" button.
 * @author Roni
 */
public class LoseView extends Application {
    private final UIController ui;
    private final String cause;
    private final int score;
    
    public LoseView(UIController ui, String cause, int score) {
        this.ui = ui;
        this.cause = cause;
        this.score = score;
    }
    /**
     * Creates all visual JavaFX components and sets the new scene as 
     * primaryStages scene.  
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button option1 = new Button("Try again");
        Button option2 = new Button("Quit");
        Text text = new Text(cause + "\n\n\n\n"
                + "Enter name to submit score \n"
                + "(Length must be EXACTLY 3)"); 
        TextField txt = new TextField();
        option1.setOnAction(e -> {
            try {
                ui.startGame(primaryStage, 1);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        option2.setOnAction(e -> primaryStage.close());

        Button back = new Button("Back to menu");
        Button submit = new Button("Submit Results \n"
                + "and go to high scores");
        back.setOnAction(e -> {
            try {
                ui.menu(primaryStage);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        
        submit.setOnAction(e -> {
            ui.scores.create(new User(txt.getText(), score));
            txt.setText("");
            try {
                ui.showHighScores(primaryStage);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        
        text.setFont(Font.font ("Verdana", 17));
        text.setFill(Color.RED);
        text.setTextAlignment(TextAlignment.JUSTIFY);
        
        submit.setStyle("-fx-pref-width: 230px; -fx-pref-height: 42px");
        option1.setStyle("-fx-pref-width: 230px; -fx-pref-height: 30px");
        option2.setStyle("-fx-pref-width: 230px; -fx-pref-height: 30px");
        back.setStyle("-fx-pref-width: 230px; -fx-pref-height: 30px");

        
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.BASELINE_CENTER);
        
        layout.setVgap(20);

        layout.add(text, 0, 0);
        layout.add(txt, 0, 1);
        layout.add(submit, 0, 2);
        layout.add(option1, 0, 3);
        layout.add(back, 0, 4);
        layout.add(option2, 0, 5);
        
        layout.setMinSize(500, 500);
        layout.setStyle("-fx-background-color: #383838");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
    }
    
}
