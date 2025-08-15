/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.assistask.controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import com.assistask.animations.Animations;
import javafx.scene.Node;
import javafx.scene.layout.HBox;
/**
 * FXML Controller class
 *
 * @author stredhy
 */
public class LogInController implements Initializable {
    static final String REG_EXP_VER_EMAIL= "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$";
    static final String REG_EXP_VER_PASS= ".{8,16}";
    
    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private Button logInBtn;
    @FXML
    private Button signUpBtn;
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
        Animations.setFadeFocus(emailField);
        Animations.setFadeFocus(passwordField);
    }    

    @FXML
    private void logIn(ActionEvent event) {
    }

    @FXML
    private void signUp(ActionEvent event) {
    }
    
    public boolean verifyPassword(String str){
        return REG_EXP_VER_PASS == str;
    }
    
    public boolean verifyUsername(String str){
        return REG_EXP_VER_EMAIL == str;
    }
    
    public boolean checkEmail(String str){
        return true;
    }
    
    public boolean checkPassword(String str){
        return true;
    }
}
