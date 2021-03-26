package issamu;

import java.io.IOException;

import issamu.util.UserServices;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginUserController extends MenuBarController {

    @FXML
    private TextField tfLogin;

    @FXML
    private PasswordField pfPassword;

    @FXML
    private Label lbErrorMensage;

    @FXML
    private Button btLogin;

    @FXML
    public void onBtLogin() throws IOException {
        if(tfLogin.getText().isEmpty() || pfPassword.getText().isEmpty()){
            lbErrorMensage.setText("* The fields cannot be empty!");
        }else {
            boolean userLoginVerified = UserServices.userLogin(
                tfLogin.getText(), pfPassword.getText());
            
            if(userLoginVerified == false){
                lbErrorMensage.setText("* The credentials used are invalid! ");
            }else {
                App.setRoot("menu");
            }
        }
    }
}