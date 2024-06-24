module example.baitap01 {
    requires javafx.controls;
    requires javafx.fxml;


    opens example.baitap01 to javafx.fxml;
    exports example.baitap01;
}