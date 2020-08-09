package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class ManiClass extends JFrame implements ActionListener
{
    JLabel Img_Background;
	
    JLabel Name_Head;
    Font   fH;
    ImageIcon background;
	
    // Student Button
    JButton Regis_Std;
    JButton Remove_Std;
    JButton Search_Std;
    JButton Upd_Std;
	
    // Faculty Button
    JButton hostel_data;
    JButton Mess_Staff_info;
    JButton Mess_info;
    JButton Fee_info;    
    JButton Room_info;

		
    JPanel Heading;
	
    ManiClass()
    {
        // JFrame
        setSize(1200,700);
        setLayout(null);
        setVisible(true);	
		
		
        // Heading
        Heading = new JPanel();
        Heading.setBackground(new Color(0,0,0,80));
        Heading.setBounds(0,0,1200,100);
        
        fH = new Font("Serif",Font.BOLD,30);
        Name_Head = new JLabel("WELCOME TO HOSTEL");
	Name_Head.setBounds(200,25,400,50);
	Name_Head.setFont(fH);
        Name_Head.setForeground(Color.white);
	Heading.add(Name_Head);
		
		
	// Background Image
	background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic4.jpg"));
	Image temp_Img_Background1 = background.getImage();
	Image temp_Img_Background2 = temp_Img_Background1.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
	background = new ImageIcon(temp_Img_Background2);
	Img_Background = new JLabel("",background,JLabel.CENTER);		
	
	// Button
	fH = new Font("Serif",Font.BOLD,15);
	Regis_Std = new JButton("Student Registration");
	Regis_Std.setBounds(100,200,180,50);
	Regis_Std.setFont(fH);
		
		
	Remove_Std = new JButton("Delete Student Data");
	Remove_Std.setBounds(100,280,180,50);
	Remove_Std.setFont(fH);
		
		
	Search_Std = new JButton("Search Student ID");
	Search_Std.setBounds(100,360,180,50);
	Search_Std.setFont(fH);
		
	Upd_Std = new JButton("Update Student Data");
	Upd_Std.setBounds(100,440,180,50);
	Upd_Std.setFont(fH);
        
        Fee_info = new JButton("Fees Info");
	Fee_info.setBounds(100,520,180,50);
	Fee_info.setFont(fH);

	
        // Hostel info delaring the Button
	hostel_data = new JButton("Hostel information");
	hostel_data.setBounds(920,200,180,50 );
	hostel_data.setFont(fH);
        
        Room_info = new JButton("Room Info");
	Room_info.setBounds(920,280,180,50);
	Room_info.setFont(fH);

        Mess_Staff_info = new JButton("Mess Staff Info");
	Mess_Staff_info.setBounds(920,360,180,50 );
	Mess_Staff_info.setFont(fH);
	
        Mess_info = new JButton("Mess Info");
	Mess_info.setBounds(920,440,180,50);
        Mess_info.setFont(fH);
	

        
        
	
	
		
	Regis_Std.addActionListener(this);
	Remove_Std.addActionListener(this);
	Search_Std.addActionListener(this);
	Upd_Std.addActionListener(this);
		
	hostel_data.addActionListener(this);	
	Mess_Staff_info.addActionListener(this);
	Mess_info.addActionListener(this);	
	Fee_info.addActionListener(this);	
	Room_info.addActionListener(this);	
	    
        Img_Background.add(Regis_Std);
	Img_Background.add(Remove_Std);
	Img_Background.add(Search_Std);
	Img_Background.add(Upd_Std);
	
		
	Img_Background.add(hostel_data);
	Img_Background.add(Mess_Staff_info);
	Img_Background.add(Mess_info);
	Img_Background.add(Fee_info);
	Img_Background.add(Room_info);
		
        Img_Background.add(Heading);
	Img_Background.setBounds(0,0,1200,700);
	add(Img_Background);
		 

	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setResizable(false);
	
    }
	
    public void actionPerformed(ActionEvent ae)
    {
        try
	{
            if(ae.getSource()==Regis_Std)
            {
		new Reg_Std();
                setVisible(false);

            }
            else if(ae.getSource()==Remove_Std)
            {
                new RemoveData(); // Csalling the Registration page of Faculty
                dispose(); //this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==Search_Std)
            {
                new Search_Student_Data(); // Calling the Registration page of Faculty
		dispose();// this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==Upd_Std)
            {
                new Search_For_Update(); // Calling the Registration page of Faculty
                dispose(); //this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==hostel_data)
            {
                new Hostel_Data(); // Calling the Registration page of Faculty
                dispose(); //this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==Mess_Staff_info)
            {
                new Mess_Staff(); // Calling the Registration page of Faculty
		dispose(); //this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==Mess_info)
            {
                new Mess(); // Calling the Registration page of Faculty
		dispose(); //this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==Fee_info)
            {
                new Fees_Info(); // Calling the Registration page of Faculty
		dispose(); //this is used to run currently page and dispose opened page
            }
            else if(ae.getSource()==Room_info)
            {
                new Room_Info(); // Calling the Registration page of Faculty
		dispose(); //this is used to run currently page and dispose opened page
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex.getMessage());
        }
    }
    public static void main(String args[])
    {
        new ManiClass();
    }
}