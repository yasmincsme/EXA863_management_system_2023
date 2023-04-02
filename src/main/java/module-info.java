module com.example.exa863_management_system_2023 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.exa863_management_system_2023 to javafx.fxml;
    exports com.example.exa863_management_system_2023;
}