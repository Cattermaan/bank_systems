import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class SignupTwo extends JFrame implements ActionListener {
    // Khai báo các biến cần thiết
    JTextField panField, aadharField;
    JButton next;
    JRadioButton syes, sno, eyes, eno;
    JComboBox<String> religion, category, income, edu, occupation;
    String formno;
   

    SignupTwo(String formno) {
        this.formno = formno;
        setLayout(null);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel AddrDetails = new JLabel("Page 2: Additional Details");
        AddrDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        AddrDetails.setBounds(290, 80, 400, 30);
        add(AddrDetails);

        JLabel name = new JLabel("Religion:");
        name.setFont(new Font("Raleway", Font.BOLD, 20));
        name.setBounds(100, 140, 200, 30);
        add(name);

        String vreligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religion = new JComboBox<>(vreligion);
        religion.setBounds(300, 140, 400, 30);
        religion.setBackground(Color.WHITE);
        add(religion);

        JLabel Categoryz = new JLabel("Category:");
        Categoryz.setFont(new Font("Raleway", Font.BOLD, 20));
        Categoryz.setBounds(100, 190, 200, 30);
        add(Categoryz);

        String vcategory[] = {"Kinh", "Other"};
        category = new JComboBox<>(vcategory);
        category.setBounds(300, 190, 400, 30);
        category.setBackground(Color.WHITE);
        add(category);

        JLabel comein = new JLabel("Income:");
        comein.setFont(new Font("Raleway", Font.BOLD, 20));
        comein.setBounds(100, 240, 200, 30);
        add(comein);

        String vincome[] = {"Null", "< 5,000,000vnd", "< 10.000.000", "< 50,00,000", "< 100,00,000", "> 100,00,000"};
        income = new JComboBox<>(vincome);
        income.setBounds(300, 240, 400, 30);
        income.setBackground(Color.WHITE);
        add(income);

        JLabel Edcu = new JLabel("Educational");
        Edcu.setFont(new Font("Raleway", Font.BOLD, 20));
        Edcu.setBounds(100, 290, 200, 30);
        add(Edcu);

        JLabel Qua = new JLabel("Qualification:");
        Qua.setFont(new Font("Raleway", Font.BOLD, 20));
        Qua.setBounds(100, 315, 200, 30);
        add(Qua);

        String eduvl[] = {"High School", "College", "University", "Master's Degree", "Doctorate", "Others"};
        edu = new JComboBox<>(eduvl);
        edu.setBounds(300, 315, 400, 30);
        edu.setBackground(Color.WHITE);
        add(edu);

        JLabel maritl = new JLabel("Occupation:");
        maritl.setFont(new Font("Raleway", Font.BOLD, 20));
        maritl.setBounds(100, 390, 200, 30);
        add(maritl);

        String Occup[] = {"Salaried", "Self-Employed", "Business", "Student", "IT", "Others"};
        occupation = new JComboBox<>(Occup);
        occupation.setBounds(300, 390, 400, 30);
        occupation.setBackground(Color.WHITE);
        add(occupation);

        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway", Font.BOLD, 20));
        address.setBounds(100, 440, 200, 30);
        add(address);

        panField = new JTextField();
        panField.setFont(new Font("Raleway", Font.BOLD, 14));
        panField.setBounds(300, 440, 400, 30);
        add(panField);

        JLabel city = new JLabel("Identity Card:");
        city.setFont(new Font("Raleway", Font.BOLD, 20));
        city.setBounds(100, 490, 200, 30);
        add(city);

        aadharField = new JTextField();
        aadharField.setFont(new Font("Raleway", Font.BOLD, 14));
        aadharField.setBounds(300, 490, 400, 30);
        add(aadharField);

        JLabel seniorCitizen = new JLabel("Senior Citizen:");
        seniorCitizen.setFont(new Font("Raleway", Font.BOLD, 20));
        seniorCitizen.setBounds(100, 540, 200, 30);
        add(seniorCitizen);

        syes = new JRadioButton("Yes");
        syes.setBounds(300, 540, 100, 30);
        syes.setBackground(Color.WHITE);
        add(syes);

        sno = new JRadioButton("No");
        sno.setBounds(450, 540, 100, 30);
        sno.setBackground(Color.WHITE);
        add(sno);

        ButtonGroup senior = new ButtonGroup();
        senior.add(syes);
        senior.add(sno);

        JLabel existingAccount = new JLabel("Existing Account:");
        existingAccount.setFont(new Font("Raleway", Font.BOLD, 20));
        existingAccount.setBounds(100, 590, 200, 30);
        add(existingAccount);

        eyes = new JRadioButton("Yes");
        eyes.setBounds(300, 590, 100, 30);
        eyes.setBackground(Color.WHITE);
        add(eyes);

        eno = new JRadioButton("No");
        eno.setBounds(450, 590, 100, 30);
        eno.setBackground(Color.WHITE);
        add(eno);

        ButtonGroup esenior = new ButtonGroup();
        esenior.add(eyes);
        esenior.add(eno);

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

    public void actionPerformed(ActionEvent ae) {
        
        String sreligion = (String) religion.getSelectedItem();
        String scategory = (String) category.getSelectedItem();
        String sincome = (String) income.getSelectedItem();
        String eduq = (String) edu.getSelectedItem();
        String occu = (String) occupation.getSelectedItem();
        String seniorcitizen = null;

        if (syes.isSelected()) {
            seniorcitizen = "Yes";
        } else if (sno.isSelected()) {
            seniorcitizen = "No";
        }

        String existingAccount = null;
        if (eyes.isSelected()) {
            existingAccount = "Yes";
        } else if (eno.isSelected()) {
            existingAccount = "No";
        }

        String panVal = panField.getText();
        String identityz = aadharField.getText();

        try {
            conn c = new conn();
            String query = "INSERT INTO signuptwo (formno, religion, category, income, education, occupation, "
                         + "seniorcitizen, existingaccount, pan, indentity) "
                         + "VALUES ('" + formno + "', '" + sreligion + "', '" + scategory + "', '" + sincome + "', '"
                         + eduq + "', '" + occu + "', '" + seniorcitizen + "', '" + existingAccount + "', '"
                         + panVal + "', '" + identityz + "')";

            c.s.executeUpdate(query);
            JOptionPane.showMessageDialog(null, "Signup Successful");

            setVisible(false);
            new SignupThree(formno).setVisible(true);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void main(String[] args) {
        new SignupTwo("");
    }
}
