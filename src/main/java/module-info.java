module com.cortez.herramientas {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.cortez.herramientas to javafx.fxml;
    opens com.cortez.herramientas.control to javafx.fxml;    opens com.cortez.herramientas.dto to javafx.base, javafx.fxml;
    opens com.cortez.herramientas.dao to javafx.base, javafx.fxml;
    opens com.cortez.herramientas.service to javafx.base, javafx.fxml;

    exports com.cortez.herramientas;
}