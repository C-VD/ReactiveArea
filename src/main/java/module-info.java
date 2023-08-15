module com.example.reactivearea {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.reactivearea to javafx.fxml;
    exports com.example.reactivearea;
}