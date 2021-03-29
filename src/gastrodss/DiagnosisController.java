/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import POJOS.Disease;
import POJOS.Patient;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.TreeMap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;

/**
 *
 * @author ALVARO
 */
public class DiagnosisController implements Initializable {

    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");

    private Stage window; //for filechooser

    private Patient patient;
    private Environment clips;
    private List<Disease> diseases;
    @FXML
    private Label label;

    private List<ProgressBar> pbars;
    private List<Label> labels;
    private List<Label> labelsp;

    @FXML
    private Label label0;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;

    @FXML
    private Label label9;

    @FXML
    private Label label10;

    @FXML
    private Label label11;

    @FXML
    private ProgressBar pbar0;

    @FXML
    private ProgressBar pbar1;

    @FXML
    private ProgressBar pbar3;

    @FXML
    private ProgressBar pbar2;

    @FXML
    private ProgressBar pbar4;

    @FXML
    private ProgressBar pbar5;

    @FXML
    private ProgressBar pbar6;

    @FXML
    private ProgressBar pbar7;

    @FXML
    private ProgressBar pbar8;

    @FXML
    private ProgressBar pbar9;

    @FXML
    private ProgressBar pbar10;

    @FXML
    private ProgressBar pbar11;

    @FXML
    private Label labelp11;

    @FXML
    private Label labelp10;

    @FXML
    private Label labelp9;

    @FXML
    private Label labelp8;

    @FXML
    private Label labelp7;

    @FXML
    private Label labelp6;

    @FXML
    private Label labelp5;

    @FXML
    private Label labelp4;

    @FXML
    private Label labelp3;

    @FXML
    private Label labelp2;

    @FXML
    private Label labelp1;

    @FXML
    private Label labelp0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labels = new ArrayList<>();
        List<Label> list = Arrays.asList(label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11);
        labels.addAll(list);

        pbars = new ArrayList<>();
        List<ProgressBar> list2 = Arrays.asList(pbar0, pbar1, pbar2, pbar3, pbar4, pbar5, pbar6, pbar7, pbar8, pbar9, pbar10, pbar11);
        pbars.addAll(list2);

        labelsp = new ArrayList<>();
        List<Label> list3 = Arrays.asList(labelp0, labelp1, labelp2, labelp3, labelp4, labelp5, labelp6, labelp7, labelp8, labelp9, labelp10, labelp11);
        labelsp.addAll(list3);
    }

    private void showDiagnosis() throws CLIPSException {

        List<FactAddressValue> diseasesClips = clips.findAllFacts("disease");
        diseases = new ArrayList<>();
        for (FactAddressValue f : diseasesClips) {
            String name = f.getSlotValue("name").toString();
            Float score = Float.valueOf(f.getSlotValue("score").toString()) / Float.valueOf(f.getSlotValue("total").toString());
            if (score < 0) {
                score = 0.f;
            }
            Disease disease = new Disease(name, score);
            diseases.add(disease);
        }
        Collections.sort(diseases, new Comparator<Disease>() {
            @Override
            public int compare(Disease d1, Disease d2) {
                return (int) (d1.getScore() * 100 - d2.getScore() * 100);
            }
        });
        DecimalFormat f = new DecimalFormat("#.00"); //for showing only 2 decimals
        float percentage;
        for (int i = 0; i < labels.size(); i++) {
            labels.get(i).setText(diseases.get(diseases.size() - 1 - i).getName());
            pbars.get(i).setProgress(diseases.get(diseases.size() - 1 - i).getScore());
            percentage = diseases.get(diseases.size() - 1 - i).getScore() * 100;
            if (percentage == 0.0) {
                labelsp.get(i).setText("    <0.01 %"); //we cannot say a disease has 0%
            } else {
                labelsp.get(i).setText("    " + f.format(percentage) + " %");
            }

        }
    }

    @FXML
    private void saveRecords(ActionEvent event) throws FileNotFoundException, IOException, CLIPSException {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter for text files
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("TXT files (*.txt)", "*.txt");
        fileChooser.getExtensionFilters().add(extFilter);
        fileChooser.setTitle("Save the patient's symptoms and diagnosis.");

        //Show save file dialog
        File file = fileChooser.showSaveDialog(window);

        if (file != null) {
            //save the records

            PrintWriter printW = null;
            try {
                printW = new PrintWriter(file);
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            printW.write("Date of data acquisition: " + formatter.format(new Date()) + "\n");
            printW.write("\nName: " + patient.getName() + "\n");
            printW.write("Gender: " + patient.getGender() + "\n");
            printW.write("Date of birth: " + patient.getBirth().toString() + "\n");
            printW.write("\nRecorded symptoms: \n");
            List<FactAddressValue> symptoms = clips.findAllFacts("symptom");
            for (FactAddressValue f : symptoms) {
                printW.write(" "+f.getSlotValue("name").toString());
            }
            
            printW.write("\n\nDiagnosis: \n");
            for (int i = 0; i < labels.size(); i++) {
                printW.write("\t"+labels.get(i).getText() + ": " + labelsp.get(i).getText() + "\n");
            }
            printW.close();
        }
    }
    
    @FXML
    private void newPatient(ActionEvent event) throws IOException, CLIPSException {
        clips.clear();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("Welcome.fxml"));
        Parent welcome = loader.load();

        Scene welcomeScene = new Scene(welcome);

        Stage window = new Stage();
        window.setScene(welcomeScene);
        window.setTitle("Gastroenterology DSS");
        window.getIcons().add(new Image("/resources/icon.png"));
        window.centerOnScreen();
        window.show();
        Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        myStage.close();
    }

    public void initData(Patient patient, Environment clips, Stage window) throws CLIPSException {
        this.window = window;
        this.patient = patient;
        label.setText("Patient: " + patient.getName());
        this.clips = clips;
        showDiagnosis();
    }
}
