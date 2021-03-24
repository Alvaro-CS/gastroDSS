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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;

public class Symptoms4Controller implements Initializable {

    @FXML private RadioButton muscularPainNo;
    @FXML private RadioButton headacheNo;
    @FXML private RadioButton ictericiaNo;
    @FXML private RadioButton rapidPulsationsNo;
    @FXML private RadioButton anemiaNo;
    @FXML private RadioButton dermatitisNo;
    @FXML private RadioButton stomatitiNo;
    @FXML private RadioButton impotenceNo;
    @FXML private RadioButton infertilityNo;
    @FXML private RadioButton amenorrheaNo;
    
    @FXML
    void openSymptoms1(ActionEvent event) {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

