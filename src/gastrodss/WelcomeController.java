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
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
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
    private Label error2;

    @FXML
    private RadioButton female;

    @FXML
    private DatePicker date;

    private String gender;

    @FXML
    private void openSymptoms1(ActionEvent event) throws IOException {
        if (!patientName.getText().equals("")) {
            if (female.isSelected()) {
                gender = "Female";
            } else {
                gender = "Male";
            }
            if (date.getValue() != null) {

                p = new Patient(patientName.getText(), gender, date.getValue());
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("Symptoms1.fxml"));
                Parent symptoms1Parent = loader.load();

                Symptoms1Controller controller = loader.getController();
                controller.initData(p, clips);
                Scene Symptoms1Scene = new Scene(symptoms1Parent);

                Stage window = new Stage();
                window.setScene(Symptoms1Scene);
                window.setTitle("Gastroenterology DSS");
                window.getIcons().add(new Image("/resources/icon.png"));
                window.centerOnScreen();

                window.show();
                Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                myStage.close();
            } else {
                error2.setText("Please, insert a date");
            }
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
        } catch (CLIPSException e) {
            e.printStackTrace();
        }
    }

}
