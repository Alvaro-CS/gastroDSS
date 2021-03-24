/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;

public class WelcomeController implements Initializable {

    @FXML
    private TextField patientname;

    @FXML
    void openSymptoms1(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Environment clips;
        clips = new Environment();
        try {
            clips.load("resources/project2.clp");
            clips.reset();
            clips.run();
        } catch (CLIPSException e) {
            e.printStackTrace();
        }
    }

}
