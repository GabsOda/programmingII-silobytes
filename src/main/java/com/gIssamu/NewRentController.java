package com.gIssamu;

import java.net.URL;
import java.util.ResourceBundle;

import com.gIssamu.model.Producer;
import com.gIssamu.model.Silo;
import com.gIssamu.util.DataType;
import com.gIssamu.util.ProducerServices;
import com.gIssamu.util.SiloServices;

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
        lbQuantityEmpty.setText("");
    }

    @FXML
    public void onBtSave(){
        
    }

    @FXML
    public void onSelectItemCbSilo(){
        Silo auxSilo = cbSilo.getSelectionModel().getSelectedItem();

        lbQuantityEmpty.setText("Remaining Capacity: "+auxSilo.getCapacityEmpty().toString());
    }



}
