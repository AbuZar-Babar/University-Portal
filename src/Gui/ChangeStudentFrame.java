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
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JToggleButton;
import portalv3.Admin;
import portalv3.Student;
import portalv3.Teacher;

/**
 *
 * @author AbuZar
 */
public final class ChangeStudentFrame extends JFrame implements ActionListener{

   int index; 
    
   JButton btnCancel=new JButton();
   JButton btnEdit=new JButton();

   JComboBox<String> cbage=new JComboBox<>();
   JComboBox<String> cbdep=new JComboBox<>();
   
   JLabel lbldep=new JLabel();
   JLabel lblgpa = new JLabel();
   JLabel lblRoll = new JLabel();
   JLabel lblage  = new JLabel();
   JLabel lblname = new JLabel();
   JLabel lblpass = new JLabel();
   JLabel lbltop=new JLabel();
   
    JCheckBox ckshowpassword=new JCheckBox();
   JToggleButton togbutton=new JToggleButton();
   
   JTextField txtgpa=new JTextField();
   JTextField txtname=new JTextField();
   JPasswordField txtpass=new JPasswordField();
   JTextField txtroll=new JTextField();
   
    JLabel iconinternalbackground=new JLabel(new ImageIcon(getClass().getResource("/icons/rounded small_1.png")));
    JLabel iconbackground=new JLabel(new ImageIcon(getClass().getResource("/icons/wallpaperflare700700crpo.jpg")));
    JPanel internalpanel=new JPanel(null);
    
    
    
    
    public ChangeStudentFrame(int index)  {
        
        this.index=index;
       
        frame();
        Buttons();
        TextFields();
        Label();
        Combobox();
        checkbox();
        icon();
        this.setVisible(true);
        
        
        this.retriveData();
    }
    
    
    public void frame()
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
    public void Label()
    {
        lbltop.setFont(new Font("Arial Rounded MT Bold", 1, 40)); 
        lbltop.setForeground(new Color(255, 255, 255));
        lbltop.setText("CHANGE STUDENT INFO");
        getContentPane().add(lbltop);
        lbltop.setBounds(70, 30, 550, 43);
        
        lblname.setFont(new Font("Segoe UI", 1, 18)); 
        lblname.setText("NAME");
        internalpanel.add(lblname);
        lblname.setBounds(50, 80, 170, 25);
        
        
        lblpass.setFont(new Font("Segoe UI", 1, 18)); 
        lblpass.setText("PASSWORD");
        internalpanel.add(lblpass);
        lblpass.setBounds(50, 160, 150, 25);
        
        
        lblage.setFont(new Font("Segoe UI", 1, 18)); 
        lblage.setText("Age");
        internalpanel.add(lblage);
        lblage.setBounds(50, 340, 50, 25);
        
        
        lbldep.setFont(new Font("Segoe UI", 1, 18)); 
        lbldep.setText("Departement");
        internalpanel.add(lbldep);
        lbldep.setBounds(230, 340, 120, 25);
        
        
        lblRoll.setFont(new Font("Segoe UI", 1, 18)); 
        lblRoll.setText("Roll Number");     
        internalpanel.add(lblRoll);
        lblRoll.setBounds(50, 250, 140, 25);

        lblgpa.setFont(new Font("Segoe UI", 1, 18)); 
        lblgpa.setText("Gpa");
        internalpanel.add(lblgpa);
        lblgpa.setBounds(250, 270, 50, 40);
    }
    public void Buttons()
    {
        btnEdit.setFont(new Font("Segoe UI", 1, 18)); 
        btnEdit.setText("EDIT");      
        internalpanel.add(btnEdit);
        btnEdit.setBounds(330, 440, 100, 30);
        btnEdit.addActionListener(this);
        
        
        
        btnCancel.setFont(new Font("Segoe UI", 1, 18)); 
        btnCancel.setText("Cancel"); 
        internalpanel.add(btnCancel);
        btnCancel.setBounds(60, 440, 100, 30);
        btnCancel.addActionListener(this);
       
        
    }
    
    public void TextFields()
    {
        internalpanel.add(txtname);
        txtname.setBounds(50, 110, 390, 22);
        
        internalpanel.add(txtpass);
        txtpass.setBounds(50, 190, 390, 22);

        internalpanel.add(txtgpa);
        txtgpa.setBounds(360, 280, 71, 22);
        
        
        internalpanel.add(txtroll);
        txtroll.setBounds(50, 280, 150, 22);
         
        
    }
    
    public void checkbox()
    {
        internalpanel.add(ckshowpassword);
        ckshowpassword.setFont(new Font("Segoe UI", 1, 12));
        ckshowpassword.setText("Show Password");
        ckshowpassword.setBounds(320, 220, 120, 20);
        ckshowpassword.addActionListener(this);
    }
    public void Combobox()
    {
        //loop for combobox age 1-100
        String[] age = new String[101];
        for(int i=0;i<=100;i++)
        {
            age[i]=String.valueOf(i);
        }
        
        cbage.setModel(new DefaultComboBoxModel<>(age));
        internalpanel.add(cbage);
        cbage.setBounds(130, 340, 72, 30);
        
        
        String[] dep={ "CS", "SE", "BBA", "CE", "EE",};
        cbdep.setModel(new DefaultComboBoxModel<>(dep));
        internalpanel.add(cbdep);
        cbdep.setBounds(360, 340, 72, 30);
        
        
        
        
    }
    
    
    
    
    
    
    public void retriveData()
    {
        
        txtname.setText(Admin.arrstudent.get(index).getName());
        txtpass.setText(Admin.arrstudent.get(index).getPass()); 
        txtroll.setText(String.valueOf(Admin.arrstudent.get(index).getRollNo()));
        cbdep.setSelectedItem(Admin.arrstudent.get(index).getDepartement());
        cbage.setSelectedItem(String.valueOf(Admin.arrstudent.get(index).getAge()));
        txtgpa.setText(String.valueOf(Admin.arrstudent.get(index).getGpa()));
        
       
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
    

    
    
    

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnEdit)
        {
            
                String name =txtname.getText();
                String pass =txtpass.getText();
                int age =cbage.getSelectedIndex();
                int roll= Integer.parseInt(txtroll.getText());
                String dep= cbdep.getItemAt(cbdep.getSelectedIndex());
                int oldroll=Admin.arrstudent.get(index).getRollNo();
                double gpa=Double.parseDouble(txtgpa.getText());

                if(roll<=0||gpa<0||gpa>4)
                {
                    JOptionPane.showMessageDialog(rootPane, "Invalid Roll or Gpa","Error",0);
                    return;
                    
                }

                JOptionPane.showMessageDialog(rootPane, "Student Info Changed!!!");

                Admin admin=new Admin();
                admin.changeStudentInfo(name, age,  dep,pass, gpa, roll,oldroll);


                this.Write();
                
                
        }
        else if(e.getSource()==btnCancel)
        {
                this.dispose();

                new AdminFrame(1);
        
        }
        else if(e.getSource()==ckshowpassword)
        {
             if(ckshowpassword.isSelected())
             {
                 txtpass.setEchoChar((char)0);
             }
             else 
             {
                 txtpass.setEchoChar('*');
             } 
        }

    }
    
    
    
}
