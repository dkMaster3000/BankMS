package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class Withdrawal extends ATMFrame {

    JTextField amountTF;
    JButton withdrawB, backB;
    JLabel maxWithdrawalInfoL, amountL;


    Withdrawal(String cardnumber) {
        super(cardnumber);

        maxWithdrawalInfoL = createATMJLabel("MAXIMUM WITHDRAWAL IS 10,000$", 190, 350, 400, 20);

        amountL = createATMJLabel("PLEASE ENTER YOUR AMOUNT", 190, 400, 400, 20);

        amountTF = createJTextField(25, 190, 450, 330, 30);

        withdrawB = createATMJButton("WITHDRAW", ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow3);
        backB = createATMBackJButton();
    }


    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backB) {
            forwardToTransactions();
        } else {
            String amount = amountTF.getText();

            if (amountTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
            } else {
                GeneralUtils.handleWithdrawal(cardnumber, amount);

                forwardToTransactions();
            }

        }
    }

    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }

}
