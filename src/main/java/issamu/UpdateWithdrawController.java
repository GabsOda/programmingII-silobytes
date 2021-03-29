package issamu;

import java.net.URL;
import java.util.ResourceBundle;

import issamu.model.Withdrawn;
import issamu.util.DataType;
import issamu.util.PaymentConfirmation;
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
import javafx.scene.layout.GridPane;

public class UpdateWithdrawController extends MenuBarController implements Initializable{

    @FXML
    private ComboBox<Withdrawn> cbWithdraw; 

    @FXML
    private Button btSave; 

    @FXML
    private GridPane gpUpdatePane; 

    @FXML
    private TextField tfRent; 

    @FXML
    private TextField tfTotalCost; 

    @FXML
    private CheckBox checkbPaid; 

    @FXML
    private CheckBox checkbNotPaid; 

    @FXML
    private CheckBox checkbInThere; 

    @FXML
    private Label lbUpdateConfirmation; 

    @FXML
    private Label lbErrorMensage; 

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes(); 
    }

    private void initializeNodes(){
        cbWithdraw.setItems(
            FXCollections.observableArrayList(Services.listReader(DataType.WITHDRAW))
        );

        gpUpdatePane.setVisible(false);
    }

    @FXML
    public void onClickCbWithdrawItem(){
        gpUpdatePane.setVisible(true);

        Withdrawn auxWithdraw = cbWithdraw.getSelectionModel().getSelectedItem();
        tfRent.setText(auxWithdraw.getRent().toString());
        tfTotalCost.setText(auxWithdraw.getTotalCost().toString());

        PaymentConfirmation payConfirmation = auxWithdraw.getPaid(); 
        if(payConfirmation == PaymentConfirmation.PAID){
            checkbPaid.setSelected(true);
        }else if(payConfirmation == PaymentConfirmation.NOTPAID){
            checkbNotPaid.setSelected(true);
        }else if(payConfirmation == PaymentConfirmation.INTHERE){
            checkbInThere.setSelected(true);
        }
    }

    @FXML
    public void onActionBtSave(){
        Withdrawn auxWithdraw = cbWithdraw.getSelectionModel().getSelectedItem(); 

        Withdrawn updatedWithdraw = new Withdrawn(
            auxWithdraw.getRent(), auxWithdraw.getTotalCost(), checkCheckBox()
        );
        if(checkCheckBox() == null){
            lbErrorMensage.setText("*The withdraw cannot be update");
        }else{
            boolean sucessUpdate = WithdrawService.update(auxWithdraw, updatedWithdraw);
            if(sucessUpdate){
                lbUpdateConfirmation.setText("*The whitdraw has been updated");
            }else{
                lbErrorMensage.setText("*The withdraw cannot be update");
            }
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
    
}
