package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener {

    JPasswordField newPinPF, repeatNewPinPF;
    JButton changeB, backB;
    JLabel changePinHeaderL, newPinL, repeatNewPinL;
    String cardnumber;

    ChangePin(String cardnumber) {
        this.cardnumber = cardnumber;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        changePinHeaderL = ATMJElementsCreator.createATMJLabel("CHANGE YOUR PIN", 280, 330, 800, 35, atm);

        newPinL = ATMJElementsCreator.createATMJLabel("New PIN:", 180, 390, 150, 35, atm);

        repeatNewPinL = ATMJElementsCreator.createATMJLabel("Re-Enter New PIN:", 180, 440, 200, 35, atm);


        newPinPF = ATMJElementsCreator.createJPasswordField(350, 390, 180, 25, atm);

        repeatNewPinPF = ATMJElementsCreator.createJPasswordField(350, 440, 180, 25, atm);


        changeB = ATMJElementsCreator.createATMJButton("CHANGE", ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow3, atm, this);
        backB = ATMJElementsCreator.createATMBackJButton(atm, this);


        ATMJElementsCreator.setATMDefaultSettings(this);

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backB) {
            ATMJElementsCreator.forwardToTransactions(cardnumber, this);
        } else {
            String newPin = newPinPF.getText();
            String repeatedPin = repeatNewPinPF.getText();

            if (!newPin.equals(repeatedPin)) {
                JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                return;
            }

            if (newPin.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Enter New PIN and Re-Enter new PIN");
                return;
            }


            String query1 = "update " + DatabaseStrings.loginTableS + " set " + DatabaseStrings.pinColumnS + " = '" + newPin + "' where " + DatabaseStrings.cardnumberColumnS + " = '" + cardnumber + "' ";
            String query2 = "update " + DatabaseStrings.signup3TableS + " set " + DatabaseStrings.pinColumnS + " = '" + newPin + "' where " + DatabaseStrings.cardnumberColumnS + " = '" + cardnumber + "' ";

            GeneralUtils.sendQuery(query1);
            GeneralUtils.sendQuery(query2);

            JOptionPane.showMessageDialog(null, "PIN changed successfully");

            ATMJElementsCreator.forwardToTransactions(cardnumber, this);

        }
    }

    public static void main(String[] args) {
        new ChangePin("").setVisible(true);
    }
}
