/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import java.io.IOException;
import javafx.event.ActionEvent;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;

public class WelcomeController implements Initializable {

//    @FXML
//    private TextField patientname;
    @FXML
    private void openSymptoms(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Symptoms1.fxml"));
        Parent symptoms1Parent = loader.load();

        //Symptoms1Controller controller = loader.getController();
//       controller.initData(patientMoved, com_data_client);
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
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
//        Environment clips;
//        clips = new Environment();
//        try {
//            clips.load("resources/project2.clp");
//            clips.reset();
//            clips.run();
//        } catch (CLIPSException e) {
//            e.printStackTrace();
//        }
    }

}
