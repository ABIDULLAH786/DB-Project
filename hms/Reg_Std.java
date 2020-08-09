//Stduent Registration
package hms;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;


public class Reg_Std extends DATA implements ActionListener 
{
    public static java.util.Date StringToDate(String dob) throws ParseException 
    {
        //Instantiating the SimpleDateFormat class
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        //Parsing the given String to Date object
        java.util.Date date = formatter.parse(dob);
        return date;
    }
    JFrame frame;
    public Reg_Std() 
    {
        fH = new Font("Serif", Font.BOLD, 20);
        frame = new JFrame("WELCOME TO STUDENT REGISTRATION");
        frame.setSize(1200, 700);
        frame.setLayout(null);

        Submit = new JButton("Submit");
	Submit.setBounds(645,600,100,40);
        Back = new JButton("Go Back");
	Back.setBounds(500,600,100,40);	

        // Heading
        Heading = new JPanel();
        Heading.setBackground(new Color(0, 0, 0, 80));
        Heading.setBounds(0, 0, 1200, 70);

        // Name_Heading
        Name_Heading = new JLabel(" STUDENT REGISTRATION PAGE ");
        Name_Heading.setBounds(100, 500, 400, 100);
        Name_Heading.setFont(fH);

        // Background Img
        background = new ImageIcon(ClassLoader.getSystemResource("hms/HostelPic1.jpg"));
        img = new JLabel("", background, JLabel.CENTER);
        img.setBounds(0, 0, 1200, 700);
        // JTextField 
        TF_student_name = new JTextField(20);
        TF_student_name.setBounds(470, 70, 300, 30);

        TF_student_father_name = new JTextField(20);
        TF_student_father_name.setBounds(470, 120, 300, 30);

        TF_student_id = new JTextField(20);
        TF_student_id.setBounds(470, 170, 300, 30);

        TF_hostel_id = new JTextField(20);
        TF_hostel_id.setBounds(470, 220, 300, 30);

        TF_room_id = new JTextField(20);
        TF_room_id.setBounds(470, 270, 300, 30);
        img.add(TF_room_id);

        TF_student_DOB = new JTextField(20);
        TF_student_DOB.setBounds(470, 320, 300, 30);


        TF_department = new JTextField(20);
        TF_department.setBounds(470, 370, 300, 30);

        // Male or Femal Button
        Male = new JRadioButton("MALE");
        Male.setBounds(535, 420, 60, 25);
        Female = new JRadioButton("FEMALE");
        Female.setBounds(620, 420, 70, 25);
        Male.addActionListener(this);
        Female.addActionListener(this);

        TF_cell_no = new JTextField(20);
        TF_cell_no.setBounds(470, 470, 300, 30);
        img.add(TF_cell_no);

        TF_address = new JTextField(20);
        TF_address.setBounds(470, 520, 300, 30);
        img.add(TF_address);

        // Adding 
        Lb_student_name.setBounds(280, 70, 300, 30);
        Lb_student_name.setFont(fH);
        img.add(Lb_student_name);
        img.add(TF_student_name);

        Lb_student_father_name.setBounds(280, 120, 300, 30);
        Lb_student_father_name.setFont(fH);
        img.add(Lb_student_father_name);
        img.add(TF_student_father_name);

        Lb_student_id.setBounds(280, 170, 300, 30);
        Lb_student_id.setFont(fH);
        img.add(Lb_student_id);
        img.add(TF_student_id);

        Lb_hostel_id.setBounds(280, 220, 300, 30);
        Lb_hostel_id.setFont(fH);
        img.add(Lb_hostel_id);
        img.add(TF_hostel_id);

        Lb_room_id.setBounds(280, 270, 300, 30);
        Lb_room_id.setFont(fH);

        Lb_student_DOB.setBounds(280, 320, 300, 30);
        Lb_student_DOB.setFont(fH);
        img.add(Lb_student_DOB);
        img.add(TF_student_DOB);


        Lb_department.setBounds(280, 370, 300, 30);
        Lb_department.setFont(fH);
        img.add(Lb_department);
        img.add(TF_department);

        lb_Gender.setBounds(280, 420, 300, 30);
        lb_Gender.setFont(fH);

        Lb_cell_no.setBounds(280, 470, 300, 30);
        Lb_cell_no.setFont(fH);
        img.add(Lb_cell_no);

        Lb_address.setBounds(280, 520, 300, 30);
        Lb_address.setFont(fH);
        img.add(Lb_address);

        img.add(lb_Gender);
        img.add(Lb_room_id);
        img.add(Heading);
        //img.add(Regis_page);

        Submit.addActionListener(this);
        img.add(Submit);
        Back.addActionListener(this);
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
        if (ae.getSource() == Submit) 
        {
            try 
            {
                Connection con;
		Class.forName("com.mysql.jdbc.Driver");	
		String url = "jdbc:mysql://localhost:3306/hms?characterEncoding=latin1&useConfigs=maxPerformance";
		con = DriverManager.getConnection(url,"root","pakistani12");
                
                //String query1 = "Insert into Student(student_id,student_name,student_father_name,department,address,cell_no,student_age,student_DOB,hostel_id,room_id,gender)  values('"+TF_student_id.getText().toString()+"','"+TF_student_name.getText()+"','"+TF_student_father_name.getText()+"','"+TF_department.getText()+"','"+TF_address.getText()+"','"+TF_cell_no.getText().toString()+"','"+TF_student_age.getText()+"','"+TF_student_DOB.getText().toString()+"','"+TF_hostel_id.getText().toString()+"','"+TF_room_id.getText().toString()+"','"+GENDER+"')";

                String query = "Insert into student(student_id, student_name, student_father_name, department, address, cell_no, student_DOB, hostel_id, room_id, gender) values (?,?,?,?,?,?,?,?,?,?)";
                PreparedStatement ps = con.prepareStatement(query);

                ps.setString(1,TF_student_id.getText());
                ps.setString(2,TF_student_name.getText());
                ps.setString(3,TF_student_father_name.getText());
                ps.setString(4,TF_department.getText());
                ps.setString(5,TF_address.getText());
                ps.setString(6,TF_cell_no.getText());
                
                String StringDate = TF_student_DOB.getText().toString();
                java.util.Date date = Reg_Std.StringToDate(StringDate);
                java.sql.Date sDate = new java.sql.Date(date.getTime());
                ps.setDate(7,sDate);
                
                
                
                ps.setInt(8,Integer.parseInt(TF_hostel_id.getText()));
                ps.setInt(9,Integer.parseInt(TF_room_id.getText()));
                if (Male.isSelected()) 
                {
                    ps.setString(10,"Male");
                } 
                else if (Female.isSelected()) 
                {
                    ps.setString(10,"Female");
                }
                
                int affected = ps.executeUpdate();

                if(affected > 0) 
                {
                    JOptionPane.showMessageDialog(null, "Successfully Registered");
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Sorry The Registeration is Failed!");
                    TF_student_name.setText("");
                    TF_student_father_name.setText("");
                    TF_student_id.setText("");
                    TF_hostel_id.setText("");
                    TF_department.setText("");
                    TF_student_DOB.setText("");
                    TF_room_id.setText("");
                    TF_cell_no.setText("");
                    TF_address.setText("");
                }
                con.close();

            } catch (Exception err) {
                System.out.println("Error:" + err.getMessage());
            }

        }
        else if(ae.getSource()==Back)
        {
            new ManiClass();
            frame.dispose(); //this is used to run currently page and dispose opened page
        }
    }

}

class DATA {

    Font fH;
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

    JRadioButton Male;
    JRadioButton Female;

    JTextField TF_student_name;
    JTextField TF_student_father_name;
    JTextField TF_student_id;
    JTextField TF_hostel_id;
    JTextField TF_department;
    JTextField TF_student_DOB;
    JTextField TF_room_id;
    JTextField TF_cell_no;
    JTextField TF_address;

    JButton Submit;
    JButton Back;
    JLabel img;
    ImageIcon background;
    JPanel Heading;
    JLabel Name_Heading;

}
