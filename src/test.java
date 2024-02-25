import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class test extends JFrame {
    JPanel donor, receiver;
    DefaultTableModel dtm_donor,dtm;
    JTable jTabledonor, jt ;
    JScrollPane jsp_donor,jsp ;
    JTabbedPane jtab;
    JLabel heading;


    public test() {
        this.setLayout(null);


        heading = new JLabel("Donor", JLabel.CENTER);
        heading.setFont(new Font("gabriola", Font.BOLD| Font.ITALIC, 40));
        heading.setBounds(280, 25, 210, 60);
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
        jsp_donor.setBounds(110,120,350,250);
        setCellsAlignment(jTabledonor, 0);
        loadDonorTable();
        setCellsAlignment(jTabledonor, 0);
        donor = new JPanel();
        donor.setLayout(null);
        donor.add(heading);
        donor.add(jsp_donor);






//RECEIVER panel
        dtm = new DefaultTableModel();
        String[] col ={"Id","Name","Blood Group"};
        for(String i : col)
        {
            dtm.addColumn(i);
        }
        jt = new JTable(dtm);

        jt.setBounds(300,100,100,300);
        jt.getTableHeader().setForeground(Color.RED);
        jt.getTableHeader().setBackground(Color.WHITE);
        jt.setBackground(Color.WHITE);
        setCellsAlignment(jt, 0);

        loadreceiverTable();
        jsp = new JScrollPane(jt);
        jsp.setBounds(410,120,350,250);

        receiver = new JPanel();
        receiver.add(jsp);

        jtab = new JTabbedPane(JTabbedPane.TOP);
        jtab.addTab("Donor",donor);
        jtab.addTab("receiver", receiver);
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
        this.add(back);




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
            PreparedStatement ps = con.prepareStatement("select * from receiver");

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


        public static void setCellsAlignment(JTable table, int alignment)
        {
            DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
            rightRenderer.setHorizontalAlignment(alignment);

            TableModel tableModel = table.getModel();

            for (int columnIndex = 0; columnIndex < tableModel.getColumnCount(); columnIndex++)
            {
                table.getColumnModel().getColumn(columnIndex).setCellRenderer(rightRenderer);
            }
        }


    public static void main(String[] args) {
        new View();
    }
}
