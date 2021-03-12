package com.gIssamu;

import java.io.IOException;

import javafx.fxml.FXML;

public class MenuBarController {

    @FXML
    public void backToLogin() throws IOException {
        App.setRoot("loginUser");
    }

    @FXML
    public void backToMenu() throws IOException {
        App.setRoot("menu");
    }

    @FXML
    public void quit(){
        System.exit(0);
    }

    @FXML
    public void goNewUser() throws IOException{
        App.setRoot("newUser");
    }

    @FXML
    public void goNewUserNoLogin() throws IOException{
        App.setRoot("newUserNoLogin");
    }

    @FXML
    public void goUpdateUser() throws IOException{
        App.setRoot("updateUser");
    }

    @FXML
    public void goListUser() throws IOException{
        App.setRoot("listUsers");
    }

    @FXML
    public void goListUserNoLogin() throws IOException{
        App.setRoot("listUserNoLogin");
    }

    @FXML
    public void goDeleteUser() throws IOException{
        App.setRoot("deleteUser");
    }

    @FXML
    public void goNewProducer() throws IOException{
        App.setRoot("newProducer");
    }

    @FXML
    public void goListProducer() throws IOException{
        App.setRoot("listProducer");
    }

    @FXML
    public void goDeleteProducer() throws IOException{
        App.setRoot("deleteProducer");
    }

    @FXML
    public void goUpdateProducer() throws IOException{
        App.setRoot("updateProducer");
    }
}
