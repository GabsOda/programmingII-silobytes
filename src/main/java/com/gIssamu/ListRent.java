package com.gIssamu;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import com.gIssamu.model.Producer;
import com.gIssamu.model.Rent;
import com.gIssamu.model.Silo;
import com.gIssamu.util.DataType;
import com.gIssamu.util.RentServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class ListRent extends MenuBarController implements Initializable{
    
    @FXML
    private TableView<Rent> tvRent; 

    @FXML
    private TableColumn<Rent, Silo> tcRentSilo; 

    @FXML
    private TableColumn<Rent, Producer> tcRentProducer; 

    @FXML
    private TableColumn<Rent, Double> tcRentQuantity; 

    @FXML
    private TableColumn<Rent, Date> tcRentDate; 

    @FXML
    private Button btNewRent; 

    @FXML
    private Button btUpdateRent; 

    @FXML
    private Button btDeleteRent;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcRentSilo.setCellValueFactory(new PropertyValueFactory<>("silo"));
        tcRentProducer.setCellValueFactory(new PropertyValueFactory<>("producer"));
        tcRentQuantity.setCellValueFactory(new PropertyValueFactory<>("quantity"));
        tcRentDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        tvRent.setItems(returnRentList());
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
    public void onBtUpdateRent(){

    }

    @FXML
    public void onBtDeleteRent(){
        
    }
}
