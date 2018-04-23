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
public class MenuView extends Application {
    
    private final UIController ui;
    
    public MenuView(UIController ui) {
        this.ui = ui;
    }
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        
        Button option1 = new Button("Start the game");
        Button option2 = new Button("Help");
        Button option3 = new Button("Quit");
        Text text = new Text("Seven - The Game");
        option1.setOnAction(e -> {
            try {
                ui.startGame(primaryStage, 1);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        option2.setOnAction(e -> {
            try {
                ui.showHelp(primaryStage);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });
        option3.setOnAction(e -> primaryStage.close());
        
        GridPane layout = new GridPane();
        option1.setStyle("-fx-pref-width: 230px; -fx-pref-height: 30px");
        option2.setStyle("-fx-pref-width: 230px; -fx-pref-height: 30px");
        option3.setStyle("-fx-pref-width: 230px; -fx-pref-height: 30px");
        text.setFont(Font.font ("Verdana", 25));
        text.setUnderline(true);
        text.setFill(Color.RED);
        text.setTextAlignment(TextAlignment.CENTER);
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);

        //Setting gaps
        layout.setVgap(20);
        layout.setHgap(20);

        //adding nodes
        
        layout.add(text, 0, 0);
        layout.add(option1, 0, 1);
        layout.add(option2, 0, 2);
        layout.add(option3, 0, 3);
        
        layout.setMinSize(500, 500);
        layout.setStyle("-fx-background-color: #383838");
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
}
