/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portalv3;

import java.util.ArrayList;

/**
 *
 * @author AbuZar
 */
public class Teacher extends Person{
    
    
    static ArrayList<Student> assignedStudents=new ArrayList<>();
    
    
    String Desegnation;
    String Experience;
    String Departement;
    int id;

    public Teacher(String Desegnation, String Experience, String Departement, int id,String name, int age) {
        super(name, age);
        this.Desegnation = Desegnation;
        this.Experience = Experience;
        this.Departement = Departement;
        this.id=id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesegnation() {
        return Desegnation;
    }

    public void setDesegnation(String Desegnation) {
        this.Desegnation = Desegnation;
    }

    public String getExperience() {
        return Experience;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public String getDepartement() {
        return Departement;
    }

    public void setDepartement(String Departement) {
        this.Departement = Departement;
    }

    
    
    
    
}
