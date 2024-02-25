import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Storage extends JFrame {

    public Storage()
    {
        this.setLayout(null);

        JLabel heading = new JLabel("Storage");
        heading.setFont(new Font("gabriola", Font.BOLD| Font.ITALIC, 40));
        heading.setBounds(295, 25, 210, 60);
        heading.setForeground(Color.RED);
        this.add(heading);

    JLabel ap = new JLabel("A+");
    this.add(ap);
    ap.setBounds(180,100,50,25);

    JTextField txt_ap = new JTextField();
    txt_ap.setBounds(410,100,180,30);
    this.add(txt_ap);
    txt_ap.setEditable(false);

        JLabel an = new JLabel("A-");
        an.setBounds(180,140,50,25);
        this.add(an);

        JTextField txt_an = new JTextField();
        this.add(txt_an);
        txt_an.setBounds(410,140,180,30);
        txt_an.setEditable(false);

        JLabel abp = new JLabel("AB+");
        this.add(abp);
        abp.setBounds(180,180,50,25);

        JTextField txt_abp = new JTextField();
        txt_abp.setBounds(410,180,180,30);
        this.add(txt_abp);
        txt_abp.setEditable(false);

        JLabel abn = new JLabel("AB-");
        this.add(abn);
        abn.setBounds(180,220,50,25);

        JTextField txt_abn= new JTextField();
        txt_abn.setBounds(410,220,180,30);
        this.add(txt_abn);
        txt_abn.setEditable(false);

        JLabel bp = new JLabel("B+");
        this.add(bp);
        bp.setBounds(180,260,50,25);

        JTextField txt_bp = new JTextField();
        txt_bp.setBounds(410,260,180,30);
        this.add(txt_bp);
        txt_bp.setEditable(false);

        JLabel bn = new JLabel("B-");
        this.add(bn);
        bn.setBounds(180,300,50,25);

        JTextField txt_bn = new JTextField();
        txt_bn.setBounds(410,300,180,30);
        this.add(txt_bn);
        txt_bn.setEditable(false);


        JLabel op = new JLabel("O+");
        this.add(op);
        op.setBounds(180,340,50,25);

        JTextField txt_op = new JTextField();
        this.add(txt_op);
        txt_op.setBounds(410,340,180,30);
        txt_op.setEditable(false);

        JLabel on = new JLabel("O-");
        this.add(on);
        on.setBounds(180,380,50,25);

        JTextField txt_on = new JTextField();
        this.add(txt_on);
        txt_on.setBounds(410,380,180,30);
        txt_on.setEditable(false);

        JLabel back = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\back.jpg"));
        back.setBounds(5,5,50,49);
        back.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                back();
            }
        });
        
        this.setSize(800,600);
        this.setVisible(true);



    }
    public void back()
    {
        this.dispose();
        new Homeform().setVisible(true);
    }

    public static void main(String[] args) {
        new Storage();

    }

}
