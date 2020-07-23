package sample;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.stage.Stage;


public class Main extends Application {
    public static Label currentBuffer = new Label(rpiSystem.allFrames.toString());
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane pane = new FlowPane();
        primaryStage.setTitle("Hello World");
        primaryStage.setScene(new Scene(pane, 300, 275));
        primaryStage.show();
        pane.getChildren().add(currentBuffer);

    }

    public static void main(String[] args) {
        rpiSystem.runThreads();
        launch(args);
    }



}
