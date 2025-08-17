package com.assistask.util;

import com.assistask.Main;
import com.assistask.controller.PopUpController;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * @author stredhy
 */
public class Dialogs {
    public static final String FXML_PATH = "/com/assistask/";
    public static final String IMG_PATH = "/com/assistask/img/";
    
    
    public static void showAlert(String labelStr, String btnLeft, String btnRight){
        
    }
    
    public static void showMessage(String labelStr, String btnStr) throws IOException{
        FXMLLoader loader = new FXMLLoader(Main.class.getResource(FXML_PATH + "popUp.fxml"));
        Parent root = loader.load();
        PopUpController popUpControl = loader.getController();
        Stage popUp = new Stage();
        Scene scene = new Scene(root);
        Image icon = new Image(Main.class.getResourceAsStream(IMG_PATH + "alertIcon.png"));
        scene.setFill(Color.TRANSPARENT);
        popUp.getIcons().add(icon);
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setScene(scene);
        popUp.initStyle(StageStyle.UNDECORATED);
        popUp.setTitle(labelStr);
        popUpControl.setLabelText(labelStr);
        popUpControl.setBtnText(btnStr);
        popUpControl.setStage(popUp);
        popUp.initStyle(StageStyle.TRANSPARENT);
        
        Animations.fadeWindow(popUp);
        
        popUp.setOnShown(e -> Animations.scaleInWindow(popUp));
        
        popUp.show();   
    }
}
