///Search Faculty
package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
public class Mess implements ActionListener
{
    JFrame frame;
    Font fH;
    JLabel Lb_mess_incharge_Id= new JLabel("Mess Incha_ID:");//1 5
    JLabel Lb_cook_Id = new JLabel("Cook ID:");//2
    JLabel Lb_monthly_avg_expence = new JLabel("Monthy Avg Expence:");//2
    JLabel Lb_mess_bf_timing= new JLabel("mess_bf_timing:");//3
    JLabel Lb_mess_dinner_timing= new JLabel("mess_dinner_timing:");//4
    JLabel Lb_sunday_bf_timing = new JLabel("sunday_bf_timing:");//5 1

    JTextField TF_mess_incharge_Id;// 1
    JTextField TF_cook_Id;//
    JTextField TF_monthly_avg_expence;//
    JTextField TF_mess_bf_timing;//3
    JTextField TF_mess_dinner_timing;//4
    JTextField TF_sunday_bf_timing;//5  

    JButton Submit;
    JButton Back;

    JLabel img;
    ImageIcon background;
    JPanel Heading;
    JLabel Name_Heading;
    
    public Mess()
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
        Name_Heading = new JLabel(" Mess ");
        Name_Heading.setBounds(100,500,400,100);
        Name_Heading.setFont(fH);
        
        // Background Img
        background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic1.jpg"));
        img = new JLabel("",background,JLabel.CENTER);
        img.setBounds(0,0,1200,700);
        
        TF_mess_incharge_Id = new JTextField(20);
        TF_mess_incharge_Id.setBounds(470,150,300,30);
        
        TF_cook_Id = new JTextField(20);
        TF_cook_Id.setBounds(470,200,300,30);
        
        TF_monthly_avg_expence = new JTextField(20);
        TF_monthly_avg_expence.setBounds(470,250,300,30);
        
        TF_mess_bf_timing = new JTextField(20);
        TF_mess_bf_timing.setBounds(470,300,300,30);	

	TF_mess_dinner_timing = new JTextField(20);
        TF_mess_dinner_timing.setBounds(470,350,300,30);	

		
	TF_sunday_bf_timing = new JTextField(20);
        TF_sunday_bf_timing.setBounds(470,400,300,30);
				
	
        // Adding 
        
        Lb_mess_incharge_Id.setBounds(280,150,300,30);
        Lb_mess_incharge_Id.setFont(fH);
        img.add(Lb_mess_incharge_Id);
        img.add(TF_mess_incharge_Id);
        //Lb_cook_Id
        
        Lb_cook_Id.setBounds(280,200,300,30);
        Lb_cook_Id.setFont(fH);
        img.add(Lb_cook_Id);
        img.add(TF_cook_Id);
        
        Lb_monthly_avg_expence.setBounds(280,250,300,30);
        Lb_monthly_avg_expence.setFont(fH);
        img.add(Lb_monthly_avg_expence);
        img.add(TF_monthly_avg_expence);
        
        
        Lb_mess_bf_timing.setBounds(280,300,300,30);
        Lb_mess_bf_timing.setFont(fH);
        img.add(Lb_mess_bf_timing);
        img.add(TF_mess_bf_timing);
        
        Lb_mess_dinner_timing.setBounds(280,350,300,30);
        Lb_mess_dinner_timing.setFont(fH);
        img.add(Lb_mess_dinner_timing);
        img.add(TF_mess_dinner_timing);
        
    	Lb_sunday_bf_timing.setBounds(280,400,300,30);
        Lb_sunday_bf_timing.setFont(fH);
        img.add(Lb_sunday_bf_timing);
        img.add(TF_sunday_bf_timing);
        
        
        //............................

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
                
                String query = "Insert into mess(mess_incharge_Id,monthly_avg_expence,mess_bf_timing,mess_dinner_timing,sunday_bf_timing) values(?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);
                /*
                JTextField TF_mess_incharge_Id;// 1
    JTextField TF_monthly_avg_expence;//
    JTextField TF_mess_bf_timing;//3
    JTextField TF_mess_dinner_timing;//4
    JTextField TF_sunday_bf_timing;//5  
                */
                ps.setInt(1, Integer.parseInt(TF_mess_incharge_Id.getText()));
                ps.setInt(2, Integer.parseInt(TF_monthly_avg_expence.getText()));
                
                String BF_time = TF_mess_bf_timing.getText().toString();
                //Date utilDate = new SimpleDateFormat("hh:mm:ss").parse(time);
                java.sql.Time sql_BF_Time = new java.sql.Time(new SimpleDateFormat("hh:mm:ss").parse(BF_time).getTime()); 
                ps.setTime(3,sql_BF_Time);
                
                String D_time = TF_mess_dinner_timing.getText().toString();
                //Date utilDate = new SimpleDateFormat("hh:mm:ss").parse(time);
                java.sql.Time sql_D_Time = new java.sql.Time(new SimpleDateFormat("hh:mm:ss").parse(D_time).getTime()); 
                ps.setTime(4,sql_D_Time);
                
                String Sun_BF_time = TF_sunday_bf_timing.getText().toString();
                //Date utilDate = new SimpleDateFormat("hh:mm:ss").parse(time);
                java.sql.Time sql_Sun_BF_Time = new java.sql.Time(new SimpleDateFormat("hh:mm:ss").parse(Sun_BF_time).getTime()); 
                ps.setTime(4,sql_Sun_BF_Time);
                                
		int affected = ps.executeUpdate(query);
                
                if(affected>0)
                {
                    JOptionPane.showMessageDialog(frame, "The Mess Information Added successfully");

                }
                else
                    JOptionPane.showMessageDialog(frame, "The Mess Information Didn't Added successfully");

                
                con.close();
            }
            catch(Exception err)
            {
                System.out.println("Error:"+err.getMessage());
            }
            
        }
        else if(ae.getSource()==Back)
        {
            new ManiClass();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }
    public static void main(String args[])
    {
        new Mess();
    }
}
