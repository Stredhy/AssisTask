/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.assistask.controllers;

import com.assistask.animations.Animations;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(new Scene(fxmlLoader.load()));
        stage.setTitle("Log in");
        stage.show();
        Animations.fadeWindow(stage);
    }

    @FXML
    private void signUp(ActionEvent event) {
    }
    
}
