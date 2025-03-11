import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PinChange extends JFrame implements ActionListener {

    JPasswordField pinfield, repin;
    JButton change, back;
    String pin;

    PinChange(String pinchange) {
        this.pin = pinchange;
        setLayout(null);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        JLabel text = new JLabel("CHANGE YOUR PIN");
        text.setBounds(250, 280, 500, 25);
        text.setForeground(Color.WHITE);
        text.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(text);

        JLabel pintext = new JLabel("New PIN:");
        pintext.setBounds(165, 320, 180, 25);
        pintext.setForeground(Color.WHITE);
        pintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pintext);

        pinfield = new JPasswordField();
        pinfield.setBounds(330, 320, 180, 25);
        pinfield.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(pinfield);

        JLabel repintext = new JLabel("Re-Enter New PIN:");
        repintext.setBounds(165, 360, 180, 25);
        repintext.setForeground(Color.WHITE);
        repintext.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repintext);

        repin = new JPasswordField();
        repin.setBounds(330, 360, 180, 25);
        repin.setFont(new Font("Raleway", Font.BOLD, 16));
        image.add(repin);

        change = new JButton("CHANGE");
        change.setBounds(355, 485, 150, 30);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("BACK");
        back.setBounds(355, 520, 150, 30);
        back.addActionListener(this);
        image.add(back);

        setSize(900, 900);
        setLocation(300, 0);
        setUndecorated(true);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                // Dùng getPassword thay cho getText
                String npin = new String(pinfield.getPassword());
                String rpin = new String(repin.getPassword());

                if (!npin.equals(rpin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }
                if (npin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please enter PIN");
                    return;
                }
                if (rpin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Please re-enter PIN");
                    return;
                }

                conn conn = new conn();
                String query = "update bank set pin = '" + rpin + "' where pin = '" + pin + "'";
                String query2 = "update login set pin = '" + rpin + "' where pin = '" + pin + "'";
                String query3 = "update signup3 set pin = '" + rpin + "' where pin = '" + pin + "'";

                conn.s.executeUpdate(query);
                conn.s.executeUpdate(query2);
                conn.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN changed successfully");
                setVisible(false);
                new Transactions(rpin).setVisible(true);
            } catch (Exception e) {
                System.out.println(e);
            }
        } else {
            setVisible(false);
            new Transactions(pin).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PinChange("").setVisible(true);
    }
}
