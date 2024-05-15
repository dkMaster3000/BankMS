package bank.management.system;

import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class Deposit extends JFrame implements ActionListener {

    JTextField amountTF;
    JButton depositB, backB;
    JLabel amountL;
    String pin;

    Deposit(String pin) {
        this.pin = pin;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        amountL = ATMJElementsCreator.createATMJLabel("ENTER AMOUNT YOU WANT TO DEPOSIT", 190, 350, 400, 35, atm);

        amountTF = ATMJElementsCreator.createJTextField(22, 190, 420, 320, 25, atm);

        depositB = ATMJElementsCreator.createATMJButton("DEPOSIT", ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow3, atm, this);
        backB = ATMJElementsCreator.createATMBackJButton(atm, this);


        ATMJElementsCreator.setATMDefaultSettings(this);
    }

    public void actionPerformed(ActionEvent ae) {

        if (ae.getSource() == backB) {
            ATMJElementsCreator.forwardToTransactions(pin, this);
        } else {
            String amount = amountTF.getText();

            if (amountTF.getText().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
            } else {
                Date date = new Date();
                String query = "insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')";
                GeneralUtils.sendQuery(query);

                JOptionPane.showMessageDialog(null, amount + ATMJElementsCreator.currencySign + " Deposited Successfully");

                ATMJElementsCreator.forwardToTransactions(pin, this);
            }
        }
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
