/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import portalv3.Admin;

/**
 *
 * @author AbuZar
 */
public final class AdminLoginFrame extends JFrame implements ActionListener{

    JPanel internalframe=new JPanel(null);
    JLabel iconlight=new JLabel(new ImageIcon(getClass().getResource("/icons/internalframebackground.png")));
    JLabel icondark=new JLabel(new ImageIcon(getClass().getResource("/icons/externalframebackground.jpg"))); 
    JCheckBox ckshowpass=new JCheckBox();
    
    JButton btnback=new JButton();
    JButton btnlogin=new JButton();
    JLabel lbltop=new JLabel();
    JLabel lblname=new JLabel();
    JLabel lblpass=new JLabel();
    JTextField txtname=new JTextField();
    JPasswordField txtpass=new JPasswordField();
    
    
    public AdminLoginFrame() {
        
       frame();
       label();
       textfield();
       buttons();
       checkbox();
       icons();
       this.validate();
       this.setVisible(true);
       
    }
   
    
    
    
    
    public void frame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setSize(600, 700);
        setLocationRelativeTo(null);
        this.setLayout(null);
        this.getContentPane().setBackground(new Color(117, 176, 189));
        
        
        
        getContentPane().add(internalframe);
        internalframe.setBounds(120, 160, 380, 400);
        internalframe.setOpaque(false);
        
        
        
        
    }
    
    public void icons()
    {
        
        iconlight.setBounds(0, 10, 370, 390);
        icondark.setBounds(0, 0, 590, 680);
        internalframe.add(iconlight); 
        getContentPane().add(icondark); 
    }
    public void label()
    {
        
        
        
        
        lbltop.setFont(new Font("Arial Rounded MT Bold", 1, 48)); 
        lbltop.setText("ADMIN LOGIN");
        this.add(lbltop);
        lbltop.setBounds(130, 30, 350, 90);
        lbltop.setForeground(new Color(204, 204, 204));

        lblname.setFont(new Font("Bahnschrift", 1, 20)); 
        lblname.setText("Name");
        lblname.setBounds(50, 80, 120, 30);
        internalframe.add(lblname);
        
        
        lblpass.setFont(new Font("Bahnschrift", 1, 20)); 
        lblpass.setText("Password");
        internalframe.add(lblpass);
        lblpass.setBounds(50, 180, 170, 30);

    }
    
    
    public void textfield()
    {
        
        
        internalframe.add(txtname);
        txtname.setBounds(50, 110, 280, 30);
        
        
        internalframe.add(txtpass);
        txtpass.setBounds(50, 210, 280, 30);
        
        
        
    }
    
    
    public void buttons()
    {   
        
        
        
        
        
        btnlogin.setFont(new Font("Segoe UI", 1, 14)); 
        btnlogin.setText("LOGIN");
        btnlogin.setBounds(230, 330, 90, 30);
        btnlogin.addActionListener(this);
        internalframe.add(btnlogin);

        
        
        btnback.setFont(new Font("Segoe UI", 1, 14)); 
        btnback.setText("BACK");
        btnback.setBounds(60, 330, 90, 30);
        btnback.addActionListener(this);
        internalframe.add(btnback);

    }

    public void checkbox()
    {
        ckshowpass.setText("Show Password");
        internalframe.add(ckshowpass);
        ckshowpass.setBounds(50, 260, 140, 20);
        ckshowpass.addActionListener(this);
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnlogin)
        {
                Admin admin=new Admin();
                String name=txtname.getText();
                String pass=txtpass.getText();
               
                if(admin.getName().equals(name))
                {
                    if(admin.getPass().equals(pass))
                    {
                        new AdminFrame(0);
                        this.dispose();
                    }
                    else
                    {
                        JOptionPane.showMessageDialog(null, "Incorrect Password");
                    }
                }
                else
                {
                   JOptionPane.showMessageDialog(null, "Incorrect Username and Password");
                }
        }
        else if(e.getSource()==btnback)
        {
            new MainFrame();
            this.dispose(); 
        }
        
        else if(e.getSource()==ckshowpass)
        {
            if(ckshowpass.isSelected())
            {
                txtpass.setEchoChar((char)0);
            }
            else {
                txtpass.setEchoChar('*');
            }
        }

    }
    
    
    
    
    
}
