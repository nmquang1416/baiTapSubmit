package example.javafxapplication;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    Stage window;

    @Override
    public void start(Stage stage) throws IOException {
        StudentController studentController = new StudentController();
        Student student = new Student();
        TableView<Student> firstLoadTable = studentController.showAllStudents();
        window = stage;
        window.setTitle("Students Table");
        window.setResizable(false);

        Button buttonAdd = new Button("Add Student");
        buttonAdd.setOnAction(event -> studentController.createNewStudent());

        Button buttonDelete = new Button("Delete Student");
        buttonDelete.setOnAction(event -> {
            studentController.deleteStudent();
        });

        Button buttonEdit = new Button("Edit Student");
        buttonEdit.setOnAction(event -> studentController.editStudent());

        TextField findInput = new TextField();
        findInput.setPromptText("Find Student by Id");
        findInput.setOnAction(event -> studentController.findStudent(findInput.getText()));

        HBox hbox = new HBox();
        hbox.getChildren().addAll(buttonAdd, buttonDelete, buttonEdit, findInput);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(hbox, firstLoadTable);
        Scene scene = new Scene(vbox);
        window.setScene(scene);
        window.show();
    }
}