import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

    public Login() {
        setTitle("Login Page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(660, 400);
        setLocationRelativeTo(null); // Center the window on the screen
//
        // Background image
        JLabel backgroundLabel = new JLabel(new ImageIcon("D:\\Sanket\\Java projects\\Blood Bank\\Blood Bank\\images\\login.jpg"));
        backgroundLabel.setBounds(0, 0, 660, 400);

        // Username and password labels
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100, 120, 130, 45);
        usernameLabel.setFont(new Font("Gabriola",Font.BOLD,30));
        usernameLabel.setForeground(Color.WHITE);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 180, 130, 45);
        passwordLabel.setFont(new Font("Gabriola",Font.BOLD,30));
        passwordLabel.setForeground(Color.WHITE);

        // Username and password fields
        JTextField usernameField = new JTextField();
        usernameField.setBounds(250, 120, 200, 30);
        usernameField.setFont(new Font("Serif",Font.ITALIC,20));

        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(250, 180, 200, 30);
        passwordField.setFont(new Font("Gabriola",Font.ITALIC,20));

        // Login button
        JButton loginButton = new JButton("Login");
        loginButton.setBounds(140, 250, 100, 30);
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String user = usernameField.getText().trim();
                    String pass = passwordField.getText().trim();
                    if (user.equals("Admin") &&  pass.equals("Pass")) {

                        exit();
                        

                    } else
                        JOptionPane.showMessageDialog(null, "Invelid username or password ");
                }
                catch (Exception ex )
                {
                    ex.printStackTrace();
                }
                //
            }
        });

        JButton clear = new JButton("Clear");
        clear.setBounds(340, 250, 100, 30);
        clear.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent ex)
            {
                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Add components to the frame
        //backgroundLabel.add(logoLabel);
        backgroundLabel.add(usernameLabel);
        backgroundLabel.add(passwordLabel);
        backgroundLabel.add(usernameField);
        backgroundLabel.add(passwordField);
        backgroundLabel.add(loginButton);
        backgroundLabel.add(clear);

        // Add the background label to the content pane
        setContentPane(backgroundLabel);

        // Set the frame visible
        setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void exit()
    {
        new Homeform().setVisible(true);
        this.dispose();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new Login();
            }
        });
    }
}
