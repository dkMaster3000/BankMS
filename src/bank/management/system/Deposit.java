package bank.management.system;

import java.awt.*;
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

        amountTF = new JTextField();
        amountTF.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTF.setBounds(190, 420, 320, 25);
        atm.add(amountTF);

        depositB = ATMJElementsCreator.createATMJButton("DEPOSIT", 390, 588, atm, this);
        backB = ATMJElementsCreator.createATMJButton("BACK", 390, 633, atm, this);


        ATMJElementsCreator.setATMDefaultSettings(this);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountTF.getText();
            Date date = new Date();
            if (ae.getSource() == depositB) {
                if (amountTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Deposit");
                } else {
                    String query = "insert into bank values('" + pin + "', '" + date + "', 'Deposit', '" + amount + "')";
                    GeneralUtils.sendQuery(query);

                    JOptionPane.showMessageDialog(null, amount + "$ Deposited Successfully");

                    backToTransactions();
                }
            } else if (ae.getSource() == backB) {
                backToTransactions();
            } else {
                System.out.println("There is not such an action.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    //todo for all pages
    private void backToTransactions() {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
