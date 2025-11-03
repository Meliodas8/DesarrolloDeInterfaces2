package com.example.desarrollodeinterfaces2.prueba;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

// Ejemplo calculadora resuelta
public class CalculadoraR extends Application {
    private TextField display;
    private double num1 = 0;
    private String operador = "";
    private boolean nuevoNumero = true;

    @Override
    public void start(Stage stage) {
        // Campo de texto (display)
        display = new TextField();
        display.setEditable(false);
        display.setAlignment(Pos.CENTER_RIGHT);

        // Panel de cuadrícula para botones
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(10));
        grid.setHgap(8);
        grid.setVgap(8);

        // Botones de la calculadora
        String[][] botones = {
                {"7", "8", "9", "/"},
                {"4", "5", "6", "*"},
                {"1", "2", "3", "-"},
                {"0", "C", "=", "+"}
        };

        // Añadir botones al grid
        for (int i = 0; i < botones.length; i++) {
            for (int j = 0; j < botones[i].length; j++) {
                String texto = botones[i][j];
                Button boton = new Button(texto);
                boton.setPrefSize(50, 50);
                boton.setOnAction(e -> manejarEntrada(texto));
                // En la primera fila va ubicado el display
                grid.add(boton, j, i + 1);
            }
        }

        // Añadir display en la primera fila (4 columnas)
        grid.add(display, 0, 0, 4, 1);

        // Escena y Escenario
        Scene scene = new Scene(grid, 270, 320);
        stage.setTitle("Calculadora");
        stage.setScene(scene);
        stage.show();
    }

    private void manejarEntrada(String texto) {
        switch (texto) {
            case "C": //Limpiar
                display.clear();
                num1 = 0;
                operador = "";
                nuevoNumero = true;
                break;

            case "+": case "-": case "*": case "/": //Operación
                if (!display.getText().isEmpty()) {
                    num1 = Double.parseDouble(display.getText());
                    operador = texto;
                    nuevoNumero = true;
                }
                break;

            case "=": //Calcular
                if (!display.getText().isEmpty() && !operador.isEmpty()) {
                    double num2 = Double.parseDouble(display.getText());
                    String resultado = calcular(num1, num2, operador);
                    display.setText(resultado);
                    nuevoNumero = true;
                }
                break;

            default: //Números
                if (nuevoNumero) {
                    display.setText(texto);
                    nuevoNumero = false;
                } else {
                    display.appendText(texto);
                }
        }
    }

    private String calcular(double a, double b, String operacion) {
        return switch (operacion) {
            case "+" -> String.valueOf(a + b);
            case "-" -> String.valueOf(a - b);
            case "*" -> String.valueOf(a * b);
            case "/" -> (b != 0) ? String.valueOf(a / b) : "Error";
            default -> "Error";
        };
    }
}
