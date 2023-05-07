module NIOPrac {

    requires kotlin.stdlib;
    requires javafx.controls;
    requires javafx.fxml;
    requires carte.controllerfx;

    opens org.example.carte.controllers to javafx.fxml;


    exports org.example.carte;
}