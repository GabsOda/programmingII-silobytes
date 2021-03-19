package com.gIssamu;

import com.gIssamu.model.Silo;
import com.gIssamu.util.DataType;
import com.gIssamu.util.SiloServices;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;

public class NewSiloController extends MenuBarController{
    
    @FXML
    private TextField tfName; 

    @FXML
    private Slider sCapacity; 

    @FXML
    private Button btClear; 

    @FXML
    private Button btSave; 

    @FXML
    private Label lbSaveNewSilo; 

    @FXML
    private Label lbNumberVerif; 

    @FXML
    public void onBtSave(){
        if(tfName.getText().isEmpty()){
            lbNumberVerif.setText("The fields cannot be empty!");
        }else {
            if(SiloServices.siloNameVerification(tfName.getText())){
                lbNumberVerif.setText("* This silo already exists!");
            }else {
                Silo newSilo = new Silo(); 
                newSilo.setName(tfName.getText());
                newSilo.setCapacity(sCapacity.getValue());

                SiloServices.insert(DataType.SILO, newSilo);
                lbSaveNewSilo.setText("New silo has been saved!");
                onBtClear(); 
            }

        }
    }

    @FXML
    public void onBtClear(){
        tfName.setText("");
        sCapacity.setValue(0.0);
    }
}
