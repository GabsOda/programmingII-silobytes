package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import issamu.model.Rent;
import issamu.model.Withdrawn;
import issamu.util.DataType;
import issamu.util.PaymentConfirmation;
import issamu.util.RentServices;
import issamu.util.Services;
import issamu.util.WithdrawService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class NewWithdrawController extends MenuBarController implements Initializable{

    @FXML
    private ComboBox<Rent> cbRents; 

    @FXML
    private TextField tfTotalCost; 

    @FXML 
    private CheckBox checkbPaid; 

    @FXML
    private CheckBox checkbNotPaid; 

    @FXML
    private CheckBox checkbInThere; 

    @FXML
    private Label lbErrorMensage; 

    @FXML
    private Label lbConfirmationSave; 

    @FXML
    private Button btClear; 

    @FXML
    private Button btSave; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes(); 
    }
    
    private void initializeNodes(){
        cbRents.setItems( 
            FXCollections.observableArrayList(Services.listReader(DataType.RENT))
        );
    }

    @FXML
    public void onClickCbRentsItem(){
        Rent auxRent = cbRents.getSelectionModel().getSelectedItem(); 

        tfTotalCost.setText(WithdrawService.calculateCost(auxRent).toString());
    }

    @FXML
    public void onActionBtSave(){
        Rent auxRent = cbRents.getSelectionModel().getSelectedItem(); 

        PaymentConfirmation payConfir = checkCheckBox(); 
        if(payConfir == null){
            lbErrorMensage.setText("*select only one state");
        }else {
            Withdrawn auxWithdraw = new Withdrawn(
                auxRent, Double.parseDouble(tfTotalCost.getText()), payConfir
            );
            WithdrawService.insert(DataType.WITHDRAW, auxWithdraw);
            RentServices.delete(auxRent); 
            lbConfirmationSave.setText("*The withdraw was saved");
        }

        
    }

    private PaymentConfirmation checkCheckBox() {
        if(checkbPaid.isSelected() && !checkbNotPaid.isSelected() && !checkbInThere.isSelected()){
            return PaymentConfirmation.PAID; 
        }
        else if(!checkbPaid.isSelected() && checkbNotPaid.isSelected() && !checkbInThere.isSelected()){
            return PaymentConfirmation.NOTPAID; 
        }
        else if(!checkbPaid.isSelected() && !checkbNotPaid.isSelected() && checkbInThere.isSelected()){
            return PaymentConfirmation.INTHERE; 
        }
        return null; 
    }

    @FXML
    public void onActionBtClear() throws IOException{
        App.setRoot("newWithdraw");
    }
}
