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
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * @author stredhy
 */
public class LogInController implements Initializable{
    public static final String REG_EXP_VER_EMAIL= "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$";
    public static final String REG_EXP_VER_PASS= ".{8,16}";
    public static final String FXML_PATH = "/com/assistask/";
    
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Node n: btnBox.getChildren()){
            Animations.setFadeAndScale(n);
        }
        Animations.setFadeFocus(emailField);
        Animations.setFadeFocus(passwordField);
    }    

    private boolean isEmpty(){
        return passwordField.getText().isEmpty() || emailField.getText().isEmpty();
    }
    
    private boolean checkEmail(){
        return emailField.getText().matches(REG_EXP_VER_EMAIL);
    }
    
    private boolean checkPassword(){
        return passwordField.getText().matches(REG_EXP_VER_PASS);
    }
    
    public boolean checkCredentials(){
        return true;
    }
    
    @FXML
    private void logIn(ActionEvent event) throws IOException {
        if(isEmpty()){
            showMessage("You need to enter you credentials","Try again");
            return;
        }
        
        if(!checkEmail() || !checkPassword() || !checkCredentials()){
            showMessage("Invalid credentials","Try again");
            return;
        }
    }
    
    @FXML
    private void signUp(ActionEvent event) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(FXML_PATH + "signUp.fxml"));
        Parent root = fxmlLoader.load();
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        scene.setFill(Color.web("#120907"));
        stage.setScene(scene);
        stage.setTitle("Sign up");
        
        stage.show();
        Animations.fadeWindow(stage);
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
