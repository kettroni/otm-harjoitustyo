/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 * Creates a view which includes Top 3 players from the file LocalData.txt
 * using the HighscoreData.java class.
 * @author Roni
 */
public class HighscoreView extends Application {

    private UIController ui;

    public HighscoreView(UIController ui) {
        this.ui = ui;
    }

    /**
     * Creates all visual JavaFX components and sets the new scene as 
     * primaryStages scene.  
     * @param primaryStage
     * @throws Exception 
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        Text text = new Text(
                "Seven - High Scores, Top Three\n"
                + "\n"
                + ui.scores.getTopThree());

        Button back = new Button("Back to menu");
        back.setOnAction(e -> {
            try {
                ui.menu(primaryStage);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        GridPane layout = new GridPane();
        text.setFont(Font.font("Verdana", 17));
        text.setFill(Color.RED);
        text.setTextAlignment(TextAlignment.JUSTIFY);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);

        layout.setVgap(20);
        layout.setHgap(20);

        layout.add(text, 0, 0);
        layout.add(back, 0, 1);

        layout.setMinSize(500, 500);
        layout.setStyle("-fx-background-color: #383838");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
    }

}
