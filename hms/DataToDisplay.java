/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Abid Khan
 */
public class DataToDisplay implements ActionListener
{
    boolean ifRemove;
    boolean ifSearch;
    JButton BackToMenu;
    JTextField TF_student_name;
    JTextField TF_student_father_name;
    JTextField TF_student_id;
    JTextField TF_hostel_id;
    JTextField TF_department;
    JTextField TF_student_DOB;
    JTextField TF_room_id;
    JTextField TF_cell_no;
    JTextField TF_address;
    JTextField TF_Gender;
    
    JLabel DeleteInfo;
    JLabel Lb_hostel_id;
    JLabel Lb_student_name;
    JLabel Lb_student_father_name;
    JLabel Lb_student_id;
    JLabel Lb_department;
    JLabel Lb_student_DOB;
    JLabel lb_Gender;
    JLabel Lb_room_id;
    JLabel Lb_cell_no;
    JLabel Lb_address;

    Font FontStyle1;
    JFrame frame;
    DataToDisplay(ResultSet rs,boolean ifRemove, boolean ifSearch)
    {
        this.ifRemove = ifRemove;
        this.ifSearch = ifSearch;
        frame = new JFrame();
        if(ifRemove)
        {
            DeleteInfo = new JLabel("The Following Data Deleted Successfully");
        }
        else if(ifSearch)
        {
            DeleteInfo = new JLabel("The Following Is Your Searched Data");
        }
        Lb_hostel_id = new JLabel("HOSTEL ID:");
        Lb_student_name = new JLabel("CANDIDATE NAME:");
        Lb_student_father_name = new JLabel("FATHER NAME:");
        Lb_student_id = new JLabel("STUDENT ID:");
        Lb_department = new JLabel("DEPARTMENT:");
        Lb_student_DOB = new JLabel("DATE OF BIRTH:");
        lb_Gender = new JLabel("GENDER:");
        Lb_room_id = new JLabel("ROOM ID:");
        Lb_cell_no = new JLabel("CELL NO:");
        Lb_address = new JLabel("ADDRESS:");
        BackToMenu = new JButton("Go To Menu");
        
        try
        {
            TF_student_id = new JTextField(rs.getString(1));
            TF_student_name = new JTextField(rs.getString(2));
            TF_student_father_name = new JTextField(rs.getString(3));
            TF_department = new JTextField(rs.getString(4));
            TF_address = new JTextField(rs.getString(5));
            TF_cell_no = new JTextField(rs.getString(6));
            TF_student_DOB = new JTextField(rs.getString(7));
            TF_hostel_id = new JTextField(rs.getString(8));
            TF_room_id = new JTextField(rs.getString(9));
            TF_Gender = new JTextField(rs.getString(10));
        }
        catch(Exception e)
        {
            JOptionPane.showMessageDialog(null, "In data class"+e);
            System.out.println("Error: " + e);
        }
        BackToMenu.addActionListener(this);
                
        
        setLocationAndSize();
        addToFrame();
        addStyle();
                            
//        frame.setSize(600,700);
//        frame.setLocation(300,50);
        frame.setBounds(0, 0, 1200, 700);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);                    

    }
    
    final public void setLocationAndSize() 
    {
        // setting to dispaly it 
        TF_student_id.setBounds(300, 50, 200, 30);
        TF_student_name.setBounds(300, 100, 200, 30);
        TF_student_father_name.setBounds(300, 150, 200, 30);
        TF_department.setBounds(300, 200, 200, 30);
        TF_address.setBounds(300, 250, 200, 30);
        TF_cell_no.setBounds(300, 300, 200, 30);
        TF_student_DOB.setBounds(300, 350, 200, 30);
        TF_Gender.setBounds(300, 400, 200, 30);
        TF_hostel_id.setBounds(300, 450, 200, 30);
        TF_room_id.setBounds(300, 500, 200, 30);
        
        // setting Label....
        DeleteInfo.setBounds(120, 15, 450,30);
        
        Lb_student_id.setBounds(50, 50, 200, 30);
        Lb_student_name.setBounds(50, 100, 200, 30);
        Lb_student_father_name.setBounds(50, 150, 200, 30);
        Lb_department.setBounds(50, 200, 200, 30);
        Lb_address.setBounds(50, 250, 200, 30);
        Lb_cell_no.setBounds(50, 300, 200, 30);
        Lb_student_DOB.setBounds(50, 350, 200, 30);
        lb_Gender.setBounds(50, 400, 400, 30);
        Lb_hostel_id.setBounds(50, 450, 200, 30);
        Lb_room_id.setBounds(50, 500, 200, 30);       
        
        
        BackToMenu.setBounds(200, 590, 180, 30);
        
    
    }
    final public void addToFrame()
    {
        frame.add(DeleteInfo);

        frame.add(Lb_student_id);
        frame.add(Lb_student_name);
        frame.add(Lb_student_father_name);
        frame.add(Lb_department);
        frame.add(Lb_address);
        frame.add(Lb_cell_no);
        frame.add(Lb_student_DOB);
        frame.add(lb_Gender);
        frame.add(Lb_room_id);
        frame.add(Lb_hostel_id);
        
        // this TextField..........
        frame.add(TF_student_id);
        frame.add(TF_student_name);
        frame.add(TF_student_father_name);
        frame.add(TF_hostel_id);
        frame.add(TF_department);
        frame.add(TF_student_DOB);
        frame.add(TF_room_id);
        frame.add(TF_cell_no);
        frame.add(TF_address);
        frame.add(TF_Gender);
        frame.add(BackToMenu);
    }
    final public void addStyle()
    {
        FontStyle1 = new Font("Serif", Font.BOLD, 20);
        DeleteInfo.setFont(FontStyle1);
        
        Lb_student_id.setFont(FontStyle1);
        Lb_student_name.setFont(FontStyle1);
        Lb_student_father_name.setFont(FontStyle1);
        Lb_department.setFont(FontStyle1);
        Lb_address.setFont(FontStyle1);
        Lb_cell_no.setFont(FontStyle1);
        Lb_student_DOB.setFont(FontStyle1);
        lb_Gender.setFont(FontStyle1);
        Lb_hostel_id.setFont(FontStyle1);
        Lb_room_id.setFont(FontStyle1);
        
        BackToMenu.setFont(FontStyle1);


    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == BackToMenu) 
        {
                new ManiClass();
                frame.dispose(); //this is used to run currently page and dispose opened page
                if(ifRemove)
                {
                    RemoveData.frame.setVisible(false);
                }
                else if(ifSearch)
                Search_Student_Data.frame.setVisible(false);
                
        }
    }
}
