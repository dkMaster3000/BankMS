package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class ChangePin extends ATMFrame {

    JPasswordField newPinPF, repeatNewPinPF;
    JButton changeB, backB;
    JLabel changePinHeaderL, newPinL, repeatNewPinL;

    ChangePin(String cardnumber) {
        super(cardnumber);

        changePinHeaderL = createATMJLabel("CHANGE YOUR PIN", 280, 330, 800, 35);

        newPinL = createATMJLabel("New PIN:", 180, 390, 150, 35);

        repeatNewPinL = createATMJLabel("Re-Enter New PIN:", 180, 440, 200, 35);


        newPinPF = createJPasswordField(350, 390, 180, 25);

        repeatNewPinPF = createJPasswordField(350, 440, 180, 25);


        changeB = createATMJButton("CHANGE", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow3);
        backB = createATMBackJButton();

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backB) {
            forwardToTransactions();
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

            forwardToTransactions();

        }
    }

    public static void main(String[] args) {
        new ChangePin("").setVisible(true);
    }
}
