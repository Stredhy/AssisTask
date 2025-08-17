module com.assistask {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires spring.context;
    
    opens com.assistask.controller to javafx.fxml;

    exports com.assistask;
}