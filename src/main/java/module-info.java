module com.example.desarrollodeinterfaces2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires javafx.graphics;
    requires javafx.base;

    opens com.example.desarrollodeinterfaces2 to javafx.fxml;
    exports com.example.desarrollodeinterfaces2;
    exports com.example.desarrollodeinterfaces2.prueba;
    opens com.example.desarrollodeinterfaces2.prueba to javafx.fxml;
    exports com.example.desarrollodeinterfaces2.calculadora;
    opens com.example.desarrollodeinterfaces2.calculadora to javafx.fxml;
    exports com.example.desarrollodeinterfaces2.ejercicios1;
}