package me.landervanlaer.toetsen.toets6;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Toets 5");
        primaryStage.setScene(new Scene(FXMLLoader.load(getClass().getResource("sample.fxml"))));
        primaryStage.show();
    }
}
