module com.assistasks {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.assistasks to javafx.fxml;
    exports com.assistasks;
}
