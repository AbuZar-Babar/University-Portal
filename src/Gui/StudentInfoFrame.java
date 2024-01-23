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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import portalv3.Admin;

/**
 *
 * @author AbuZar
 */
public final class StudentInfoFrame extends JFrame implements ActionListener{
     int index;
    
    
    JButton btnback=new JButton("BACK");
    JPanel infopanel=new JPanel();
    JPanel toppanel=new JPanel();
    JLabel lblAge=new JLabel();
    JLabel lblDep=new JLabel();
    JLabel lblGpa=new JLabel();
    JLabel lblroll=new JLabel();
    JLabel lblgetage=new JLabel();
    JLabel lblgetdep=new JLabel();
    JLabel lblgetgpa=new JLabel();
    JLabel lblgetname=new JLabel();
    JLabel lblgetroll=new JLabel();
    JLabel lblname=new JLabel();
    JLabel lblemail=new JLabel();
    
    JLabel iconcomsats=new JLabel(new ImageIcon(getClass().getResource("/icons/comsatsbanner.png")));
    JLabel iconprofilepic=new JLabel(new ImageIcon(getClass().getResource("/icons/blank-profile.png")));
    JLabel iconinternalframe = new JLabel(new ImageIcon(getClass().getResource("/icons/wallpaperflare-cropped.jpg")));

    
    JLabel lblwelcomeback = new JLabel();
    JLabel lblgetemail=new JLabel();
    
    JButton btndashbord=new JButton("Dashbord");
    JButton btnacademicinfo=new JButton("Acdemic Info");
    JButton btnpersonalinfo=new JButton("Personal info");






    
    JPanel mainpanel=new JPanel(null);
    JPanel sidepanel=new JPanel(null);
    
    
    
    
    
