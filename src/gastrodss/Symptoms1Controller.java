/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import POJOS.Patient;
import javafx.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;

public class Symptoms1Controller implements Initializable {

    private Patient patient;
    private String patientname;
    private Environment clips;
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
    private Label nameLabel;

    @FXML
    private void openSymptoms2(ActionEvent event) throws IOException, CLIPSException {
        readSymptoms1();
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

    private void readSymptoms1() throws CLIPSException {

        if (!nauseaNo.isSelected()) {
            patient.setNausea(true);
            clips.assertString("(symptom (name nausea) (activated FALSE) (present YES) (asked YES))");
        }
        List<FactAddressValue> symptoms = clips.findAllFacts("symptom");
        List<FactAddressValue> diseases0 = clips.findAllFacts("disease");
        for (FactAddressValue f : diseases0) {
            System.out.println(f.getSlotValue("name") + " " + f.getSlotValue("score"));
        }
        clips.run();
        List<FactAddressValue> diseases = clips.findAllFacts("disease");
        for (FactAddressValue f : diseases) {
            System.out.println(f.getSlotValue("name") + " " + f.getSlotValue("score"));
        }
        System.out.println("Symptoms: \n");
        for (FactAddressValue f : symptoms) {
            System.out.println(f.getSlotValue("name"));
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void initData(Patient patient, Environment clips) {
        this.patient = patient;
        nameLabel.setText("Patient's name: " + patient.getName());
        this.clips = clips;
    }
}
