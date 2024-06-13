import javax.swing.*;  
import java.awt.*;
import java.awt.event.*;
import java.sql.*;


public class NewDoner extends JFrame implements ActionListener
{  
    JLabel nm,mnm,snm,bg,dob,gen,add,add1,add2,tal,dist,st,pin,mob,mail,aadhar;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t13;
    JComboBox cmb;
    JComboBox dd,mm,yy;
    JRadioButton male,female,other;
    ButtonGroup bg1;
    JButton sub,clr;
    JFrame jf;
    Connection con;
    Statement stmt1;
    ResultSet rs;
    PreparedStatement stmt;
    @SuppressWarnings("unchecked")

    public NewDoner()
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
        
        
        
        nm=new JLabel("First Name");
        mnm=new JLabel("Middle Name");
        snm=new JLabel("Last Name");
        bg=new JLabel("Blood Group");
        dob=new JLabel("Date of Birth");
        gen=new JLabel("Gender");
        add=new JLabel("Address");
        add1=new JLabel("AddressLine 1");
        add2=new JLabel("AddressLine 2");
        tal=new JLabel("Tal");
        dist=new JLabel("Dist");
        st=new JLabel("State");
        pin=new JLabel("Pin");
        mob=new JLabel("Mob No");
        mail=new JLabel("Email ID");
        aadhar=new JLabel("Aadhar No");

        t1=new JTextField(20);
        t2=new JTextField(20);
        t3=new JTextField(20);
        t4=new JTextField(20);
        t5=new JTextField(20);
        t6=new JTextField(20);
        t7=new JTextField(20);
        t8=new JTextField(20);
        t9=new JTextField(20);
        t10=new JTextField(20);
        t11=new JTextField(20);
        t13=new JTextField(20);
        

        dd=new JComboBox();
        mm=new JComboBox();
        yy=new JComboBox();

        dd.setCursor(new Cursor(Cursor.HAND_CURSOR));
        mm.setCursor(new Cursor(Cursor.HAND_CURSOR));
        yy.setCursor(new Cursor(Cursor.HAND_CURSOR));

        dd.addItem("Date");
        mm.addItem("Month");
        yy.addItem("Year");

        for(int m=1;m<=12;m++)
        {
            mm.addItem(String.valueOf(m));
        }
        
        for(int d=1;d<=31;d++)
        {
            dd.addItem(String.valueOf(d));
        }

        for(int y=1950;y<=2008;y++)
        {
            yy.addItem(String.valueOf(y));
        }


        cmb=new JComboBox();
        cmb.addItem("Select Blood Group");cmb.addItem("A+");cmb.addItem("A-");cmb.addItem("B+");cmb.addItem("B-");
        cmb.addItem("AB+");cmb.addItem("AB-");cmb.addItem("O+");cmb.addItem("O-");
        cmb.setCursor(new Cursor(Cursor.HAND_CURSOR));

        male=new JRadioButton("Male");
        female=new JRadioButton("Female");
        other=new JRadioButton("Other");
        male.setCursor(new Cursor(Cursor.HAND_CURSOR));
        female.setCursor(new Cursor(Cursor.HAND_CURSOR));
        other.setCursor(new Cursor(Cursor.HAND_CURSOR));
        bg1=new ButtonGroup();
        bg1.add(male);bg1.add(female);bg1.add(other);

        sub=new JButton("Submit");
        clr=new JButton("Clear");
        sub.setCursor(new Cursor(Cursor.HAND_CURSOR));
        clr.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon i2 = new ImageIcon("C:/Users/shambhuraje/Desktop/Bloodbank/img/logo.png");
        Image img2 = i2.getImage();
        Image newimg2 = img2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(newimg2);
        JLabel logo = new JLabel(icon2);
        logo.setBounds(20, 10, 60, 60);

        

        JPanel jp=new JPanel();
        jp.setLayout(null);
        jp.setBackground(new Color(234,185,215));
        jp.setBounds(0,0,1380,70);

