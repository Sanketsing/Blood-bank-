import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Homeform extends JFrame implements MouseListener  {

    JLabel lbl_donar_img, lbl_receiver_img, lbl_importance, name, lbl_heading ,lblview;
    JLabel lbl_donar_text, lbl_receiver_text, lbl_imp_text ,lblview_text,lbl_view_text;


    public Homeform(){

        lbl_heading = new JLabel("Homepage",JLabel.CENTER);
        lbl_heading.setFont(new Font("Gabriola", Font.BOLD,44));
        this.add(lbl_heading,BorderLayout.NORTH);

        lbl_donar_img = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\donor.jpg"));
        this.add(lbl_donar_img);
        lbl_donar_img.setBounds(210,100,250,214);
        lbl_donar_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                lbl_army_clicked(evt);
            }

            public void mouseEntered(MouseEvent e) {
                lbl_donar_text.setForeground( Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                lbl_donar_text.setForeground(Color.BLACK);

            }
        });;



        lbl_donar_text = new JLabel("Donor", JLabel.CENTER);
        this.add(lbl_donar_text);
        lbl_donar_text.setBounds(310,324,50,35);


        lbl_receiver_img = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\receiver.jpg"));

        this.add(lbl_receiver_img);
        lbl_receiver_img.setBounds(500,100,250,214);
        //lbl_receiver_img.addMouseListener(this);
        lbl_receiver_img.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                receiver_clicked(evt);

            }
            public void mouseEntered(MouseEvent e) {
                lbl_receiver_text.setForeground( Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                lbl_receiver_text.setForeground(Color.BLACK);

            }
        });

        lbl_receiver_text = new JLabel("Receiver",JLabel.CENTER);
        this.add(lbl_receiver_text);
        lbl_receiver_text.setBounds(590,324,70,35);

        lbl_importance = new JLabel( new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\imp.jpg"));
        this.add(lbl_importance);
        lbl_importance.setBounds(210, 380 ,250,214);
        lbl_importance.addMouseListener(this);
        lbl_importance.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redirection(evt);
            }
            public void mouseEntered(MouseEvent e) {
                lbl_imp_text.setForeground( Color.RED);
            }

            public void mouseExited(MouseEvent e) {
                lbl_imp_text.setForeground(Color.BLACK);

            }
        });

        lbl_imp_text = new JLabel("Importance of Blood Donation", JLabel.CENTER);
        this.add(lbl_imp_text);
        lbl_imp_text.setBounds(245,600,190,35);

//        name = new JLabel();
//        name.setBounds(510, 850 ,250,214);
//        this.add(name);



        lbl_view_text = new JLabel("View Tables", JLabel.CENTER);
        this.add(lbl_view_text);
        lbl_view_text.setBounds(590,600,70,35);


        lblview = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\view.jpg"));
        lblview.setBounds(500, 380 ,250,214);
        this.add(lblview);
        lblview.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                viewClicked();
            }


            @Override
            public void mouseEntered(MouseEvent e) {
                lbl_view_text.setForeground( Color.RED);
            }

            @Override
            public void mouseExited(MouseEvent e) {
                lbl_view_text.setForeground(Color.BLACK);
            }
        });



        name = new JLabel(" ", JLabel.CENTER);
        name.setBounds(590,600,70,35);
        this.add(name);

        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(1000,800);
        this.setLocationRelativeTo(null);

    }

    private void redirection(MouseEvent evt) {
        openWebpage("https://healthmatters.nyp.org/the-surprising-benefits-of-donating-blood/#:~:text=The%20benefits%20of%20donating%20blood,transfusions%20for%20people%20in%20need");
        this.dispose();
    }
    private static void openWebpage(String url) {
        try {
            Desktop.getDesktop().browse(new java.net.URI(url));
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
    private void receiver_clicked(MouseEvent evt) {
        this.dispose();
        new Receiver().setVisible(true);
    }

    private void lbl_army_clicked(MouseEvent evt) {
        this.dispose();
        new BLOODCHECK().setVisible(true);
    }
    private void viewClicked()
    {
        this.dispose();
        new View().setVisible(true);
    }


    public static void main(String[] args) {
        new Homeform();
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
