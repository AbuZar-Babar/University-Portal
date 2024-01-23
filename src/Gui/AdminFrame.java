/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Gui;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import portalv3.*;

/**
 *
 * @author AbuZar
 */
public final class AdminFrame extends JFrame implements ActionListener,MouseListener{
   
   DefaultTableModel teachTable;
   DefaultTableModel stdtable; 
    
    
   JTabbedPane TabbedPane1=new JTabbedPane();
   
   JButton btnAddteacher=new JButton();
   JButton btnChangeTeacherInfo=new JButton();
   JButton btnRemoveStd=new JButton();
   JButton btnRemoveTeacher=new JButton();
   JButton btnStdAdd=new JButton();
   JButton btnStdChangeInfo=new JButton();
   
   
   JPanel welcomepanel=new JPanel();
   JPanel studentpanel=new JPanel();
   JPanel teacherpanel=new JPanel();
   
   
   
   JScrollPane jScrollPane1=new  JScrollPane();
   JScrollPane jScrollPane2=new JScrollPane();
   
   JLabel lblWelcome=new JLabel();
   JLabel lbldate = new JLabel();
   JLabel icontop=new JLabel(new ImageIcon(getClass().getResource("/icons/bluetopcrop.jpg")));
   JLabel iconbottom1=new JLabel(new ImageIcon(getClass().getResource("/icons/bottomicon.jpg")));
   JLabel iconbottom2=new JLabel(new ImageIcon(getClass().getResource("/icons/bottomicon.jpg")));
   JLabel iconback=new JLabel(new ImageIcon(getClass().getResource("/icons/backarrow.png")));

   JTable tblstudent=new JTable();
   JTable tblteacher=new JTable();

    public AdminFrame(int t) {
        
        
        frame();
        Label();
        Buttons();
        SetDate();
        WelcomePanel();
        StudentPanel();
        TeacherPanel();
        Tabbedpane(t);
        Table();
        icons();
        
        setVisible(true);
        this.SetTableValues();//set the table values
        
    }
   
    public void SetDate()
    {
        LocalDate currentdate= LocalDate.now(); 
        DateTimeFormatter df=DateTimeFormatter.ofPattern("yyyy-MM-dd"); //formate the date 
        String date= currentdate.format(df);        //save date into string
    
    
        lbldate.setFont(new Font("Segoe UI", 1, 24)); 
        lbldate.setForeground(new Color(242, 242, 242));
        lbldate.setBounds(740, 50, 220, 30);
        this.lbldate.setText("Date :"+date);
    }
    
    
    public void frame()
    {
        
        setSize(1000, 610);
        setResizable(false);
        setLayout(null);
        setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
    }
    
