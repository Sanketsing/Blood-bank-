import javax.swing.*;
import java.awt.*;

public class Available extends JFrame
{

    private JLabel heading,lbl_bloodtype ;
     private JComboBox bloodcb ;

    public Available()
    {
        this.setLayout(null);
        heading = new JLabel("Check availability of Blood ", JLabel.CENTER);
        heading.setFont(new Font("gabriola", Font.BOLD| Font.ITALIC, 40));
        heading.setBounds(200, 25, 390, 60);
        heading.setForeground(Color.RED);
        this.add(heading);

        lbl_bloodtype = new JLabel("Select blood Group");
        lbl_bloodtype.setBounds(30,150,210,30);
        lbl_bloodtype.setFont(new Font("gabriola",Font.ITALIC,35));
        this.add(lbl_bloodtype);

        String groups [] = {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "O-"};
        bloodcb = new JComboBox<String>(groups);
        bloodcb.setBounds(215,260,180,30);
        this.add(bloodcb);





        this.setSize(800, 600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        Available f = new Available();

    }
}
