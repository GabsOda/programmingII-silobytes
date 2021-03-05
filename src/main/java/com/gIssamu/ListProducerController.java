package com.gIssamu;

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
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class ListProducerController extends MenuBarController implements Initializable {

    @FXML
    private ListView<Producer> lvListProducer;

    private ObservableList<Producer> obsListProducer;

    @FXML
    private Label lbInstruction;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        setListProducerView();
    }

    public void setListProducerView(){
        ArrayList<Producer> auxProducerList = ProducerServices.listReader(DataType.PRODUCER);

        obsListProducer = FXCollections.observableArrayList(auxProducerList);

        lvListProducer.setItems(obsListProducer);
    }

    @FXML
    public void onClickLvListProducersItem(){
        lbInstruction.setText("");

        Producer producer = lvListProducer.getSelectionModel().getSelectedItem();

        lbNameField.setText(producer.getName());

        lbCpf.setText("CPF: ");
        lbPhone.setText("Phone: ");

        lbCpfField.setText(producer.getCpf());
        lbPhoneField.setText(producer.getPhone());
    }
}
