package issamu;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import issamu.model.Withdrawn;
import issamu.util.DataType;
import issamu.util.WithdrawService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;

public class ListWithdrawsController extends MenuBarController implements Initializable{

    @FXML
    private ListView<Withdrawn> lvWithdraw; 

    @FXML
    private Button btNewWithdraw; 

    @FXML
    private Button btUpdateWithdraw;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initializeNodes(); 
    }

    private void initializeNodes(){
        lvWithdraw.setItems(
            FXCollections.observableArrayList(WithdrawService.listReader(DataType.WITHDRAW))
        );
    }
    
    @FXML
    private void onActionBtNewWithdraw() throws IOException{
        App.setRoot("newWithdraw");
    }

    @FXML
    private void onActionBtUpdateWithdraw() throws IOException{
        App.setRoot("updateWithdraw");
    }
}
