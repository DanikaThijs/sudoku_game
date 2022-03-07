package be.kdg.sudoku_game;

import com.sun.source.doctree.TextTree;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.paint.Color;

import javax.swing.text.Position;
import java.awt.*;
import java.util.ArrayList;


public class Main extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage mijnStage) {
        //Sudokuscherm maken
        //bovenste schermdeel
        //Buttons aanmaken
        Button btnNewGame = new Button("New Game");
        Button btnCheck = new Button("Check");

        //bovenste pane maken
        HBox hbBovensteDeel = new HBox();

        hbBovensteDeel.getChildren().add(btnNewGame);
        hbBovensteDeel.getChildren().add(btnCheck);

        //Middelste/sudokugrid maken
        int veldgrote = 4;
        //Middelstedeel/sudokugrid pane maken
        GridPane gpSudoku = new GridPane();

        TextField[][] txt = new TextField[veldgrote][veldgrote];
        for (int i = 0; i < veldgrote; i++) {
            for (int j = 0; j < veldgrote; j++) {
                TextField textField = new TextField();
                txt[i][j] = textField;
                textField.setPrefHeight(40);
                textField.setPrefWidth(40);
                textField.setStyle("-fx-border-color: black");
                //alterenerende vakkleuren instellen per grote
                if (veldgrote == 4 && j <= 1 && i <= 1 || veldgrote == 4 && j >= 2 && i >= 2) {
                    textField.setStyle("-fx-background-color: #b0b0b0; -fx-border-color: black");
                } else if (veldgrote == 6 && j <= 2 && i <= 1 || veldgrote == 6 && j >= 3 && i >= 2 && i <= 3 || veldgrote == 6 && j <= 2 && i >= 4) {
                    textField.setStyle("-fx-background-color: #b0b0b0; -fx-border-color: black");
                } else if (veldgrote == 9 && j <= 2 && i <= 2 || veldgrote == 9 && j >= 6 && i <= 2 || veldgrote == 9 && j >= 3 && j <= 5 && i >= 3 && i <= 5 || veldgrote == 9 && j <= 2 && i >= 6 || veldgrote == 9 && j >= 6 && i >= 6) {
                    textField.setStyle("-fx-background-color: #b0b0b0; -fx-border-color: black");
                }
                gpSudoku.add(txt[i][j], j, i);
            }
        }

        //onderste deel
        HBox hbOndersteDeel = new HBox();
        for (int i = 0; i<=veldgrote-1;i++){
            Button btnNummer = new Button(Integer.toString(i+1));
            btnNummer.setPrefWidth(40);
            hbOndersteDeel.getChildren().add(btnNummer);
        }
        //aanpassen eigenschappen nodes
        btnNewGame.setPrefWidth(40*veldgrote/2);
        btnCheck.setPrefWidth(40*veldgrote/2);

        //aanpassen eigenschappen panes
        hbBovensteDeel.setAlignment(Pos.CENTER);
        gpSudoku.setAlignment(Pos.CENTER);
        hbOndersteDeel.setAlignment(Pos.CENTER);

        //alles samenzetten
        VBox vbScherm = new VBox();
        vbScherm.getChildren().add(hbBovensteDeel);
        vbScherm.getChildren().add(gpSudoku);
        vbScherm.getChildren().add(hbOndersteDeel);

        //Scene toevoegen en pane daaraan toevoegen
        //Je hebt normaal gezien maar 1 scene
        Scene mijnScene = new Scene(vbScherm);

        //Scene toevoegen aan stage die je via parameter binnenkrijgt
        mijnStage.setScene(mijnScene);
        mijnStage.setFullScreen(true);
        mijnStage.show();
    }
}

