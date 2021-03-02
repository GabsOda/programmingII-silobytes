package com.gIssamu;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewProducerController extends MenuBarController{
     
    @FXML
    private TextField tfName; 
    
    @FXML
    private TextField tfCpf; 

    @FXML
    private TextField tfPhone; 

    @FXML
    private Button btClear; 

    @FXML
    private Button btSave; 

    @FXML
    private Label lbCpfVerif; 

    @FXML
    private Label lbSaveNewProducer; 

    @FXML
    public void onBtSave(){

    }

    @FXML
    public void onBtClear(){
        tfName.setText("");
        tfCpf.setText("");
        tfPhone.setText("");

        lbCpfVerif.setText("");
    }
}   
