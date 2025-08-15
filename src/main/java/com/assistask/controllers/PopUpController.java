package com.assistask.controllers;

import com.assistask.animations.Animations;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

/*
 * @author stredhy
 */
public class PopUpController implements Initializable {

    @FXML
    private Label label;
    @FXML
    private Button btnAction;

    
    private Stage stage;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        Animations.setFadeAndScale(btnAction);
        label.setWrapText(true);
        btnAction.setWrapText(true);
    }    
    
    @FXML
    private void close(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Animations.scaleOutAndClose(stage); 
    }
    
    public void setLabelText(String str){
        label.setText(str);
    }
    
    public void setBtnText(String str){
        btnAction.setText(str);
    }
    
    public Button getBtn(){
        return this.btnAction;
    }
    
    public void setStage(Stage stg){
        this.stage = stg;
    }
    
    public Stage getStage(){
        return this.stage;
    }
}
