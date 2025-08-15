package com.assistask;

import com.assistask.animations.Animations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("logIn.fxml"));
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root);
        Image icon = new Image(getClass().getResourceAsStream("img/assisTaskLogo.png"));
        scene.setFill(Color.web("#120907"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Log in");
        stage.setOnShown(e -> Animations.fadeWindow(stage));
        stage.show();
    }
    
    public static void main(String[] args) {
        launch();
    }

}