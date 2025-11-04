package com.example.desarrollodeinterfaces2.prueba;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class TablaPersonas extends Application {
    public void start(Stage stage) throws IOException {
        // Crea un TableView, es decir, una tabla que mostrará una lista de objetos Persona
        TableView<Persona> tabla = new TableView<>();
        // Crea una columna llamada "Nombre" que mostrará el valor del atributo nombre de cada Persona
        TableColumn<Persona, String> colNombre = new TableColumn<>("Nombre");
        // PropertyValueFactory<>("nombre") indica que JavaFX debe buscar el metodo getNombre() dentro de la clase Persona para obtener el nombre
        colNombre.setCellValueFactory(new PropertyValueFactory<>("nombre"));

        TableColumn<Persona, String> colApellidos = new TableColumn<>("Apellidos");
        colApellidos.setCellValueFactory(new PropertyValueFactory<>("apellidos"));

        TableColumn<Persona, Integer> colEdad = new TableColumn<>("Edad");
        colEdad.setCellValueFactory(new PropertyValueFactory<>("edad"));

        // CONSTRAINED_RESIZE_POLICY hace que las columnas se redimensionen automáticamente para ocupar el ancho disponible
        tabla.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
        // Añade las tres columnas creadas a la tabla para que aparezcan visualmente en orden
        tabla.getColumns().addAll(colNombre, colApellidos, colEdad);

        // Lista de datos
        // Crea una lista observable de objetos Persona
        ObservableList<Persona> personas = FXCollections.observableArrayList();
        // Le decimos a la tabla: “Esta es la lista de datos que vas a mostrar”
        tabla.setItems(personas);

        // Campos de texto
        TextField txtNombre = new TextField();
        txtNombre.setPromptText("Nombre");

        TextField txtApellidos = new TextField();
        txtApellidos.setPromptText("Apellidos");

        TextField txtEdad = new TextField();
        txtEdad.setPromptText("Edad");

        // Botón para añadir Persona
        Button btnAdd = new Button("Añadir");
        btnAdd.setOnAction(e -> {
            try {
                String nombre = txtNombre.getText();
                String apellidos = txtApellidos.getText();
                int edad = Integer.parseInt(txtEdad.getText());

                personas.add(new Persona(nombre, apellidos, edad));

                // Limpiar campos
                txtNombre.clear();
                txtApellidos.clear();
                txtEdad.clear();
            } catch (NumberFormatException ex) {
                new Alert(Alert.AlertType.ERROR, "Edad incorrecta").show();
            }
        });

        // Layout
        VBox root = new VBox(10, tabla, txtNombre, txtApellidos, txtEdad, btnAdd);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        // Stage y Scene
        stage.setScene(new Scene(root, 400, 400));
        stage.setTitle("Registro de personas");
        stage.show();
    }
}
