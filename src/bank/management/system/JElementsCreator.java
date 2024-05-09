package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JElementsCreator {

    public static JLabel createLogo() {
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image logoScaled = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon logoIconScaled = new ImageIcon(logoScaled);

        return new JLabel(logoIconScaled);
    }

    public static JLabel createJLabel(String text, int fontSize, int x, int y, int width, int height) {
        JLabel jLabelToReturn = new JLabel(text);
        jLabelToReturn.setFont(new Font("Raleway", Font.BOLD, fontSize));
        jLabelToReturn.setBounds(x, y, width, height);

        return jLabelToReturn;
    }

    public static JTextField createJTextField(int x, int y, int width, int height) {
        JTextField jTextFieldToReturn = new JTextField();
        jTextFieldToReturn.setFont(new Font("Raleway", Font.BOLD, 14));
        jTextFieldToReturn.setBounds(x, y, width, height);

        return jTextFieldToReturn;
    }

    public static JButton createJButton(String text, int x, int y, int width, int height, ActionListener al) {
        JButton buttonToReturn = new JButton(text);
        buttonToReturn.setBackground(Color.BLACK);
        buttonToReturn.setForeground(Color.WHITE);
        buttonToReturn.setFont(new Font("Raleway", Font.BOLD, 14));
        buttonToReturn.setBounds(x, y, width, height);
        buttonToReturn.addActionListener(al);

        return buttonToReturn;
    }

    public static JRadioButton createJRadioButton(String text, int x, int y, int width, int height) {
        JRadioButton jRadioButtonToReturn = new JRadioButton(text);
        jRadioButtonToReturn.setFont(new Font("Raleway", Font.BOLD, 14));
        jRadioButtonToReturn.setBackground(Color.WHITE);
        jRadioButtonToReturn.setBounds(x, y, width, height);

        return jRadioButtonToReturn;
    }
}
