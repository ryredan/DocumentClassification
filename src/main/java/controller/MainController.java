package controller;


import java.io.BufferedReader;
import java.io.File;
import java.io.StringReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Stream;
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
    PDFTextStripper ocr;
    

    public MainController() {
        this.ocr = new PDFTextStripper();
    }
    
    
    public void trainModel(File[] fs, TopologiaTModel t, int similarityThreshold){
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
            }while(lineLoop < t.getOwner().getSections()*t.getOwner().getLinesPerSection());
            d.close();
            t.setTrainCount(t.getTrainCount() + 1);
        }
        
    }
    
    public float classifyDocument(File f, TopologiaTModel t){
        PDDocument d = PDDocument.load(f);
        String[] lines = ocr.getText(d).split("[^\\p{L}\\p{Nd}]+");
        //BufferedReader r = new BufferedReader(new StringReader(ocr.getText(d)));
        //Stream<String> str = r.lines();
        //String[] lines = str.toArray(String[]::new);
        
        HashSet<String> dict = new HashSet<>();
        HashSet<String> extractedWords = new HashSet<>(Arrays.asList(lines));
        
        for(List arr : t.getTrainData()){
            for(Object w: arr){
                WordEntry we = (WordEntry)w;
                if(we.getOccurences()/t.getTrainCount() > 0.5){
                    dict.add(we.getWord());
                }
            }
        }
        int dictCount = dict.size();
        dict.retainAll(extractedWords);
        float result = dict.size()/(float) dictCount;
        return result;
    }
}
