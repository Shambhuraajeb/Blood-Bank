import java.awt.*;
import javax.swing.*;
import java.sql.*;
import javax.swing.table.*;
import javax.swing.table.DefaultTableModel;
import java.util.*;
import javax.swing.border.*;

public class Report3 extends JFrame
{
    JFrame jf;
    ResultSet rs;
    Statement stmt;
    Connection con;
    //JLabel no,date,agg;
    DefaultTableModel dtm;
    JTable tb;
    int i;
    String t;
    @SuppressWarnings("unchecked")

    public Report3(String tt) {

        t=tt;
        jf=new JFrame();
        setTitle("Blood Bank Management System");
        getContentPane().setBackground(Color.white);
        setLayout(new BorderLayout());
        setTitle("Blood Bank Management System");

        ImageIcon i1 = new ImageIcon ("C:/projects/Bloodbank/img/bg3.jpg");
        Image img1 = i1.getImage();
        Image newimg1=img1.getScaledInstance(1380,1220, Image.SCALE_DEFAULT);
        ImageIcon icon1=new ImageIcon(newimg1);
        JLabel back=new JLabel(icon1);
        back.setLayout(null);

        JPanel jp1=new JPanel();
        jp1.setBounds(50,150,950,400);
        jp1.setBackground(Color.white);
        jp1.setLayout(new BorderLayout(5,10));
        

	    dtm=new DefaultTableModel();
        dtm.addColumn("Aadhar No");
        dtm.addColumn("Name");
        dtm.addColumn("Quantity");
        dtm.addColumn("Date");
        dtm.addColumn("Time");
        dtm.addColumn("Amount");

        JLabel head=new JLabel("Sell Report");
        head.setBounds(420,50,300,50);
        head.setFont(new Font("Serif", Font.BOLD, 40));
        back.add(head);

	    tb=new JTable(dtm);
        tb.setEnabled(false);
        tb.setRowHeight(tb.getRowHeight() + 20);
        JTableHeader tableHeader = tb.getTableHeader();
        tableHeader.setBackground(Color.black);
        tableHeader.setForeground(Color.white);
        Font headerFont = new Font("Verdana", Font.PLAIN, 15);
        tableHeader.setFont(headerFont);

        DefaultTableCellRenderer rd = new DefaultTableCellRenderer();
        rd.setHorizontalAlignment(SwingConstants.CENTER);
        tb.getColumnModel().getColumn(1).setCellRenderer(rd);

        



        JScrollPane js=new JScrollPane(tb);
        jp1.add(js, BorderLayout.CENTER);
        back.add(jp1);
        

        String str;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/blood","root","");
            stmt = con.createStatement();
            rs = stmt.executeQuery("select * from "+t);

            
			while(rs.next())
			{
                /*System.out.println(""+rs.getInt(1));
                System.out.println(""+rs.getLong(2));
                System.out.println(""+rs.getString(3));
                System.out.println(""+rs.getInt(4));
                System.out.println(""+rs.getDate(5));
                System.out.println(""+rs.getString(6));*/
                Vector v=new Vector();
                v.add(rs.getInt(1));
                v.add(rs.getString(2));
                v.add(rs.getInt(3));
                v.add(rs.getDate(4));
                v.add(rs.getTime(5));
                v.add(rs.getInt(6));
                dtm.addRow(v);
			}
			
        } catch (Exception e) {}

        

        add(back);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(1050, 1000);
        setLocationRelativeTo(null);
        setVisible(true);
    }
    public static void main(String args[])throws Exception
    {
        //new Report();
    }
}