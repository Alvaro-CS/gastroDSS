/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;


import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Symptoms2Controller implements Initializable  {


    private String patientname;
    
    @FXML private RadioButton abdpainNo;    
    @FXML private RadioButton upAbdpainNo;
    @FXML private RadioButton uprightvaguepainNo;
    @FXML private RadioButton colicsNo;
    @FXML private RadioButton anorexiaNo;
    @FXML private RadioButton weightlossNo;
    @FXML private RadioButton fatigueNo;
    

    @FXML
    void openSymptoms3(ActionEvent event)throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Symptoms3.fxml"));
        Parent symptoms3Parent = loader.load();

        Symptoms3Controller controller = loader.getController();
//       controller.initData(patientMoved, com_data_client);

        Scene Symptoms3Scene = new Scene(symptoms3Parent);
        //this line gets the Stage information
        //Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Stage window = new Stage();
        window.setScene(Symptoms3Scene);
//        window.setTitle("WOLFFGRAM");
//        window.getIcons().add(new Image("/wolff_patient/images/logo.png"));
        window.centerOnScreen();

        window.show();

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

