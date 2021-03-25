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
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;

public class WelcomeController implements Initializable {

    private Patient p;
    private Environment clips;

    @FXML
    private TextField patientName;

    @FXML
    private Label error;

    @FXML
    private void openSymptoms1(ActionEvent event) throws IOException {
        if (!patientName.getText().equals("")) {
            p = new Patient(patientName.getText());
            System.out.println("Patient " + p.getName());
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("Symptoms1.fxml"));
            Parent symptoms1Parent = loader.load();

            Symptoms1Controller controller = loader.getController();
            controller.initData(p, clips);
            Scene Symptoms1Scene = new Scene(symptoms1Parent);
            //this line gets the Stage information
            //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Stage window = new Stage();
            window.setScene(Symptoms1Scene);
//        window.setTitle("WOLFFGRAM");
//        window.getIcons().add(new Image("/wolff_patient/images/logo.png"));
            window.centerOnScreen();

            window.show();
            Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            myStage.close();
        } else {
            error.setText("Please, insert a name");
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clips = new Environment();
        try {
            clips.load("project2.clp");
            clips.reset();
            
                    List<FactAddressValue> diseases0 = clips.findAllFacts("disease");
        System.out.println("Diseases0: \n" + diseases0);
        } catch (CLIPSException e) {
            e.printStackTrace();
        }
    }

}
