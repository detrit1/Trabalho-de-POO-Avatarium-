module exemplo.curso1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires transitive java.sql;

    opens org.exemplo.curso1.controller to javafx.fxml;
    exports org.exemplo.curso1.controller;

    opens org.exemplo.curso1.model to javafx.fxml;
    exports org.exemplo.curso1.model;

    opens org.exemplo.curso1.main to javafx.fxml;
    exports org.exemplo.curso1.main;

    opens org.exemplo.curso1.dao to javafx.fxml;
    exports org.exemplo.curso1.dao;
}
