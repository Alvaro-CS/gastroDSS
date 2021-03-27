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

        Symptoms2Controller controller = loader.getController();
        controller.initData(patient, clips);
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
        if (!vomitNo.isSelected()) {
            patient.setVomit(true);
            clips.assertString("(symptom (name vomit) (activated FALSE) (present YES) (asked YES))");
        }
        if (!regurgitationNo.isSelected()) {
            patient.setRegurgitation(true);
            clips.assertString("(symptom (name regurgitation) (activated FALSE) (present YES) (asked YES))");
        }
        if (!heartburnNo.isSelected()) {
            patient.setHeartburn(true);
            clips.assertString("(symptom (name heartburn) (activated FALSE) (present YES) (asked YES))");
        }
        if (!refluxNo.isSelected()) {
            patient.setReflux(true);
            clips.assertString("(symptom (name reflux) (activated FALSE) (present YES) (asked YES))");
        }
        if (!dysphagiaNo.isSelected()) {
            patient.setDysphagia(true);
            clips.assertString("(symptom (name dysphagia) (activated FALSE) (present YES) (asked YES))");
        }
        if (!thoracic_painNo.isSelected()) {
            patient.setThoracic_pain(true);
            clips.assertString("(symptom (name thoracic-pain) (activated FALSE) (present YES) (asked YES))");
        }
        if (!coughNo.isSelected()) {
            patient.setCough(true);
            clips.assertString("(symptom (name cough) (activated FALSE) (present YES) (asked YES))");
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
