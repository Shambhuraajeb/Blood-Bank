import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;
import java.sql.*;

public class Patient extends JFrame implements ActionListener
{
    JLabel aadhar,name,refer,mob,bg,db;
    JTextField t1,t2,t3,t4;
    JButton add;
    JComboBox bloodgrp,dd,mm,yy;
    Statement stmt;
    Connection con;
    ResultSet rs;
    JFrame jf;
    @SuppressWarnings("unchecked")
    public Patient()
    {
        jf=new JFrame();
        getContentPane().setBackground(new Color(64, 64, 66));
        setLayout(new BorderLayout());

        ImageIcon ii1 = new ImageIcon("C:/projects/Bloodbank/img/bg3.jpg");
        Image iimg1 = ii1.getImage();
        Image newiimg1 = iimg1.getScaledInstance(1380, 1220, Image.SCALE_DEFAULT);
        ImageIcon iicon1 = new ImageIcon(newiimg1);
        JLabel back = new JLabel(iicon1);
        back.setLayout(null);


        ImageIcon i2 = new ImageIcon("C:/projects/Bloodbank/img/logo.png");
        Image img2 = i2.getImage();
        Image newimg2 = img2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(newimg2);
        JLabel logo = new JLabel(icon2);
        logo.setBounds(20, 10, 60, 60);


        JPanel jp=new JPanel();
        jp.setLayout(null);
        jp.setBackground(new Color(234,185,215));
        jp.setBounds(0,0,1000,70);

        JLabel doner=new JLabel("Patient Details");
        doner.setBounds(90,15,500,50);
        doner.setFont(new Font("Serif", Font.BOLD, 40));




        aadhar=new JLabel("Aadhar Number");
        name=new JLabel("Name");
        db=new JLabel("Date of Birth");
        bg=new JLabel("Blood Group");
        refer=new JLabel("Refer Doctor Name");
        mob=new JLabel("Mobile number");

        aadhar.setFont(new Font("",Font.BOLD,20));
        name.setFont(new Font("",Font.BOLD,20));
        db.setFont(new Font("",Font.BOLD,20));
        bg.setFont(new Font("",Font.BOLD,20));
        refer.setFont(new Font("",Font.BOLD,20));
        mob.setFont(new Font("",Font.BOLD,20));

        add=new JButton("Add");

        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);

        t1.setFont(new Font("serif",Font.PLAIN,20));
        t2.setFont(new Font("serif",Font.PLAIN,20));
        t3.setFont(new Font("serif",Font.PLAIN,20));
        t4.setFont(new Font("serif",Font.PLAIN,20));

        bloodgrp=new JComboBox();
        bloodgrp.addItem("SELECT");
        bloodgrp.addItem("A+");
        bloodgrp.addItem("A-");
        bloodgrp.addItem("B+");
        bloodgrp.addItem("B-");
        bloodgrp.addItem("O+");
        bloodgrp.addItem("O-");
        bloodgrp.addItem("AB+");
        bloodgrp.addItem("AB-");

        bloodgrp.setFont(new Font("serif",Font.PLAIN,20));
        bloodgrp.setCursor(new Cursor(Cursor.HAND_CURSOR));

        dd=new JComboBox();
        mm=new JComboBox();
        yy=new JComboBox();

        dd.setFont(new Font("serif",Font.PLAIN,20));
        mm.setFont(new Font("serif",Font.PLAIN,20));
        yy.setFont(new Font("serif",Font.PLAIN,20));

        dd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yy.setCursor(new Cursor(Cursor.HAND_CURSOR));

        dd.addItem("Date");
        mm.addItem("Month");
        yy.addItem("Year");

        for(int d=1;d<=31;d++)
        {
            dd.addItem(String.valueOf(d));
        }

        for(int m=1;m<=12;m++)
        {
            mm.addItem(String.valueOf(m));
        }

        for(int y=2008;y>=1960;y--)
        {
            yy.addItem(String.valueOf(y));
        }

        add=new JButton("Add");
        add.setBounds(400,590,100,40);
        add.setFont(new Font("Serif", Font.BOLD, 20));
        add.setCursor(new Cursor(Cursor.HAND_CURSOR));

        // aadhar.setBounds(60,140,220,30);
        // name.setBounds(500,140,220,30);
        // db.setBounds(60,220,220,30);
        // bg.setBounds(500,220,220,30);
        // refer.setBounds(60,300,220,30);
        // mob.setBounds(500,300,220,30);

        // t1.setBounds(230,140,250,30);

        aadhar.setBounds(90,110,220,50);
        t1.setBounds(400,120,300,30);
        name.setBounds(90,190,150,30);
        bloodgrp.setBounds(400,350,300,30);
        db.setBounds(90,270,150,30);
        t2.setBounds(400,190,300,30);
        bg.setBounds(90,350,150,30);
        t3.setBounds(400,510,300,30);
        refer.setBounds(90,430,220,30);
        t4.setBounds(400,430,300,30);
        mob.setBounds(90,510,300,30);

        mm.setBounds(400,270,75,30);
        dd.setBounds(480,270,75,30);
        yy.setBounds(560,270,75,30);






        jp.add(doner);
        jp.add(logo);
        back.add(jp);

        back.add(aadhar);back.add(name);back.add(db);back.add(bg);back.add(refer);back.add(mob);
        back.add(t1);back.add(t2);back.add(t3);back.add(t4);back.add(bloodgrp);back.add(dd);back.add(mm);back.add(yy);
        back.add(add);
        
        add(back);
        setTitle("Blood Bank Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        setVisible(true);

        add.addActionListener(this);
        
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            
        } catch (Exception e2) {}
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==add)
        {
            try{
            int aadhar=Integer.parseInt(t1.getText());
            String nm=t2.getText();

            String d= (String) dd.getSelectedItem();
            String m= (String) mm.getSelectedItem();
            String y= (String) yy.getSelectedItem();

            String dob=d+"-"+m+"-"+y;
            String bg=bloodgrp.getSelectedItem().toString();
            String dr=t4.getText();
            int mob=Integer.parseInt(t3.getText());

            stmt=con.createStatement();
            int i=stmt.executeUpdate("insert into patient values('"+aadhar+"','"+nm+"','"+dob+"','"+bg+"','"+dr+"','"+mob+"')");

            JOptionPane.showMessageDialog(jf, "Welcome", "Welcome", JOptionPane.INFORMATION_MESSAGE);
                Sell s=new Sell(aadhar);
                s.setVisible(true);
                this.dispose();
            }catch(Exception e1){System.out.println(e1);}
        }
    }

    public static void main(String args[])throws Exception
    {
        new Patient();
    }
}