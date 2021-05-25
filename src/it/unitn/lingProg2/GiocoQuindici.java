package it.unitn.lingProg2;

import javafx.application.Application;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class GiocoQuindici extends Application {
    final int N_CASELLE = 16;

    @Override
    public void start(Stage primaryStage) throws Exception{



        clickCase eventClick = new clickCase();
        Griglia grigliaDiGioco = new Griglia(N_CASELLE,eventClick);



        primaryStage.setScene(new Scene(grigliaDiGioco, 400, 400));
        primaryStage.show();
    }
        public static void main(String[] args) {launch(args);}
}