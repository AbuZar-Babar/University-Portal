/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package portalv3;

import java.util.*;

/**
 *
 * @author AbuZar
 */
public class Admin {
    
    private String name="";
    private String Pass="";
    public static ArrayList<Student> arrstudent=new ArrayList<>();
    public static ArrayList<Teacher> arrTeachers=new ArrayList<>();
    
    

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPass() {
        return Pass;
    }

    public void setPass(String Pass) {
        this.Pass = Pass;
    }

    
    
    public void AddStudent(String nam,int age,String dep,String pass,double gpa,int roll)
    {
       Student s=new Student(gpa,roll,dep,pass,nam,age) ;
       arrstudent.add(s);
       
       
    }
    
    
    
    
    public void changeStudentInfo(String nam,int age,String dep,String pass,double gpa,int roll,int oldroll)
    {
        Student std=new Student(gpa,roll,dep,pass,nam,age) ;
        
        arrstudent.set(this.getindex(oldroll),std );
    }
    
    
    
    public void changeTeacherInfo(String des,String exp,String dep,int id,String name,int age,int oldid)
    {
        Teacher t=new Teacher(des, exp, dep, id, name, age);
        
       arrTeachers.set(this.getTeacherindex(oldid), t);
    }
    
    
    public int getindex(int roll)
    {
        for(int i=0;i<arrstudent.size();i++)
        {
            if(arrstudent.get(i).getRollNo()==roll)
            {
                
                return  i;
            }
            
        }
        return -1;
    }
    
    
     public int getTeacherindex(int id)
    {
        for(int i=0;i<arrTeachers.size();i++)
        {
            if(arrTeachers.get(i).getId()==id)
            {
                return  i;
            }
            
        }
        return -1;
    }
    
    
    
    }
