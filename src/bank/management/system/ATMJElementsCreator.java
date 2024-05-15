package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class ATMJElementsCreator {

    private static final int defaultFontSize = 16;
    private static final String defaultFont = "System";

    private static final int defaultButtonWidth = 150;
    private static final int defaultButtonHeight = 35;

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

    public static JLabel createATMJLabel(String text, int x, int y, int width, int height, JLabel atm) {
        JLabel jLabelToReturn = new JLabel(text);
        jLabelToReturn.setForeground(Color.WHITE);
        jLabelToReturn.setFont(new Font(defaultFont, Font.BOLD, defaultFontSize));
        jLabelToReturn.setBounds(x, y, width, height);

        atm.add(jLabelToReturn);

        return jLabelToReturn;
    }

    public static void setATMDefaultSettings(JFrame jFrame) {
        jFrame.setLayout(null);

        jFrame.setSize(960, 1080);
        jFrame.setLocation(500, 0);
        jFrame.setUndecorated(true);
        jFrame.setVisible(true);
    }
}