    public StudentInfoFrame(int i) 
    {
        this.index=i;
        frame();
        Panel();
        label();
        buttons();
        setinfo();
        icons();
        this.setVisible(true);
        
        
    }
    public void icons()
    {
        mainpanel.add(iconprofilepic);
        iconprofilepic.setBounds(20, 20, 90, 90);
        
        mainpanel.add(iconinternalframe);
        iconinternalframe.setBounds(0, 0, 380, 550);
    
        
        getContentPane().add(iconcomsats);
        iconcomsats.setBounds(0, 0, 510, 140);
        
    }
    public void frame()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE); 
        setSize(510, 710);
        setResizable(false);
        this.setLayout(null);  
        this.getContentPane().setBackground(new Color(117, 176, 189));
        this.setLocationRelativeTo(null);
    }
    
    public void Panel()
    {
        
        sidepanel.setBackground(new Color(102, 102, 102));
        getContentPane().add(sidepanel);
        sidepanel.setBounds(0, 138, 130, 550);
        
        
        
        
        getContentPane().add(mainpanel);
        mainpanel.setBounds(130, 140, 380, 550);
        
        

    }
    public void label()
    {

        lblwelcomeback.setFont(new Font("Arial Rounded MT Bold", 1, 24)); 
        lblwelcomeback.setForeground(new Color(255, 255, 255));
        lblwelcomeback.setText("WELCOME BACK!!!");
        mainpanel.add(lblwelcomeback);
        lblwelcomeback.setBounds(120, 30, 240, 40);

        
        lblname.setFont(new Font("Segoe UI", 1, 18)); 
        lblname.setText("Name");
        infopanel.add(lblname);
        lblname.setBounds(60, 30, 130, 30);

        lblAge.setFont(new Font("Segoe UI", 1, 18)); 
        lblAge.setText("Age");
        infopanel.add(lblAge);
        lblAge.setBounds(60, 80, 130, 30);

        lblDep.setFont(new Font("Segoe UI", 1, 18)); 
        lblDep.setForeground(new Color(255, 255, 255));
        lblDep.setText("Departement");
        mainpanel.add(lblDep);
        lblDep.setBounds(40, 230, 120, 25);
        

        lblroll.setFont(new Font("Segoe UI", 1, 18)); 
        lblroll.setForeground(new Color(255, 255, 255));
        lblroll.setText("Roll No");
        mainpanel.add(lblroll);
        lblroll.setBounds(40, 310, 120, 25);


        lblGpa.setFont(new Font("Segoe UI", 1, 18)); 
        lblGpa.setForeground(new Color(255, 255, 255));
        lblGpa.setText("GPA");
        mainpanel.add(lblGpa);
        lblGpa.setBounds(40, 160, 120, 25);

        
        lblemail.setFont(new Font("Segoe UI", 1, 18)); 
        lblemail.setForeground(new Color(255, 255, 255));
        lblemail.setText("Email");
        mainpanel.add(lblemail);
        lblemail.setBounds(40, 390, 120, 25);
        
        
        lblgetname.setFont(new Font("Arial Rounded MT Bold", 1, 24)); 
        lblgetname.setForeground(new Color(255, 255, 255));
        lblgetname.setText("NAME");
        mainpanel.add(lblgetname);
        lblgetname.setBounds(120, 80, 230, 30);
        


        

        lblgetdep.setFont(new  Font("Segoe UI", 1, 18)); 
        lblgetdep.setForeground(new Color(255, 255, 255));
        lblgetdep.setText("userdep");
        mainpanel.add(lblgetdep);
        lblgetdep.setBounds(190, 230, 160, 30);

        lblgetroll.setFont(new Font("Segoe UI", 1, 18)); 
        lblgetroll.setForeground(new Color(255, 255, 255));
        lblgetroll.setText("userroll");
        mainpanel.add(lblgetroll);
        lblgetroll.setBounds(190, 310, 160, 30);

        
        lblgetgpa.setFont(new Font("Segoe UI", 1, 18)); 
        lblgetgpa.setForeground(new Color(255, 255, 255));
        lblgetgpa.setText("usergpa");
        mainpanel.add(lblgetgpa);
        lblgetgpa.setBounds(190, 150, 160, 30);
        
        
        lblgetemail.setFont(new Font("Segoe UI", 1, 16)); 
        lblgetemail.setForeground(new Color(255, 255, 255));
        lblgetemail.setText("useremail");
        mainpanel.add(lblgetemail);
        lblgetemail.setBounds(130, 390, 200, 30);

        
    }
    
    public void buttons()
    {
        sidepanel.add(btnback);
        btnback.setBounds(10, 500, 110, 23);
        btnback.setFont(new Font("Segoe UI", 1, 14)); 
        btnback.addActionListener(this);
        
        btndashbord.setFont(new Font("Segoe UI", 1, 12)); 
        sidepanel.add(btndashbord);
        btndashbord.setBounds(10, 30, 110, 23);
        
        sidepanel.add(btnpersonalinfo);
        btnpersonalinfo.setBounds(10, 80, 110, 23);
        btnpersonalinfo.setFont(new Font("Segoe UI", 1, 12)); 
        
        sidepanel.add(btnacademicinfo);
        btnacademicinfo.setBounds(10, 130, 110, 23);
        btnacademicinfo.setFont(new Font("Segoe UI", 1, 12)); 
        
    }
    
    
    
    
    public void setinfo()
    {
        new Admin();
        
        int i=index;
        lblgetname.setText(Admin.arrstudent.get(i).getName());
        lblgetage.setText(String.valueOf(Admin.arrstudent.get(i).getAge()));
        lblgetdep.setText(Admin.arrstudent.get(i).getDepartement());
        lblgetroll.setText(String.valueOf(Admin.arrstudent.get(i).getRollNo()));
        lblgetgpa.setText(String.valueOf(Admin.arrstudent.get(i).getGpa()));
        lblgetemail.setText(lblgetname.getText()+"@gmail.com");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnback)
        {
            this.dispose();
            new MainFrame();
            
        }
        
    }
    
    
    
    
    
    
}
