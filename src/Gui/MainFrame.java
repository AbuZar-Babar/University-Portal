/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author AbuZar
 */
public final class MainFrame extends JFrame implements MouseListener{

    JLabel Tittle=new JLabel();
    JLabel lblbtnadmin=new JLabel();
    JLabel lblbtnstudent=new JLabel();
    JLabel icondark=new JLabel(new ImageIcon(getClass().getResource("/icons/mainframebackground.jpg")));
    
    public MainFrame() {
        
        
        Frame();
        label();
        button();
        this.validate();
        this.add(icondark);
        setVisible(true);
        
    }
    
    public void Frame()
    {
        this.setLayout(null);
        setSize(1000,600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        icondark.setBounds(0, 0, 1000, 600);
        
        this.getContentPane().setBackground(new Color(117, 176, 189));
        
    }
    
    public void label()
    {
        
        Tittle.setFont(new Font("Arial Rounded MT Bold", 1, 48)); 
        Tittle.setText("University Portal");
        Tittle.setForeground(new Color(204, 204, 204));
        Tittle.setBounds(290, 40, 420, 90);
        this.add(Tittle);

    }
    
    public void button()
    {
        
        getContentPane().add(lblbtnadmin);
        lblbtnadmin.setBounds(290, 180, 400, 120);
        lblbtnadmin.setIcon(new ImageIcon(getClass().getResource("/icons/adminbuttone.png")));
        lblbtnadmin.addMouseListener(this);
        
        
        
        getContentPane().add(lblbtnstudent);
        lblbtnstudent.setBounds(290, 360, 400, 120);
        lblbtnstudent.setIcon(new ImageIcon(getClass().getResource("/icons/studentbuttone.png"))); // NOI18N
        lblbtnstudent.addMouseListener(this);
        
        

    }

    @Override
    public void mouseClicked(MouseEvent e) {
       if(e.getSource()==lblbtnadmin)
       {
           new AdminLoginFrame();
           this.dispose();
       }
       else if(e.getSource()==lblbtnstudent)
       {
           new StudentLoginFrame();
           this.dispose();
       }
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        if(e.getSource()==lblbtnadmin)
        {
           lblbtnadmin.setIcon(new ImageIcon(getClass().getResource("/icons/adminbuttonepop.png"))); 
        }
        else if(e.getSource()==lblbtnstudent)
        {
            lblbtnstudent.setIcon(new ImageIcon(getClass().getResource("/icons/studentbuttonepop.png"))); // NOI18N
        }


    }

    @Override
    public void mouseExited(MouseEvent e) {
        if(e.getSource()==lblbtnadmin)
        {
           lblbtnadmin.setIcon(new ImageIcon(getClass().getResource("/icons/adminbuttone.png"))); 
        }
        else if(e.getSource()==lblbtnstudent)
        {
            lblbtnstudent.setIcon(new ImageIcon(getClass().getResource("/icons/studentbuttone.png"))); // NOI18N
        }


    }

    
    
    
    
    
    
    
    
    
    
}
