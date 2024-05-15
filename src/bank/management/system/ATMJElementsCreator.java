package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ATMJElementsCreator {

    private static final int defaultFontSize = 16;
    private static final String defaultFontSystem = "System";
    private static final String defaultFontTF = "Raleway";

    private static final int defaultButtonWidth = 150;
    private static final int defaultButtonHeight = 35;

    public static final String currencySign = "$";

    public static final int buttonColumn1 = 170;
    public static final int buttonColumn2 = 390;

    public static final int buttonRow1 = 499;
    public static final int buttonRow2 = 543;
    public static final int buttonRow3 = 588;
    public static final int buttonRow4 = 633;


    public static JLabel createATM() {
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image atmScaled = atm.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon atmIconScaled = new ImageIcon(atmScaled);
        JLabel atmIconScaledJ = new JLabel(atmIconScaled);
        atmIconScaledJ.setBounds(0, 0, 960, 1080);

        return atmIconScaledJ;
    }

    public static JButton createATMJButton(String text, int x, int y, JLabel atm, ActionListener al) {
        JButton buttonToReturn = new JButton(text);
        buttonToReturn.setBounds(x, y, defaultButtonWidth, defaultButtonHeight);

        buttonToReturn.addActionListener(al);

        atm.add(buttonToReturn);

        return buttonToReturn;
    }

    public static JButton createATMBackJButton(JLabel atm, ActionListener al) {
        return ATMJElementsCreator.createATMJButton("BACK", ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow4, atm, al);
    }

    public static JLabel createATMJLabel(String text, int x, int y, int width, int height, JLabel atm) {
        JLabel jLabelToReturn = new JLabel(text);
        jLabelToReturn.setForeground(Color.WHITE);
        jLabelToReturn.setFont(new Font(defaultFontSystem, Font.BOLD, defaultFontSize));
        jLabelToReturn.setBounds(x, y, width, height);

        atm.add(jLabelToReturn);

        return jLabelToReturn;
    }

    public static JTextField createJTextField(int fontSize, int x, int y, int width, int height, JLabel atm) {
        JTextField jTextFieldToReturn = new JTextField();
        jTextFieldToReturn.setFont(new Font(defaultFontTF, Font.BOLD, fontSize));
        jTextFieldToReturn.setBounds(x, y, width, height);
        atm.add(jTextFieldToReturn);

        return jTextFieldToReturn;
    }

    public static void setATMDefaultSettings(JFrame jFrame) {
        jFrame.setLayout(null);

        jFrame.setSize(960, 1080);
        jFrame.setLocation(500, 0);
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
    }

    public static void forwardToTransactions(String pin, JFrame activeJFrame) {
        activeJFrame.setVisible(false);
        new Transactions(pin).setVisible(true);
    }
}
