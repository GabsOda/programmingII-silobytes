package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import issamu.model.Producer;
import issamu.util.DataType;
import issamu.util.ProducerServices;
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
    private Button btSave; 

    @FXML
    private GridPane gpUpdatePane; 

    @FXML
    private TextField tfName; 

    @FXML
    private TextField tfCpf; 

    @FXML
    private TextField tfPhone; 

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
        gpUpdatePane.setVisible(false); 
    }
    
    @FXML
    public void onSelectItemOnComboBox(){
        Producer producer = cbProducerBox.getSelectionModel().getSelectedItem();
        lbSucessUpdate.setText("");

        gpUpdatePane.setVisible(true);

        tfName.setText(producer.getName());
        tfCpf.setText(producer.getCpf());
        tfPhone.setText(producer.getPhone());

        selectedProducer = producer; 
        updatedProducer = new Producer(tfName.getText(), tfCpf.getText(), tfPhone.getText());
    }

    @FXML
    public void onBtSaveAction() throws IOException{
        updatedProducer = new Producer(tfName.getText(), tfCpf.getText(), tfPhone.getText());
        boolean sucessUpdate = ProducerServices.update(selectedProducer, updatedProducer);
        if(sucessUpdate){
            lbSucessUpdate.setText("The producer has been updated");
        }else {
            lbUnSucessUpdate.setText("The producer cannot be update");
        }
    }
}
