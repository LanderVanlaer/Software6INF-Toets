package me.landervanlaer.toetsen.toets4;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("build.fxml"));
        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Toets 4");
        primaryStage.show();
    }
}
