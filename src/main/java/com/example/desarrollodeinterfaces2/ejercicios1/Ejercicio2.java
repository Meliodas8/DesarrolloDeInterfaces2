package com.example.desarrollodeinterfaces2.ejercicios1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio2 extends Application {

    public void start(Stage stage) throws IOException {

        Label hobbies = new Label("Selecciona tus hobbies");
        CheckBox musica = new CheckBox("Musica");
        CheckBox deporte = new CheckBox("Deporte");
        CheckBox lectura = new CheckBox("Lectura");

        Label genero = new Label("Selecciona tu genero");
        RadioButton mujer = new RadioButton("Mujer");
        RadioButton hombre = new RadioButton("Hombre");
        RadioButton otro = new RadioButton("Otro");

        ToggleGroup grupo = new ToggleGroup();
        mujer.setToggleGroup(grupo);
        hombre.setToggleGroup(grupo);
        otro.setToggleGroup(grupo);

        Label notificaciones = new Label("Notificaciones");
        ToggleButton notiActivar = new ToggleButton("Activar/Desactivar");

        Label pais = new Label("Selecciona tu pais");
        ChoiceBox<String> menuDesplegable = new ChoiceBox<>();

        menuDesplegable.getItems().add("España");
        menuDesplegable.getItems().add("Dinamarca");
        menuDesplegable.getItems().add("Chile");
        menuDesplegable.getItems().add("Argentina");

        Label color = new Label("Selecciona tu color favorito");
        ComboBox<String> colores = new ComboBox<>();

        colores.getItems().add("rojo");
        colores.getItems().add("azul");
        colores.getItems().add("verde");

        Label edad = new Label("Selecciona tu edad");
        Spinner<Integer> edades = new Spinner<>();
        SpinnerValueFactory<Integer> valores = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 0);
        edades.setValueFactory(valores);

        VBox ventana = new VBox(hobbies,musica,deporte,lectura, genero, mujer,hombre,otro, notificaciones, notiActivar,
                pais,menuDesplegable, color, colores, edad, edades);

        ventana.setAlignment(Pos.CENTER_LEFT);
        ventana.setSpacing(10);
        ventana.setPadding(new Insets(15, 15, 15, 15));

        Scene scene = new Scene(ventana, 500, 700);
        stage.setTitle("Controles de seleccion");
        stage.setScene(scene);
        stage.show();
    }
}
