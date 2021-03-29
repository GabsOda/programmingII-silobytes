package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import issamu.model.Rent;
import issamu.util.Alerts;
import issamu.util.DataType;
import issamu.util.RentServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

public class ListRentsController extends MenuBarController implements Initializable{
    
    @FXML
    private ListView<Rent> lvRent;  

    @FXML
    private Button btNewRent; 

    @FXML
    private Button btDeleteRent;

    @FXML
    private Button btWithdrawl; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        lvRent.setItems(returnRentList());
        btDeleteRent.setVisible(false); 
    } 

    private ObservableList<Rent> returnRentList(){
        return FXCollections.observableArrayList(
            RentServices.listReader(DataType.RENT)
        );
    }

    @FXML
    public void onBtNewRent() throws IOException{
        App.setRoot("newRent");
    }

    @FXML
    public void onBtDeleteRent() throws IOException{
        Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you shure to delete this Rent? "); 

        if(result.get() == ButtonType.OK){
            RentServices.delete(lvRent.getSelectionModel().getSelectedItem());
            App.setRoot("listRents");
        }
    }

    @FXML
    public void onClickItemListRents(){
        btDeleteRent.setVisible(true);
    }
}
