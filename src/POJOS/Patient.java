/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

/**
 *
 * @author ALVARO
 */
public class Patient {

    private String name;

    private boolean nausea;
    private boolean vomit;
    private boolean regurgitation;
    private boolean heartburn;
    private boolean reflux;
    private boolean dysphagia;
    private boolean cough;
    private boolean thoracic_pain;
    private boolean abdpain;
    private boolean upAbdpain;
    private boolean uprightvaguepain;
    private boolean colics;
    private boolean anorexia;
    private boolean weightloss;
    private boolean fatigue;
    private boolean constipation;
    private boolean diarrhea;
    private boolean gas;
    private boolean tenesmus;
    private boolean melena;


    public Patient(String name) {
        this.name = name;
        this.nausea = false;
        this.vomit = false;
        this.regurgitation = false;
        this.heartburn = false;
        this.reflux = false;
        this.dysphagia = false;
        this.cough = false;
        this.thoracic_pain = false;
        this.abdpain = false;
        this.upAbdpain = false;
        this.uprightvaguepain = false;
        this.colics = false;
        this.anorexia = false;
        this.weightloss = false;
        this.fatigue = false;
        this.constipation = false;
        this.diarrhea = false;
        this.gas = false;
        this.tenesmus = false;
        this.melena = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isNausea() {
        return nausea;
    }

    public void setNausea(boolean nausea) {
        this.nausea = nausea;
    }

    public boolean isVomit() {
        return vomit;
    }

    public void setVomit(boolean vomit) {
        this.vomit = vomit;
    }

    public boolean isRegurgitation() {
        return regurgitation;
    }

    public void setRegurgitation(boolean regurgitation) {
        this.regurgitation = regurgitation;
    }

    public boolean isHeartburn() {
        return heartburn;
    }

    public void setHeartburn(boolean heartburn) {
        this.heartburn = heartburn;
    }

    public boolean isReflux() {
        return reflux;
    }

    public void setReflux(boolean reflux) {
        this.reflux = reflux;
    }

    public boolean isDysphagia() {
        return dysphagia;
    }

    public void setDysphagia(boolean dysphagia) {
        this.dysphagia = dysphagia;
    }

    public boolean isCough() {
        return cough;
    }

    public void setCough(boolean cough) {
        this.cough = cough;
    }

    public boolean isThoracic_pain() {
        return thoracic_pain;
    }

    public void setThoracic_pain(boolean thoracic_pain) {
        this.thoracic_pain = thoracic_pain;
    }

    public boolean isAbdpain() {
        return abdpain;
    }

    public void setAbdpain(boolean abdpain) {
        this.abdpain = abdpain;
    }

    public boolean isUpAbdpain() {
        return upAbdpain;
    }

    public void setUpAbdpain(boolean upAbdpain) {
        this.upAbdpain = upAbdpain;
    }

    public boolean isUprightvaguepain() {
        return uprightvaguepain;
    }

    public void setUprightvaguepain(boolean uprightvaguepain) {
        this.uprightvaguepain = uprightvaguepain;
    }

    public boolean isColics() {
        return colics;
    }

    public void setColics(boolean colics) {
        this.colics = colics;
    }

    public boolean isAnorexia() {
        return anorexia;
    }

    public void setAnorexia(boolean anorexia) {
        this.anorexia = anorexia;
    }

    public boolean isWeightloss() {
        return weightloss;
    }

    public void setWeightloss(boolean weightloss) {
        this.weightloss = weightloss;
    }

    public boolean isFatigue() {
        return fatigue;
    }

    public void setFatigue(boolean fatigue) {
        this.fatigue = fatigue;
    }

    public boolean isConstipation() {
        return constipation;
    }

    public void setConstipation(boolean constipation) {
        this.constipation = constipation;
    }

    public boolean isDiarrhea() {
        return diarrhea;
    }

    public void setDiarrhea(boolean diarrhea) {
        this.diarrhea = diarrhea;
    }

    public boolean isGas() {
        return gas;
    }

    public void setGas(boolean gas) {
        this.gas = gas;
    }

    public boolean isTenesmus() {
        return tenesmus;
    }

    public void setTenesmus(boolean tenesmus) {
        this.tenesmus = tenesmus;
    }

    public boolean isMelena() {
        return melena;
    }

    public void setMelena(boolean melena) {
        this.melena = melena;
    }
    
}
