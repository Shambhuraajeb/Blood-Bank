import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.time.*;

public class Buy extends JFrame implements ActionListener
{
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t1,t2,t3,t4,t5;
    JComboBox cmb1;
    JButton b1;
    JFrame jf;
    @SuppressWarnings("unchecked")
    public Buy()
    {
        jf=new JFrame();
        getContentPane().setBackground(new Color(64, 64, 66));
        setLayout(new BorderLayout());

        ImageIcon ii1 = new ImageIcon("C:/projects/Bloodbank/img/bg3.jpg");
        Image iimg1 = ii1.getImage();
        Image newiimg1 = iimg1.getScaledInstance(1380, 1220, Image.SCALE_DEFAULT);
        ImageIcon iicon1 = new ImageIcon(newiimg1);
        JLabel background = new JLabel(iicon1);
        background.setLayout(null);


        ImageIcon i2 = new ImageIcon("C:/projects/Bloodbank/img/logo.png");
        Image img2 = i2.getImage();
        Image newimg2 = img2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(newimg2);
        JLabel logo = new JLabel(icon2);
        logo.setBounds(20, 10, 60, 60);

        

        JPanel jp=new JPanel();
        jp.setLayout(null);
        jp.setBackground(new Color(234,185,215));
        jp.setBounds(0,0,1380,70);

        JLabel doner=new JLabel("Blood Buy");
        doner.setBounds(90,15,500,50);
        doner.setFont(new Font("Serif", Font.BOLD, 40));

        

        l1=new JLabel("Blood Bank Name");
        l1.setFont(new Font("",Font.BOLD,20));
       // l1.setForeground(Color.BLUE);
        
        l2=new JLabel("Blood Group");
        l2.setFont(new Font("",Font.BOLD,20));
       // l2.setForeground(Color.BLUE);
       
        l3=new JLabel("Quantity");
        l3.setFont(new Font("",Font.BOLD,20));
       // l3.setForeground(Color.BLUE);

        l4=new JLabel("Date");
        l4.setFont(new Font("",Font.BOLD,20));
        //l4.setForeground(Color.BLUE);

        l5=new JLabel("Time");
        l5.setFont(new Font("",Font.BOLD,20));
        //l5.setForeground(Color.BLUE);

        l6=new JLabel("Amount of blood");
        l6.setFont(new Font("",Font.BOLD,20));
        //l6.setForeground(Color.BLUE);

        l7=new JLabel("Amount as per bag ₹450");
        l7.setFont(new Font("",Font.PLAIN,15));


        t1=new JTextField();
        t1.setFont(new Font("serif",Font.PLAIN,20));
        t2=new JTextField();
        t2.setFont(new Font("serif",Font.PLAIN,20));
        t3=new JTextField();
        t3.setFont(new Font("serif",Font.PLAIN,20));
        LocalDate date = LocalDate.now();  
        t3.setText(" "+date);
        t3.setEditable(false);

        t4=new JTextField();
        t4.setFont(new Font("serif",Font.PLAIN,20));
        LocalTime tt = LocalTime.now();
        int hh=tt.getHour();
        int mm=tt.getMinute();  
        t4.setText(hh+":"+mm);
        t4.setEditable(false);



        t5=new JTextField();
        t5.setFont(new Font("serif",Font.PLAIN,20));
        t5.setEditable(false);

        // JLabel buy=new JLabel("Blood Buy");
        // buy.setBounds(400,30,500,50);
        // buy.setFont(new Font("Serif", Font.BOLD, 40));

        b1=new JButton("BUY");
        b1.setFont(new Font("Serif", Font.BOLD, 20));

        cmb1=new JComboBox();
        cmb1.addItem("SELECT");
        cmb1.addItem("A+");
        cmb1.addItem("A-");
        cmb1.addItem("B+");
        cmb1.addItem("B-");
        cmb1.addItem("O+");
        cmb1.addItem("O-");
        cmb1.addItem("AB+");
        cmb1.addItem("AB-");
        cmb1.setFont(new Font("serif",Font.PLAIN,20));

        
        l1.setBounds(180,110,180,50);
        t1.setBounds(370,120,300,30);
        l2.setBounds(230,190,150,30);
        cmb1.setBounds(370,190,300,30);
        l3.setBounds(230,270,150,30);
        t2.setBounds(370,270,300,30);
        l4.setBounds(230,350,150,30);
        t3.setBounds(370,350,300,30);
        l5.setBounds(230,430,150,30);
        t4.setBounds(370,430,300,30);
        l7.setBounds(230,480,300,30);
        l6.setBounds(230,530,200,30);
        t5.setBounds(400,530,270,30);

        b1.setBounds(400,640,100,40);

        background.add(l1);
        background.add(l2);
        background.add(l3);
        background.add(l4);
        background.add(l5);
        background.add(l6);
        background.add(l7);
        //background.add(buy);

        background.add(t1);
        background.add(t2);
        background.add(cmb1);
        background.add(t3);
        background.add(t4);
        background.add(t5);
        background.add(b1);
        
        add(background);
        setTitle("Blood Bank Management System");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1000, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
        
       
        b1.addActionListener(this);
        t2.addActionListener(this);
        
    }
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==b1)
        {
            
        }
        else if(e.getSource()==t2)
        {
            int i=Integer.parseInt(t2.getText());
            int amt=i*450;
            t5.setText(String.valueOf(amt));
        }

    }

    public static void main(String args[])throws Exception
    {
        new Buy();
    }
}