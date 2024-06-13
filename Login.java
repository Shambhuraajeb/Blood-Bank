import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Login extends JFrame implements ActionListener {
    JLabel l1, l2;
    JTextField t1;
    JPasswordField p1;
    JButton b1;
    JFrame jf;
    Connection con;
    Statement stmt;
    ResultSet rs;
    String email, pass;

    public Login() {
        jf = new JFrame();
        setLayout(null);
        l1 = new JLabel("Email ID");
        l2 = new JLabel("Password");
        t1 = new JTextField(20);
        p1 = new JPasswordField(20);
        b1 = new JButton("Login");

        l1.setBounds(100, 100, 100, 50);
        l2.setBounds(100, 200, 100, 50);
        t1.setBounds(250, 110, 200, 30);
        p1.setBounds(250, 210, 200, 30);
        b1.setBounds(200, 300, 100, 30);

        l1.setFont(new Font("Serif", Font.BOLD, 20));
        l2.setFont(new Font("Serif", Font.BOLD, 20));
        b1.setFont(new Font("Serif", Font.BOLD, 20));

        add(l1);
        add(t1);
        add(l2);
        add(p1);
        add(b1);

        b1.addActionListener(this);

        setTitle("Blood Bank Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);
        setVisible(true);
        getContentPane().setBackground(Color.PINK);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "");

        } catch (Exception e1) {
        }
    }

    public void actionPerformed(ActionEvent e) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood", "root", "");
            if (e.getSource() == b1) {
                email = t1.getText();
                pass = String.valueOf(p1.getPassword());
                stmt = con.createStatement();

                rs = stmt.executeQuery("select * from admin where email='" + email + "' and pass='" + pass + "'");

                if (rs.next()) {
                    JOptionPane.showMessageDialog(jf, "Welcome  " + rs.getString(2) + " You Successfully Login",
                            "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    new Home();
                } else

                    JOptionPane.showMessageDialog(jf, "Wrong email or password", "Alert", JOptionPane.WARNING_MESSAGE);

            }
        }

        catch (Exception e2) {}
    }

    public static void main(String args[]) {
        new Login();
    }
}