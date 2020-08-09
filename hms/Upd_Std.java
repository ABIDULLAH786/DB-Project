package hms;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class Search_For_Update implements ActionListener
{
    JLabel Imge_Background;
    JLabel Heading_Name;
    Font fH;
    ImageIcon background;
    JButton butt_Seacrh;		
    JButton Back;		
    JPanel Heading;
	
	
    JTextField Tf_SearchID;
    JLabel lb_SearchID;
    static JFrame frame;
    String SearchID;
    Search_For_Update()
    {
        // JFrame
        frame = new JFrame();
	frame.setSize(1200,700);
	frame.setLayout(null);
	frame.setVisible(true);	

        // Heading and Heading_Name
	Heading = new JPanel();
	Heading.setBackground(new Color(0,0,0,80));
	Heading.setBounds(0,0,1200,100);
       
	fH = new Font("Serif",Font.BOLD,20);
	Heading_Name = new JLabel("SEARCH DATA FROM RECORDS");
	Heading_Name.setBounds(200,25,300,50);
	Heading_Name.setFont(fH);
        Heading_Name.setForeground(Color.white);
	Heading.add(Heading_Name);
        
		
	// Background Image
	background = new ImageIcon(ClassLoader.getSystemResource("hms/search.jpg"));
	Image temp_Imge_Background1 = background.getImage();
        Image temp_Imge_Background2 = temp_Imge_Background1.getScaledInstance(1200,700,Image.SCALE_SMOOTH);
	background = new ImageIcon(temp_Imge_Background2);
	Imge_Background = new JLabel("",background,JLabel.CENTER);		
		
	// Declaring the varibale
	Tf_SearchID = new JTextField();
	Tf_SearchID.setBounds(200,250,130,25);
		
	lb_SearchID= new JLabel("SEARCH ID:");
	lb_SearchID.setBounds(60,245,130,30);
	lb_SearchID.setFont(fH);
        lb_SearchID.setForeground(Color.white);
		
        // Search Button
	fH = new Font("Serif",Font.BOLD,15);
	butt_Seacrh = new JButton("Search Data");
	butt_Seacrh.setBounds(200,300,120,30);
	butt_Seacrh.setFont(fH);
        
        Back = new JButton("Go Back");
        Back.setBounds(70, 300, 120, 30);
        Back.setFont(fH);
		
	butt_Seacrh.addActionListener(this);
	Back.addActionListener(this);
		
	// Adding Labels and Buttons as well as JTextField
	Imge_Background.add(Tf_SearchID);
	Imge_Background.add(lb_SearchID);
	Imge_Background.add(Heading);
	Imge_Background.add(butt_Seacrh);
	Imge_Background.add(Back);
		
	Imge_Background.setBounds(0,0,1200,700);
	frame.add(Imge_Background);
			 
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setResizable(false);
    } 
    public void actionPerformed(ActionEvent ae)
    {
	try
	{
            Connection con;
            Statement  stmt;
            ResultSet  rs;

            Class.forName("com.mysql.jdbc.Driver");	
            String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
            con = DriverManager.getConnection(url,"root","pakistani12");
            stmt = con.createStatement();
			
            if(ae.getSource()==butt_Seacrh)
            {
                try
                {								
                    SearchID=Tf_SearchID.getText().toString();
                    String sql = "SELECT * from student where student_id="+"'"+SearchID+"'";
                    rs =stmt.executeQuery(sql);
                    boolean ignore=true;
                    while (rs.next()) 
                    {
                        ignore= false;
                        new DataToUpdate(rs,SearchID);
                        frame.dispose();
                    }
                    if(ignore)
                    {                           
                            JOptionPane.showMessageDialog(null, "Search Data Not Found");
                    }

                }
                catch(Exception ar)
                {
                    System.out.println("ERROR : "+ar.getMessage());
                }
                finally
                {
                    try
                    {
                        stmt.close();
                        con.close();
                    }
                    catch(Exception err)
                    {
                        System.out.println("ERROR : "+err);
                    }
                }
            }
            else if (ae.getSource() == Back) 
            {
                new ManiClass();
                frame.dispose(); //this is used to run currently page and dispose opened page
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ex);
        }
    }	
}
class DataToUpdate implements ActionListener
{
    JButton BackToMenu;
    JButton updateData;
    JTextField TF_student_name;
    JTextField TF_student_father_name;
    JTextField TF_student_id;
    JTextField TF_hostel_id;
    JTextField TF_department;
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
    JLabel lb_Gender;
    JLabel Lb_room_id;
    JLabel Lb_cell_no;
    JLabel Lb_address;

