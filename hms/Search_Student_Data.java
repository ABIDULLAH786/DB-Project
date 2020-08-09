package hms;
import static hms.RemoveData.frame;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


class Search_Student_Data implements ActionListener
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
    Search_Student_Data()
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
	Heading.add(Heading_Name);
        Heading_Name.setForeground(Color.white);
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
                    System.out.println("ok5");
                    SearchID=Tf_SearchID.getText().toString();
                    String sql = "SELECT * from student where student_id="+"'"+SearchID+"'";
                    rs =stmt.executeQuery(sql);
                    boolean ignore=true;
                    while (rs.next()) 
                    {
                        ignore= false;
                        new DataToDisplay(rs,false,true);
                        frame.setVisible(false);
                    }
                    if(ignore)
                    {                           
                            JOptionPane.showMessageDialog(null, "Search Data Not Found");
                    }

                }
                catch(Exception ar)
                {
                    JOptionPane.showMessageDialog(null,"ERROR : "+ ar.getMessage());
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
                        JOptionPane.showMessageDialog(null,"ERROR : "+ err.getMessage());
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
            JOptionPane.showMessageDialog(null,"ERROR : "+ ex.getMessage());
        }
    }	
}