        JLabel doner=new JLabel("New Doner Registration");
        doner.setBounds(90,15,500,50);
        doner.setFont(new Font("Serif", Font.BOLD, 40));
        

        nm.setBounds(80,110,100,30);
        mnm.setBounds(500,110,150,30);
        snm.setBounds(920,110,100,30);
        bg.setBounds(80,180,150,30);
        dob.setBounds(80,240,150,50);
        gen.setBounds(500,240,100,50);
        add.setBounds(600,300,200,50);
        add1.setBounds(80,360,150,50);
        add2.setBounds(790,360,150,50);
        tal.setBounds(80,430,100,50);
        dist.setBounds(790,430,100,50);
        st.setBounds(80,500,100,50);
        pin.setBounds(790,500,100,50);
        mob.setBounds(80,570,100,50);
        mail.setBounds(790,570,100,50);
        aadhar.setBounds(500,180,150,30);

        t1.setBounds(220,110,250,30);
        t2.setBounds(640,110,250,30);
        t3.setBounds(1060,110,250,30);
        cmb.setBounds(220,180,250,30);
        male.setBounds(640,250,150,30);
        female.setBounds(790,250,150,30);
        other.setBounds(940,250,150,30);
        t4.setBounds(220,370,250,30);
        t5.setBounds(940,370,250,30);
        t6.setBounds(220,440,250,30);
        t7.setBounds(940,440,250,30);
        t8.setBounds(220,510,250,30);
        t9.setBounds(940,510,250,30);
        t10.setBounds(220,580,250,30);
        t11.setBounds(940,580,250,30);
        sub.setBounds(420,640,100,40);
        clr.setBounds(740,640,100,40);
        t13.setBounds(640,180,250,30);

        dd.setBounds(300,250,75,30);
        mm.setBounds(220,250,75,30);
        yy.setBounds(380,250,75,30);
        

        nm.setFont(new Font("Serif", Font.BOLD, 20));
        mnm.setFont(new Font("Serif", Font.BOLD, 20));
        snm.setFont(new Font("Serif", Font.BOLD, 20));
        bg.setFont(new Font("Serif", Font.BOLD, 20));
        dob.setFont(new Font("Serif", Font.BOLD, 20));
        add.setFont(new Font("Serif", Font.BOLD, 30));
        add1.setFont(new Font("Serif", Font.BOLD, 20));
        add2.setFont(new Font("Serif", Font.BOLD, 20));
        tal.setFont(new Font("Serif", Font.BOLD, 20));
        dist.setFont(new Font("Serif", Font.BOLD, 20));
        st.setFont(new Font("Serif", Font.BOLD, 20));
        pin.setFont(new Font("Serif", Font.BOLD, 20));
        mob.setFont(new Font("Serif", Font.BOLD, 20));
        mail.setFont(new Font("Serif", Font.BOLD, 20));
        gen.setFont(new Font("Serif", Font.BOLD, 20));
        male.setFont(new Font("Serif", Font.BOLD, 20));
        female.setFont(new Font("Serif", Font.BOLD, 20));
        other.setFont(new Font("Serif", Font.BOLD, 20));
        cmb.setFont(new Font("Serif", Font.PLAIN, 20));
        aadhar.setFont(new Font("Serif", Font.BOLD, 20));


