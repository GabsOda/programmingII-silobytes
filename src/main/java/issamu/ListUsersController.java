package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import issamu.model.User;
import issamu.util.Alerts;
import issamu.util.DataType;
import issamu.util.UserServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

public class ListUsersController extends MenuBarController implements Initializable{
    
    @FXML
    private Button btNewUserNoLogin; 

    @FXML
    private Button btNewUser; 

    @FXML
    private Button btUpdate;

    @FXML
    private Button btDelete; 

    @FXML
    private ListView<User> lvUsers; 

    ObservableList<User> obsListUsers; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes();
    }

    private void initializeNodes(){
        ArrayList<User> list = UserServices.listReader(DataType.USER);
        obsListUsers = FXCollections.observableArrayList(list);
        lvUsers.setItems(obsListUsers);
    }

    @FXML
    public void onActionBtNewUserNoLogin() throws IOException{
        App.setRoot("newUserNoLogin");
    }

    @FXML
    public void onActionBtNewUser() throws IOException{
        App.setRoot("newUser");
    }

    @FXML
    public void onActionBtUpdate() throws IOException{
        App.setRoot("updateUser");
    }

    @FXML
    public void onActionBtDelete() throws IOException{
        Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you shure to delete this User?");

        if(result.get() == ButtonType.OK){
            UserServices.delete(lvUsers.getSelectionModel().getSelectedItem());
            App.setRoot("listUsers");
        }
    } 

    
    @FXML
    public void onClickItemListUsers(){
        btDelete.setVisible(true);
    }
}
