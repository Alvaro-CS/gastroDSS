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
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;

public class Symptoms3Controller implements Initializable {

    private Patient patient;
    private Environment clips;
    @FXML
    private Label nameLabel;

    @FXML
    private RadioButton constipationNo;
    @FXML
    private RadioButton diarrheaNo;
    @FXML
    private RadioButton gasNo;
    @FXML
    private RadioButton tenesmusNo;
    @FXML
    private RadioButton melenaNo;

    @FXML
    private void openSymptoms4(ActionEvent event) throws IOException, CLIPSException {
        readSymptoms3();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Symptoms4.fxml"));
        Parent symptoms4Parent = loader.load();

        Symptoms4Controller controller = loader.getController();
        controller.initData(patient, clips);
        Scene Symptoms4Scene = new Scene(symptoms4Parent);
        //this line gets the Stage information
        //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(Symptoms4Scene);
//        window.setTitle("WOLFFGRAM");
//        window.getIcons().add(new Image("/wolff_patient/images/logo.png"));
        window.centerOnScreen();

        window.show();
        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.close();
    }

    private void readSymptoms3() throws CLIPSException {

        if (!constipationNo.isSelected()) {
            patient.setNausea(true);
            clips.assertString("(symptom (name constipation) (activated FALSE) (present YES) (asked YES))");
        }
        if (!diarrheaNo.isSelected()) {
            patient.setNausea(true);
            clips.assertString("(symptom (name diarrhea) (activated FALSE) (present YES) (asked YES))");
        }
        if (!gasNo.isSelected()) {
            patient.setNausea(true);
            clips.assertString("(symptom (name gas) (activated FALSE) (present YES) (asked YES))");
        }
        if (!tenesmusNo.isSelected()) {
            patient.setNausea(true);
            clips.assertString("(symptom (name rectal-tenesmus) (activated FALSE) (present YES) (asked YES))");
        }
        if (!melenaNo.isSelected()) {
            patient.setNausea(true);
            clips.assertString("(symptom (name melena) (activated FALSE) (present YES) (asked YES))");
        }
        List<FactAddressValue> symptoms = clips.findAllFacts("symptom");
        List<FactAddressValue> diseases = clips.findAllFacts("disease");

        System.out.println("Diseases: \n");
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
