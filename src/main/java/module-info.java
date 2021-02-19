module com.gIssamu {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.gIssamu to javafx.fxml;
    exports com.gIssamu;
}