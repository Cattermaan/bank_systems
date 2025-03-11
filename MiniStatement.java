import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class MiniStatement extends JFrame {
    MiniStatement(String pin) {
        setTitle("Mini Statement");
        setLayout(null);

        JLabel mini = new JLabel();   
        mini.setFont(new Font("System", Font.PLAIN, 12));
        add(mini);

        JLabel bank = new JLabel("DK Bank");
        bank.setFont(new Font("System", Font.BOLD, 18));
        bank.setBounds(150, 20, 100, 20);
        add(bank);

        JLabel card = new JLabel();
        card.setFont(new Font("System", Font.BOLD, 14));
        card.setBounds(20, 80, 300, 20);
        add(card);

        JLabel balance = new JLabel();
        balance.setFont(new Font("System", Font.BOLD, 14));
        balance.setBounds(20, 400, 300, 20); 
        add(balance);

        try {
            conn conn = new conn();
            ResultSet rs = conn.s.executeQuery("select * from login where pin = '"+pin+"'");
            if(rs.next()) {
                String cardNumber = rs.getString("card_number");
                // Kiểm tra độ dài trước khi cắt chuỗi
                if (cardNumber.length() >= 16) {
                    card.setText("Card Number: " + cardNumber.substring(0,4) + "XXXXXXXX" + cardNumber.substring(12));
                } else {
                    card.setText("Card Number: " + cardNumber);
                }
            }
        } catch(Exception e) { 
            System.out.println(e);
        }

        try {
            conn conn = new conn();
            int bal = 0;
            ResultSet rs = conn.s.executeQuery("select * from bank where pin = '"+pin+"'");
            
            // Xóa bỏ nội dung hiện tại và bắt đầu với định dạng HTML đúng
            StringBuilder transactions = new StringBuilder("<html>");
            transactions.append("<table>");
            transactions.append("<tr><th>Date</th><th>Type</th><th>Amount</th></tr>");
            
            while(rs.next()) {
                String type = rs.getString("type");
                String amount = rs.getString("amount");
                String date = rs.getString("date");
                
                transactions.append("<tr>");
                transactions.append("<td width='140'>").append(date).append("</td>");
                transactions.append("<td width='80'>").append(type).append("</td>");
                transactions.append("<td width='80'>").append(amount).append(" vnd</td>");
                transactions.append("</tr>");
                
                if(type.equals("Deposit")) {
                    bal += Integer.parseInt(amount);
                } else {
                    bal -= Integer.parseInt(amount);
                }
            }
            
            transactions.append("</table></html>");
            mini.setText(transactions.toString());
            
            balance.setText("Your Current Account Balance is VND "+bal);
        } catch(Exception e) { 
           System.out.println(e);
        }

        mini.setBounds(20, 120, 400, 250);

        setSize(440, 600);
        setLocation(20, 20);
        getContentPane().setBackground(Color.WHITE);
        setVisible(true);
    }
    
    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }
}
