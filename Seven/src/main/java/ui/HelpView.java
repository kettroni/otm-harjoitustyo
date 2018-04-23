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
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/**
 *
 * @author Roni
 */
public class HelpView extends Application {
    private UIController ui;
    
    public HelpView(UIController ui) {
        this.ui = ui;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Text text = new Text(
                "                       Seven - Rules               \n"
                + "\n"
                + "           Input integers in ascending order.\n"
                + "           First type 1 and press 'Guess', \n"
                + "           then proceed with 2 and press\n"
                + "           'Guess' and so on. \n"
                + "\n"
                + "           There are 'prohibited' numbers \n"
                + "           which you're not allowed to \n"
                + "           type in, and these are the following: \n"
                + "\n"
                + "           1) any number divisible by the number 7 \n"
                + "           2) any number that includes the number 7 \n"
                + "           3) any number that includes more than one \n"
                + "           occurence of a specific number, \n"
                + "           ex. '11', '22', '343' etc. \n"
                + "\n"
                + "           Instead of typing any of these forbidden\n"
                + "           numbers, just press 'Guess' without typing\n"
                + "           anything and continue to the next integer. \n"
                + "\n"
                + "           Notice that there can be multiple \n"
                + "           'skips' in a row. \n"
                + "\n"
                + "           The game ends when you don't input a right \n"
                + "           number or you don't skip at the right time. \n"
                + "                                      \n");

        Button back = new Button("Back to menu");
        back.setOnAction(e -> {
            try {
                ui.menu(primaryStage);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        
        GridPane layout = new GridPane();
        text.setFont(Font.font ("Verdana", 17));
        text.setFill(Color.RED);
        text.setTextAlignment(TextAlignment.JUSTIFY);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);

        //Setting gaps
        layout.setVgap(20);
        layout.setHgap(20);

        //adding nodes
        
        layout.add(text, 0, 0);
        layout.add(back, 0, 1);
        
        layout.setMinSize(500, 500);
        layout.setStyle("-fx-background-color: #383838");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
    }
    
}
