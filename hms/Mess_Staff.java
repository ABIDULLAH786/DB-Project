//DELETE FACULTY 
package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Mess_Staff implements ActionListener
{
    Font fH;
    JFrame frame;
    JLabel Lb_emp_name = new JLabel("Employee NAME:");//1
    //JLabel Lb_emp_designation = new JLabel("Emp Designation:");//2
    JLabel Lb_emp_id= new JLabel("ID NO:");//3
    JLabel Lb_hostel_id= new JLabel("Hostel ID:");//4
    //JLabel Lb_mess_incharge_Id= new JLabel("Mess Incha_ID:");//5
    JLabel Lb_emp_salary= new JLabel("Salary:");//6
    JLabel Lb_emp_cellno= new JLabel("Cell No:");//7
    JLabel Lb_Gender  = new JLabel("GENDER:") ;//8
    JLabel Lb_emp_address = new JLabel("Address:");//9

    JRadioButton Male;
    JRadioButton Female;
    JTextField TF_emp_name;//1
    //JTextField TF_emp_designation;//2
    JTextField TF_emp_id;//3
    JTextField TF_hostel_id;//4
    //JTextField TF_mess_incharge_Id;//5
    JTextField TF_emp_salary;//6
    JTextField TF_emp_cellno;//7
    JTextField TF_emp_address; //9

    JButton Submit;
    JButton Back;
    
    JLabel img;
    ImageIcon background;
    JPanel Heading;
    JLabel Name_Heading;
    
    public Mess_Staff()
    {
        fH = new Font("Serif",Font.BOLD,20);
        frame = new JFrame("WELCOME TO Mess Staff");
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
        Name_Heading = new JLabel(" Mess Staff");
        Name_Heading.setBounds(100,500,400,100);
        Name_Heading.setFont(fH);
        
	// Background Img
        background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic1.jpg"));
        img = new JLabel("",background,JLabel.CENTER);
        
        img.setBounds(0,0,1200,700);
        
	// JTextField 
        TF_emp_name = new JTextField(20);
        TF_emp_name.setBounds(470,150,300,30);
		
	//TF_emp_designation = new JTextField(20);
        //TF_emp_designation.setBounds(470,200,300,30);	

	TF_emp_id = new JTextField(20);
        TF_emp_id.setBounds(470,250,300,30);	

	TF_hostel_id = new JTextField(20);
        TF_hostel_id.setBounds(470,300,300,30);	

	//TF_mess_incharge_Id = new JTextField(20);
        //TF_mess_incharge_Id.setBounds(470,350,300,30);	

	TF_emp_salary = new JTextField(20);
        TF_emp_salary.setBounds(470,400,300,30);	

	TF_emp_cellno = new JTextField(20);
        TF_emp_cellno.setBounds(470,450,300,30);	
		
        TF_emp_address = new JTextField(20);
        TF_emp_address.setBounds(470,550,300,30);	
	img.add(TF_emp_address);
		
	// Male or Femal Button
	Male = new JRadioButton("MALE");
        Male.setBounds(535,500,60,25);
        
        Female = new JRadioButton("FEMALE");
        Female.setBounds(620,500,70,25);		
			
	
	Male.addActionListener(this);
	Female.addActionListener(this);
		
	
	// Adding 
    	Lb_emp_name.setBounds(280,145,300,30);
	Lb_emp_name.setFont(fH);
	img.add(Lb_emp_name);
	img.add(TF_emp_name);
		
//	Lb_emp_designation.setBounds(280,200,300,30);
//	Lb_emp_designation.setFont(fH);
//	img.add(Lb_emp_designation);
//	img.add(TF_emp_designation);
		
		
	Lb_emp_id.setBounds(280,245,300,30);
        Lb_emp_id.setFont(fH);
	img.add(Lb_emp_id);
	img.add(TF_emp_id);
		
	Lb_hostel_id.setBounds(280,300,300,30);
	Lb_hostel_id.setFont(fH);
	img.add(Lb_hostel_id);
	img.add(TF_hostel_id);
        
//        Lb_mess_incharge_Id.setBounds(280,345,300,30);
//        Lb_mess_incharge_Id.setFont(fH);
//        img.add(Lb_mess_incharge_Id);
//        img.add(TF_mess_incharge_Id);
        
        Lb_emp_salary.setBounds(280,400,300,30);
        Lb_emp_salary.setFont(fH);
        img.add(Lb_emp_salary);
        img.add(TF_emp_salary);
        
        Lb_emp_cellno.setBounds(280,445,300,30);
        Lb_emp_cellno.setFont(fH);
        
        Lb_Gender.setBounds(280,490,300,30);
        Lb_Gender.setFont(fH);
        
        Lb_emp_address.setBounds(280,540,300,30);
        Lb_emp_address.setFont(fH);
        
        img.add(Lb_emp_cellno);
        img.add(TF_emp_cellno);
        img.add(Lb_Gender);
        img.add(Lb_emp_address);
        img.add(Heading);
	
        //img.add(Regis_page);
        Submit.addActionListener(this);
        Back.addActionListener(this);

        img.add(Submit);
        img.add(Back);
        
        Heading.add(Name_Heading);
        img.add(Male);
        img.add(Female);

        frame.add(img);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
        frame.setResizable(false);
    }
    
    public void actionPerformed(ActionEvent ae)
    {
        if(ae.getSource()==Submit)
        {
            String GENDER=null;
            
            try
            {
                if(Male.isSelected())
                {
                    GENDER="Male";
                }
                else if(Female.isSelected())
                {
                    GENDER="Female";
                }
                
                Connection con;
                Statement stmt;
                ResultSet re;
                Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
		String date = TF_emp_salary.getText().toString();
                con = DriverManager.getConnection(url,"root","pakistani12");
		//stmt = con.createStatement();
		
                String query = "Insert into staff (emp_id,emp_name,emp_address,emp_salary,emp_cellno,hostel_id,emp_gender) values (?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                System.out.println("Data 1");
                ps.setString(1,TF_emp_id.getText());
                System.out.println("Data 2");
                ps.setString(2,TF_emp_name.getText());
                System.out.println("Data 3");
                ps.setString(3,TF_emp_address.getText());
                System.out.println("Data 4");
                ps.setDouble(4,Double.parseDouble(TF_emp_salary.getText()));
                System.out.println("Data 5");
                ps.setString(5,TF_emp_cellno.getText());
                System.out.println("Data 6");
                ps.setInt(6,Integer.parseInt(TF_hostel_id.getText()));
                System.out.println("Data 7");

                if (Male.isSelected()) 
                {
                    ps.setString(7,"Male");
                } 
                else if (Female.isSelected()) 
                {
                    ps.setString(7,"Female");
                }
                System.out.println("After Data 7");

                int affected =ps.executeUpdate();
                
                if(affected>0)
                {
                    JOptionPane.showMessageDialog(null,"Data Added Successfully");
                }
                else
                    JOptionPane.showMessageDialog(null,"Data didn't Added Successfully");
                
            }
            catch(Exception err)
            {
                JOptionPane.showMessageDialog(null,"ERROR : "+ err.getMessage());
            }
        }
        else if(ae.getSource()==Back)
        {
            new ManiClass();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }
}
