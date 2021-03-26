package issamu;

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
    public void goListUser() throws IOException{
        App.setRoot("listUsers");
    }

    @FXML
    public void goListUserNoLogin() throws IOException{
        App.setRoot("listUsersNoLogin");
    }

    @FXML
    public void goUpdateUser() throws IOException{
        App.setRoot("updateUser");
    }

    @FXML
    public void goNewProducer() throws IOException{
        App.setRoot("newProducer");
    }

    @FXML
    public void goListProducer() throws IOException{
        App.setRoot("listProducers");
    }

    @FXML
    public void goUpdateProducer() throws IOException{
        App.setRoot("updateProducer");
    }

    @FXML
    public void goNewSilo() throws IOException{
        App.setRoot("newSilo");
    }

    @FXML
    public void goListSilo() throws IOException{
        App.setRoot("listSilos");
    }

    @FXML
    public void goUpdateSilo() throws IOException{
        App.setRoot("updateSilo");
    }

    @FXML
    public void goNewRent() throws IOException{
        App.setRoot("newRent");
    }

    @FXML
    public void goListRent() throws IOException{
        App.setRoot("listRents");
    }
}
