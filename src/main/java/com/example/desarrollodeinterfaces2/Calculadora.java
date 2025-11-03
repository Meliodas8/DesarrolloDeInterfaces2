package com.example.desarrollodeinterfaces2;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Calculadora extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        TextArea textArea = new TextArea();

        textArea.setEditable(false);
        textArea.setPrefHeight(25);

        Button cero = new Button("0");

        Button uno = new Button("1");
        Button dos = new Button("2");
        Button tres = new Button("3");
        Button cuatro = new Button("4");
        Button cinco = new Button("5");
        Button seis = new Button("6");
        Button siete = new Button("7");
        Button ocho = new Button("8");
        Button nueve = new Button("9");
        Button suma = new Button("+");
        Button resta = new Button("-");
        Button multiplicacion = new Button("*");
        Button division = new Button("/");
        Button borrar = new Button("C");
        Button igual = new Button("=");

        GridPane grid = new GridPane();

        grid.add(siete, 0, 0);
        grid.add(ocho, 1, 0);
        grid.add(nueve, 2, 0);
        grid.add(division, 3, 0);

        grid.add(cuatro, 0, 1);
        grid.add(cinco, 1, 1);
        grid.add(seis, 2, 1);
        grid.add(multiplicacion, 3, 1);

        grid.add(uno, 0, 2);
        grid.add(dos, 1, 2);
        grid.add(tres, 2, 2);
        grid.add(resta, 3, 2);

        grid.add(cero, 0, 3);
        grid.add(borrar, 1, 3);
        grid.add(igual, 2, 3);
        grid.add(suma, 3, 3);

        grid.setHgap(5);
        grid.setVgap(5);

        grid.setAlignment(Pos.CENTER);

        EventHandler<ActionEvent> buttonHandler = event -> {
            Button boton = (Button) event.getSource();
            int valor1 = 0;
            int valor2 = 0;
            String cuenta = "";
            switch (boton.getContentDisplay()){
                case cero -> textArea.setText("0");
            };
        };

        for (int i = 0; i < 4; i++) {
            javafx.scene.layout.ColumnConstraints col = new javafx.scene.layout.ColumnConstraints();
            col.setPercentWidth(25);
            grid.getColumnConstraints().add(col);

            javafx.scene.layout.RowConstraints row = new javafx.scene.layout.RowConstraints();
            row.setPercentHeight(25);
            grid.getRowConstraints().add(row);
        }

        Button[] botones = {cero, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve,
                suma, resta, multiplicacion, division, borrar, igual};

        for (Button b : botones) {
            b.setMaxSize(Double.MAX_VALUE, Double.MAX_VALUE);
        }

        VBox ventana = new VBox(10);
        ventana.setPadding(new Insets(5));
        ventana.getChildren().addAll(textArea, grid);
        ventana.setAlignment(Pos.CENTER);

        Scene scene = new Scene(ventana, 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }
}
