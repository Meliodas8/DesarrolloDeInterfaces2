package com.example.desarrollodeinterfaces2.ejerciciosEventos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import java.io.IOException;

public class Ejercicio1 extends Application {

    public void start(Stage stage) throws IOException {
        Button button = new Button("Click Me");

        Label etiqueta = new Label("Desactivado");
        CheckBox activacion = new CheckBox("Activar");

        TextField texto = new TextField();

        Label textoL =  new Label();

        VBox ventana = new VBox(button, etiqueta, activacion, texto,  textoL);

        int[] contador = {0};

        button.setOnAction(event -> {
            System.out.println("Boton pulsado");
            ventana.setStyle("-fx-background-color:" + colorRandom() + ";");
            contador[0]++;
            System.out.println("Contador: " + contador[0]);
        });

        activacion.setOnAction(event -> {
            if (activacion.isSelected()) {
                etiqueta.setText("Activado");
                return;
            }
            etiqueta.setText("Desactivado");
        });

        texto.setOnAction(event -> {
            String texto1 = texto.getText();
            textoL.setText(texto1);
        });

        Scene scene = new Scene(ventana , 320, 240);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    private String colorRandom() {
        Color randomColor = new Color(Math.random(), Math.random(), Math.random(), 1.0);

        String colorCss = String.format("#%02X%02X%02X",
                (int)(randomColor.getRed() * 255),
                (int)(randomColor.getGreen() * 255),
                (int)(randomColor.getBlue() * 255));

        return colorCss;
    }
}