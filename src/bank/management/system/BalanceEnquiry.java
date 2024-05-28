package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

class BalanceEnquiry extends ATMFrame {

    JButton backB;
    JLabel currentBalance;

    BalanceEnquiry(String cardnumber) {
        super(cardnumber);

        int balance = GeneralUtils.getBalance(cardnumber);

        currentBalance = createATMJLabel("Your Current Account Balance is " + balance + ATMDEFAULTVALUES.currencySign, 190, 350, 400, 35);

        backB = createATMBackJButton();

    }

    public void actionPerformed(ActionEvent ae) {
        forwardToTransactions();
    }

    public static void main(String[] args) {
        new BalanceEnquiry("").setVisible(true);
    }
}