package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel welcomeLabel, cardNoLabel, pinLabel;
    JTextField cardNoField;
    JPasswordField pinField;
    JButton signInButton, clearButton, singUpButton;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image logoScaled = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon logoIconScaled = new ImageIcon(logoScaled);

        JLabel label = new JLabel(logoIconScaled);
        label.setBounds(70, 10, 100, 100);
        add(label);

        welcomeLabel = new JLabel("Welcome to ATM");
        welcomeLabel.setFont((new Font("Osward", Font.BOLD, 38)));
        welcomeLabel.setBounds(200, 40, 400, 40);
        add(welcomeLabel);

        cardNoLabel = new JLabel("Card No:");
        cardNoLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        cardNoLabel.setBounds(125, 150, 375, 30);
        add(cardNoLabel);

        cardNoField = new JTextField(15);
        cardNoField.setBounds(300, 150, 230, 30);
        cardNoField.setFont(new Font("Arial", Font.BOLD, 14));
        add(cardNoField);

        pinLabel = new JLabel("PIN:");
        pinLabel.setFont(new Font("Raleway", Font.BOLD, 28));
        pinLabel.setBounds(125, 220, 375, 30);
        add(pinLabel);

        pinField = new JPasswordField(15);
        pinField.setFont(new Font("Arial", Font.BOLD, 14));
        pinField.setBounds(300, 220, 230, 30);
        add(pinField);

        signInButton = generateLoginButton("SIGN IN", 300, 300, 100, 30);
        add(signInButton);
        clearButton = generateLoginButton("CLEAR", 430, 300, 100, 30);
        add(clearButton);
        singUpButton = generateLoginButton("SIGN UP", 300, 350, 230, 30);
        add(singUpButton);

        setLayout(null);

        getContentPane().setBackground(Color.white);

        setSize(800, 480);
        setVisible(true);
        setLocation(350, 200);
    }

    public static void main(String[] args) {
        new Login();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            if (e.getSource() == signInButton) {

            } else if (e.getSource() == clearButton) {
                cardNoField.setText("");
                pinField.setText("");
            } else if (e.getSource() == singUpButton) {
                setVisible(false);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    private JButton generateLoginButton(String text, int x, int y, int width, int height) {
        JButton buttonToReturn = new JButton(text);
        buttonToReturn.setBackground(Color.BLACK);
        buttonToReturn.setForeground(Color.WHITE);
        buttonToReturn.setFont(new Font("Arial", Font.BOLD, 14));
        buttonToReturn.setBounds(x, y, width, height);
        buttonToReturn.addActionListener(this);

        return buttonToReturn;
    }
}
