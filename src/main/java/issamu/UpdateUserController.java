package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import issamu.model.User;
import issamu.util.DataType;
import issamu.util.UserServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class UpdateUserController extends MenuBarController implements Initializable {

    @FXML
    private ComboBox<User> cbUserBox;

    private ObservableList<User> obsListUsers;

    @FXML
    private Label lbName;

    @FXML
    private TextField tfNameField;

    @FXML
    private Label lbLogin; 

    @FXML
    private TextField tfLoginField;

    @FXML
    private Label lbPassword;

    @FXML
    private TextField tfPasswordField;

    @FXML
    private Button btSave;

    @FXML
    private Label lbSucessUpdate;
    
    @FXML
    private Label lbUnSucessUpdate; 

    private User selectedUser; 
    private User updatedUser;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadUsersFromComboBox();
        setInvisible();
    }

    public void loadUsersFromComboBox(){
        List<User> auxUsers = UserServices.listReader(DataType.USER);

        obsListUsers = FXCollections.observableArrayList(auxUsers);
        cbUserBox.setItems(obsListUsers);
    }

    public void setInvisible(){
        lbName.setText("");
        lbLogin.setText("");
        lbPassword.setText("");

        tfNameField.setVisible(false);
        tfLoginField.setVisible(false);
        tfPasswordField.setVisible(false);
    }

    @FXML
    public void onSelectItemOnComboBox(){
        User user = cbUserBox.getSelectionModel().getSelectedItem();
        lbSucessUpdate.setText("");

        lbName.setText("Name");
        lbLogin.setText("Login");
        lbPassword.setText("Password"); 

        tfNameField.setVisible(true);
        tfLoginField.setVisible(true);
        tfPasswordField.setVisible(true);

        tfNameField.setText(user.getName());
        tfLoginField.setText(user.getLogin());
        tfPasswordField.setText(user.getPassword());

        selectedUser = user;
        updatedUser = new User(tfNameField.getText(), tfLoginField.getText(), tfPasswordField.getText());
    }

    @FXML
    public void onBtSaveAction() throws IOException {
        updatedUser = new User(tfNameField.getText(), tfLoginField.getText(), tfPasswordField.getText());
        boolean sucessUpdate = UserServices.update(selectedUser, updatedUser);
        if(sucessUpdate){
            lbSucessUpdate.setText("The user has been updated");
        }else{
            lbUnSucessUpdate.setText("The user cannot be update!");
        }
    }
}
