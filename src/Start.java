import javax.swing.*;
import java.awt.*;

public class Start  extends JFrame{
    private  JLabel heading;
      private JLabel background,small_img;
    JProgressBar jp ;

    public Start()
    {
        super.setTitle("Blood Bank");
        this.setLayout(null);
        background = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\start.jpg"));
        setContentPane(background);

        heading = new JLabel(" Blood Bank");
        heading.setBounds(320,20,200,60);
        heading.setFont(new Font("gabriola", Font.BOLD | Font.ITALIC, 40));
        heading.setForeground(Color.RED);
        heading.setBackground(Color.WHITE);
        background.add(heading);

        small_img = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\star.jpg"));
        small_img.setBounds(50,50,750,350);
        background.add(small_img);


        jp = new JProgressBar(SwingConstants.HORIZONTAL,0,100);
        background.add(jp);
        jp.setStringPainted(true);
        jp.setBounds(20,430,750,20);
        jp.setForeground(Color.RED);
        jp.setBackground(Color.white);


        this.setSize(800,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
         Start j = new Start();
         int i = 0 ;
        while(i<=100){
            j.jp.setValue(i);
            i=i+1;
            try{Thread.sleep(50);}catch(Exception e){}
        }
        j.dispose();
        new Login().setVisible(true);

    }
}
