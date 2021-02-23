package com.gIssamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.gIssamu.model.User;
import com.gIssamu.util.UserServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DeleteUserController extends MenuBarController implements Initializable {

    @FXML
    private Label lbTittle;

    @FXML
    private ListView<User> lvUsersList;

    private ObservableList<User> obsUsersList;

    @FXML
    private Label lbName;

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

    @FXML
    private Button btDelete;

    private User selectedUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListUsersView();
    }

    public void setListUsersView() {
        ArrayList<User> auxUserList = UserServices.listReader();

        obsUsersList = FXCollections.observableArrayList(auxUserList);

        lvUsersList.setItems(obsUsersList);
    }

    @FXML
    public void onClicklvUsersListItem() {
        lbName.setText("Name");
        lbLogin.setText("Login");
        lbPassword.setText("Password");

        User user = lvUsersList.getSelectionModel().getSelectedItem();

        lbNameField.setText(user.getName());
        lbLoginField.setText(user.getLogin());
        int passwordCharacter = user.getPassword().length();
        lbPasswordField.setText(UserServices.generateHidePassword(passwordCharacter));

        selectedUser = user;
    }

    @FXML
    public void onBtDeleteAction() throws IOException {
        boolean confirmation = UserServices.delete(selectedUser);
        if(confirmation) {
            App.setRoot("deleteUser");
        }
    }
}
