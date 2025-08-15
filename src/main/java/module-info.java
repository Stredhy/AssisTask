module com.assistask {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens com.assistask.controllers to javafx.fxml;
    exports com.assistask;
}
