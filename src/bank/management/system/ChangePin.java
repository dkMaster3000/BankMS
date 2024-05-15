package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class ChangePin extends JFrame implements ActionListener {

    JPasswordField newPinPF, repeatNewPinPF;
    JButton changeB, backB;
    JLabel changePinHeaderL, newPinL, repeatNewPinL;
    String pin;

    ChangePin(String pin) {
        this.pin = pin;

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
            ATMJElementsCreator.forwardToTransactions(pin, this);
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

            String query1 = "update bank set " + DatabaseStrings.pinColumnS + " = '" + newPin + "' where " + DatabaseStrings.pinColumnS + " = '" + pin + "' ";
            String query2 = "update login set " + DatabaseStrings.pinColumnS + " = '" + newPin + "' where " + DatabaseStrings.pinColumnS + " = '" + pin + "' ";
            String query3 = "update signup3 set " + DatabaseStrings.pinColumnS + " = '" + newPin + "' where " + DatabaseStrings.pinColumnS + " = '" + pin + "' ";

            GeneralUtils.sendQuery(query1);
            GeneralUtils.sendQuery(query2);
            GeneralUtils.sendQuery(query3);

            JOptionPane.showMessageDialog(null, "PIN changed successfully");

            ATMJElementsCreator.forwardToTransactions(newPin, this);

        }
    }

    public static void main(String[] args) {
        new ChangePin("").setVisible(true);
    }
}
