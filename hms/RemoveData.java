package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

class RemoveData extends Data_Variable implements ActionListener {

    String SearchID;
    static JFrame frame;

    RemoveData() 
    {
        // JFrame
        frame = new JFrame();
        frame.setSize(1200, 700);
        frame.setLayout(null);
        frame.setVisible(true);

        // Heading and Name_Heading
        Heading = new JPanel();
        Heading.setBackground(new Color(0, 0, 0, 80));
        Heading.setBounds(0, 0, 1200, 100);

        fH = new Font("Serif", Font.BOLD, 20);
        Name_Head = new JLabel("REMOVE DATA FROM DATA");
        Name_Head.setBounds(200, 50, 300, 50);
        Name_Head.setFont(fH);
        Heading.add(Name_Head);

        // Background Image
        background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic.jpg"));
        Image temp_Img_Background1 = background.getImage();
        Image temp_Img_Background2 = temp_Img_Background1.getScaledInstance(1200, 700, Image.SCALE_SMOOTH);
        background = new ImageIcon(temp_Img_Background2);
        Img_Background = new JLabel("", background, JLabel.CENTER);

        // Declaring the varibale
        IDForRemove = new JTextField();
        IDForRemove.setBounds(180, 250, 130, 25);

        lb_IDRemove = new JLabel("SEARCH ID:");
        lb_IDRemove.setBounds(60, 245, 130, 30);
        lb_IDRemove.setFont(fH);


        // Removal And Back Buttons
        fH = new Font("Serif", Font.BOLD, 15);
        Remove_std = new JButton("Remove");
        Remove_std.setBounds(200, 300, 90, 30);
        Remove_std.setFont(fH);

        Back = new JButton("Go Back");
        Back.setBounds(70, 300, 120, 30);
        Back.setFont(fH);

        Remove_std.addActionListener(this);
        Back.addActionListener(this);

        // Adding Labels and Buttons as well as JTextField
        Img_Background.add(IDForRemove);
        Img_Background.add(lb_IDRemove);
        Img_Background.add(Heading);
        Img_Background.add(Remove_std);
        Img_Background.add(Back);

        Img_Background.setBounds(0, 0, 1200, 700);
        frame.add(Img_Background);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public void actionPerformed(ActionEvent ae) {

        try {
           Connection con;
		Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
		con = DriverManager.getConnection(url,"root","pakistani12");
                Statement stmt = con.createStatement();
                ResultSet rs;

            if (ae.getSource() == Remove_std) {
                try {
                    SearchID = IDForRemove.getText().toString();
                    String sql = "delete from student where student_id="+"'"+SearchID+"'";
                    int ifDeleted=0;

                    rs = stmt.executeQuery("Select * From student");
                    int i=0;
                    boolean ignore=true;
                    while (rs.next()) 
                    {
                        i++;
                        if(rs.getString(1).equalsIgnoreCase(SearchID))
                        {   ignore= false;
                            
                            new DataToDisplay(rs,true,false);
                            ifDeleted = stmt.executeUpdate(sql);
                            frame.setVisible(false);
                            break;
                        }
                  }
                    if(ignore)
                    {                           
                            JOptionPane.showMessageDialog(null, "Search Data Not Found");
                    }
                    //Noew the problem has been solved !
                    
                } catch (Exception ar) {
                    System.out.println("In Exception");
                    System.out.println("ERROR : " + ar);
                } finally {
                    try {

                        System.out.println("In finally");
                       
                        con.close();
                    } catch (Exception err) {
                        System.out.println("in inner catch");
                        System.out.println("ERROR : " + err);
                    }

                }
            } 
            else if (ae.getSource() == Back) 
            {
                new ManiClass();
                frame.dispose(); //this is used to run currently page and dispose opened page
            }
        } 
        catch (Exception ex) 
        {
            JOptionPane.showMessageDialog(null, ex);
            System.out.println("Error: " + ex);
        }

    }

}

class Data_Variable 
{
    // Varibale for to display which cancelling the specific data 
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
    
    JLabel Lb_hostel_id = new JLabel("HOSTEL ID:");
    JLabel Lb_student_name = new JLabel("CANDIDATE NAME:");
    JLabel Lb_student_father_name = new JLabel("FATHER NAME:");
    JLabel Lb_student_id = new JLabel("STUDENT ID:");
    JLabel Lb_department = new JLabel("DEPARTMENT:");
    JLabel Lb_student_DOB = new JLabel("DATE OF BIRTH:");
    JLabel lb_Gender = new JLabel("GENDER:");
    JLabel Lb_room_id = new JLabel("ROOM ID:");
    JLabel Lb_cell_no = new JLabel("CELL NO:");
    JLabel Lb_address = new JLabel("ADDRESS:");

    // Decalaring Variable
    JLabel Img_Background;
    JLabel Name_Head;
    Font fH;
    ImageIcon background;
    JButton Remove_std;
    JButton Back;
    JButton Confirm_yes;
    JButton Confirm_No;
    JTextField Confirm_tf;

    JPanel Heading;

    JTextField IDForRemove;
    JLabel lb_IDRemove;


}
