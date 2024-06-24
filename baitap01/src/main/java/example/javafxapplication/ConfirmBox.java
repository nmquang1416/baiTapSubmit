package example.javafxapplication;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class ConfirmBox {
    boolean confirmed;

    public boolean confirmBox(String title, String message) {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle(title);
        window.setMinWidth(250);
        Label label = new Label(message);
        label.setText(message);

        Button yesButton = new Button("Yes");
        Button noButton = new Button("No");

        yesButton.setOnAction(e -> {
            confirmed = true;
            window.close();
        });
        noButton.setOnAction(e -> {
            confirmed = false;
            window.close();
        });

        VBox vbox = new VBox(10);
        vbox.getChildren().addAll(label, yesButton, noButton);
        vbox.setAlignment(Pos.CENTER);
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.showAndWait();
        return confirmed;
    }
}