        t1.setFont(new Font("Serif", Font.PLAIN, 20));
        t2.setFont(new Font("Serif", Font.PLAIN, 20));
        t3.setFont(new Font("Serif", Font.PLAIN, 20));
        t4.setFont(new Font("Serif", Font.PLAIN, 20));
        t5.setFont(new Font("Serif", Font.PLAIN, 20));
        t6.setFont(new Font("Serif", Font.PLAIN, 20));
        t7.setFont(new Font("Serif", Font.PLAIN, 20));
        t8.setFont(new Font("Serif", Font.PLAIN, 20));
        t9.setFont(new Font("Serif", Font.PLAIN, 20));
        t10.setFont(new Font("Serif", Font.PLAIN, 20));
        t11.setFont(new Font("Serif", Font.PLAIN, 20));
        t13.setFont(new Font("Serif", Font.PLAIN, 20));
        sub.setFont(new Font("Serif", Font.BOLD, 20));
        clr.setFont(new Font("Serif", Font.BOLD, 20));


        
        jp.add(doner);
        jp.add(logo);
        back.add(jp);
        back.add(nm);back.add(mnm);back.add(snm);back.add(bg);back.add(dob);back.add(gen);back.add(add);back.add(add1);
        back.add(add2);back.add(tal);back.add(dist);back.add(st);back.add(pin);back.add(mob);back.add(mail);back.add(aadhar);
        back.add(t1);back.add(t2);back.add(t3);back.add(cmb);back.add(male);back.add(female);back.add(other);back.add(t4);
        back.add(t5);back.add(t6);back.add(t7);back.add(t8);back.add(t9);back.add(t10);back.add(t11);//back.add(t12);
        back.add(t13);back.add(dd);back.add(mm);back.add(yy);
        back.add(sub);back.add(clr);

        add(back);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1380,1920);
        setLocationRelativeTo(null);
        setVisible(true);


        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            
        } catch (Exception e2) {}

        sub.addActionListener(this);
        clr.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e)
    {

        if(t5.getText().equals(""))
        {
            t5.setText("-");
        }
        if(t9.getText().equals(""))
        {
            t9.setText("0");
        }
        if(t11.getText().equals(""))
        {
            t11.setText("-");
        }
        if(e.getSource()==sub)
        {
            try{
            Double aadhar=Double.parseDouble(t13.getText());
            stmt1=con.createStatement();
            rs=stmt1.executeQuery("select * from doner where aadhar="+aadhar);
            if(rs.next())
            {
                JOptionPane.showMessageDialog(jf, "Doner already exist","Alert",JOptionPane.WARNING_MESSAGE);
            }
            else{
            String fname=t1.getText();
            String mname=t2.getText();
            String sname=t3.getText();

            String name=fname+mname+sname;
            
            String addr=t4.getText()+" "+t5.getText()+" "+t6.getText()+" "+t7.getText()+" "+t8.getText();

            String bg=cmb.getSelectedItem().toString();
            String d= (String) dd.getSelectedItem();
            String m= (String) mm.getSelectedItem();
            String y= (String) yy.getSelectedItem();
            String gen="";
            String dob=d+m+y;

            if(male.isSelected())
            {
                gen="male";
            }
            else if(female.isSelected())
            {
                gen="female";
            }
            else
            {
                gen="other";
            }

            int pin=Integer.parseInt(t9.getText());
            long mob=Long.parseLong(t10.getText());
            String email=t11.getText();
            

            
                stmt=con.prepareStatement("insert into doner values(?,?,?,?,?,?,?,?,?)");
                stmt.setDouble(1,aadhar);
                stmt.setString(2,name);
                stmt.setString(3,bg);
                stmt.setString(4,dob);
                stmt.setString(5,gen);
                stmt.setString(6,addr);
                stmt.setInt(7,pin);
                stmt.setLong(8,mob);
                stmt.setString(9,email);
                
                int i=stmt.executeUpdate();  
                
                JOptionPane.showMessageDialog(jf, "New Doner added succesful");
                Long aa=Long.parseLong(t13.getText()); 
                Donation d1=new Donation(aa);
                d1.show();
                this.dispose();
                con.close();
            
        }
        }catch(Exception e1){System.out.println(e1);
        JOptionPane.showMessageDialog(jf, "Please first fill this form","Alert",JOptionPane.WARNING_MESSAGE);
        }
        }
        else if(e.getSource()==clr)
        {
            t1.setText("");
            t2.setText("");
            t3.setText("");
            t4.setText("");
            t5.setText("");
            t6.setText("");
            t7.setText("");
            t8.setText("");
            t9.setText("");
            t10.setText("");
            t11.setText("");
            t13.setText("");

            cmb.setSelectedIndex(0);
            bg1.clearSelection();
        }
    } 

    public static void main(String args[])
    {
        new NewDoner();
    }
}