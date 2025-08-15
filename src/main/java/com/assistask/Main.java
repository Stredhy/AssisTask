package com.assistask;

import com.assistask.animations.Animations;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import javafx.scene.image.Image;

public class Main extends Application {

    @Override
    public void start(Stage stage) throws IOException{
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("logIn.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Image icon = new Image(getClass().getResourceAsStream("img/assisTaskLogo.png"));
        stage.getIcons().add(icon);
        stage.setScene(scene);
        stage.setTitle("Log in");
        stage.show();
    }
    
    public static void setIcon(){
        
    }
    
    public static void main(String[] args) {
        launch();
    }

}