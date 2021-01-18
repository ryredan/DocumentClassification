/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class TopologiaTModel {
    int trainCount;
    List<List> trainData = new ArrayList<>();
    String name;
    int sections;
    int linesPerSection;

    public TopologiaTModel(String name, int sections, int linesPerSection) {
        this.name = name;
        this.sections = sections;
        this.linesPerSection = linesPerSection;
        this.trainCount = 0;
        for(int i = 0; i < sections*linesPerSection; i++){
            trainData.add(new ArrayList<WordEntry>());
        }
    }
        
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSections() {
        return sections;
    }

    public void setSections(int sections) {
        this.sections = sections;
    }

    public int getLinesPerSection() {
        return linesPerSection;
    }

    public void setLinesPerSection(int linesPerSection) {
        this.linesPerSection = linesPerSection;
    }

    public int getTrainCount() {
        return trainCount;
    }

    public void setTrainCount(int trainCount) {
        this.trainCount = trainCount;
    }

    public List<List> getTrainData() {
        return trainData;
    }

    public void setTrainData(List<List> trainData) {
        this.trainData = trainData;
    }
    
    public String toString(){
        return name;
    }
}
