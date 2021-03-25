/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class Symptoms4Controller implements Initializable {

    @FXML
    private RadioButton muscularPainNo;
    @FXML
    private RadioButton headacheNo;
    @FXML
    private RadioButton ictericiaNo;
    @FXML
    private RadioButton rapidPulsationsNo;
    @FXML
    private RadioButton anemiaNo;
    @FXML
    private RadioButton dermatitisNo;
    @FXML
    private RadioButton stomatitiNo;
    @FXML
    private RadioButton impotenceNo;
    @FXML
    private RadioButton infertilityNo;
    @FXML
    private RadioButton amenorrheaNo;

    @FXML
    private void openDiagnosis(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Diagnosis.fxml"));
        Parent diagnosisParent = loader.load();

        //Symptoms1Controller controller = loader.getController();
//       controller.initData(patientMoved, com_data_client);
        Scene diagnosisScene = new Scene(diagnosisParent);
        //this line gets the Stage information
        //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(diagnosisScene);
//        window.setTitle("WOLFFGRAM");
//        window.getIcons().add(new Image("/wolff_patient/images/logo.png"));
        window.centerOnScreen();

        window.show();
        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.close();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

}
