package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import issamu.model.Rent;
import issamu.model.Silo;
import issamu.util.Alerts;
import issamu.util.DataType;
import issamu.util.RentServices;
import issamu.util.SiloServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

public class ListSilosController extends MenuBarController implements Initializable{
    
    @FXML
    private Button btNewSilo;

    @FXML
    private Button btUpdate; 

    @FXML
    private Button btDelete; 

    @FXML
    private ListView<Silo> lvSilos; 

    private ObservableList<Silo> obsListSilos; 
    
    @FXML
    private VBox vbDetailSilo; 
    
    @FXML
    private TextField tfName; 

    @FXML
    private TextField tfCapacity;
    
    @FXML
    private TextField tfEmptyCapacity; 

    @FXML
    private ListView<Rent> lvSiloRents; 

    private ObservableList<Rent> obsListSiloRents;
    
    @FXML
    private Label lbErrorMensage; 


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes();
    } 

    public void initializeNodes(){
        ArrayList<Silo> list = SiloServices.listReader(DataType.SILO);
        obsListSilos = FXCollections.observableArrayList(list);
        lvSilos.setItems(obsListSilos);

        vbDetailSilo.setVisible(false);
        btDelete.setVisible(false);
    }

    @FXML
    public void onActionBtNewSilo() throws IOException {
        App.setRoot("newSilo");
    }
    
    @FXML
    public void onActionBtUpdateSilo() throws IOException {
        App.setRoot("updateSilo"); 
    }

    @FXML
    public void onActionBtDeleteSilo() throws IOException {
        Optional<ButtonType> result = Alerts.showConfirmation(
            "Confirmation", 
            "Are you shure to delete this Silo? *remember that to delete a silo, it must not have rents"
        );

        if(result.get() == ButtonType.OK){
            Silo auxSilo = lvSilos.getSelectionModel().getSelectedItem(); 
            if(RentServices.searchRentsOnSilo(auxSilo).isEmpty()){
                SiloServices.delete(auxSilo);
                App.setRoot("listSilos");
            }else{
                App.setRoot("listSilos");
                lbErrorMensage.setText("*this silo still has rents on it");
            }
        }
    }

    @FXML
    public void onClickItemLvSilos(){
        Silo auxSilo = lvSilos.getSelectionModel().getSelectedItem(); 

        vbDetailSilo.setVisible(true);
        btDelete.setVisible(true);

        tfName.setText(auxSilo.getName());
        tfCapacity.setText(auxSilo.getCapacity().toString());
        tfEmptyCapacity.setText(auxSilo.getCapacityEmpty().toString());

        ArrayList<Rent> siloRentsList = RentServices.searchRentsOnSilo(auxSilo);
        obsListSiloRents = FXCollections.observableArrayList(siloRentsList);
        lvSiloRents.setItems(obsListSiloRents);

    }
}
