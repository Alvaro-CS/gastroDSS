/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import javafx.event.ActionEvent;
import java.io.IOException;
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

public class Symptoms1Controller implements Initializable{

    private String patientname;

    @FXML
    private RadioButton nauseaNo;

    @FXML
    private RadioButton vomitNo;

    @FXML
    private RadioButton regurgitationNo;

    @FXML
    private RadioButton heartburnNo;

    @FXML
    private RadioButton refluxNo;

    @FXML
    private RadioButton dysphagiaNo;

    @FXML
    private RadioButton coughNo;
    @FXML
    private RadioButton thoracic_painNo;

    @FXML
    private void openSymptoms2(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Symptoms2.fxml"));
        Parent symptoms2Parent = loader.load();

        //Symptoms1Controller controller = loader.getController();
//       controller.initData(patientMoved, com_data_client);
        Scene Symptoms2Scene = new Scene(symptoms2Parent);
        //this line gets the Stage information
        //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(Symptoms2Scene);
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
