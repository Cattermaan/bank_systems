import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener{
   JTextField amount;
   JButton deposit, back;
   String pin;
   
   Deposit(String pin){
        setLayout(null);
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("Please Enter Amount You Want To Deposit");
        text.setBounds(170,300,400,20);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        text.setForeground(Color.WHITE);
        image.add(text);

        amount = new JTextField();
        amount.setBounds(170,350,320,20);
        amount.setFont(new Font("Arial", Font.BOLD, 16));
        image.add(amount);

        deposit = new JButton("DEPOSIT");
        deposit.setBounds(355,485,150,30);
        deposit.addActionListener(this);
        image.add(deposit);

        back = new JButton("Back");
        back.setBounds(355,520,150,30);
        back.addActionListener(this);
        image.add(back);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == deposit){
            String number = amount.getText();
            Date date = new Date();
            if(number.equals("")){
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            } else {
                conn conn = new conn();
                try{
                    String query = "insert into bank values('"+pin+"', '"+date+"', 'Deposit', '"+number+"')";
                    conn.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null, number+" vnd Deposited Successfully");
                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                } catch(Exception e){
                    System.out.println(e);
                }
            }
        } else if (ae.getSource() == back){
            new Transactions(pin).setVisible(true);
            setVisible(false);
        }
    }
    
    public static void main(String[] args) {
        new Deposit(""); // Đây là nguyên nhân pin = ""
    }
}