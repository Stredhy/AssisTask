package com.assistask.animations;

import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.scene.Node;
import javafx.stage.Stage;
import javafx.util.Duration;

public class Animations {
    public static void setFadeTransition(Node n){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.3),n);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.3),n);
        fadeIn.setFromValue(1.0);
        fadeIn.setToValue(0.5);
        fadeIn.setAutoReverse(false);
        
        n.setOnMouseEntered(e -> {
            fadeIn.play();
        });
        
        fadeOut.setFromValue(0.5);
        fadeOut.setToValue(1.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(false);
        
        n.setOnMouseExited(e -> {
            fadeOut.play();
        });
    }
    
    public static void setScaleTransition(Node n){
        ScaleTransition expand = new ScaleTransition(Duration.seconds(0.3),n);
        ScaleTransition reduce = new ScaleTransition(Duration.seconds(0.3),n);
        
        expand.setToX(1.05);
        expand.setToY(1.05);
        
        n.setOnMouseEntered(e -> {
            expand.play();
        });
        
        reduce.setToX(1);
        reduce.setToY(1);
        
        n.setOnMouseExited(e -> {
            reduce.play();
        });
    }
    
    public static void setFadeAndScale(Node n){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.3),n);
        FadeTransition fadeOut = new FadeTransition(Duration.seconds(0.3),n);
        ScaleTransition expand = new ScaleTransition(Duration.seconds(0.3),n);
        ScaleTransition reduce = new ScaleTransition(Duration.seconds(0.3),n);
        
        fadeIn.setFromValue(1.0);
        fadeIn.setToValue(0.5);
        fadeIn.setAutoReverse(false);
        
        expand.setToX(1.05);
        expand.setToY(1.05);
        
        n.setOnMouseEntered(e -> {
            expand.play();
            fadeIn.play();
        });
        
        fadeOut.setFromValue(0.5);
        fadeOut.setToValue(1.0);
        fadeOut.setCycleCount(1);
        fadeOut.setAutoReverse(false);
        
        reduce.setToX(1);
        reduce.setToY(1);
        
        n.setOnMouseExited(e -> {
            reduce.play();
            fadeOut.play();
        });
    }
    
    public static void setFadeFocus(Node n){
        n.focusedProperty().addListener((obs,oldVal,newVal)-> {
            FadeTransition fade = new FadeTransition(Duration.seconds(0.5),n);
            fade.setCycleCount(1);
            fade.setAutoReverse(false);
            if(newVal){
                fade.setFromValue(0.5);
                fade.setToValue(1);
            }else{
                fade.setFromValue(1);
                fade.setToValue(1);
            }
            fade.play();
        });
    }
    
    public static void fadeWindow(Stage stage){
        FadeTransition fadeIn = new FadeTransition(Duration.seconds(0.3),stage.getScene().getRoot());
        fadeIn.setFromValue(0.9);
        fadeIn.setToValue(1.0);
        fadeIn.play();
    }
}
