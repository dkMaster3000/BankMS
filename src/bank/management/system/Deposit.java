package bank.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends ATMFrame {

    JTextField amountTF;
    JButton depositB, backB;
    JLabel amountL;


    Deposit(String cardnumber) {
        super(cardnumber);

        amountL = createATMJLabel("ENTER AMOUNT YOU WANT TO DEPOSIT", 190, 350, 400, 35);

        amountTF = createJTextField(22, 190, 420, 320, 25);

        depositB = createATMJButton("DEPOSIT", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow3);
        backB = createATMBackJButton();

    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backB) {
            forwardToTransactions();
        } else {
            String amount = amountTF.getText();

            if (amountTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            } else {
                Date date = new Date();
                String query = "insert into " + DatabaseStrings.bankTableS + " values('" + cardnumber + "', '" + date + "', '" + DatabaseStrings.depositTypeS + "', '" + amount + "')";
                GeneralUtils.sendQuery(query);

                JOptionPane.showMessageDialog(null, amount + ATMDEFAULTVALUES.currencySign + " Deposited Successfully");

                forwardToTransactions();
            }
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
