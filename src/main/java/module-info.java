module org.example.schoolmanager {
    requires javafx.controls;
    requires javafx.fxml;
    requires jdk.jdi;
    requires java.sql;
    requires java.desktop;


    opens org.example.schoolmanager to javafx.fxml;
    exports org.example.schoolmanager;

    opens org.example.schoolmanager.controllers to javafx.fxml;
    exports org.example.schoolmanager.controllers;
}