package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amountTF;
    JButton withdrawB, backB;
    JLabel maxWithdrawalInfoL, amountL;
    String pin;

    Withdrawal(String pin) {
        this.pin = pin;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        maxWithdrawalInfoL = ATMJElementsCreator.createATMJLabel("MAXIMUM WITHDRAWAL IS 10,000$", 190, 350, 400, 20, atm);

        amountL = ATMJElementsCreator.createATMJLabel("PLEASE ENTER YOUR AMOUNT", 190, 400, 400, 20, atm);

        amountTF = ATMJElementsCreator.createJTextField(25, 190, 450, 330, 30, atm);

        withdrawB = ATMJElementsCreator.createATMJButton("WITHDRAW", ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow3, atm, this);
        backB = ATMJElementsCreator.createATMBackJButton(atm, this);

        ATMJElementsCreator.setATMDefaultSettings(this);
    }


    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backB) {
            ATMJElementsCreator.forwardToTransactions(pin, this);
        } else {
            String amount = amountTF.getText();

            if (amountTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
            } else {
                GeneralUtils.handleWithdrawal(pin, amount, this);
            }

        }
    }

    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }

}
