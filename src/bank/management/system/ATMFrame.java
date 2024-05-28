package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class ATMFrame extends JFrame implements ActionListener {

    JLabel atm;
    String cardnumber;

    ATMFrame(String cardnumber) {
        this.cardnumber = cardnumber;

        atm = createATM();
        add(atm);

        setLayout(null);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }

    private JLabel createATM() {
        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image atmScaled = atm.getImage().getScaledInstance(1000, 1180, Image.SCALE_DEFAULT);
        ImageIcon atmIconScaled = new ImageIcon(atmScaled);
        JLabel atmIconScaledJ = new JLabel(atmIconScaled);
        atmIconScaledJ.setBounds(0, 0, 960, 1080);

        return atmIconScaledJ;
    }

    protected void forwardTo(ATMFrame atmFrame) {
        this.setVisible(false);
        atmFrame.setVisible(true);
    }

    protected void forwardToTransactions() {
        forwardTo(new Transactions(cardnumber));
    }

    @Override
    public abstract void actionPerformed(ActionEvent e);

    protected JButton createATMJButton(String text, int x, int y) {
        JButton buttonToReturn = new JButton(text);
        buttonToReturn.setBounds(x, y, ATMDEFAULTVALUES.defaultButtonWidth, ATMDEFAULTVALUES.defaultButtonHeight);

        buttonToReturn.addActionListener(this);

        atm.add(buttonToReturn);

        return buttonToReturn;
    }

    protected JButton createATMBackJButton() {
        return createATMJButton("BACK", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow4);
    }

    protected JLabel createATMJLabel(String text, int x, int y, int width, int height) {
        JLabel jLabelToReturn = new JLabel(text);
        jLabelToReturn.setForeground(Color.WHITE);
        jLabelToReturn.setFont(new Font(ATMDEFAULTVALUES.defaultFontSystem, Font.BOLD, ATMDEFAULTVALUES.defaultFontSize));
        jLabelToReturn.setBounds(x, y, width, height);

        atm.add(jLabelToReturn);

        return jLabelToReturn;
    }

    protected JTextField createJTextField(int fontSize, int x, int y, int width, int height) {
        JTextField jTextFieldToReturn = new JTextField();
        jTextFieldToReturn.setFont(new Font(ATMDEFAULTVALUES.defaultFontTF, Font.BOLD, fontSize));
        jTextFieldToReturn.setBounds(x, y, width, height);
        atm.add(jTextFieldToReturn);

        return jTextFieldToReturn;
    }

    protected JPasswordField createJPasswordField(int x, int y, int width, int height) {
        JPasswordField jPasswordFieldToReturn = new JPasswordField();
        jPasswordFieldToReturn.setFont(new Font(ATMDEFAULTVALUES.defaultFontTF, Font.BOLD, 25));
        jPasswordFieldToReturn.setBounds(x, y, width, height);
        atm.add(jPasswordFieldToReturn);

        return jPasswordFieldToReturn;
    }
}
