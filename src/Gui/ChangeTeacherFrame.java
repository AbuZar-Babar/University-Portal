/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import portalv3.Admin;
import portalv3.Student;
import portalv3.Teacher;

/**
 *
 * @author AbuZar
 */
public final class ChangeTeacherFrame extends JFrame implements ActionListener{

    int index;
    
    
    JButton btnEdit=new JButton();
    JButton btncancel=new JButton();
    JComboBox<String> cbage=new JComboBox<>();
    JComboBox<String> cbdep=new JComboBox<>();
    JComboBox<String> cbdes=new JComboBox<>();
    JComboBox<String> cbexp=new JComboBox<>();
    JLabel lblDep=new JLabel();
    JLabel lblDesig=new JLabel();
    JLabel lblexp=new JLabel();
    JLabel lblage=new JLabel();
    JLabel lblid=new JLabel();
    JLabel lblname=new JLabel();
    JLabel lbltop=new JLabel();
    JTextField txtid=new JTextField();
    JTextField txtname=new JTextField();
    
    JLabel iconinternalbackground=new JLabel(new ImageIcon(getClass().getResource("/icons/rounded small_1.png")));
    JLabel iconbackground=new JLabel(new ImageIcon(getClass().getResource("/icons/wallpaperflare700700crpo.jpg")));
    JPanel internalpanel=new JPanel(null);
    
    
    public ChangeTeacherFrame(int i)  {
        
        this.index=i;
        Frame();
        label();
        Button();
        Combobox();
        TextFields();
        icon();
        this.retriveData();
        this.setVisible(true);
        
    }
    
    
    
    public void Frame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(700, 700);  
        this.setResizable(false);
        setLocationRelativeTo(null);
        this.getContentPane().setBackground(new Color(117, 176, 189));
        this.setLayout(null);
        
