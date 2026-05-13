module org.example.lab78 {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.dlsc.formsfx;
    requires java.desktop;
    exports app;
    opens app to javafx.fxml;
}