package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import issamu.model.Silo;
import issamu.util.DataType;
import issamu.util.SiloServices;
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
    private Button btSave; 

    @FXML
    private GridPane gpUpdateSilo; 

    @FXML
    private TextField tfName; 

    @FXML
    private TextField tfCapacity; 

    @FXML
    private TextField tfCapacityEmpty;

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
        gpUpdateSilo.setVisible(false);
    }

    @FXML
    public void onSelectItemOnComboBox(){
        Silo silo = cbSiloBox.getSelectionModel().getSelectedItem();
        lbSucessUpdate.setText("");

        gpUpdateSilo.setVisible(true); 

        tfName.setText(silo.getName());
        tfCapacity.setText(silo.getCapacity().toString());
        tfCapacityEmpty.setText(silo.getCapacityEmpty().toString());

        selectedSilo = silo; 
    }
    
    @FXML
    public void onBtSaveAction() throws IOException {
        updatedSilo = new Silo(tfName.getText(), Double.parseDouble(tfCapacity.getText()), Double.parseDouble(tfCapacityEmpty.getText())); 
        boolean sucessUpdate = SiloServices.update(selectedSilo, updatedSilo, true); 
        if(sucessUpdate){
            lbSucessUpdate.setText("The silo has been updated");
        }else{
            lbUnSucessUpdate.setText("The silo cannot be update");
        }
    }
}
