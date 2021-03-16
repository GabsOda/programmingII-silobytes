package com.gIssamu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.gIssamu.model.Silo;
import com.gIssamu.util.DataType;
import com.gIssamu.util.ProducerServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ListSiloController extends MenuBarController implements Initializable{

    @FXML
    private ListView<Silo> lvListSilo; 

    private ObservableList<Silo> obsListSilo; 

    @FXML
    private Label lbInstruction; 

    @FXML
    private Label lbNameField; 

    @FXML
    private Label lbCapacity;

    @FXML
    private Label lbCapacityField; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListSiloView();
    }
    
    public void setListSiloView(){
        ArrayList<Silo> auxSiloList = ProducerServices.listReader(DataType.SILO);
        
        obsListSilo = FXCollections.observableArrayList(auxSiloList);

        lvListSilo.setItems(obsListSilo);
    }

    @FXML
    public void onClickLvListSiloItem(){
        lbInstruction.setText("");

        Silo silo = lvListSilo.getSelectionModel().getSelectedItem();

        lbNameField.setText(silo.getName());
        
        lbCapacity.setText("Capacity: ");
        lbCapacityField.setText(silo.getCapacity().toString());
    }
}