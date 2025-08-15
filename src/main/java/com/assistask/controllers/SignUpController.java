/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.assistask.controllers;

import com.assistask.animations.Animations;
import static com.assistask.controllers.LogInController.FXML_PATH;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author stredhy
 */
public class SignUpController implements Initializable {

    @FXML
    private TextField userNameField;
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private PasswordField confirmPasswordField;
    @FXML
    private PasswordField birthdayField;
    @FXML
    private Button logInBtn;
    @FXML
    private Button signUpBtn;
    @FXML
    private VBox fieldBox;
    @FXML
    private HBox btnBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Node n: btnBox.getChildren()){
            Animations.setFadeAndScale(n);
        }
        for(Node n: fieldBox.getChildren()){
            Animations.setFadeFocus(n);
        }
    }    

    @FXML
    private void logIn(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/com/assistask/logIn.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        
        scene.setFill(Color.web("#120907"));
        stage.setScene(scene);
        stage.setTitle("Log in");

        stage.show();
        Animations.fadeWindow(stage);
    }

    @FXML
    private void signUp(ActionEvent event) {
        
    }
    
    private void showMessage(String labelStr, String btnStr) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource(FXML_PATH + "popUp.fxml"));
        Parent root = loader.load();
        PopUpController popUpControl = loader.getController();
        popUpControl.setLabelText(labelStr);
        popUpControl.setBtnText(btnStr);
        Stage popUp = new Stage();
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        popUp.initModality(Modality.APPLICATION_MODAL);
        popUp.setScene(scene);
        popUp.initStyle(StageStyle.UNDECORATED);
        popUp.setTitle(labelStr);
        popUpControl.setStage(popUp);
        Animations.fadeWindow(popUp);
        
        popUp.initStyle(StageStyle.TRANSPARENT);
        
        root.setScaleX(0);
        root.setScaleY(0);
        
        popUp.setOnShown(e -> Animations.scaleInWindow(popUp));
        
        popUp.show();   
    }
}
