package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Hostel_Data implements ActionListener
{
    JFrame frame;   
    Font fH;
    JLabel lb_hostel_id;
    JLabel lb_no_of_rooms;
    JLabel lb_no_of_student;
    JLabel lb_annual_expences ;
    JLabel lb_location ;
    JLabel lb_hostetl_status ;
    
    JRadioButton Boys;
    JRadioButton Girls;
	
    JTextField TF_hostel_id;
    JTextField TF_no_of_rooms;
    JTextField TF_no_of_student;
    JTextField TF_annual_expences;
    JTextField TF_location;
    JButton Submit;
    JButton Back;

    JLabel F_img;
    ImageIcon background_f;
    JPanel Heading;
    JLabel Name_Heading;
	
    
    public Hostel_Data()
    {


        fH = new Font("Serif",Font.BOLD,20);
        frame = new JFrame("WELCOME TO Hostel Info");
	frame.setSize(1200,700);
	frame.setLayout(null);
  
	Submit = new JButton("Submit");
	Submit.setBounds(645,600,100,40);
        
        Back = new JButton("Go Back");
	Back.setBounds(500,600,100,40);	
		
	// Heading
	Heading = new JPanel();
	Heading.setBackground(new Color(0,0,0,80));
	Heading.setBounds(0,0,1200,100);
	
	// Name_Heading
	Name_Heading = new JLabel(" Hostel Info ");
	Name_Heading.setBounds(100,500,400,100);
	Name_Heading.setFont(fH);
		
        // background_f F_img
	background_f = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic6.jpg"));
        F_img = new JLabel("",background_f,JLabel.CENTER);
	F_img.setBounds(0,0,1200,700);			
		
        // JLabel
        lb_hostel_id = new JLabel("Hostel ID:");
        lb_no_of_rooms = new JLabel("Num Of Rooms:");
        lb_no_of_student= new JLabel("Num Of Students:");
        lb_annual_expences= new JLabel("Annula Expences:");
        lb_location = new JLabel("Location:");
        lb_hostetl_status= new JLabel("Hostel Status:");
        

	// JTextField 
	TF_hostel_id = new JTextField(20);
    	TF_hostel_id.setBounds(470,150,300,30);
	TF_no_of_rooms = new JTextField(20);
    	TF_no_of_rooms.setBounds(470,200,300,30);	
	TF_no_of_student = new JTextField(20);
    	TF_no_of_student.setBounds(470,250,300,30);	
	TF_annual_expences = new JTextField(20);
    	TF_annual_expences.setBounds(470,300,300,30);	
	TF_location = new JTextField(20);
    	TF_location.setBounds(470,350,300,30);	
		
	// Boys or Femal Button
	Boys = new JRadioButton("Boys");
        Boys.setBounds(470,400,60,25);		
		
	Girls = new JRadioButton("Girls");
        Girls.setBounds(555,400,70,25);		
			
        ButtonGroup group = new ButtonGroup();
	group.add(Boys);
	group.add(Girls);
        
	Boys.addActionListener(this);
	Girls.addActionListener(this);
		
			
	Submit.addActionListener(this);
	Back.addActionListener(this);
	
	// Adding 
    	lb_hostel_id.setBounds(280,145,300,30);
	lb_hostel_id.setFont(fH);
	F_img.add(lb_hostel_id);
	F_img.add(TF_hostel_id);
		
	lb_no_of_rooms.setBounds(280,200,300,30);
	lb_no_of_rooms.setFont(fH);
	F_img.add(lb_no_of_rooms);
	F_img.add(TF_no_of_rooms);
        
        lb_no_of_student.setBounds(280,245,300,30);
	lb_no_of_student.setFont(fH);
	F_img.add(lb_no_of_student);
	F_img.add(TF_no_of_student);
		
	lb_annual_expences.setBounds(280,300,300,30);
	lb_annual_expences.setFont(fH);
	F_img.add(lb_annual_expences);
	F_img.add(TF_annual_expences);
		
		
        lb_location.setBounds(280,345,300,30);
	lb_location.setFont(fH);
	F_img.add(lb_location);
	F_img.add(TF_location);
		
		
	lb_hostetl_status.setBounds(280,400,300,30);
	lb_hostetl_status.setFont(fH);
	F_img.add(lb_hostetl_status);
	F_img.add(Heading);

	F_img.add(Boys);
	F_img.add(Girls);
        			                                       

        F_img.add(Submit);
        F_img.add(Back);
	Heading.add(Name_Heading);
	frame.add(F_img);

	frame.setVisible(true);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
	frame.setResizable(false);	

    }
	
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Submit)
        {
            try
            {
		
                Connection con;
                PreparedStatement ps=null;
		Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
		con = DriverManager.getConnection(url,"root","pakistani12");
               
                String query=null;
                query = "Insert into hostel(hostel_id, no_of_rooms, no_of_student, annual_expences, location,hostetl_status) values(?,?,?,?,?,?)";
                ps = con.prepareStatement(query);
                ps.setInt(1,Integer.parseInt(TF_hostel_id.getText()));
                ps.setInt(2,Integer.parseInt(TF_no_of_rooms.getText()));
                ps.setInt(3,Integer.parseInt(TF_no_of_student.getText()));
                ps.setInt(4,Integer.parseInt(TF_annual_expences.getText()));
                ps.setString(5,TF_location.getText());
                if(Boys.isSelected())
                    ps.setString(6,"Boys");
                else if(Girls.isSelected())
                    ps.setString(6,"Girls");
                else
                    JOptionPane.showMessageDialog(frame, "Please Select Hostel Status");
                
                ps.executeUpdate();
                 
                boolean EveryThingOK= false;
                if(Boys.isSelected())
                {
                    System.out.println("IN Boys");
                    EveryThingOK=true;
                    query = "Insert into boys_hostel(hostel_id, no_of_rooms, no_of_student, annual_expences, location) values(?,?,?,?,?)";

                }
                else if(Girls.isSelected())
                {
                    System.out.println("IN Girls");
                    
                    EveryThingOK=true;
                    query = "Insert into girls_hostel(hostel_id, no_of_rooms, no_of_student, annual_expences, location) values(?,?,?,?,?)";
                }
                else
                    JOptionPane.showMessageDialog(frame, "Please Select Hostel Status");
                
                if(EveryThingOK)
                {
                    System.out.println("In Inserting if");
                    
                ps = con.prepareStatement(query);
                ps.setInt(1,Integer.parseInt(TF_hostel_id.getText()));
                ps.setInt(2,Integer.parseInt(TF_no_of_rooms.getText()));
                ps.setInt(3,Integer.parseInt(TF_no_of_student.getText()));
                ps.setInt(4,Integer.parseInt(TF_annual_expences.getText()));
                ps.setString(5,TF_location.getText());
                
                }
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(frame, "The Hostel Information Added successfully");
                    TF_hostel_id.setText("");
                    TF_no_of_rooms.setText("");
                    TF_no_of_student.setText("");
                    TF_annual_expences.setText("");
                    TF_location.setText("");
                }
                else
                    JOptionPane.showMessageDialog(frame, "The Hostel Information did not Added successfully");
                
                con.close();
            }
            catch(Exception err)
            {
                System.out.println("\n\nError "+err.getMessage());
            }
        }
        else if(ae.getSource()==Back)
        {
            new ManiClass();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }
}
