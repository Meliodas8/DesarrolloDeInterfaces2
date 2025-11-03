package com.example.desarrollodeinterfaces2.ejercicios1;

import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Ejercicio3 {

    public void start(Stage stage) throws IOException {

        MenuBar menuBar = new MenuBar();

        Menu menuArchivo = new Menu("Archivo");

        MenuItem abrir = new MenuItem("Abrir");
        MenuItem nuevo = new MenuItem("Nuevo");
        MenuItem salir = new MenuItem("Salir");

        menuArchivo.getItems().addAll(abrir, nuevo,   salir);

        Menu menuEditar = new Menu("Editar");

        MenuItem copiar = new MenuItem("Copiar");
        MenuItem cortar = new MenuItem("Cortar");
        MenuItem pegar = new MenuItem("Pegar");

        menuEditar.getItems().addAll(copiar, cortar, pegar);

        menuBar.getMenus().addAll(menuArchivo, menuEditar);

        Label nombre = new Label("Nombre:");
        TextField nombreText = new TextField();

        Label contraseña = new Label("Contraseña:");
        PasswordField contraPassword = new PasswordField();

        Label genero = new Label("Genero:");
        RadioButton genero1 = new RadioButton("Masculino");
        RadioButton genero2 = new RadioButton("Femenino");

        ToggleGroup generoGroup = new ToggleGroup();
        generoGroup.getToggles().addAll(genero1, genero2);
        CheckBox subcripcion = new CheckBox("Subcripcion");

        Label pais = new Label("Selecciona tu pais");
        ChoiceBox<String> menuDesplegable = new ChoiceBox<>();

        menuDesplegable.setValue("España");

        menuDesplegable.getItems().add("España");
        menuDesplegable.getItems().add("Dinamarca");
        menuDesplegable.getItems().add("Chile");
        menuDesplegable.getItems().add("Argentina");

        Label edad = new Label("Selecciona tu edad");
        Spinner<Integer> edades = new Spinner<>();
        SpinnerValueFactory<Integer> valores = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 100, 25);
        edades.setValueFactory(valores);

        Label fechaN =  new Label("Fecha de nacimiento:");
        DatePicker fechaNDate = new DatePicker();

        Button enviar = new Button("Enviar");

        Button rojo = new Button("Rojo");
        Button azul = new Button("Azul");
        Button verde = new Button("Verde");

        ToolBar toolBar = new ToolBar(rojo, azul, verde);

        Button boton = new Button("Boton");
        MenuItem copiarItem = new MenuItem("Copiar");
        MenuItem pergarItem = new MenuItem("Pergar");
        MenuItem eliminarItem = new MenuItem("Eliminar");
        ContextMenu contextMenu = new ContextMenu(copiarItem, pergarItem, eliminarItem);
        boton.setContextMenu(contextMenu);

        ListView<String> ciudades = new ListView<>();
        ciudades.getItems().addAll("Cordoba", "Malaga", "Barcelona");
        ciudades.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        ciudades.setFixedCellSize(30);

        int filas = ciudades.getItems().size();
        double alturaTotal = filas * ciudades.getFixedCellSize();
        ciudades.setPrefHeight(alturaTotal + 2);
        ciudades.setMinHeight(alturaTotal + 2);

        TableView<Persona> tablaPersona = new TableView<>();

        TableColumn<Persona, String> nombreColumn = new TableColumn<>("Nombre");
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombre"));
        TableColumn<Persona, Integer> edadColumn = new TableColumn<>("Edad");
        edadColumn.setCellValueFactory(new PropertyValueFactory<>("edad"));

        tablaPersona.getColumns().addAll(nombreColumn, edadColumn);

        tablaPersona.setItems(FXCollections.observableArrayList(
                new Persona("yo", 33),
                new Persona("el", 55),
                new Persona("tu", 25)));

        GridPane grid = new GridPane();

        grid.add(nombre,0,0);
        grid.add(nombreText,1,0);
        grid.add(contraseña,0,1);
        grid.add(contraPassword,1,1);
        grid.add(genero,0,2);
        grid.add(genero1,1,2);
        grid.add(genero2,2,2);
        grid.add(subcripcion,1, 3);
        grid.add(pais,0,4);
        grid.add(menuDesplegable,1,4);
        grid.add(edad,0,5);
        grid.add(edades,1,5);
        grid.add(fechaN,0,6);
        grid.add(fechaNDate,1,6);
        grid.add(enviar,1,7);
        grid.add(toolBar,1,8);
        grid.add(boton,1,9);
        grid.add(ciudades,1,10);
        grid.add(tablaPersona,1,11);

        grid.setHgap(10);
        grid.setVgap(10);

        grid.setPadding(new Insets(15,10,10,10));

        BorderPane borderPane = new BorderPane();

        borderPane.setTop(menuBar);
        borderPane.setCenter(grid);

        Scene scene = new Scene(borderPane, 525, 610);
        stage.setTitle("Menu");
        stage.setScene(scene);
        stage.show();

    }
}
