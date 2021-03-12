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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

public class UpdateProducerController extends MenuBarController implements Initializable{

    @FXML 
    private ComboBox<Producer> cbProducerBox; 

    private ObservableList<Producer> obsListProducer; 

    @FXML
    private GridPane gpUpdatePane; 

    @FXML
    private Label lbName; 

    @FXML
    private TextField tfNameField; 

    @FXML
    private Label lbCpf; 

    @FXML
    private TextField tfCpfField; 

    @FXML
    private Label lbPhone; 

    @FXML
    private TextField tfPhoneField; 

    @FXML
    private Button btSave; 

    @FXML
    private Label lbSucessUpdate; 

    @FXML
    private Label lbUnSucessUpdate; 

    private Producer selectedProducer; 
    private Producer updatedProducer;  

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadProducerFromComboBox();
        setInvisible();
    }

    public void loadProducerFromComboBox(){
        ArrayList<Producer> auxProducer = ProducerServices.listReader(DataType.PRODUCER);

        obsListProducer = FXCollections.observableArrayList(auxProducer);

        cbProducerBox.setItems(obsListProducer);
    }

    public void setInvisible(){
        lbName.setText("");
        lbCpf.setText("");
        lbPhone.setText("");

        tfNameField.setVisible(false);
        tfCpfField.setVisible(false);
        tfPhoneField.setVisible(false); 
    }
    
    @FXML
    public void onSelectItemOnComboBox(){
        Producer producer = cbProducerBox.getSelectionModel().getSelectedItem();
        lbSucessUpdate.setText("");

        lbName.setText("Name");
        lbCpf.setText("Cpf");
        lbPhone.setText("Phone");

        tfNameField.setVisible(true);
        tfCpfField.setVisible(true);
        tfPhoneField.setVisible(true);

        tfNameField.setText(producer.getName());
        tfCpfField.setText(producer.getCpf());
        tfPhoneField.setText(producer.getPhone());

        selectedProducer = producer; 
        updatedProducer = new Producer(tfNameField.getText(), tfCpfField.getText(), tfPhoneField.getText());
    }

    @FXML
    public void onBtSaveAction() throws IOException{
        updatedProducer = new Producer(tfNameField.getText(), tfCpfField.getText(), tfPhoneField.getText());
        boolean sucessUpdate = ProducerServices.update(selectedProducer, updatedProducer);
        if(sucessUpdate){
            lbSucessUpdate.setText("The producer has been updated");
        }else {
            lbUnSucessUpdate.setText("The producer cannot be update");
        }
    }
}
