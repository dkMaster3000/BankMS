package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

class BalanceEnquiry extends JFrame implements ActionListener {


    JButton backB;
    JLabel currentBalance;
    String pin;

    BalanceEnquiry(String pin) {
        this.pin = pin;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        int balance = GeneralUtils.getBalance(pin);

        currentBalance = ATMJElementsCreator.createATMJLabel("Your Current Account Balance is " + balance + ATMJElementsCreator.currencySign, 190, 350, 400, 35, atm);

        backB = ATMJElementsCreator.createATMBackJButton(atm, this);

        ATMJElementsCreator.setATMDefaultSettings(this);
    }

    public void actionPerformed(ActionEvent ae) {
        ATMJElementsCreator.forwardToTransactions(pin, this);
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}