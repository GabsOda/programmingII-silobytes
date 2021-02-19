package com.gIssamu;

import java.io.IOException;

import javafx.fxml.FXML;

public class MenuBarController {

    @FXML
    public void backToLogin() throws IOException {
        App.setRoot("loginUser");
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
    public void goUpdateUser() throws IOException{
        App.setRoot("updateUser");
    }

    @FXML
    public void goListUser() throws IOException{
        App.setRoot("listUser");
    }

    @FXML
    public void goDeleteUser() throws IOException{
        App.setRoot("deleteUser");
    }
}
