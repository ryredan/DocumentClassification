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
public class Topologia {
    String name;
    int sections;
    int linesPerSection;

    public Topologia(String name) {
        this.name = name;
        this.sections = sections;
        this.linesPerSection = linesPerSection;
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
    
    
}
