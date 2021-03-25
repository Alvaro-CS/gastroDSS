/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import POJOS.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.Environment;


/**
 *
 * @author ALVARO
 */
public class DiagnosisController implements Initializable {
    
    private Patient patient;
    private Environment clips;
    @FXML
    private Label label;

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
        public void initData(Patient patient, Environment clips) {
        this.patient = patient;
        label.setText("The diagnosis for " + patient.getName()+" is the following:");
        this.clips = clips;
    }
}
