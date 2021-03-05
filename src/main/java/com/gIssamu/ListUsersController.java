package com.gIssamu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.gIssamu.model.User;
import com.gIssamu.util.DataType;
import com.gIssamu.util.UserServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ListUsersController extends MenuBarController implements Initializable {

    @FXML
    private ListView<User> lvListUsers;

    private ObservableList<User> obsListUser; 

    @FXML
    private Label lbInstruction; 

    @FXML 
    private Label lbNameField;

    @FXML
    private Label lbLogin;

    @FXML
    private Label lbLoginField;

    @FXML
    private Label lbPassword;

    @FXML
    private Label lbPasswordField;

    @Override
	public void initialize(URL url, ResourceBundle rb) {
		setListUsersView();
	}

    public void setListUsersView(){
        ArrayList<User> auxUserList = UserServices.listReader(DataType.USER);

        obsListUser = FXCollections.observableArrayList(auxUserList);

        lvListUsers.setItems(obsListUser);
    }

    @FXML
    public void onClicklvListUsersItem(){
        lbInstruction.setText(" ");
        
        User user = lvListUsers.getSelectionModel().getSelectedItem();
        
        lbNameField.setText(user.getName());

        lbLogin.setText("Login: ");
        lbPassword.setText("Password: ");

        lbLoginField.setText(user.getLogin());
        
        int passwordCharacter = user.getPassword().length();
        String hidePassword = UserServices.generateHidePassword(passwordCharacter);

        lbPasswordField.setText(hidePassword);
    }
}
