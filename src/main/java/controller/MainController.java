package controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
import model.ClassificationResult;
import model.TopologiaTModel;
import model.WordEntry;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import util.EditDistanceRecursive;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class MainController {
    ArrayList<TopologiaTModel> models;
    PDFTextStripper ocr;
    
    

    public MainController() {
        this.ocr = new PDFTextStripper();
        this.models = new ArrayList<>();
    }
    
    public ArrayList<TopologiaTModel> getModels(){
        return this.models;
    }
    
    public void createModel(TopologiaTModel t){
        this.models.add(t);
    }
    
    
    public void trainModel(File[] fs, TopologiaTModel t, int similarityThreshold){
        System.out.println(t.getName());
        for(File f : fs){
            PDDocument d = PDDocument.load(f);
            BufferedReader r = new BufferedReader(new StringReader(ocr.getText(d)));
            Stream<String> str = r.lines();
            String[] lines = str.toArray(String[]::new);
            int lineLoop = 0;
            do{
                if(lineLoop < lines.length){
                    String[] words = lines[lineLoop].split("[^\\p{L}\\p{Nd}]+");
                    for(String word : words){
                        int i = 0;
                        boolean add = true;
                        do{
                            if(!t.getTrainData().get(lineLoop).isEmpty()){
                                WordEntry currentWordEntry = (WordEntry)t.getTrainData().get(lineLoop).get(i);
                                System.out.println("Comparing " + word + " with " + currentWordEntry.getWord());
                                if(EditDistanceRecursive.calculate(word, currentWordEntry.getWord()) < similarityThreshold){
                                    currentWordEntry.setOccurences(currentWordEntry.getOccurences()+1);
                                    add = false;
                                    break;
                                }
                            }
                            i++;
                        }while(i < t.getTrainData().get(lineLoop).size());
                        if(add){
                            t.getTrainData().get(lineLoop).add(new WordEntry(word, 1));
                        }
                    }
                }
                lineLoop++;
            }while(lineLoop < t.getSections()*t.getLinesPerSection());
            d.close();
            t.setTrainCount(t.getTrainCount() + 1);
        }
        
    }
    
    public float classifyDocument(File f, TopologiaTModel t){
        PDDocument d = PDDocument.load(f);
        ArrayList<Float> results = new ArrayList<>(t.getSections());
        List<List> trainData = t.getTrainData();
        float averageResult = 0;
        BufferedReader r = new BufferedReader(new StringReader(ocr.getText(d)));
        Stream<String> str = r.lines();
        String[] lines = str.toArray(String[]::new);
        
        for(int currentSection = 0; currentSection < t.getSections(); currentSection++){
            HashSet<String> section = new HashSet<>();
            HashSet<String> dict = new HashSet<>();
            for(int currentLine = 0; currentLine < t.getLinesPerSection(); currentLine++){
                section.addAll(Arrays.asList(lines[currentSection*t.getSections() + currentLine].split("[^\\p{L}\\p{Nd}]+")));
                for(Object w: trainData.get(currentSection*t.getSections() + currentLine)){
                    WordEntry we = (WordEntry)w;
                    if(we.getOccurences()/t.getTrainCount() > 0.5){
                        dict.add(we.getWord());
                    }
                }
            }
            int dictCount = dict.size();
            dict.retainAll(section);
            float result = dict.size()/(float) dictCount;
            results.add(result);
        }
        
        for(Float flt : results){
            averageResult += flt;
        }
        return averageResult / results.size();
    }
    
    public ClassificationResult testAgainstAllModels(File f){
        TopologiaTModel highestModel = null;
        ClassificationResult res = new ClassificationResult();
        float highestPercentage = 0;
        for(TopologiaTModel t : models){
            float currentPercentage = classifyDocument(f, t);
            if(currentPercentage > highestPercentage){
                highestPercentage = currentPercentage;
                highestModel = t;
            }
        }
        res.setModelName(highestModel.getName());
        res.setPercentage(highestPercentage);
        return res;
    }
    
}
