/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package POJOS;

import java.util.Comparator;

/**
 *
 * @author ALVARO
 */
public class Disease implements Comparable<Disease>{
    private String name;
    private Float score;
    
/*public static final Comparator<Disease> DESCENDING_COMPARATOR = (Disease d, Disease d1) -> {
        return d.score - d1.score;
    }
    ;
*/
    public Disease(String name, Float score) {
        this.name = name;
        this.score = score;
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
