package com.gIssamu;

import java.io.IOException;

import com.gIssamu.util.UserServices;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class LoginUserController extends MenuBarController {

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private Label lbErrorMensage;

    @FXML
    private Button btLogin;

    @FXML
    public void onBtLogin() throws IOException {
        if(tfLogin.getText().isEmpty() || tfPassword.getText().isEmpty()){
            lbErrorMensage.setText("* The fields cannot be empty!");
        }else {
            boolean userLoginVerified = UserServices.userLogin(
                tfLogin.getText(), tfPassword.getText());
            
            if(userLoginVerified == false){
                lbErrorMensage.setText("* The credentials used are invalid! ");
            }else {
                App.setRoot("menu");
            }
        }
    }
}