import javax.swing.*;  
import javax.swing.ImageIcon;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import javax.swing.border.*;


public class Stock extends JFrame implements ActionListener
{
    JFrame jf;
    Connection con;
    Statement stmt1,stmt2,stmt3,stmt4,stmt5,stmt6,stmt7,stmt8,stmt9,stmt10,stmt11;
    ResultSet rs1,rs2,rs3,rs4,rs5,rs6,rs7,rs8,rs9,rs10,rs11;
    JLabel a1,a2,b1,b2,ab1,ab2,o1,o2,total,doner;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9,l10;
    JComboBox cmb;

    @SuppressWarnings("unchecked")
    public Stock()
    {
        jf=new JFrame();
        setTitle("Blood Bank Management System");
        getContentPane().setBackground(new Color(64,64,66));
        setLayout(new BorderLayout());

        ImageIcon i1 = new ImageIcon ("C:/projects/Bloodbank/img/bg4.jpg");
        Image img1 = i1.getImage();
        Image newimg1=img1.getScaledInstance(1380,1220, Image.SCALE_DEFAULT);
        ImageIcon icon1=new ImageIcon(newimg1);
        JLabel back=new JLabel(icon1);
        back.setLayout(null);

        Border blackline = BorderFactory.createLineBorder(Color.black);

//-------------------------------first 4 boxes-----------------------------
        JPanel jp1=new JPanel();
        jp1.setBounds(100,50,100,100);
        jp1.setOpaque(false);
        jp1.setBorder(blackline);
        back.add(jp1);

        JPanel jp2=new JPanel();
        jp2.setBounds(300,50,100,100);
        jp2.setOpaque(false);
        jp2.setBorder(blackline);
        back.add(jp2);

        JPanel jp3=new JPanel();
        jp3.setBounds(500,50,100,100);
        jp3.setOpaque(false);
        jp3.setBorder(blackline);
        back.add(jp3);

        JPanel jp4=new JPanel();
        jp4.setBounds(700,50,100,100);
        jp4.setOpaque(false);
        jp4.setBorder(blackline);
        back.add(jp4);


//------------------------second 4 boxes---------------------------

        JPanel jp5=new JPanel();
        jp5.setBounds(100,250,100,100);
        jp5.setOpaque(false);
        jp5.setBorder(blackline);
        back.add(jp5);

        JPanel jp6=new JPanel();
        jp6.setBounds(300,250,100,100);
        jp6.setOpaque(false);
        jp6.setBorder(blackline);
        back.add(jp6);

        JPanel jp7=new JPanel();
        jp7.setBounds(500,250,100,100);
        jp7.setOpaque(false);
        jp7.setBorder(blackline);
        back.add(jp7);

        JPanel jp8=new JPanel();
        jp8.setBounds(700,250,100,100);
        jp8.setOpaque(false);
        jp8.setBorder(blackline);
        back.add(jp8);

        JPanel jp9=new JPanel();
        jp9.setBounds(100,450,100,100);
        jp9.setOpaque(false);
        jp9.setBorder(blackline);
        back.add(jp9);

        JPanel jp10=new JPanel();
        jp10.setBounds(300,450,100,100);
        jp10.setOpaque(false);
        jp10.setBorder(blackline);
        back.add(jp10);

//--------------JLabel set--------------------

        a1=new JLabel("    A+   ");
        a2=new JLabel("    A-   ");

        b1=new JLabel("    B+   ");
        b2=new JLabel("    B-   ");

        ab1=new JLabel("    AB+   ");
        ab2=new JLabel("    AB-   ");

        o1=new JLabel("    O+   ");
        o2=new JLabel("    O-   ");

        total=new JLabel("Total  ");
        doner=new JLabel("Doners");

        a1.setFont(new Font("Serif", Font.BOLD, 30));
        a2.setFont(new Font("Serif", Font.BOLD, 30));
        b1.setFont(new Font("Serif", Font.BOLD, 30));
        b2.setFont(new Font("Serif", Font.BOLD, 30));
        ab1.setFont(new Font("Serif", Font.BOLD, 30));
        ab2.setFont(new Font("Serif", Font.BOLD, 30));
        o1.setFont(new Font("Serif", Font.BOLD, 30));
        o2.setFont(new Font("Serif", Font.BOLD, 30));
        total.setFont(new Font("Serif", Font.BOLD, 30));
        doner.setFont(new Font("Serif", Font.BOLD, 30));

        a1.setBounds(30,10,30,30);

        jp1.add(a1);jp2.add(a2);
        jp3.add(b1);jp4.add(b2);
        jp5.add(ab1);jp6.add(ab2);
        jp7.add(o1);jp8.add(o2);
        jp9.add(total);jp10.add(doner);



//--------------------2nd JLabel set--------------------

        l1=new JLabel();
        l2=new JLabel();
        l3=new JLabel();
        l4=new JLabel();
        l5=new JLabel();
        l6=new JLabel();
        l7=new JLabel();
        l8=new JLabel();
        l9=new JLabel();
        l10=new JLabel();

        l1.setFont(new Font("Serif", Font.PLAIN, 20));
        l2.setFont(new Font("Serif", Font.PLAIN, 20));
        l3.setFont(new Font("Serif", Font.PLAIN, 20));
        l4.setFont(new Font("Serif", Font.PLAIN, 20));
        l5.setFont(new Font("Serif", Font.PLAIN, 20));
        l6.setFont(new Font("Serif", Font.PLAIN, 20));
        l7.setFont(new Font("Serif", Font.PLAIN, 20));
        l8.setFont(new Font("Serif", Font.PLAIN, 20));
        l9.setFont(new Font("Serif", Font.PLAIN, 20));
        l10.setFont(new Font("Serif", Font.PLAIN, 20));

        /*l1.setBounds(50,70,20,20);
        l2.setBounds(50,70,20,20);
        l3.setBounds(50,70,20,20);
        l4.setBounds(50,70,20,20);
        l5.setBounds(50,70,20,20);
        l6.setBounds(50,70,20,20);
        l7.setBounds(50,70,20,20);
        l8.setBounds(50,70,20,20);
        l9.setBounds(50,70,20,20);
        l10.setBounds(50,70,20,20);*/

        //jp1.add(l1, BorderLayout.SOUTH);

        jp1.add(l1);jp2.add(l2);
        jp3.add(l3);jp4.add(l4);
        jp5.add(l5);jp6.add(l6);
        jp7.add(l7);jp8.add(l8);
        jp9.add(l9);jp10.add(l10);
        

        //------------------Database-------------------------------

        try 
        {
            
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            
            //-----------A+------------------
            int sum=0;
            stmt1=con.createStatement();
            rs1=stmt1.executeQuery("select sum(qty) from blood where bloodgrp='A+'");
            while (rs1.next()) 
            {
                int c = rs1.getInt(1);
                sum = sum + c;
            }
            l1.setText(String.valueOf(sum));



            //-------------A-----------------------
            int sum1=0;
            stmt2=con.createStatement();
            rs2=stmt2.executeQuery("select sum(qty) from blood where bloodgrp='A-'");
            while (rs2.next()) 
            {
                int c = rs2.getInt(1);
                sum1 = sum1 + c;
            }
            l2.setText(String.valueOf(sum1));



            //----------------B+---------------
            int sum2=0;
            stmt3=con.createStatement();
            rs3=stmt3.executeQuery("select sum(qty) from blood where bloodgrp='B+'");
            while (rs3.next()) 
            {
                int c = rs3.getInt(1);
                sum2 = sum2 + c;
            }
            l3.setText(String.valueOf(sum2));



            //------------------B- ---------------
            int sum3=0;
            stmt4=con.createStatement();
            rs4=stmt4.executeQuery("select sum(qty) from blood where bloodgrp='B-'");
            while (rs4.next()) 
            {
                int c = rs4.getInt(1);
                sum3 = sum3 + c;
            }
            l4.setText(String.valueOf(sum3));


            //-------------AB+--------------------
            int sum4=0;
            stmt5=con.createStatement();
            rs5=stmt5.executeQuery("select sum(qty) from blood where bloodgrp='AB+'");
            while (rs5.next()) 
            {
                int c = rs5.getInt(1);
                sum4 = sum4 + c;
            }
            l5.setText(String.valueOf(sum4));



            //--------------AB- ----------------------
            int sum5=0;
            stmt6=con.createStatement();
            rs6=stmt6.executeQuery("select sum(qty) from blood where bloodgrp='AB-'");
            while (rs6.next()) 
            {
                int c = rs6.getInt(1);
                sum5 = sum5 + c;
            }
            l6.setText(String.valueOf(sum5));



            //---------------O+-------------------------
            int sum6=0;
            stmt7=con.createStatement();
            rs7=stmt7.executeQuery("select sum(qty) from blood where bloodgrp='O+'");
            while (rs7.next()) 
            {
                int c = rs7.getInt(1);
                sum6 = sum6 + c;
            }
            l7.setText(String.valueOf(sum6));



            //-----------------------O- ---------------------
            int sum7=0;
            stmt8=con.createStatement();
            rs8=stmt8.executeQuery("select sum(qty) from blood where bloodgrp='O-'");
            while (rs8.next()) 
            {
                int c = rs8.getInt(1);
                sum7 = sum7 + c;
            }
            l8.setText(String.valueOf(sum7));



            //---------------------TOTAL----------------------
            int sum8=0;
            stmt9=con.createStatement();
            rs9=stmt9.executeQuery("select sum(qty) from blood");
            while (rs9.next()) 
            {
                int c = rs9.getInt(1);
                sum8 = sum8 + c;
            }
            l9.setText(String.valueOf(sum8));



            //---------------------Doners----------------------
            int sum9=0;
            stmt10=con.createStatement();
            rs10=stmt10.executeQuery("select * from doner");
            while (rs10.next()) 
            {
                sum9++;
            }
            l10.setText(String.valueOf(sum9));

        } catch (Exception e2) {}


        //--------------report--------------

        JLabel j1=new JLabel("Enter Blood Group");
        j1.setFont(new Font("Serif", Font.BOLD, 20));
        j1.setBounds(500,450,200,50);
        back.add(j1);

        cmb=new JComboBox();
        cmb.addItem("Select Blood Group");cmb.addItem("A+");cmb.addItem("A-");cmb.addItem("B+");cmb.addItem("B-");
        cmb.addItem("AB+");cmb.addItem("AB-");cmb.addItem("O+");cmb.addItem("O-");
        cmb.setFont(new Font("Serif", Font.PLAIN, 20));
        cmb.setBounds(700,460,200,30);
        back.add(cmb);

        
        JButton b1=new JButton("Report");
        b1.setFont(new Font("Serif", Font.BOLD, 20));
        b1.setBounds(600,550,150,40);
        back.add(b1);
        b1.addActionListener(this);
        
        




        back.add(jp1);back.add(jp2);back.add(jp3);back.add(jp4);back.add(jp5);
        back.add(jp6);back.add(jp7);back.add(jp8);back.add(jp9);back.add(jp10);


        add(back);
        setDefaultCloseOperation(jf.DISPOSE_ON_CLOSE);
        setSize(1000,1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        String bg=cmb.getSelectedItem().toString();
        // new Report();

        Report r=new Report(bg);
        r.show();
        this.dispose();
    }
    public static void main(String args[])
    {
        new Stock();
    }
}