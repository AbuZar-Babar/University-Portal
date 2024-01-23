/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package portalv3;

import Gui.MainFrame;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author AbuZar
 */
public class PortalV3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        
        
        
        System.out.println("run");
        
        
        try {
            
            BufferedReader reader=new BufferedReader(new FileReader("StudentInfo.txt"));
       
            
            String line;
        int i=0;
        
        
        
        String name=null; 
        String pass = null;
        int roll = 0;
        int age = 0;
        String dep = null;
        double gpa = 0;
         
        while((line=reader.readLine())!=null)
        {   
            //System.out.println(line);
            
            //System.out.println(line.charAt(8));
            if(line.contains("Name"))
            {
                name=line.substring(9,line.length());
                i++;
            }
            else if(line.contains("Pass"))
            {
                pass=line.substring(9,line.length());
                i++;
            }
            else if(line.contains("Roll"))
            {
                roll=Integer.parseInt(line.substring(9, line.length()));
                i++;
            }
            else if(line.contains("Dep"))
            {
              dep=line.substring(9,line.length());
              i++;
            }
            else if(line.contains("GPA"))
            {
                gpa=Double.parseDouble(line.substring(9,line.length()));
                i++;
            }
            else if(line.contains("Age"))
            {
                age=Integer.parseInt(line.substring(9,line.length()));
                i++;
            }
            
            if(i==6)
            {

        Student s=new Student(gpa, roll, dep, pass, name, age);
        Admin.arrstudent.add(s);
        i=0;
            }
        }
   reader.close(); 
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(PortalV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            
            BufferedReader reader=new BufferedReader(new FileReader("teacher.txt"));
        String line;
        int i=0;
        
        
        
        
        String name=null; 
        String des = null;
        String dep = null;
        String exp = null;
        int age = 0;
        int id = 0;
         
        while((line=reader.readLine())!=null)
        {   
        
            if(line.contains("Name"))
            {
                name=line.substring(9,line.length());
                i++;
            }
            else if(line.contains("ID"))
            {
                id=Integer.parseInt(line.substring(9,line.length()));
                i++;
            }
            else if(line.contains("Des"))
            {
                des=line.substring(9, line.length());
                i++;
            }
            else if(line.contains("Dep"))
            {
              dep=line.substring(9,line.length());
              i++;
            }
            else if(line.contains("Exp"))
            {
                exp=line.substring(9,line.length());
                i++;
            }
            else if(line.contains("Age"))
            {
                age=Integer.parseInt(line.substring(9,line.length()));
                i++;
            }
            
            if(i==6)
            {

        Teacher t=new Teacher(des, exp, dep, id, name, age);
        Admin.arrTeachers.add(t);
        i=0;
            }
        }
   reader.close(); 
        } 
        catch (FileNotFoundException ex) {
            Logger.getLogger(PortalV3.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        new MainFrame();
        
    }
    
}
