import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class Home extends JFrame implements MouseListener
{
    JFrame jf;
    @SuppressWarnings("unchecked")

    public Home() {

        jf = new JFrame();
        getContentPane().setBackground(new Color(64, 64, 66));
        setLayout(new BorderLayout());

        ImageIcon ii1 = new ImageIcon("C:/projects/Bloodbank/img/bg4.jpg");
        Image iimg1 = ii1.getImage();
        Image newiimg1 = iimg1.getScaledInstance(1380, 1220, Image.SCALE_DEFAULT);
        ImageIcon iicon1 = new ImageIcon(newiimg1);
        JLabel back = new JLabel(iicon1);
        back.setLayout(null);

        Border bd = BorderFactory.createLineBorder(Color.red);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0, 0, 150, 1920);
        panel.setBackground(new Color(234,185,215));
        panel.setBorder(bd);

        JPanel panel1 = new JPanel();
        panel1.setLayout(null);
        panel1.setBounds(150, 0, 1230, 100);
        panel1.setBackground(new Color(234,185,215));
        panel1.setBorder(bd);



        ImageIcon i1 = new ImageIcon("C:/projects/Bloodbank/img/home.png");
        Image img1 = i1.getImage();
        Image newimg1 = img1.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon1 = new ImageIcon(newimg1);
        JLabel home = new JLabel("Home",icon1,0);
        home.setBounds(20, 20, 110, 80);
        home.setHorizontalTextPosition(JLabel.CENTER);
        home.setVerticalTextPosition(JLabel.BOTTOM);
        home.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon i2 = new ImageIcon("C:/projects/Bloodbank/img/new.png");
        Image img2 = i2.getImage();
        Image newimg2 = img2.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(newimg2);
        JLabel neww = new JLabel("New Doner",icon2,0);
        neww.setBounds(20, 130, 110, 80);
        neww.setHorizontalTextPosition(JLabel.CENTER);
        neww.setVerticalTextPosition(JLabel.BOTTOM);
        neww.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon i3 = new ImageIcon("C:/projects/Bloodbank/img/group.png");
        Image img3 = i3.getImage();
        Image newimg3 = img3.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon3 = new ImageIcon(newimg3);
        JLabel group = new JLabel("Donation",icon3,0);
        group.setBounds(20, 240, 110, 80);
        group.setHorizontalTextPosition(JLabel.CENTER);
        group.setVerticalTextPosition(JLabel.BOTTOM);
        group.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon i4 = new ImageIcon("C:/projects/Bloodbank/img/sell.png");
        Image img4 = i4.getImage();
        Image newimg4 = img4.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon4 = new ImageIcon(newimg4);
        JLabel sell = new JLabel("Sell",icon4,0);
        sell.setBounds(20, 350, 110, 80);
        sell.setHorizontalTextPosition(JLabel.CENTER);
        sell.setVerticalTextPosition(JLabel.BOTTOM);
        sell.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon i5 = new ImageIcon("C:/projects/Bloodbank/img/report.png");
        Image img5 = i5.getImage();
        Image newimg5 = img5.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon5 = new ImageIcon(newimg5);
        JLabel buy = new JLabel("Report",icon5,0);
        buy.setBounds(20, 460, 110, 80);
        buy.setHorizontalTextPosition(JLabel.CENTER);
        buy.setVerticalTextPosition(JLabel.BOTTOM);
        buy.setCursor(new Cursor(Cursor.HAND_CURSOR));

        ImageIcon i6 = new ImageIcon("C:/projects/Bloodbank/img/blood.png");
        Image img6 = i6.getImage();
        Image newimg6 = img6.getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon icon6 = new ImageIcon(newimg6);
        JLabel camp = new JLabel("Blood Stock",icon6,0);
        camp.setBounds(20, 570, 110, 80);
        camp.setHorizontalTextPosition(JLabel.CENTER);
        camp.setVerticalTextPosition(JLabel.BOTTOM);
        camp.setCursor(new Cursor(Cursor.HAND_CURSOR));

        panel.add(home);
        panel.add(neww);
        panel.add(group);
        panel.add(sell);
        panel.add(buy);
        panel.add(camp);
        back.add(panel);

        JLabel bb=new JLabel("Blood Bank");
        bb.setBounds(500,30,500,30);
        bb.setForeground(Color.red);
        bb.setFont(new Font("Serif", Font.BOLD, 40));
        panel1.add(bb);
        back.add(panel1);


        

        JLabel b=new JLabel("DONATE BLOOD!!!");
        JLabel q=new JLabel();
        q.setText("<html><body>If you're blood doner <br> you're HERO to someone, somewhere <br> who recieved Gracious GIFT of Life!!!</body></html>");
        b.setFont(new Font("Serif", Font.BOLD, 40));
        q.setFont(new Font("Serif", Font.BOLD, 20));
        b.setForeground(Color.red);
        q.setForeground(Color.red);

        b.setBounds(300,240,400,50);
        q.setBounds(300,300,400,100);
        back.add(b);back.add(q);



        JButton about=new JButton("About Us");
        about.setFont(new Font("Serif", Font.BOLD, 15));
        about.setBackground(Color.red);
        about.setBounds(350,460,100,50);
        //about.setOpaque(false);
        about.setFocusPainted(false);
        about.setBorderPainted(false);
        //about.setContentAreaFilled(false);
        about.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
        about.setCursor(new Cursor(Cursor.HAND_CURSOR));
        back.add(about);




        ImageIcon i7 = new ImageIcon("C:/projects/Bloodbank/img/img.png");
        Image img7 = i7.getImage();
        Image newimg7 = img7.getScaledInstance(300, 300, Image.SCALE_DEFAULT);
        ImageIcon icon7 = new ImageIcon(newimg7);
        JLabel im = new JLabel(icon7);
        im.setBounds(800, 100, 400, 400);
        back.add(im);

        JLabel p=new JLabel("Powered By:");
        JLabel m=new JLabel("Aayush Blood Bank, Baramati");
        p.setFont(new Font("Serif", Font.BOLD, 15));
        m.setFont(new Font("Serif", Font.BOLD, 15));
        p.setForeground(Color.black);
        m.setForeground(Color.black);

        p.setBounds(1120,620,100,30);
        m.setBounds(1080,650,200,30);
        back.add(p);back.add(m);







        add(back);
        setTitle("Blood Bank Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1380, 1920);
        setLocationRelativeTo(null);
        setVisible(true);

        home.addMouseListener(this);
        neww.addMouseListener(this);
        group.addMouseListener(this);
        sell.addMouseListener(this);
        buy.addMouseListener(this);
        camp.addMouseListener(this);
    }
    public void mouseClicked(MouseEvent e) {  
        //System.out.println(e.getText());
        JLabel lb=(JLabel) e.getSource();
        String l=lb.getText();
        if(l=="Home")
        {
            new Home();
        }
        
        if(l=="New Doner")
        {
            new NewDoner();
        }
            
        if(l=="Donation")
        {
            new Check();
        }
            
        if(l=="Sell")
        {
            new P_Check();
        }
            
        if(l=="Report")
        {
            Object[] options = { "Doners", "Patients", "Sell" };

            int a=JOptionPane.showOptionDialog(null, "Which report do you want?", "information",
            JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE,
            null, options, options[0]);

            if(JOptionPane.YES_OPTION==a)
            {
                Report1 r1=new Report1("doner");
                r1.setVisible(true);
            }
            if(JOptionPane.NO_OPTION==a)
            {
                Report2 r2=new Report2("patient");
                r2.setVisible(true);
            }
            if(JOptionPane.CANCEL_OPTION==a)
            {
                Report3 r3=new Report3("sell");
                r3.setVisible(true);
            }
        }
            
        if(l=="Blood Stock")
        {
            new Stock();
        }
            
    }  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {  }  

    public static void main(String args[]) {
        new Home();
    }
}
