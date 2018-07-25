package demo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
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
            getChildren().addAll(
                    new TitledPane("BI binding", new VBox() {{
                        TextField field1 = new TextField("change both of us");
                        TextField field2 = new TextField();
                        field2.textProperty().bindBidirectional(field1.textProperty());
                        getChildren().addAll(field1, field2);
                    }}),
                    new TitledPane("Single Way Binding", new VBox() {{
                        TextField field1 = new TextField("you can only change me");
                        TextField field2 = new TextField();
                        field2.textProperty().bind(field1.textProperty());
                        getChildren().addAll(field1, field2);
                    }})
            );
        }};

        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }
}