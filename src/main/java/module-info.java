module issamu {
    requires javafx.controls;
    requires javafx.fxml;

    opens issamu to javafx.fxml;
    exports issamu;
}