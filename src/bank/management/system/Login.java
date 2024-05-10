package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame implements ActionListener {
    JLabel logo, welcomeLabel, cardNoLabel, pinLabel;
    JTextField cardNoField;
    JPasswordField pinField;
    JButton signInButton, clearButton, singUpButton;

    Login() {

        setTitle("AUTOMATED TELLER MACHINE");

        logo = JElementsCreator.createLogo();
        logo.setBounds(70, 10, 100, 100);
        add(logo);

        welcomeLabel = JElementsCreator.createJLabel("Welcome to ATM", 38, 200, 40, 400, 40);
        add(welcomeLabel);

        cardNoLabel = JElementsCreator.createJLabel("Card No:", 28, 125, 150, 375, 30);
        add(cardNoLabel);

        cardNoField = JElementsCreator.createJTextField(300, 150, 230, 30);
        add(cardNoField);

        pinLabel = JElementsCreator.createJLabel("PIN:", 28, 125, 220, 375, 30);
        add(pinLabel);

        pinField = new JPasswordField(15);
        pinField.setFont(new Font("Arial", Font.BOLD, 14));
        pinField.setBounds(300, 220, 230, 30);
        add(pinField);

        signInButton = JElementsCreator.createJButton("SIGN IN", 300, 300, 100, 30, this);
        add(signInButton);
        clearButton = JElementsCreator.createJButton("CLEAR", 430, 300, 100, 30, this);
        add(clearButton);
        singUpButton = JElementsCreator.createJButton("SIGN UP", 300, 350, 230, 30, this);
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
    public void actionPerformed(ActionEvent ae) {
        try {
            if (ae.getSource() == signInButton) {

            } else if (ae.getSource() == clearButton) {
                cardNoField.setText("");
                pinField.setText("");
            } else if (ae.getSource() == singUpButton) {
                setVisible(false);
                new SignUpPageOne().setVisible(true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
