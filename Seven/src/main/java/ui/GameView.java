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
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 *
 * @author Roni
 */
public class GameView extends Application {

    private final UIController ui;
    private final int b;

    public GameView(UIController ui, int param) {
        this.ui = ui;
        b = param;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        int current = b;
        VBox text = new VBox();

        TextField answer = new TextField();
        Button submit = new Button("Guess");
        submit.setOnAction(e -> {
            try {
                ui.iterate(primaryStage, current, answer);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        });

        text.setPadding(new Insets(10));
        text.setSpacing(8);

        text.getChildren().add(answer);

        Text adv = new Text("Input integers ascending");
        adv.setFont(Font.font("Verdana", 27));
        adv.setUnderline(true);
        adv.setFill(Color.RED);

        GridPane layout = new GridPane();
        layout.setPadding(new Insets(10, 10, 10, 10));
        layout.setAlignment(Pos.CENTER);

        layout.setVgap(120);

        //adding nodes
        layout.add(adv, 0, 0);
        layout.add(text, 0, 1);
        layout.add(submit, 1, 1);

        layout.setMinSize(500, 500);
        layout.setStyle("-fx-background-color: #383838");
        Scene scene = new Scene(layout);
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.ENTER) {
                try {
                    ui.iterate(primaryStage, current, answer);
                } catch (Exception ex) {
                    System.out.println(ex);
                }
            }
        });
        primaryStage.setScene(scene);
    }

}