        getContentPane().add(internalpanel);
        internalpanel.setBounds(100, 100, 500, 530);
        internalpanel.setOpaque(false);
    }
    
    
    public void icon()
    {
        getContentPane().add(iconbackground);
        iconbackground.setBounds(0, 0, 700, 699);
        
        internalpanel.add(iconinternalbackground);
        iconinternalbackground.setBounds(0, 0, 500, 530);
    }
    
    public void label()
    {
        lbltop.setFont(new Font("Arial Rounded MT Bold", 1, 40)); 
        lbltop.setText("CHANGE TEACHER INFO");
        lbltop.setForeground(new Color(255, 255, 255));
        getContentPane().add(lbltop);
        lbltop.setBounds(100, 30, 550, 60);
        
        lblage.setFont(new Font("Segoe UI", 1, 18)); 
        lblage.setText("Age");
        internalpanel.add(lblage);
        lblage.setBounds(50, 240, 50, 25);

        lblname.setFont(new Font("Segoe UI", 1, 18)); 
        lblname.setText("NAME :");
        internalpanel.add(lblname);
        lblname.setBounds(50, 80, 170, 25);

        
        lblDep.setFont(new Font("Segoe UI", 1, 18)); 
        lblDep.setText("Departement");
        internalpanel.add(lblDep);
        lblDep.setBounds(240, 240, 120, 30);
        
        lblDesig.setFont(new Font("Segoe UI", 1, 18)); 
        lblDesig.setText("Designation");
        internalpanel.add(lblDesig);
        lblDesig.setBounds(234, 330, 120, 40);
        
        lblexp.setFont(new Font("Segoe UI", 1, 18)); 
        lblexp.setText("Exp");
        internalpanel.add(lblexp);
        lblexp.setBounds(50, 340, 50, 25);
        
        lblid.setFont(new Font("Segoe UI", 1, 18)); 
        lblid.setText("Id");
        internalpanel.add(lblid);
        lblid.setBounds(50, 160, 90, 25);
        
    }
    public void Button()
    {
        btnEdit.setText("Add"); 
        btnEdit.addActionListener(this);
        internalpanel.add(btnEdit);
        btnEdit.setBounds(340, 440, 100, 30);
        
        
        
        btncancel.setText("cancel");
        internalpanel.add(btncancel);
        btncancel.setBounds(50, 440, 100, 30);
        btncancel.addActionListener(this);
    }
    
    public void Combobox()
    {
        String[] age = new String[101];
        for(int i=0;i<=100;i++)
        {
            age[i]=String.valueOf(i);
        }
        
        cbage.setModel(new DefaultComboBoxModel<>(age));
        internalpanel.add(cbage);
        cbage.setBounds(130, 240, 72, 30);
        
        
        String[] dep={ "CS", "SE", "BBA", "CE", "EE" };
        
        
        cbdep.setModel(new DefaultComboBoxModel<>(dep));
        internalpanel.add(cbdep);
        cbdep.setBounds(370, 240, 72, 30);
        
        String[] diseg={ "Assistant Professor", "Associate Professor",
            "Professor", "Lecturer",
            "HOD", "Lab Engineer"};
        
        cbdes.setModel(new DefaultComboBoxModel<>(diseg));
        internalpanel.add(cbdes);
        cbdes.setBounds(340, 340, 130, 30);
        
        
        
        String[] exp={ "1", "2", "3", "4", "5", "6", "7", "8", "9", "10+" };
        cbexp.setModel(new DefaultComboBoxModel<>(exp));
        internalpanel.add(cbexp);
        cbexp.setBounds(130, 340, 72, 30);
    }
    
    
    public void TextFields()
    {
        internalpanel.add(txtname);
        txtname.setBounds(50, 110, 390, 22);
        
        internalpanel.add(txtid);
        txtid.setBounds(50, 190, 150, 22);
    }
    

    
    public void Write()
    {
        
        BufferedWriter buffer;
        try {
            buffer = new BufferedWriter(new FileWriter("teacher.txt"));
            for(Teacher T:Admin.arrTeachers)
            {
                buffer.write("\n==========================================");
                buffer.write("\nName    :"+T.getName());
                buffer.write("\nID      :"+T.getId());
                buffer.write("\nDep     :"+T.getDepartement());
                buffer.write("\nAge     :"+T.getAge());
                buffer.write("\nDes     :"+T.getDesegnation());
                buffer.write("\nExp     :"+T.getExperience());

            }

            buffer.close();

        } catch (IOException ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        try {
            buffer = new BufferedWriter(new FileWriter("StudentInfo.txt"));
            for(Student std:Admin.arrstudent)
            {
                buffer.write("\n==========================================");
                buffer.write("\nName    :"+std.getName());
                buffer.write("\nPass    :"+std.getPass());
                buffer.write("\nRoll    :"+std.getRollNo());
                buffer.write("\nAge     :"+std.getAge());
                buffer.write("\nDep     :"+std.getDepartement());
                buffer.write("\nGPA     :"+std.getGpa());
                
            }

            buffer.close();

        } catch (IOException ex) {
            Logger.getLogger(AdminFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    
    public void retriveData()
    {
        
        txtname.setText(Admin.arrTeachers.get(index).getName());
        txtid.setText( String.valueOf(Admin.arrTeachers.get(index).getId())); 
        cbdes.setSelectedItem(Admin.arrTeachers.get(index).getDesegnation());
         
         
        cbdep.setSelectedItem(Admin.arrTeachers.get(index).getDepartement());
        cbage.setSelectedItem(String.valueOf(Admin.arrTeachers.get(index).getAge()));
        cbexp.setSelectedItem(Admin.arrTeachers.get(index).getExperience());
        
        
        
        
        
       
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnEdit)
        {
               String name =txtname.getText();
               int age =cbage.getSelectedIndex();
               String dep= cbdep.getItemAt(cbdep.getSelectedIndex());
               String des=cbdes.getItemAt(cbdes.getSelectedIndex());
               String exp=cbexp.getItemAt(cbexp.getSelectedIndex());
               int id =Integer.parseInt(txtid.getText());
               int oldid=Admin.arrTeachers.get(index).getId();

               JOptionPane.showMessageDialog(rootPane, "Teacher Info Changed");

               Admin admin=new Admin();
               admin.changeTeacherInfo(des, exp, dep, id, name, age, oldid);



               this.Write();
        }
        else if(e.getSource()==btncancel)
        {
            this.dispose();
            new AdminFrame(0);
        
        }
        


    }
}