    public void icons()
    {
        
        iconback.setBounds(10, 17, 50, 50);     
        iconback.addMouseListener(this);
        welcomepanel.add(iconback);
        
        welcomepanel.add(icontop);
        icontop.setBounds(0, 0, 990, 100);
        
        
        teacherpanel.add(iconbottom1);
        iconbottom1.setBounds(0, 0, 1000, 500);
        studentpanel.add(iconbottom2);
        iconbottom2.setBounds(0, 0, 1000, 500);
        
        
        
        
    }
    public void Label()
    {
        
        lblWelcome.setBackground(new Color(243, 240, 202));
        lblWelcome.setFont(new Font("Verdana", 1, 36)); 
        lblWelcome.setForeground(new Color(243, 240, 202));
        lblWelcome.setText("Welcome Abuzar !");
        lblWelcome.setBounds(340, 20, 365, 45);
        lblWelcome.addMouseListener(this);
       
        
        
        
        
        
        
        
        
        
        
        
    }
    public void Buttons()
    {
        
        btnRemoveTeacher.setBackground(new Color(102, 102, 102));
        btnRemoveTeacher.setFont(new Font("Segoe UI", 1, 18)); 
        btnRemoveTeacher.setForeground(new Color(242, 242, 242));
        btnRemoveTeacher.setText("Remove Teacher");
        btnRemoveTeacher.setBounds(365, 40, 250, 32);
        btnRemoveTeacher.addActionListener(this);
        
        
        
        
        btnChangeTeacherInfo.setBackground(new Color(102, 102, 102));
        btnChangeTeacherInfo.setFont(new Font("Segoe UI", 1, 18)); 
        btnChangeTeacherInfo.setForeground(new Color(242, 242, 242));
        btnChangeTeacherInfo.setText("Change Teacher Info");
        btnChangeTeacherInfo.setBounds(710, 40, 250, 30);
        btnChangeTeacherInfo.addActionListener(this);
        
        
        
        btnAddteacher.setBackground(new Color(102, 102, 102));
        btnAddteacher.setFont(new Font("Segoe UI", 1, 18)); 
        btnAddteacher.setForeground(new Color(242, 250, 242));
        btnAddteacher.setText("Add Teacher");
        btnAddteacher.setBounds(20, 40, 250, 30);
        btnAddteacher.addActionListener(this);
        
        
        
        btnStdAdd.setBackground(new Color(102, 102, 102));
        btnStdAdd.setFont(new Font("Segoe UI", 1, 18)); 
        btnStdAdd.setForeground(new Color(242, 250, 242));
        btnStdAdd.setText("Add Student");
        btnStdAdd.setBounds(20, 40, 250, 32);
        btnStdAdd.addActionListener(this);
        
        
        btnRemoveStd.setBackground(new Color(102, 102, 102));
        btnRemoveStd.setFont(new Font("Segoe UI", 1, 18)); 
        btnRemoveStd.setForeground(new Color(255, 250, 255));
        btnRemoveStd.setText("Remove Student");
        btnRemoveStd.setBounds(365, 40, 250, 30);
        btnRemoveStd.addActionListener(this);
        
        btnStdChangeInfo.setBackground(new Color(102, 102, 102));
        btnStdChangeInfo.setFont(new Font("Segoe UI", 1, 18)); 
        btnStdChangeInfo.setForeground(new Color(255, 250, 255));
        btnStdChangeInfo.setText("Change Student Info");
        btnStdChangeInfo.setBounds(710, 40, 250, 30);
        btnStdChangeInfo.addActionListener(this);
        
        
        

          
        
    }
    
    
    public void WelcomePanel()
    {
        
        welcomepanel.setBackground(new Color(56, 118, 191));
        welcomepanel.setForeground(new Color(0, 102, 102));
        welcomepanel.setVisible(true);
        welcomepanel.setBounds(0, 0, 990, 90);
        welcomepanel.setOpaque(true);
        welcomepanel.setLayout(null);
        welcomepanel.add(lblWelcome);
        welcomepanel.add(lbldate);
        
        this.add(welcomepanel);
          
        
    }
    
    public void StudentPanel()
    {
     studentpanel.setBackground(new Color(204, 255, 204));
     studentpanel.setLayout(null);
     studentpanel.add(btnStdAdd);
     studentpanel.add(btnStdChangeInfo);
     studentpanel.add(btnRemoveStd);
     studentpanel.add(jScrollPane1); //list for students
     
     
    }
    
    public void TeacherPanel()
    {
        teacherpanel.setBackground(new Color(255, 102, 102));
        teacherpanel.setLayout(null);
        teacherpanel.add(btnRemoveTeacher);
        teacherpanel.add(btnChangeTeacherInfo);
        teacherpanel.add(btnAddteacher);
        teacherpanel.add(jScrollPane2);//list for Teachers
        
        
        
        
    }
    
    
    public void Tabbedpane(int t)
    {
        TabbedPane1.setBackground(new Color(0, 204, 204));
        TabbedPane1.addTab("Teacher", teacherpanel);  //Tabs For Teacher and Student
        TabbedPane1.addTab("Student", studentpanel);
        
        TabbedPane1.setSelectedIndex(t);
        TabbedPane1.setBounds(0, 90, 1010, 500);
        
        this.add(TabbedPane1);

    }
    
