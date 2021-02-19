package com.gIssamu;

import com.gIssamu.model.User;
import com.gIssamu.util.UserServices;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewUserController extends MenuBarController{
    
    @FXML
    private TextField tfName;

    @FXML
    private TextField tfLogin;

    @FXML
    private TextField tfPassword;

    @FXML
    private Button btClear;

    @FXML
    private Button btSave; 

    @FXML
    private Label lbUserVerif; 

    @FXML
    private Label lbSaveNewUser;

    @FXML
    public void onBtSave(){
        if(tfName.getText().isEmpty() || tfLogin.getText().isEmpty() || tfPassword.getText().isEmpty()){
            lbUserVerif.setText("The fields cannot be empty!");
        }else {
            boolean verifyNewUser = UserServices.loginEqualsVerification(tfLogin.getText());
    
            if(verifyNewUser == true){
                lbUserVerif.setText("* This login already exists!");
            }else{
                User newUser = new User();
                newUser.setName(tfName.getText());
                newUser.setLogin(tfLogin.getText());
                newUser.setPassword(tfPassword.getText());

                UserServices.insert(newUser);
                lbSaveNewUser.setText("New user has been saved!");
                onBtClear();
            }
        }
    }

    @FXML
    public void onBtClear(){
        tfName.setText("");
        tfLogin.setText("");
        tfPassword.setText("");

        lbUserVerif.setText("");
    }
}
