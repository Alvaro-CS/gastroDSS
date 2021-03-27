/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import POJOS.Patient;
import java.io.IOException;
import javafx.event.ActionEvent;
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
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;

public class Symptoms4Controller implements Initializable {

    private Patient patient;
    private Environment clips;
    @FXML
    private Label nameLabel;
    
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
    private void openDiagnosis(ActionEvent event) throws IOException, CLIPSException {
        readSymptoms4();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Diagnosis.fxml"));
        Parent diagnosisParent = loader.load();

        
        Scene diagnosisScene = new Scene(diagnosisParent);
        //this line gets the Stage information
        //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(diagnosisScene);
//        window.setTitle("WOLFFGRAM");
//        window.getIcons().add(new Image("/wolff_patient/images/logo.png"));
        window.centerOnScreen();
        DiagnosisController controller = loader.getController();
           controller.initData(patient, clips,window);
        window.show();
        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.close();
    }
private void readSymptoms4() throws CLIPSException {

        if (!muscularPainNo.isSelected()) {
            patient.setMuscularPain(true);
            clips.assertString("(symptom (name muscular-pain) (activated FALSE) (present YES) (asked YES))");
        }
        if (!headacheNo.isSelected()) {
            patient.setHeadache(true);
            clips.assertString("(symptom (name headache) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!ictericiaNo.isSelected()) {
            patient.setIctericia(true);
            clips.assertString("(symptom (name ictericia) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!rapidPulsationsNo.isSelected()) {
            patient.setRapidPulsations(true);
            clips.assertString("(symptom (name rapid-pulsations) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!anemiaNo.isSelected()) {
            patient.setAnemia(true);
            clips.assertString("(symptom (name anemia) (activated FALSE) (present YES) (asked YES))");
        }
        if (!dermatitisNo.isSelected()) {
            patient.setDermatitis(true);
            clips.assertString("(symptom (name dermatitis-herpetiformis) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!stomatitiNo.isSelected()) {
            patient.setStomatiti(true);
            clips.assertString("(symptom (name aphthous-stomatiti) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!impotenceNo.isSelected()) {
            patient.setImpotence(true);
            clips.assertString("(symptom (name impotence) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!infertilityNo.isSelected()) {
            patient.setInfertility(true);
            clips.assertString("(symptom (name infertility) (activated FALSE) (present YES) (asked YES))");
        }
        
        if (!amenorrheaNo.isSelected()) {
            patient.setAmenorrhea(true);
            clips.assertString("(symptom (name amenorrhea) (activated FALSE) (present YES) (asked YES))");
        }
   
        clips.run();
        List<FactAddressValue> symptoms = clips.findAllFacts("symptom");

        System.out.println("Symptoms: \n");
        for (FactAddressValue f : symptoms) {
            System.out.println(f.getSlotValue("name")+" "+f.getSlotValue("activated"));
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
