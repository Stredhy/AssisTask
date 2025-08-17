package com.assistask.controller;

import com.assistask.util.Animations;
import com.assistask.util.Dialogs;
import static com.assistask.util.Dialogs.FXML_PATH;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author stredhy
 */
public class LogInController implements Initializable{
    public static final String REG_EXP_VER_EMAIL= "[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,63}$";
    public static final String REG_EXP_VER_PASS= ".{8,16}";
    
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
            Dialogs.showMessage("You need to enter you credentials","Try again");
            return;
        }
        
        if(!checkEmail() || !checkPassword() || !checkCredentials()){
            Dialogs.showMessage("Invalid credentials","Try again");
            return;
        }
        
        System.out.println("login");
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
}
