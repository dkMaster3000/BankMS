package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class JElementsCreator {

    private static final int defaultFontSize = 14;
    private static final String defaultFont = "Raleway";

    public static JLabel createLogo() {
        ImageIcon logo = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image logoScaled = logo.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon logoIconScaled = new ImageIcon(logoScaled);

        return new JLabel(logoIconScaled);
    }

    public static JLabel createATM() {
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image atmScaled = atm.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon atmIconScaled = new ImageIcon(atmScaled);
        JLabel atmIconScaledJ = new JLabel(atmIconScaled);
        atmIconScaledJ.setBounds(0, 0, 960, 1080);

        return atmIconScaledJ;
    }

    public static JLabel createJLabel(String text, int fontSize, int x, int y, int width, int height) {
        JLabel jLabelToReturn = new JLabel(text);
        jLabelToReturn.setFont(new Font(defaultFont, Font.BOLD, fontSize));
        jLabelToReturn.setBounds(x, y, width, height);

        return jLabelToReturn;
    }

    public static JTextField createJTextField(int x, int y, int width, int height) {
        JTextField jTextFieldToReturn = new JTextField();
        jTextFieldToReturn.setFont(new Font(defaultFont, Font.BOLD, defaultFontSize));
        jTextFieldToReturn.setBounds(x, y, width, height);

        return jTextFieldToReturn;
    }

    public static JButton createJButton(String text, int x, int y, int width, int height, ActionListener al) {
        JButton buttonToReturn = new JButton(text);
        buttonToReturn.setBackground(Color.BLACK);
        buttonToReturn.setForeground(Color.WHITE);
        buttonToReturn.setFont(new Font(defaultFont, Font.BOLD, defaultFontSize));
        buttonToReturn.setBounds(x, y, width, height);
        buttonToReturn.addActionListener(al);

        return buttonToReturn;
    }

    public static JRadioButton createJRadioButton(String text, int x, int y, int width, int height) {
        JRadioButton jRadioButtonToReturn = new JRadioButton(text);
        jRadioButtonToReturn.setFont(new Font(defaultFont, Font.BOLD, defaultFontSize));
        jRadioButtonToReturn.setBackground(Color.WHITE);
        jRadioButtonToReturn.setBounds(x, y, width, height);

        return jRadioButtonToReturn;
    }

    public static JRadioButton createJRadioButton(String text, int fontSize, int x, int y, int width, int height) {
        JRadioButton jRadioButtonToReturn = createJRadioButton(text, x, y, width, height);
        jRadioButtonToReturn.setFont(new Font(defaultFont, Font.BOLD, fontSize));

        return jRadioButtonToReturn;
    }

    public static void groupJRadioButtons(JRadioButton[] jRadioButtons) {
        ButtonGroup grouper = new ButtonGroup();
        for (JRadioButton jRadioButton : jRadioButtons) {
            grouper.add(jRadioButton);
        }
    }

    public static JComboBox createJComboBox(String[] options, int x, int y, int width, int height) {
        JComboBox jComboBoxToReturn = new JComboBox(options);
        jComboBoxToReturn.setFont(new Font(defaultFont, Font.BOLD, defaultFontSize));
        jComboBoxToReturn.setBackground(Color.WHITE);
        jComboBoxToReturn.setBounds(x, y, width, height);

        return jComboBoxToReturn;
    }

    public static JCheckBox createJCheckBox(String text, int fontSize, int x, int y, int width, int height) {
        JCheckBox jCheckBoxToReturn = new JCheckBox(text);
        jCheckBoxToReturn.setFont(new Font(defaultFont, Font.BOLD, fontSize));
        jCheckBoxToReturn.setBackground(Color.WHITE);
        jCheckBoxToReturn.setBounds(x, y, width, height);

        return jCheckBoxToReturn;
    }

    public static void setDefaultSettings(JFrame jFrame) {
        jFrame.getContentPane().setBackground(Color.WHITE);

        jFrame.setLocation(500, 120);
        jFrame.setVisible(true);
    }

    public static void showUnfilledFieldMessage() {
        JOptionPane.showMessageDialog(null, "Fill all the required fields");
    }

}
