import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupThree extends JFrame implements ActionListener {
    
    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton submit, cancel;
    String formno;
    
    SignupThree(String formno) {
        this.formno = formno;
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);

        JLabel l1 = new JLabel("Page 3: Account Details");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel type = new JLabel("Account Type");
        type.setFont(new Font("Raleway", Font.BOLD, 22));
        type.setBounds(100, 140, 200, 30);
        add(type);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(Color.WHITE);
        r1.setBounds(100, 180, 200, 20);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(Color.WHITE);
        r2.setBounds(350, 180, 250, 20);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(Color.WHITE);
        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(Color.WHITE);
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        ButtonGroup group1 = new ButtonGroup();
        group1.add(r1);
        group1.add(r2);
        group1.add(r3);
        group1.add(r4);

        JLabel card = new JLabel("Card Number:");
        card.setFont(new Font("Raleway", Font.BOLD, 22));
        card.setBounds(100, 300, 200, 30);
        add(card);

        JLabel number = new JLabel("XXXX-XXXX-XXXX-4184");
        number.setFont(new Font("Raleway", Font.BOLD, 22));
        number.setBounds(330, 300, 300, 30);
        add(number);

        JLabel carddetail = new JLabel("Your 16-digit Card number");
        carddetail.setFont(new Font("Raleway", Font.BOLD, 12));
        carddetail.setBounds(100, 330, 300, 20);
        add(carddetail);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Raleway", Font.BOLD, 22));
        pin.setBounds(100, 370, 200, 30);
        add(pin);

        JLabel pnumber = new JLabel("XXXX");
        pnumber.setFont(new Font("Raleway", Font.BOLD, 22));
        pnumber.setBounds(330, 370, 300, 30);
        add(pnumber);

        JLabel pindetail = new JLabel("Your 4-digit PIN");
        pindetail.setFont(new Font("Raleway", Font.BOLD, 12));
        pindetail.setBounds(100, 400, 300, 20);
        add(pindetail);

        JLabel service = new JLabel("Service Required:");
        service.setFont(new Font("Raleway", Font.BOLD, 22));
        service.setBounds(100, 450, 200, 30);
        add(service);
        
        c1 = new JCheckBox("ATM CARD");
        c1.setFont(new Font("Raleway", Font.BOLD, 16));
        c1.setBackground(Color.WHITE);
        c1.setBounds(100, 500, 200, 20);
        add(c1);

        c2 = new JCheckBox("Internet Banking");
        c2.setFont(new Font("Raleway", Font.BOLD, 16));
        c2.setBackground(Color.WHITE);
        c2.setBounds(350, 500, 200, 20);
        add(c2);

        c3 = new JCheckBox("Mobile Banking");
        c3.setFont(new Font("Raleway", Font.BOLD, 16));
        c3.setBackground(Color.WHITE);
        c3.setBounds(100, 550, 200, 20);
        add(c3);

        c4 = new JCheckBox("Email & SMS Alerts");
        c4.setFont(new Font("Raleway", Font.BOLD, 16));
        c4.setBackground(Color.WHITE);
        c4.setBounds(350, 550, 200, 20);
        add(c4);

        c5 = new JCheckBox("Cheque Book");
        c5.setFont(new Font("Raleway", Font.BOLD, 16));
        c5.setBackground(Color.WHITE);
        c5.setBounds(100, 600, 200, 20);
        add(c5);

        c6 = new JCheckBox("E-Statement");
        c6.setFont(new Font("Raleway", Font.BOLD, 16));
        c6.setBackground(Color.WHITE);
        c6.setBounds(350, 600, 200, 20);
        add(c6);

        c7 = new JCheckBox("I hereby declare that the above entered details correct to th best of my knowledge.", true);
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(Color.WHITE);
        c7.setBounds(100, 650, 600, 20);
        add(c7);
        
        submit = new JButton("Submit");
        submit.setFont(new Font("Raleway", Font.BOLD, 14));
        submit.setBackground(Color.BLACK);
        submit.setForeground(Color.WHITE);
        submit.setBounds(250, 700, 100, 30);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        cancel.setBackground(Color.BLACK);
        cancel.setForeground(Color.WHITE);
        cancel.addActionListener(this);
        cancel.setBounds(420, 700, 100, 30);
        
        add(cancel);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 820);
        setLocation(350, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) { // Changed from ActiveEvent to ActionEvent
        if (ae.getSource() == submit) {
            String acctype = null;
            if (r1.isSelected()) {
                acctype = "Saving Account";
            } else if (r2.isSelected()) {
                acctype = "Fixed Deposit Account";
            } else if (r3.isSelected()) {
                acctype = "Current Account";
            } else if (r4.isSelected()) {
                acctype = "Recurring Deposit Account";
            }

            Random ran = new Random();
            // Fix the random.nextLong() calls to ran.nextLong()
            String cardnumber = "" + Math.abs((ran.nextLong() % 90000000L) + 5040936000000000L);
            String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);
            
            // Fix checkbox logic to concatenate all selected services
            String facility = "";
            if (c1.isSelected()) {
                facility = facility + "ATM Card,";
            }
            if (c2.isSelected()) { // Changed from else if to if to allow multiple selections
                facility = facility + "Internet Banking,";
            }
            if (c3.isSelected()) {
                facility = facility + "Mobile Banking,";
            }
            if (c4.isSelected()) {
                facility = facility + "Email & SMS Alerts,";
            }
            if (c5.isSelected()) {
                facility = facility + "Cheque Book,";
            }
            if (c6.isSelected()) {
                facility = facility + "E-Statement,";
            }
            
            try {
                if (acctype == null) { // Changed from accType to acctype
                    JOptionPane.showMessageDialog(null, "Account Type is Required");
                } else {
                    conn c = new conn();
                    String query1 = "insert into signup3 values('" + formno + "','" + acctype + "','" + cardnumber + "','" + pin + "','" + facility + "')";
                    String query2 = "insert into login values('" + formno + "','" +cardnumber + "','" + pin +"')";
                    c.s.executeUpdate(query1);
                    c.s.executeUpdate(query2);

                   
                    JOptionPane.showMessageDialog(null, "Card Number: " + cardnumber + "\nPin: " + pin);
                    setVisible(false);
                    new Deposit(pin).setVisible(false);
                }
            } catch (Exception e) { // Fixed catch syntax
                System.out.println(e);
            }
        } else if (ae.getSource() == cancel) {
            setVisible(false);
            new Login().setVisible(true);
            
        }
    }
    
    public static void main(String[] args) {
        new SignupThree("");
    }
}
