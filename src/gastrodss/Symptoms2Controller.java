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
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;

public class Symptoms2Controller implements Initializable {

    private Patient patient;
    private Environment clips;
    
    @FXML
    private Label nameLabel;
    
    @FXML
    private RadioButton abdpainNo;
    @FXML
    private RadioButton upAbdpainNo;
    @FXML
    private RadioButton uprightvaguepainNo;
    @FXML
    private RadioButton colicsNo;
    @FXML
    private RadioButton anorexiaNo;
    @FXML
    private RadioButton weightlossNo;
    @FXML
    private RadioButton fatigueNo;
    @FXML
    private RadioButton feverNo;
    
    @FXML
    private void openSymptoms3(ActionEvent event) throws IOException, CLIPSException {
        readSymptoms2();

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Symptoms3.fxml"));
        Parent symptoms3Parent = loader.load();

        Symptoms3Controller controller = loader.getController();
        controller.initData(patient, clips);
        Scene Symptoms3Scene = new Scene(symptoms3Parent);
        
        Stage window = new Stage();
        window.setTitle("Gastroenterology DSS");
        window.getIcons().add(new Image("/resources/icon.png"));
        window.setScene(Symptoms3Scene);
        window.centerOnScreen();

        window.show();
        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.close();
    }

    private void readSymptoms2() throws CLIPSException {

        if (!abdpainNo.isSelected()) {
            patient.setAbdpain(true);
            clips.assertString("(symptom (name abdominal-pain) (activated FALSE) (present YES) (asked YES))");
        }
        if (!upAbdpainNo.isSelected()) {
            patient.setUpAbdpain(true);
            clips.assertString("(symptom (name upper-abdominal-pain) (activated FALSE) (present YES) (asked YES))");
        }
        if (!uprightvaguepainNo.isSelected()) {
            patient.setUprightvaguepain(true);
            clips.assertString("(symptom (name upper-right-vague-pain) (activated FALSE) (present YES) (asked YES))");
        }
        if (!colicsNo.isSelected()) {
            patient.setColics(true);
            clips.assertString("(symptom (name colics) (activated FALSE) (present YES) (asked YES))");
        }
        if (!anorexiaNo.isSelected()) {
            patient.setAnorexia(true);
            clips.assertString("(symptom (name anorexia) (activated FALSE) (present YES) (asked YES))");
        }
        if (!weightlossNo.isSelected()) {
            patient.setWeightloss(true);
            clips.assertString("(symptom (name weight-loss) (activated FALSE) (present YES) (asked YES))");
        }
        if (!fatigueNo.isSelected()) {
            patient.setFatigue(true);
            clips.assertString("(symptom (name fatigue) (activated FALSE) (present YES) (asked YES))");
        }
        if (!feverNo.isSelected()) {
            patient.setFever(true);
            clips.assertString("(symptom (name fever) (activated FALSE) (present YES) (asked YES))");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }

    public void initData(Patient patient, Environment clips) {
        this.patient = patient;
        nameLabel.setText("Patient: " + patient.getName());
        this.clips = clips;
    }
}
