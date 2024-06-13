import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.time.*;
import java.time.LocalDate.*;
import java.time.LocalDate;

public class Donation extends JFrame implements ActionListener,KeyListener
{
    JFrame jf;
    JTextField t1,t3,t4,t5;
    JLabel aadhar,bgg,qty,date,time,head;
    JButton sub,clr;
    JComboBox bg;
    Connection con;
    Statement stmt;
    PreparedStatement stmt2,stmt1;
    ResultSet rs;
    LocalDate dd;
    LocalTime tt;
    JLabel err1;
    Long  d;
    @SuppressWarnings("unchecked")
    
    public Donation(Long i)
    {
        d=i;
        jf=new JFrame();
        setTitle("Blood Bank Management System");
        getContentPane().setBackground(new Color(64,64,66));
        setLayout(new BorderLayout());

        ImageIcon i1 = new ImageIcon ("C:/projects/Bloodbank/img/bg1.jpg");
        Image img1 = i1.getImage();
        Image newimg1=img1.getScaledInstance(1380,1220, Image.SCALE_DEFAULT);
        ImageIcon icon1=new ImageIcon(newimg1);
        JLabel back=new JLabel(icon1);
        back.setLayout(null);


        head=new JLabel("Donation");
        aadhar=new JLabel("Aadhar Number");
        bgg=new JLabel("Blood Group");
        qty=new JLabel("Quantity");
        date=new JLabel("Date");
        time=new JLabel("Time");
        err1=new JLabel();

        t1=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        t5=new JTextField(20);

        sub=new JButton("Submit");
        clr=new JButton("Clear");


        t1.setText(String.valueOf(d));
        t1.setEnabled(false);

        LocalTime lt = LocalTime.now();
        int hh=lt.getHour();
        int mm=lt.getMinute();  
        t5.setText(hh+":"+mm);
        t5.setEnabled(false);

        LocalDate ld = LocalDate.now();  
        t4.setText(""+ld);
        t4.setEnabled(false);

        t3.setText("1");
        t3.setEnabled(false);

        aadhar.setFont(new Font("Serif", Font.BOLD, 20));
        bgg.setFont(new Font("Serif", Font.BOLD, 20));
        qty.setFont(new Font("Serif", Font.BOLD, 20));
        date.setFont(new Font("Serif", Font.BOLD, 20));
        time.setFont(new Font("Serif", Font.BOLD, 20));
        head.setFont(new Font("Serif", Font.BOLD, 40));

        err1.setFont(new Font("Serif",Font.PLAIN,15));

        err1.setForeground(Color.RED);

        bg=new JComboBox();
        bg.addItem("SELECT");
        bg.addItem("A+");
        bg.addItem("A-");
        bg.addItem("B+");
        bg.addItem("B-");
        bg.addItem("O+");
        bg.addItem("O-");
        bg.addItem("AB+");
        bg.addItem("AB-");
        bg.setFont(new Font("serif",Font.PLAIN,20));
        bg.setCursor(new Cursor(Cursor.HAND_CURSOR));


        t1.setFont(new Font("Serif", Font.PLAIN, 20));
        bg.setFont(new Font("Serif", Font.PLAIN, 20));
        t3.setFont(new Font("Serif", Font.PLAIN, 20));
        t4.setFont(new Font("Serif", Font.PLAIN, 20));
        t5.setFont(new Font("Serif", Font.PLAIN, 20));
        sub.setFont(new Font("Serif", Font.BOLD, 20));
        clr.setFont(new Font("Serif", Font.BOLD, 20));
        sub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clr.setCursor(new Cursor(Cursor.HAND_CURSOR));
        


        aadhar.setBounds(100,110,150,50);
        bgg.setBounds(100,210,300,50);
        qty.setBounds(580,210,150,50);
        date.setBounds(100,310,150,50);
        time.setBounds(580,310,150,50);
        head.setBounds(400,30,500,30);

        sub.setBounds(300,460,150,40);
        clr.setBounds(500,460,150,40);

        t1.setBounds(250,120,300,30);
        bg.setBounds(250,220,300,30);
        t3.setBounds(670,220,300,30);
        t4.setBounds(250,320,300,30);
        t5.setBounds(670,320,300,30);

        err1.setBounds(250,150,300,15);


        back.add(aadhar);back.add(bgg);back.add(qty);back.add(date);back.add(time);back.add(head);
        back.add(t1);back.add(bg);back.add(t3);back.add(t4);back.add(t5);
        back.add(sub);back.add(clr);
        back.add(err1);


        add(back);
        setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);

         try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            
        } catch (Exception e2) {}

        
        clr.addActionListener(this);
        sub.addActionListener(this);
        t1.addKeyListener(this);
    } 
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==sub)
            {
                try{
                
                
                Double aadhar=Double.parseDouble(t1.getText());
                int qty=Integer.parseInt(t3.getText());
                String dd1=t4.getText();
                String tt1= t5.getText();
                String bloodgrp=bg.getSelectedItem().toString();

                stmt1=con.prepareStatement("insert into donation values(default,?,?,?,?,?)");
                stmt1.setDouble(1,aadhar);
                stmt1.setString(2,bloodgrp);
                stmt1.setInt(3,qty);
                stmt1.setString(4,dd1);
                stmt1.setString(5,tt1);
                int j=stmt1.executeUpdate();


                stmt2=con.prepareStatement("update blood set qty=qty+1 where bloodgrp=?");
                stmt2.setString(1,bloodgrp);
                int m=stmt2.executeUpdate();
                JOptionPane.showMessageDialog(jf, "Donation successful");
                
                
                
                }catch(Exception e3){System.out.println(e3);}
            }
        if(e.getSource()==clr)
        {
            bg.setSelectedIndex(0);
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
       
    } 
}