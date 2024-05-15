package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel transactionsHeader;
    JButton depositB, withdrawlB, fastCashB, statementB, pinChangeB, balanceB, exitB;
    String pin; //todo with cardnumber and not pin


    Transactions(String pin) {
        this.pin = pin;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        transactionsHeader = ATMJElementsCreator.createATMJLabel("Please Select Your Transaction", 235, 400, 700, 35, atm);

        depositB = ATMJElementsCreator.createATMJButton("DEPOSIT", 170, 499, atm, this);
        withdrawlB = ATMJElementsCreator.createATMJButton("CASH WITHDRAWL", 390, 499, atm, this);
        fastCashB = ATMJElementsCreator.createATMJButton("FAST CASH", 170, 543, atm, this);
        statementB = ATMJElementsCreator.createATMJButton("MINI STATEMENT", 390, 543, atm, this);
        pinChangeB = ATMJElementsCreator.createATMJButton("PIN CHANGE", 170, 588, atm, this);
        balanceB = ATMJElementsCreator.createATMJButton("BALANCE ENQUIRY", 390, 588, atm, this);
        exitB = ATMJElementsCreator.createATMJButton("EXIT", 390, 633, atm, this);

        ATMJElementsCreator.setATMDefaultSettings(this);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositB) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawlB) {
            setVisible(false);
            new Withdrawal(pin).setVisible(true);
        } else if (ae.getSource() == fastCashB) {
            setVisible(false);
            new FastCash(pin).setVisible(true);
        } else if (ae.getSource() == statementB) {
//            new MiniStatement(pin).setVisible(true);
        } else if (ae.getSource() == pinChangeB) {
            setVisible(false);
//            new Pin(pin).setVisible(true);
        } else if (ae.getSource() == balanceB) {
            this.setVisible(false);
//            new BalanceEnquiry(pin).setVisible(true);
        } else if (ae.getSource() == exitB) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
