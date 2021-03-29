package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;

import issamu.model.Producer;
import issamu.util.Alerts;
import issamu.util.DataType;
import issamu.util.ProducerServices;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;

public class ListProducersController extends MenuBarController implements Initializable{

    @FXML
    private Button btNewProducer;

    @FXML
    private Button btUpdate;

    @FXML
    private Button btDelete; 

    @FXML
    private ListView<Producer> lvProducers;

    ObservableList<Producer> obsListProducers; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializenNodes();
    }
    
    private void initializenNodes(){
        ArrayList<Producer> list = ProducerServices.listReader(DataType.PRODUCER);
        obsListProducers = FXCollections.observableArrayList(list);
        lvProducers.setItems(obsListProducers);

        btDelete.setVisible(false);
    }

    @FXML
    public void onActionBtNewProducer() throws IOException {
        App.setRoot("newProducer");
    }

    @FXML
    public void onActionBtUpdateProducer() throws IOException {
        App.setRoot("updateProducer");
    }

    @FXML
    public void onActionBtDeleteProducer() throws IOException {
        Optional<ButtonType> result = Alerts.showConfirmation("Confirmation", "Are you shure to delete this Producer? ");

        if(result.get() == ButtonType.OK){
            ProducerServices.delete(lvProducers.getSelectionModel().getSelectedItem());
            App.setRoot("listProducers");
        }
    }

    @FXML
    public void onClickItemListProducer(){
        btDelete.setVisible(true); 
    }
  
}
