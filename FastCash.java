import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{

        JButton deposit, withdrawl, fastCash, miniStatement, pinChange, balanceEnquiry, exit;
        String pin ;
        FastCash(String pin){
        
        setLayout(null);
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);   
        ImageIcon i3 = new ImageIcon(i2); 
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("Raleway", Font.BOLD, 16));

        text.setForeground(Color.WHITE);
        image.add(text);

        deposit = new JButton("10,000 vnd ");
        deposit.setBounds(170,415, 150, 30);
        deposit.addActionListener(this);
        image.add(deposit);

        withdrawl = new JButton("20,000 vnd ");
        withdrawl.setBounds(355,415, 150, 30);
        withdrawl.addActionListener(this);
        image.add(withdrawl);

        fastCash = new JButton("50,000 vnd ");
        fastCash.setBounds(170,450, 150, 30);
        fastCash.addActionListener(this);
        image.add(fastCash);
        
        miniStatement = new JButton("100,000  vnd");
        miniStatement.setBounds(355,450, 150, 30);
        miniStatement.addActionListener(this);
        image.add(miniStatement);

        pinChange = new JButton("200,000  vnd");
        pinChange.setBounds(170,485, 150, 30);
        pinChange.addActionListener(this);
        image.add(pinChange);
        
        balanceEnquiry = new JButton("500,000  vnd");
        balanceEnquiry.setBounds(355,485, 150, 30);
        balanceEnquiry.addActionListener(this);
        image.add(balanceEnquiry);

        exit = new JButton("BACK");
        exit.setBounds(260,520, 150, 30);
        exit.addActionListener(this);
        image.add(exit);

        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        setUndecorated(true);
    }

    public  void actionPerformed(ActionEvent ae){
        if(ae.getSource() == exit){
           setVisible(false);
              new Transactions(pin).setVisible(true);
        } else {
           String amount = ((JButton) ae.getSource()).getText().replaceAll("[^0-9]", "");
           conn c = new conn();
           try {
                ResultSet  rs = c.s.executeQuery("select * from bank where pin = '"+pin+"'");
                int balance = 0;
                while (rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance += Integer.parseInt(rs.getString("amount"));
                    } else {
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                }
                if(ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                    JOptionPane.showMessageDialog(null, "Insuffient Balance");
                    return;
                }
                
                Date date = new Date();
                String query = "insert into bank values('"+pin+"', '"+date+"', 'Withdrawl', '"+amount+"')";
                c.s.executeUpdate(query);
                JOptionPane.showMessageDialog(null, "VND "+amount+" Debited Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);


           }catch(Exception e){
               System.out.println(e);
           }
        }
    }
    public static void main(String[] args) {
        new FastCash("");
    }
}
