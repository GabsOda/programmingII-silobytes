package issamu;

import java.net.URL;
import java.util.ResourceBundle;

import issamu.model.Producer;
import issamu.model.Rent;
import issamu.model.Silo;
import issamu.util.DataType;
import issamu.util.ProducerServices;
import issamu.util.RentServices;
import issamu.util.SiloServices;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewRentController extends MenuBarController implements Initializable{
    
    @FXML
    private ComboBox<Producer> cbProducer; 

    @FXML
    private ComboBox<Silo> cbSilo; 

    @FXML
    private TextField tfQuantity; 

    @FXML
    private DatePicker dpEntryDate; 

    @FXML
    private Label lbErrorMensage; 

    @FXML
    private Label lbQuantityEmpty; 

    @FXML
    private Button btClear; 

    @FXML
    private Button btSave;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbProducer.setItems(FXCollections.observableArrayList(
           ProducerServices.listReader(DataType.PRODUCER)
        )); 
        cbSilo.setItems(FXCollections.observableArrayList(
            SiloServices.listReader(DataType.SILO)
        ));
    } 

    @FXML
    public void onBtClear(){
        tfQuantity.setText("");
        lbErrorMensage.setText("");
    }

    @FXML
    public void onBtSave(){
        double capacityEmpty = cbSilo.getSelectionModel().getSelectedItem().getCapacityEmpty();
        double quantity = Double.parseDouble(tfQuantity.getText());
        if(quantity > capacityEmpty){
            lbErrorMensage.setText("*Quantity to be rented unavailable for the selected silo");
        }else{
            Silo auxSilo = cbSilo.getSelectionModel().getSelectedItem();
            Rent newRent = new Rent(
                Double.parseDouble(tfQuantity.getText()), 
                dpEntryDate.getValue(), 
                cbProducer.getSelectionModel().getSelectedItem(),
                auxSilo
            ); 
            Silo auxUpdatedSilo = new Silo(auxSilo.getName(), auxSilo.getCapacity(), auxSilo.getCapacityEmpty()-quantity);

            RentServices.insert(DataType.RENT, newRent);
            SiloServices.update(auxSilo, auxUpdatedSilo, false);

        }
    }

    @FXML
    public void onSelectItemCbSilo(){
        Silo auxSilo = cbSilo.getSelectionModel().getSelectedItem();

        lbQuantityEmpty.setText("Remaining Capacity: "+auxSilo.getCapacityEmpty().toString());
    }



}
