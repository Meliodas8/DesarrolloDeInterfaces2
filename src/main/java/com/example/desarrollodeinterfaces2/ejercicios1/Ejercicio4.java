package com.example.desarrollodeinterfaces2.ejercicios1;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio4 {
    public void start(Stage stage) throws IOException {

        Button left = new Button("Left");
        Button top = new Button("Top");
        Button right = new Button("Right");
        Button bottom = new Button("Bottom");
        Button center = new Button("Center");

        BorderPane ventana = new BorderPane();

        Scene scene = new Scene(ventana, 500, 500);
        stage.setTitle("bordes");
        stage.setScene(scene);
        stage.show();
    }
}
