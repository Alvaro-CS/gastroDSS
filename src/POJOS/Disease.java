/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

public class Disease implements Comparable<Disease> {

    private String name;
    private Float score;
    private final boolean serious; //if the disease is serious and must not be ignored
    private final float threshold_score; //score above which an alert is shown if the disease is serious.
    private final boolean dont_miss; //if the disease is serious and must not be ignored

    public Disease(String name, Float score) {
        this.name = name;
        this.score = score;
        serious = name.equals("cholelithiasis") | name.equals("hepatic-cirrhosis") | name.equals("pancreatitis") | name.equals("stomach-cancer");
        switch (name) {
            case "cholelithiasis":
                threshold_score = 0.50f;
                break;
            case "hepatic-cirrhosis":
                threshold_score = 0.42f;
                break;
            case "pancreatitis":
                threshold_score = 0.34f;
                break;
            case "stomach-cancer":
                threshold_score = 0.25f;
                break;
            default:
                threshold_score = 0;
        }
        dont_miss = serious && (threshold_score <= score);
    }

    public boolean isDont_miss() {
        return dont_miss;
    }

    public float getThreshold_score() {
        return threshold_score;
    }

    public boolean isSerious() {
        return serious;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getScore() {
        return score;
    }

    public void setScore(Float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Disease{" + "name=" + name + ", score=" + score + '}';
    }

    @Override
    public int compareTo(Disease d) {
        return (this.score).compareTo(d.score);
    }

}
