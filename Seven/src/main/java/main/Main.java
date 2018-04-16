/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;
import javafx.geometry.Insets;
import static javafx.application.Application.launch;
/**
 *
 * @author Roni
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import utilities.GameMechanics;

/**
 *
 * @author Roni
 */
public class Main extends Application {
    
    
    public static void main(String[] args) {
        /*TextInterface ti = new TextInterface();
        ti.run(); */
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        
        primaryStage.setTitle("Seven the game");
        menu(primaryStage);
        
    }
    
    public void menu(Stage primaryStage) {
        
        Button option1 = new Button("Start the game");
        Button option2 = new Button("Help");
        Button option3 = new Button("Quit");
        option1.setOnAction(e -> startGame(primaryStage, 1));
        option2.setOnAction(e -> showHelp(primaryStage));
        option3.setOnAction(e -> primaryStage.close());
        
        VBox layout = new VBox();
        layout.getChildren().addAll(option1, option2, option3);
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public void startGame(Stage primaryStage, int a) {
        
        int current = a;
        VBox text = new VBox();
        
        TextField answer = new TextField();
        Button submit = new Button("Guess");
        submit.setOnAction(e -> iterate(primaryStage, current, answer));
        
        text.setPadding(new Insets(10));
        text.setSpacing(8);
        
        text.getChildren().addAll(answer, submit);
        Scene scene = new Scene(text, 300, 250);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public void iterate(Stage primaryStage, int current, TextField tf) {
        String answer = tf.getText();
        GameMechanics gm = new GameMechanics(current);
        if(gm.start(answer)) {
            current++;
            startGame(primaryStage, current);
        } else {
            loseScreen(primaryStage, gm.getCause());
        }
    }
    
    public void loseScreen(Stage primaryStage, String cause) {
        Button option1 = new Button("Try again");
        Button option2 = new Button("Quit");
        Text text = new Text(cause);
        option1.setOnAction(e -> startGame(primaryStage, 1));
        option2.setOnAction(e -> primaryStage.close());
        
        VBox layout = new VBox(); 
        
        Button back = new Button("Back to menu");
        back.setOnAction(e -> menu(primaryStage));
        
        layout.getChildren().addAll(text, option1, option2, back);
        
        Scene scene = new Scene(layout, 300, 250);
        primaryStage.setScene(scene);
        
        primaryStage.show();
    }
    
    public void showHelp(Stage primaryStage) {
        
        Text text = new Text("            'Seven' - Rules               \n" 
            + "Input integers in ascending order.\n"
            + "First type 1 and press 'Submit', then proceed with 2 and press 'Submit' and so on. \n"
            + "There are 'prohibited' numbers which you're not allowed to type in, and these are the following: \n"
            + "     1) any number divisible by the number 7 \n"
            + "     2) any number that includes the number 7 \n"
            + "     3) any number that includes more than one occurence of a specific number, ex. '11', '22', '343' etc. \n"
            + "Instead of typing any of these forbidden numbers, just press 'Submit' without typing anything and continue to the next integer. \n"
            + "Notice that there can be multiple 'skips' in a row. \n"
            + "The game ends when you don't input a right number or you don't skip at the right time. \n"
            + "                                      \n");
        
        Button back = new Button("Back to menu");
        back.setOnAction(e -> menu(primaryStage));
        VBox layout = new VBox(text, back);
        Scene scene = new Scene(layout, 300, 250);
        
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