    Font FontStyle1;
    JFrame frame;
    String SearchID;
    DataToUpdate(ResultSet rs, String SearchID)
    {
        this.SearchID = SearchID;
        frame = new JFrame();
        
        DeleteInfo = new JLabel("The Following Data Ready to Update");
        Lb_hostel_id = new JLabel("HOSTEL ID:");
        Lb_student_name = new JLabel("CANDIDATE NAME:");
        Lb_student_father_name = new JLabel("FATHER NAME:");
        Lb_student_id = new JLabel("STUDENT ID:");
        Lb_department = new JLabel("DEPARTMENT:");
        lb_Gender = new JLabel("GENDER:");
        Lb_room_id = new JLabel("ROOM ID:");
        Lb_cell_no = new JLabel("CELL NO:");
        Lb_address = new JLabel("ADDRESS:");
        BackToMenu = new JButton("Go To Menu");
        updateData = new JButton("Update Data");
        try
        {
            TF_student_id = new JTextField(rs.getString(1));
            TF_student_name = new JTextField(rs.getString(2));
            TF_student_father_name = new JTextField(rs.getString(3));
            TF_department = new JTextField(rs.getString(4));
            TF_address = new JTextField(rs.getString(5));
            TF_cell_no = new JTextField(rs.getString(6));
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
        updateData.addActionListener(this);
        
        setLocationAndSize();
        addToFrame();
        addStyle();
                            
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
        TF_Gender.setBounds(300, 350, 200, 30);
        TF_hostel_id.setBounds(300, 400, 200, 30);
        TF_room_id.setBounds(300, 450, 200, 30);
        
        // setting Label....
        DeleteInfo.setBounds(120, 15, 450,30);
        
        Lb_student_id.setBounds(50, 50, 200, 30);
        Lb_student_name.setBounds(50, 100, 200, 30);
        Lb_student_father_name.setBounds(50, 150, 200, 30);
        Lb_department.setBounds(50, 200, 200, 30);
        Lb_address.setBounds(50, 250, 200, 30);
        Lb_cell_no.setBounds(50, 300, 200, 30);
        lb_Gender.setBounds(50, 350, 400, 30);
        Lb_hostel_id.setBounds(50, 400, 200, 30);
        Lb_room_id.setBounds(50, 450, 200, 30);       
        
        
        BackToMenu.setBounds(100, 590, 180, 30);
        updateData.setBounds(300, 590, 180, 30);
        
    
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
        frame.add(lb_Gender);
        frame.add(Lb_room_id);
        frame.add(Lb_hostel_id);
        
        // this TextField..........
        frame.add(TF_student_id);
        frame.add(TF_student_name);
        frame.add(TF_student_father_name);
        frame.add(TF_hostel_id);
        frame.add(TF_department);
        frame.add(TF_room_id);
        frame.add(TF_cell_no);
        frame.add(TF_address);
        frame.add(TF_Gender);
        frame.add(BackToMenu);
        frame.add(updateData);
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
        lb_Gender.setFont(FontStyle1);
        Lb_hostel_id.setFont(FontStyle1);
        Lb_room_id.setFont(FontStyle1);
        
        BackToMenu.setFont(FontStyle1);
        updateData.setFont(FontStyle1);


    }

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getSource() == BackToMenu) 
        {
                new ManiClass();
                frame.dispose(); //this is used to run currently page and dispose opened page
        }
        else if(e.getSource() == updateData)
        {
            try 
            {
                Connection con;
		Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
		con = DriverManager.getConnection(url,"root","pakistani12");
                String query = "Update student SET student_id="+"'"+TF_student_id.getText().toString()+"'"+",student_name="+"'"+TF_student_name.getText().toString()+"'"+", student_father_name="+"'"+TF_student_father_name.getText().toString()+"'"+",department="+"'"+TF_department.getText().toString()+"'"+",address="+"'"+TF_address.getText().toString()+"'"+",cell_no="+"'"+TF_cell_no.getText().toString()+"'"+",hostel_id="+"'"+Integer.parseInt(TF_hostel_id.getText())+"'"+",room_id="+"'"+Integer.parseInt(TF_room_id.getText())+"'"+",gender="+"'"+TF_Gender.getText().toString()+"' Where student_id="+"'"+SearchID+"'";
                PreparedStatement ps = con.prepareStatement(query);

                int affected = ps.executeUpdate(query);

                if(affected > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Data Successfully Updated");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Sorry The Data Update is Failed!");
                }
                con.close();

            } catch (Exception err) {
                System.out.println("Error:" + err.getMessage());
            }
        }
    }
}
