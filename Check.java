import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.LocalDate.*;
import java.util.Date;

public class Check extends JFrame implements ActionListener,KeyListener
{
    JFrame jf;
    JTextField t1;
    JLabel aadhar,head;
    JButton check;
    
    Connection con;
    Statement stmt;
    ResultSet rs;
    JLabel err1;

    @SuppressWarnings("unchecked")

    public Check()
    {
        jf=new JFrame();
        setTitle("Blood Bank Management System");
        getContentPane().setBackground(new Color(64,64,66));
        setLayout(new BorderLayout());

        ImageIcon i1 = new ImageIcon ("C:/Users/shambhuraje/Desktop/Bloodbank/img/bg1.jpg");
        Image img1 = i1.getImage();
        Image newimg1=img1.getScaledInstance(1380,1220, Image.SCALE_DEFAULT);
        ImageIcon icon1=new ImageIcon(newimg1);
        JLabel back=new JLabel(icon1);
        back.setLayout(null);


        head=new JLabel("Donation");
        aadhar=new JLabel("Aadhar Number");
        err1=new JLabel();

        t1=new JTextField(20);
        
        check=new JButton("Check");
        check.setCursor(new Cursor(Cursor.HAND_CURSOR));


        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
        check.setFont(new Font("Serif", Font.BOLD, 20));
        err1.setFont(new Font("Serif",Font.PLAIN,15));

        err1.setForeground(Color.RED);

        t1.setFont(new Font("Serif", Font.PLAIN, 20));
        
        aadhar.setBounds(120,70,150,50);
        check.setBounds(150,230,100,35);
        t1.setBounds(90,140,200,30);
        err1.setBounds(100,180,300,15);

        
        back.add(aadhar);back.add(head);
        back.add(t1);back.add(check);
        back.add(err1);


        add(back);
        setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        setSize(400,400);
        setLocationRelativeTo(null);
        setVisible(true);

         try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            
        } catch (Exception e2) {}

        check.addActionListener(this);
        t1.addKeyListener(this);
    } 
    public void actionPerformed(ActionEvent e)
    {
        
        if(e.getSource()==check)
        {
            try{
            LocalDate dd = LocalDate.now();
            LocalTime tt = LocalTime.now();
            Long i=Long.parseLong(t1.getText());
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from donation where aadhar='"+i+"'");
            if(rs.next())
            {
                Date dd3=null;
                dd3=rs.getDate("date");
                LocalDate dd2 = Instant.ofEpochMilli(dd3.getTime()).atZone(ZoneId.systemDefault()).toLocalDate();
                // LocalDate dd2=dd3.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                LocalDate minus = dd.minusDays(180);
                //System.out.println(dd3);

                if(dd2.isBefore(minus))
                { 
                    JOptionPane.showMessageDialog(jf, "You are eligible for donation", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                    Donation d=new Donation(i);
                    d.setVisible(true);
                    this.dispose();
                }
                else
            {
                JOptionPane.showMessageDialog(jf, "You are not eligible", "Alert", JOptionPane.WARNING_MESSAGE);
            }
            }
            else
            {
                JOptionPane.showMessageDialog(jf, "Please register first", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                NewDoner n=new NewDoner();
                n.setVisible(true);
                this.dispose();
            }
            }catch(Exception e1){System.out.println(e1);
        }
        }
    }
    public void keyPressed(KeyEvent k)
    {
        String str=t1.getText();
        int l=str.length();
            if (k.getKeyChar() >= '0' && k.getKeyChar() <= '9') {
               err1.setText(" ");
            } else {
               err1.setText("* Enter only numeric digits(0-9)");
            }
    }
    public void keyReleased(KeyEvent k){}
    public void keyTyped(KeyEvent k){}



    public static void main(String args[])
    {
        new Check();
    } 
}