import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public class Login extends JFrame implements ActionListener{
    
    JButton login , clear, signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    Login(){
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
        ImageIcon il = new ImageIcon(ClassLoader.getSystemResource("icons/logo.png"));
        Image i2 = il.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(70, 10, 100, 100);
        add(label);

        JLabel text = new JLabel("WELCOME TO ATM");
        text.setFont(new Font("Osward", Font.BOLD, 36));
        text.setBounds(180, 30, 500, 40);
        add(text);

        JLabel cardno = new JLabel("Card No.");
        cardno.setFont(new Font("Raleway", Font.BOLD, 24));
        cardno.setBounds(120, 120, 150, 40);
        add(cardno);

        cardTextField = new JTextField();
        cardTextField.setBounds(300, 120, 250, 30);
        add(cardTextField);

        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("Raleway", Font.BOLD, 24));
        pin.setBounds(120, 180, 100, 40);
        add(pin);

        pinTextField = new JPasswordField();  // Notice "pinTextField", not "pinTexField"
        pinTextField.setBounds(300, 180, 250, 30);
        add(pinTextField);

        login = new JButton("LOGIN");  // removed JButton
        login.setBounds(300, 260, 100, 35); 
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        clear = new JButton("CLEAR");  // removed JButton
        clear.setBounds(430, 260, 100, 35);
        clear.setBackground(Color.black);
        clear.setForeground(Color.white); 
        clear.addActionListener(this);
        add(clear);
 
        signup = new JButton("SIGN UP");  // removed JButton
        signup.setBounds(300, 310, 230, 35);
        signup.setBackground(Color.black);
        signup.setForeground(Color.white); 
        signup.addActionListener(this);
        add(signup);

        ImageIcon bgIcon = new ImageIcon(ClassLoader.getSystemResource("icons/background.jpg"));
        Image bgImg = bgIcon.getImage().getScaledInstance(800, 480, Image.SCALE_DEFAULT);
        ImageIcon scaledBg = new ImageIcon(bgImg);

        JLabel bgLabel = new JLabel(scaledBg);
        bgLabel.setBounds(0, 0, 800, 480);
        add(bgLabel);

        bgLabel.add(label);
        bgLabel.add(text);
        bgLabel.add(cardno);
        bgLabel.add(cardTextField);
        bgLabel.add(pin);
        bgLabel.add(pinTextField);
        bgLabel.add(login);
        bgLabel.add(clear);
        bgLabel.add(signup);

        getContentPane().setBackground(null);
        setSize(800,480);
        setVisible(true);
        setLocation(350,200);
    }

    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== clear){
            cardTextField.setText("");
            pinTextField.setText("");
        } else if(ae.getSource()== login){
            conn conn = new conn();
            String cardnumber = cardTextField.getText();
            String pin = new String(pinTextField.getPassword());
            String query = "select * from login where card_number = '"+cardnumber+"' and pin = '"+pin+"'";
            try {
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            } catch (Exception e) {
                System.out.println(e);
            }
        }else if (ae.getSource()== signup){
           setVisible(false);
           new SignupOne().setVisible(true);
        }    
    }
    public static void main(String[] args) {
        new Login();
    }

}