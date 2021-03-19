package com.gIssamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.gIssamu.model.Silo;
import com.gIssamu.util.DataType;
import com.gIssamu.util.SiloServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UpdateSiloController extends MenuBarController implements Initializable{

    @FXML
    private ComboBox<Silo> cbSiloBox; 

    private ObservableList<Silo> obsListSilo; 

    @FXML
    private GridPane gpUpdateSilo; 

    @FXML
    private Label lbName; 
    
    @FXML
    private TextField tfNameField; 

    @FXML
    private Label lbCapacity; 

    @FXML
    private TextField tfCapacityField; 

    @FXML
    private Button btSave; 

    @FXML
    private Label lbSucessUpdate; 

    @FXML
    private Label lbUnSucessUpdate; 

    private Silo selectedSilo; 
    private Silo updatedSilo; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadSiloFromComboBox();
        setInvisible();
    }

    public void loadSiloFromComboBox(){
        ArrayList<Silo> auxSilo = SiloServices.listReader(DataType.SILO);
        
        obsListSilo = FXCollections.observableArrayList(auxSilo);

        cbSiloBox.setItems(obsListSilo);
    }

    public void setInvisible(){
        lbName.setText("");
        lbCapacity.setText("");

        tfNameField.setVisible(false);
        tfCapacityField.setVisible(false); 
    }

    @FXML
    public void onSelectItemOnComboBox(){
        Silo silo = cbSiloBox.getSelectionModel().getSelectedItem();
        lbSucessUpdate.setText("");

        lbName.setText("Name");
        lbCapacity.setText("Capacity");

        tfNameField.setVisible(true);
        tfCapacityField.setVisible(true); 

        tfNameField.setText(silo.getName());
        tfCapacityField.setText(silo.getCapacity().toString());

        selectedSilo = silo; 
    }
    
    @FXML
    public void onBtSaveAction() throws IOException {
        updatedSilo = new Silo(tfNameField.getText(), Double.parseDouble(tfCapacityField.getText())); 
        boolean sucessUpdate = SiloServices.update(selectedSilo, updatedSilo); 
        if(sucessUpdate){
            lbSucessUpdate.setText("The silo has been updated");
        }else{
            lbUnSucessUpdate.setText("The silo cannot be update");
        }
    }
}
