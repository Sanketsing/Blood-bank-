import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class View extends JFrame {
   JPanel donor, receiver,group;
   DefaultTableModel dtm_donor,dtm,dtm_group;
   JTable jTabledonor, jt,jt_group ;
   JScrollPane jsp_donor,jsp,jsp_group ;
   JTabbedPane jtab;
   JLabel heading,heading1,heading_group;



    public View() {
        this.setLayout(null);
//

        heading = new JLabel("Donor", JLabel.CENTER);
        heading.setFont(new Font("gabriola", Font.BOLD| Font.ITALIC, 40));
        heading.setBounds(250, 25, 210, 60);
        heading.setForeground(Color.RED);
        dtm_donor = new DefaultTableModel();

        String[] cols ={"Id","Name","Blood Group"};
        for(String i : cols)
        {
            dtm_donor.addColumn(i);
        }
        jTabledonor = new JTable(dtm_donor);
        jTabledonor.setBounds(100,100,100,300);
        jTabledonor.getTableHeader().setForeground(Color.RED);
        jTabledonor.getTableHeader().setBackground(Color.WHITE);
        jTabledonor.setBackground(Color.WHITE);

        jTabledonor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                //jtMouseClicked(e);

            }
        });


        jsp_donor = new JScrollPane(jTabledonor);
        jsp_donor.setBounds(110,120,500,250);
        loadDonorTable();
        JLabel backo = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\back.jpg"));
        backo.setBounds(5,5,50,49);
        backo.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back();
            }
        });

        donor = new JPanel();
        donor.setLayout(null);
        donor.add(heading);
        donor.add(backo);
        donor.add(jsp_donor);






        heading1 = new JLabel("Receiver", JLabel.CENTER);
        heading1.setFont(new Font("gabriola", Font.BOLD| Font.ITALIC, 40));
        heading1.setBounds(250, 25, 210, 60);
        heading1.setForeground(Color.RED);
        dtm_donor = new DefaultTableModel();
        dtm = new DefaultTableModel();
        String[] col ={"Id","Name","Blood Group"};
        for(String i : col)
        {
            dtm.addColumn(i);
        }
        jt = new JTable(dtm);
        jt.setBounds(100,100,100,300);
        jt.getTableHeader().setForeground(Color.RED);
        jt.getTableHeader().setBackground(Color.WHITE);
        jt.setBackground(Color.WHITE);

        loadreceiverTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(110,120,500,250);

        receiver = new JPanel();
        receiver.setLayout(null);
        receiver.add(heading1);
        receiver.add(jsp);


        group = new JPanel();
        group.setLayout(null);

        heading_group = new JLabel("Stocks", JLabel.CENTER);
        heading_group.setFont(new Font("gabriola", Font.BOLD| Font.ITALIC, 40));
        heading_group.setBounds(250, 25, 210, 60);
        heading_group.setForeground(Color.RED);

        dtm_group = new DefaultTableModel();
        String[] cole ={"Blood Group","Quantity"};
        for(String i : cole)
        {
            dtm_group.addColumn(i);
        }

        jt_group = new JTable(dtm_group);
        jt_group.setBounds(100,100,100,300);
        jt_group.getTableHeader().setForeground(Color.RED);
        jt_group.getTableHeader().setBackground(Color.WHITE);
        jt_group.setBackground(Color.WHITE);

        jsp_group = new JScrollPane(jt_group);
        jsp_group.setBounds(110,120,500,250);
        loadgroup();
        group.add(heading_group);
        group.add(jsp_group);




        jtab = new JTabbedPane(JTabbedPane.TOP);
        jtab.addTab("Donor",donor);
        jtab.addTab("receiver", receiver);
        jtab.addTab("group",group);
        jtab.setBounds(0,0,800,600);
        this.add(jtab);

        JLabel back = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\back.jpg"));
        back.setBounds(5,5,50,49);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back();
            }
        });
        group.add(back);


        JLabel backe = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\back.jpg"));
        backe.setBounds(5,5,50,49);
        backe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back();
            }
        });
        receiver.add(backe);

        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void back()
    {
        this.dispose();
        new Homeform().setVisible(true);
    }
    private void loadgroup() {
        try
        {
            dtm_group.setRowCount(0);

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blood", "root", "pass");
            PreparedStatement ps = con.prepareStatement("select * from bl_storage");

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                String name = rs.getString(1);
                double qty = rs.getDouble(2);
                dtm_group.addRow(new Object[]{name,qty});
                jt_group.setModel(dtm_group);
            }
        }
        catch (Exception e )
        {
            JOptionPane.showMessageDialog(null, "groups"+ e.toString());
        }

    }


    private void loadDonorTable() {
        try
        {
            dtm_donor.setRowCount(0);

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blood", "root", "pass");
            PreparedStatement ps = con.prepareStatement("select * from donor");

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String bloodgroup =rs.getString(3);
                dtm_donor.addRow(new Object[]{id,name,bloodgroup});
                jTabledonor.setModel(dtm_donor);
            }
        }
        catch (Exception e )
        {
            JOptionPane.showMessageDialog(null, "loadTable"+ e.toString());
        }

    }

    private void loadreceiverTable() {
        try
        {
            dtm.setRowCount(0);

            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/blood", "root", "pass");
            PreparedStatement ps = con.prepareStatement("select * from receiver order by blood_group ");

            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
                int id = rs.getInt(1);
                String name = rs.getString(2);
                String bloodgroup = rs.getString(3);
                dtm.addRow(new Object[]{id,name,bloodgroup});
                jt.setModel(dtm);
            }
        }
        catch (Exception e )
        {
            JOptionPane.showMessageDialog(null, "loadTable"+ e.toString());
        }

    }

    public static void main(String[] args) {
        new View();
    }
}
