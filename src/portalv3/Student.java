/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portalv3;

/**
 *
 * @author AbuZar
 */
public class Student extends Person{
    
    private double gpa;
    private int rollNo;
    private String departement;
    private String pass;

    public Student(double gpa, int rollNo, String departement, String pass,String name, int age) {
        super(name, age);
        this.gpa = gpa;
        this.rollNo = rollNo;
        this.departement = departement;
        this.pass=pass;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public int getRollNo() {
        return rollNo;
    }

    public void setRollNo(int rollNo) {
        this.rollNo = rollNo;
    }

    public String getDepartement() {
        return departement;
    }

    public void setDepartement(String departement) {
        this.departement = departement;
    }

    @Override
    public String toString() {
        return super.toString()+"Student{" + "gpa=" + gpa + ", rollNo=" + rollNo + ", departement=" + departement + '}';
    }
    
    public void disp()
    {
        System.out.println(this.toString());
    }
    
    
    
    
    
    
    
}
