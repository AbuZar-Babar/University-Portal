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

/**
 *
 * @author AbuZar
 */
public final class AddStudentFrame extends JFrame implements ActionListener{
    
    JButton btnAdd=new JButton();
    JButton btnBack=new JButton();
    JComboBox<String> cbage=new JComboBox<>();
    JComboBox<String> cbdep=new JComboBox<>();
    JLabel lbldep=new JLabel();
    JLabel lblRoll=new JLabel();
    JLabel lblage=new JLabel();
    JLabel lblname=new JLabel();
    JLabel lblpass=new JLabel();
    JLabel lbltop=new JLabel();
    JTextField txtname=new JTextField();
    JTextField txtpass=new JTextField();
    JTextField txtroll=new JTextField();

    JLabel iconinternalbackground=new JLabel(new ImageIcon(getClass().getResource("/icons/rounded small_1.png")));
    JLabel iconbackground=new JLabel(new ImageIcon(getClass().getResource("/icons/wallpaperflare700700crpo.jpg")));
    JPanel internalpanel=new JPanel(null);

    public AddStudentFrame() {
          
        frame();
        Label();
        TextFields();
        Combobox();
        Buttons();
        icon();

        this.setVisible(true);
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
        lbltop.setFont(new Font("Arial Rounded MT Bold", 1, 48)); 
        lbltop.setForeground(new Color(255, 255, 255));
        lbltop.setText("Add Student");
        getContentPane().add(lbltop);
        lbltop.setBounds(200, 30, 380, 43);
        
        lblname.setFont(new Font("Segoe UI", 1, 14)); 
        lblname.setText("NAME :");
        internalpanel.add(lblname);
        lblname.setBounds(50, 80, 170, 25);
        
        
        lblpass.setFont(new Font("Segoe UI", 1, 14)); 
        lblpass.setText("PASSWORD");
        internalpanel.add(lblpass);
        lblpass.setBounds(50, 160, 90, 25);
        
        
        lblage.setFont(new Font("Segoe UI", 1, 14)); 
        lblage.setText("Age");
        internalpanel.add(lblage);
        lblage.setBounds(50, 340, 50, 25);
        
        
        lbldep.setFont(new Font("Segoe UI", 1, 14)); 
        lbldep.setText("Departement");
        internalpanel.add(lbldep);
        lbldep.setBounds(230, 340, 120, 25);
        
        
        lblRoll.setFont(new Font("Segoe UI", 1, 14)); 
        lblRoll.setText("Roll Number");     
        internalpanel.add(lblRoll);
        lblRoll.setBounds(50, 250, 90, 25);

        
        
    }
    
    
    public void Buttons()
    {
        btnAdd.setFont(new Font("Segoe UI", 1, 18)); 
        btnAdd.setText("ADD");      
        internalpanel.add(btnAdd);
        btnAdd.setBounds(330, 440, 100, 30);
        btnAdd.addActionListener(this);
        
        
        
        btnBack.setFont(new Font("Segoe UI", 1, 18)); 
        btnBack.setText("Cancel"); 
        internalpanel.add(btnBack);
        btnBack.setBounds(60, 440, 100, 30);
        btnBack.addActionListener(this);
       
        
    }
    
    public void TextFields()
    {
        internalpanel.add(txtname);
        txtname.setBounds(50, 110, 390, 22);
        
        internalpanel.add(txtpass);
        txtpass.setBounds(50, 190, 390, 22);

        
        internalpanel.add(txtroll);
        txtroll.setBounds(50, 280, 150, 22);
         
        
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

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnAdd)
        {
                String name =txtname.getText();
                String pass =txtpass.getText();
                int age =cbage.getSelectedIndex();
                int roll= Integer.parseInt(txtroll.getText());
                String dep= cbdep.getItemAt(cbdep.getSelectedIndex());

                if(roll<=0)
                {
                
                    JOptionPane.showMessageDialog(rootPane, "Invalid Id","Error",0);
                    return;
                }


                for(int i=0;i<=Admin.arrstudent.size();i++)
                {
                    if(i==Admin.arrstudent.size())
                    {
                         JOptionPane.showMessageDialog(rootPane, "Student Added!!!");

                        Admin admin=new Admin();
                        admin.AddStudent(name,age,dep,pass,0,roll);

                        this.WriteStudentInfo();
                        this.ClearTextFields();
                        break;
                    }



                    if(Admin.arrstudent.get(i).getRollNo()==roll)
                    {
                        JOptionPane.showMessageDialog(rootPane, "Roll No Already Added");
                        break;
                    }

                } 
        }
        else if(e.getSource()==btnBack)
        {
           
            this.dispose();
            new AdminFrame(1);
  
        }
            


    }
    
    public void WriteStudentInfo()
    {
        BufferedWriter buffer;
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
    
    
    
    public void ClearTextFields()
    {
        txtname.setText("");
        txtpass.setText("");
        txtroll.setText("");
    }
}
