package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Hello extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Hello");
        VBox root = new VBox() {{
            TextField field1 = new TextField("change me");
            TextField field2 = new TextField();
            field2.textProperty().bindBidirectional(field1.textProperty());
            Label label = new Label();
            label.textProperty().bind(field1.textProperty());
            getChildren().addAll(new Label("Input something"),
                    field1, field2, label);
        }};
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}