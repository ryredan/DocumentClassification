/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author User
 */
public class WordEntry {
    String word;
    float occurences;

    public WordEntry(String word, float n) {
        this.word = word;
        this.occurences = n;
    }
    
    

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public float getOccurences() {
        return occurences;
    }

    public void setOccurences(float occurences) {
        this.occurences = occurences;
    }
    
    
}
