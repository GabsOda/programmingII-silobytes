package com.gIssamu;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DeleteSiloController extends MenuBarController implements Initializable{

    @FXML
    private ListView<Silo> lvSiloList; 

    private ObservableList<Silo> obsSiloList; 

    @FXML
    private Label lbName; 

    @FXML
    private Label lbNameField; 

    @FXML
    private Label lbCapacity; 

    @FXML
    private Label lbCapacityField; 

    @FXML
    private Label errorMensage; 

    @FXML
    private Button btDelete; 

    private Silo selectedSilo; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListSiloView();
    }

    public void setListSiloView(){
        ArrayList<Silo> auxSiloList = SiloServices.listReader(DataType.SILO);

        obsSiloList = FXCollections.observableArrayList(auxSiloList);

        lvSiloList.setItems(obsSiloList);
    }

    @FXML
    public void onClickLvSiloItem(){
        lbName.setText("Name");
        lbCapacity.setText("Capacity");

        Silo silo = lvSiloList.getSelectionModel().getSelectedItem();

        lbNameField.setText(silo.getName());
        lbCapacityField.setText(silo.getCapacity().toString());

        selectedSilo = silo; 
        System.out.println(selectedSilo);
    }

    @FXML
    public void onBtDeleteAction() throws Exception {
        if(selectedSilo.getRentList() == null){
            boolean confirmation = SiloServices.delete(selectedSilo);
            if(confirmation){
                App.setRoot("deleteSilo");
            }
        }else {
            errorMensage.setText("to delete this silo, there can be no registered rentals");
        }
    }
}
