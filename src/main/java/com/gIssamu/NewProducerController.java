package com.gIssamu;

import com.gIssamu.model.Producer;
import com.gIssamu.util.DataType;
import com.gIssamu.util.ProducerServices;

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
        if(tfName.getText().isEmpty() || tfCpf.getText().isEmpty() || tfPhone.getText().isEmpty()){
            lbCpfVerif.setText("The fields cannot be empty!");
        }else {
            boolean verifyNewUser = ProducerServices.producerCpfVerification(tfCpf.getText());
    
            if(verifyNewUser == true){
                lbCpfVerif.setText("* This producer already exists!");
            }else{
                Producer newProducer = new Producer();
                newProducer.setName(tfName.getText());
                newProducer.setCpf(tfCpf.getText());
                newProducer.setPhone(tfPhone.getText());

                ProducerServices.insert(DataType.PRODUCER, newProducer);
                lbSaveNewProducer.setText("New producer  has been saved!");
                onBtClear();
            }
        }
    }

    @FXML
    public void onBtClear(){
        tfName.setText("");
        tfCpf.setText("");
        tfPhone.setText("");

        lbCpfVerif.setText("");
    }
}   
