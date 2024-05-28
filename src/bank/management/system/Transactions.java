package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class Transactions extends ATMFrame {

    JLabel transactionsHeader;
    JButton depositB, withdrawalB, fastCashB, statementB, pinChangeB, balanceB, exitB;

    Transactions(String cardnumber) {
        super(cardnumber);

        transactionsHeader = createATMJLabel("Please Select Your Transaction", 235, 400, 700, 35);

        depositB = createATMJButton("DEPOSIT", ATMDEFAULTVALUES.buttonColumn1, ATMDEFAULTVALUES.buttonRow1);
        withdrawalB = createATMJButton("CASH WITHDRAWL", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow1);
        fastCashB = createATMJButton("FAST CASH", ATMDEFAULTVALUES.buttonColumn1, ATMDEFAULTVALUES.buttonRow2);
        statementB = createATMJButton("MINI STATEMENT", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow2);
        pinChangeB = createATMJButton("PIN CHANGE", ATMDEFAULTVALUES.buttonColumn1, ATMDEFAULTVALUES.buttonRow3);
        balanceB = createATMJButton("BALANCE ENQUIRY", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow3);
        exitB = createATMJButton("EXIT", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow4);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositB) {
            forwardTo(new Deposit(cardnumber));

        } else if (ae.getSource() == withdrawalB) {
            forwardTo(new Withdrawal(cardnumber));

        } else if (ae.getSource() == fastCashB) {
            forwardTo(new FastCash(cardnumber));

        } else if (ae.getSource() == statementB) {
            new MiniStatement(cardnumber).setVisible(true);

        } else if (ae.getSource() == pinChangeB) {
            forwardTo(new ChangePin(cardnumber));

        } else if (ae.getSource() == balanceB) {
            forwardTo(new BalanceEnquiry(cardnumber));

        } else if (ae.getSource() == exitB) {
            System.exit(0);
        } else {
            System.out.println("No Action!");
        }
    }

    public static void main(String[] args) {
        new Transactions("").setVisible(true);
    }
}
