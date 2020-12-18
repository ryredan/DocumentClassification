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
    Topologia owner;
    int trainCount;
    List<List> trainData = new ArrayList<>();

    public TopologiaTModel(Topologia t) {
        this.owner = t;
        this.trainCount = 0;
        for(int i = 0; i < t.getSections()*t.linesPerSection; i++){
            trainData.add(new ArrayList<WordEntry>());
        }
    }

    public Topologia getOwner() {
        return owner;
    }

    public void setOwner(Topologia owner) {
        this.owner = owner;
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
    
}
