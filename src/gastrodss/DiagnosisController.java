/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gastrodss;

import POJOS.Disease;
import POJOS.Patient;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
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
import javafx.stage.Stage;
import net.sf.clipsrules.jni.CLIPSException;
import net.sf.clipsrules.jni.Environment;
import net.sf.clipsrules.jni.FactAddressValue;

/**
 *
 * @author ALVARO
 */
public class DiagnosisController implements Initializable {

    private Patient patient;
    private Environment clips;
    private List<Disease> diseases;
    @FXML
    private Label label;

    private List<ProgressBar> pbars;
    private List<Label> labels;
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labels = new ArrayList<>();
        List<Label> list = Arrays.asList(label0, label1, label2, label3, label4, label5, label6, label7, label8, label9, label10, label11);
        labels.addAll(list);

        pbars = new ArrayList<>();
        List<ProgressBar> list2 = Arrays.asList(pbar0, pbar1, pbar2, pbar3, pbar4, pbar5, pbar6, pbar7, pbar8, pbar9, pbar10, pbar11);
        pbars.addAll(list2);
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
        System.out.println("Antes");
        System.out.println(labels);
        for (int i = 0; i <labels.size(); i++) {
            System.out.println(i);
            labels.get(i).setText(diseases.get(diseases.size() - 1 - i).getName());
            pbars.get(i).setProgress(diseases.get(diseases.size() - 1 - i).getScore());
        }
        System.out.println(diseases);
    }

    public void initData(Patient patient, Environment clips) throws CLIPSException {

        this.patient = patient;
        label.setText("The diagnosis for " + patient.getName() + " is the following:");
        this.clips = clips;
        showDiagnosis();
    }
}
