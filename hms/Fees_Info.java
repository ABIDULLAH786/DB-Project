package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Fees_Info implements ActionListener
{
    JFrame frame;
    Font fH;
    JLabel lb_Fee_mounth;
    JLabel lb_Std_ID ;

	
    JTextField TF_Fee_mounth;
    JTextField TF_Std_ID;
	
    JButton Submit;
    JButton Back;
    
    JLabel img;
    ImageIcon background;
    JPanel Heading;
    JLabel Name_Heading;
    public Fees_Info()
    {
        fH = new Font("Serif",Font.BOLD,20);
        frame = new JFrame("UPDATE FACULTY DATA PAGE");
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
	Name_Heading = new JLabel(" FEE INFO PAGE ");
	Name_Heading.setBounds(100,500,400,100);
	Name_Heading.setFont(fH);
		
	// Background Img
	background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic6.jpg"));
        img = new JLabel("",background,JLabel.CENTER);
	img.setBounds(0,0,1200,700);			
		
        // JLabel
        lb_Fee_mounth= new JLabel("Sumester Fee:");
        lb_Std_ID = new JLabel("Student ID:");
	// JTextField 
	TF_Fee_mounth = new JTextField(20);
    	TF_Fee_mounth.setBounds(470,150,300,30);
	
        TF_Std_ID = new JTextField(20);
    	TF_Std_ID.setBounds(470,200,300,30);	
       
	
        
	// Adding 
    	lb_Fee_mounth.setBounds(280,145,300,30);
	lb_Fee_mounth.setFont(fH);
	img.add(lb_Fee_mounth);
	img.add(TF_Fee_mounth);
	
        lb_Std_ID.setBounds(280,200,300,30);
	lb_Std_ID.setFont(fH);
	img.add(lb_Std_ID);
        img.add(TF_Std_ID);
        
		
	img.add(Heading);
	
        //img.add(Regis_page);
	Submit.addActionListener(this);
	Back.addActionListener(this);
        
	img.add(Submit);
	img.add(Back);
	Heading.add(Name_Heading);
		
	frame.add(img);
			
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
		Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
		con = DriverManager.getConnection(url,"root","pakistani12");
                String query = "Insert into fee(fee_month_year, student_id) values(?,?)";
                PreparedStatement ps = con.prepareStatement(query);
		
                ps.setInt(1,Integer.parseInt(TF_Fee_mounth.getText()));
                ps.setString(2,TF_Std_ID.getText());
                
		
                if(ps.executeUpdate()>0)
                {
                    JOptionPane.showMessageDialog(frame, "The Fees Information Added successfully");
                }
                else
                {
                    JOptionPane.showMessageDialog(frame, "The Fees Information did not Added successfully");
                    TF_Fee_mounth.setText("");
                    TF_Std_ID.setText("");
                }

                con.close();	
	
		
            }
            catch(Exception err)
            {
                System.out.println("Error:"+err);
            }			
	
        }
        else if(ae.getSource()==Back)
        {
            new ManiClass();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }
}
