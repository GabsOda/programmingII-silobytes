package com.gIssamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import com.gIssamu.model.Producer;
import com.gIssamu.util.DataType;
import com.gIssamu.util.ProducerServices;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class DeleteProducerController extends MenuBarController implements Initializable{
    
    @FXML
    private Label lbTittle;

    @FXML
    private ListView<Producer> lvProducerList; 

    private ObservableList<Producer> obsProducerList; 

    @FXML
    private Label lbName; 

    @FXML
    private Label lbNameField; 

    @FXML
    private Label lbCpf; 

    @FXML
    private Label lbCpfField; 
    
    @FXML
    private Label lbPhone; 
    
    @FXML
    private Label lbPhoneField; 

    @FXML
    private Button btDelete; 

    private Producer selectedProducer;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListProducerView();
    } 

    public void setListProducerView(){
        ArrayList<Producer> auxProducerList= ProducerServices.listReader(DataType.PRODUCER);
    
        obsProducerList = FXCollections.observableArrayList(auxProducerList);

        lvProducerList.setItems(obsProducerList);
    }

    @FXML
    public void onClickLvProducerItem(){
        lbName.setText("Name");
        lbCpf.setText("Cpf");
        lbPhone.setText("Phone");

        Producer producer = lvProducerList.getSelectionModel().getSelectedItem();

        lbNameField.setText(producer.getName());
        lbCpfField.setText(producer.getCpf());
        lbPhoneField.setText(producer.getPhone());

        selectedProducer = producer; 
    }

    @FXML
    public void onBtDeleteAction() throws IOException{
        boolean confirmation = ProducerServices.delete(selectedProducer);
        if(confirmation){
            App.setRoot("deleteProducer");
        }
    }
}
