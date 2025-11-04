package com.example.desarrollodeinterfaces2.ejercicios1;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ejercicio4 extends Application {
    public void start(Stage stage) {

        Button left = new Button("Left");
        Button top = new Button("Top");
        Button right = new Button("Right");
        Button bottom = new Button("Bottom");
        Button center = new Button("Center");

        GridPane gridL = new GridPane();
        gridL.add(left, 0, 0);
        gridL.setAlignment(Pos.CENTER_LEFT);
        gridL.setStyle("-fx-background-color: green;");

        GridPane gridT = new GridPane();
        gridT.add(top, 0, 0);
        gridT.setAlignment(Pos.TOP_CENTER);
        gridT.setStyle("-fx-background-color: yellow;");

        GridPane gridR = new GridPane();
        gridR.add(right, 0, 0);
        gridR.setAlignment(Pos.CENTER_RIGHT);
        gridR.setStyle("-fx-background-color: red;");

        GridPane gridB = new GridPane();
        gridB.add(bottom, 0, 0);
        gridB.setAlignment(Pos.BOTTOM_CENTER);
        gridB.setStyle("-fx-background-color: blue;");

        GridPane gridC = new GridPane();
        gridC.add(center, 0, 0);
        gridC.setAlignment(Pos.CENTER);
        gridC.setStyle("-fx-background-color: grey;");

        BorderPane ventana = new BorderPane();

        ventana.setLeft(gridL);
        ventana.setTop(gridT);
        ventana.setRight(gridR);
        ventana.setBottom(gridB);
        ventana.setCenter(gridC);

        Scene scene = new Scene(ventana, 500, 500);
        stage.setTitle("bordes");
        stage.setScene(scene);
        stage.show();
    }
}