    public void Table()
    {
       
        
        
       String[] colStd={ "Name", "Roll", "Departement","GPA"};
       tblstudent.setModel(new DefaultTableModel(colStd, 0)); //Setting list column values and row to 0
       jScrollPane1.setViewportView(tblstudent);                            // viewport = the viewable area showed to the 
       jScrollPane1.setBounds(20, 110, 940, 330);                //user like in this case list excluding borders like hedder and scroll bar
       tblstudent.setEnabled(false);                                      //set editable = list can not be edit
       tblstudent.setAutoCreateRowSorter(true);
       
       String[] Colteach={"Name", "ID", "Departement"};
       tblteacher.setModel(new DefaultTableModel(Colteach, 0));
       jScrollPane2.setViewportView(tblteacher);
       jScrollPane2.setBounds(20, 110, 940, 330);
       tblteacher.setEnabled(false);
       tblteacher.setAutoCreateRowSorter(true);
       
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if(e.getSource()==btnAddteacher)
        {
            new AddTeacherFrame();       
            this.dispose();
        }
        
        
        
        else if(e.getSource()==btnRemoveTeacher)
        {
            int id = 0;
            
            //=================try catch for empty id
            
            try{
                id=Integer.parseInt(JOptionPane.showInputDialog("Enter ID")); 
                
            }
            catch(NumberFormatException ex)
            {
                JOptionPane.showMessageDialog(rootPane, "              Enter An Id ","Error",2);
                return;
            }
                
            //============================if id is valid  
                int i;
                for(i=0;i<Admin.arrTeachers.size();i++)
                {

                    if(Admin.arrTeachers.get(i).getId()==id)
                    {
                        Admin.arrTeachers.remove(i);
                        JOptionPane.showMessageDialog(rootPane, "Teacher removed");
                        this.Write();               //write it to output file
                        this.clearTable();          //clear the table
                        this.SetTableValues();      //print the table again with new values
                        return;
                    } 
                }
                
                JOptionPane.showMessageDialog(rootPane, "   Teacher Not Found","Error",2);
        }
        
        
        
        else if(e.getSource()==btnChangeTeacherInfo)
        {
                    int id;
                    //try catch for id 
                    try{
                
                    id=Integer.parseInt(JOptionPane.showInputDialog("       Enter Teacher Id Number"));
                    }
                    catch(NumberFormatException ex)
                    {
                        JOptionPane.showMessageDialog(rootPane, "              Enter An Id ","Error",2);
                        return;
                    }

                
                Admin ad=new Admin();
                
                if(ad.getTeacherindex(id)==-1)
                {
                    JOptionPane.showMessageDialog(null, "           Id not Found", "Error", 2);
                }
                else
                {

                    int index=ad.getTeacherindex(id);
                    new ChangeTeacherFrame(index);
                    
                    this.dispose();
                }
        }
       
        else if(e.getSource()==btnStdAdd)
        {
            
            
                new AddStudentFrame();
                this.dispose();
                
                
        }
        
        
        else if(e.getSource()==btnRemoveStd)
        {
            int roll = 0;
            try {
                 roll=Integer.parseInt(JOptionPane.showInputDialog("Enter Roll No"));
            }
            catch(NumberFormatException ex)
            {
               JOptionPane.showMessageDialog(rootPane, "        Enter Valid Student Id","Error",2); 
               return;
            }
            
                

                int i;
                for(i=0;i<Admin.arrstudent.size();i++)
                {

                    if(Admin.arrstudent.get(i).getRollNo()==roll)
                    {
                        Admin.arrstudent.remove(i);
                        JOptionPane.showMessageDialog(rootPane, "Student removed");
                        this.clearTable();
                        this.SetTableValues();
                        this.Write();
                        return;
                    } 
                }
                
                JOptionPane.showMessageDialog(rootPane, "       Student Not Found","Error",0);
            
            
            
        }
        else if(e.getSource()==btnStdChangeInfo)
        {
                int roll ;
                try {
                     
                     roll=Integer.parseInt(JOptionPane.showInputDialog("Enter Student Roll Number"));
                     Admin admin=new Admin();
                //ad.getindex(roll);
                if(admin.getindex(roll)!=-1)
                {
                    int index=admin.getindex(roll);
                    new ChangeStudentFrame(index); 
                    this.dispose();
                    
                    
                    
                }
                else
                {

                    JOptionPane.showMessageDialog(null, "Roll not Found", "", 2);
                }
                     
                }
                catch(NumberFormatException ex)
                {
                   JOptionPane.showMessageDialog(rootPane, "        Enter Valid Student Id","Error",2); 
                   return;
                }    
            
            
                
                
        
        
        }
        
        

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
    }

    
    public void clearTable()
    {
        
        
       int row;
       
       row=tblstudent.getRowCount();
       for(int i=row-1;i>=0;i--)
       {
           stdtable.removeRow(i);
       }
       
       
       row=tblteacher.getRowCount();
       
       
       for(int i=row-1;i>=0;i--)
       {
           teachTable.removeRow(i);
       }
       
    }
    
    
    public void SetTableValues()
    {
        
        for(Teacher t:Admin.arrTeachers)
        {
            String teahdata[]={t.getName(),
                String.valueOf(t.getId()),
                t.getDepartement()
            };
            
            teachTable=(DefaultTableModel) tblteacher.getModel();
            teachTable.addRow(teahdata);
            
            
        }
        
        
        for(Student std:Admin.arrstudent)
        {
                String[] stddata={std.getName(),     
                String.valueOf(std.getRollNo()),
                std.getDepartement(), 
                String.valueOf(std.getGpa())
                };
            
            
            
                stdtable =(DefaultTableModel) tblstudent.getModel();
                stdtable.addRow(stddata);
            
            
        }
        
        
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        
        if(e.getSource()==iconback)
        {
            new MainFrame();
            this.dispose();
        }
        else if(e.getSource()==lblWelcome)
        {
            System.out.println("welcoe");
        }
            
    }

    @Override
    public void mousePressed(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //System.out.println("Entered");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
   
    
}
        
    
    
    
