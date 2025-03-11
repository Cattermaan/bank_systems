import javax.swing.*;
import java.awt.*;
import java.util.*;
import com.toedter.calendar.JDateChooser;
import java.awt.event.*;

public class SignupOne extends JFrame implements  ActionListener {
   
   long random;
    JTextField nameField, fnameField,EmField, Address, Cityy, Statee, Pintext;
    JButton next;
    JRadioButton male , female , other , married , unmarried;
    JDateChooser dateChooser;
    SignupOne(){
        setLayout(null);
        
        Random ran = new Random();
        random = Math.abs(ran.nextLong() % 9000L) + 1000L;

        JLabel formno = new JLabel("APPLICATION FORM NO. " + random);
        formno.setFont(new Font("Raleway", Font.BOLD, 38));
        formno.setBounds(140, 20, 600, 40);
        add(formno);

        JLabel personDetails = new JLabel("Personal Details");
        personDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personDetails.setBounds(290, 80, 400, 30);
        add(personDetails);

        JLabel name = new JLabel("Name:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);
        
        nameField = new JTextField();
        nameField.setFont(new Font("Raleway", Font.BOLD, 14));
        nameField.setBounds(300, 140, 400, 30);
        add(nameField);


        JLabel fname = new JLabel("Father's Name:");
        fname.setFont(new Font("Raleway", Font.BOLD, 20));
        fname.setBounds(100, 190, 200, 30);
        add(fname);

        fnameField = new JTextField();
        fnameField.setFont(new Font("Raleway", Font.BOLD, 14));
        fnameField.setBounds(300, 190, 400, 30);
        add(fnameField);

        JLabel dob = new JLabel("Date Of Birth:");
        dob.setFont(new Font("Raleway", Font.BOLD, 20));
        dob.setBounds(100, 240, 200, 30);
        add(dob);

        dateChooser = new JDateChooser();
        dateChooser.setBounds(300, 240, 400, 30);
        dateChooser.setForeground(new Color(150, 150, 150));
        add(dateChooser);


        JLabel gender = new JLabel("Gender:");
        gender.setFont(new Font("Raleway", Font.BOLD, 20));
        gender.setBounds(100, 290, 200, 30);
        add(gender);

        male = new JRadioButton("Male");
        male.setBounds(300,290,60,30);
        male.setBackground(Color.WHITE);
        add(male);

        female = new JRadioButton("Female");
        female.setBounds(450,290,90,30);
        female.setBackground(Color.WHITE);
        add(female);

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(male);
        groupgender.add(female);


        JLabel email = new JLabel("Email:");
        email.setFont(new Font("Raleway", Font.BOLD, 20));
        email.setBounds(100, 340, 200, 30);
        add(email);

        EmField = new JTextField();
        EmField.setFont(new Font("Raleway", Font.BOLD, 14));
        EmField.setBounds(300, 340, 400, 30);
        add(EmField);


        JLabel maritl = new JLabel("Marital Status:");
        maritl.setFont(new Font("Raleway", Font.BOLD, 20));
        maritl.setBounds(100, 390, 200, 30);
        add(maritl);

        married = new JRadioButton("Married");
        married.setBounds(300,390,100,30);
        married.setBackground(Color.WHITE);
        add(married);

        unmarried = new JRadioButton("Unmarried");
        unmarried.setBounds(450,390,100,30);
        unmarried.setBackground(Color.WHITE);
        add(unmarried);

        other = new JRadioButton("Other");
        other.setBounds(630,390,100,30);
        other.setBackground(Color.WHITE);
        add(other);

        ButtonGroup maritable = new ButtonGroup();
        maritable.add(married);
        maritable.add(unmarried);
        maritable.add(other);
        

        JLabel address = new JLabel("Address:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        Address = new JTextField();
        Address.setFont(new Font("Raleway", Font.BOLD, 14));
        Address.setBounds(300, 440, 400, 30);
        add(Address);

        JLabel city   = new JLabel("City:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);


        Cityy = new JTextField();
        Cityy.setFont(new Font("Raleway", Font.BOLD, 14));
        Cityy.setBounds(300, 490, 400, 30);
        add(Cityy);

        JLabel state= new JLabel("State:");
        state.setFont(new Font("Raleway", Font.BOLD, 20));
        state.setBounds(100, 540, 200, 30);
        add(state);

        Statee = new JTextField();
        Statee.setFont(new Font("Raleway", Font.BOLD, 14));
        Statee.setBounds(300, 540, 400, 30);
        add(Statee);

        JLabel pincode = new JLabel("Pin Code:");
        pincode.setFont(new Font("Raleway", Font.BOLD, 20));
        pincode.setBounds(100, 590, 200, 30);
        add(pincode);

        Pintext = new JTextField();
        Pintext.setFont(new Font("Raleway", Font.BOLD, 14));
        Pintext.setBounds(300, 590, 400, 30);
        add(Pintext);

        next = new JButton("Next");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setBounds(620, 640, 80, 30);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);
        setSize(850, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae){
        String formno = ""+random;
        String name = nameField.getText();
        String fname = fnameField.getText();
        String dob = ((JTextField)dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = null ;
        if (male.isSelected()){
            gender = "Male";
        }else if (female.isSelected()){
            gender = "Female";  
        }

        String email = EmField.getText();
        String marital = null;
        if (married.isSelected()){
            marital = "Married";
        }else if (unmarried.isSelected()){
            marital = "Unmarried";
        }else if (other.isSelected()){
            marital = "Other";
        }

        String address = Address.getText();
        String city = Cityy.getText();
        String state = Statee.getText();
        String pincode = Pintext.getText();
        try{
            if (name.equals("")){
                JOptionPane.showMessageDialog(null, "Name is Required");   
            }else {
                conn c = new conn();
                String query = "INSERT INTO signup VALUES ('" + formno + "','" + name + "','" + fname + "','" + dob + "','" 
                               + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + state + "','" 
                               + pincode + "')";

                // Thực thi truy vấn
                c.s.executeUpdate(query);

                setVisible(false);
                new SignupTwo(formno).setVisible(true);  

            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
        

    public static void main(String[] args) {
       new SignupOne();
    }
}
