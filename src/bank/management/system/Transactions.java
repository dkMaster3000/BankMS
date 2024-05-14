package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Transactions extends JFrame implements ActionListener {

    JLabel transactionsHeader;
    JButton depositB, withdrawlB, fastCashB, statementB, pinChangeB, balanceB, exitB;
    String pin; //todo with cardnumber and not pin


    Transactions(String pin) {
        this.pin = pin;

        JLabel atm = JElementsCreator.createATM();
        add(atm);

        transactionsHeader = new JLabel("Please Select Your Transaction");
        transactionsHeader.setForeground(Color.WHITE);
        transactionsHeader.setFont(new Font("System", Font.BOLD, 16));
        transactionsHeader.setBounds(235, 400, 700, 35);
        atm.add(transactionsHeader);


        depositB = new JButton("DEPOSIT");
        withdrawlB = new JButton("CASH WITHDRAWL");
        fastCashB = new JButton("FAST CASH");
        statementB = new JButton("MINI STATEMENT");
        pinChangeB = new JButton("PIN CHANGE");
        balanceB = new JButton("BALANCE ENQUIRY");
        exitB = new JButton("EXIT");

        depositB.setBounds(170, 499, 150, 35);

        withdrawlB.setBounds(390, 499, 150, 35);

        fastCashB.setBounds(170, 543, 150, 35);

        statementB.setBounds(390, 543, 150, 35);

        pinChangeB.setBounds(170, 588, 150, 35);

        balanceB.setBounds(390, 588, 150, 35);

        exitB.setBounds(390, 633, 150, 35);


        atm.add(depositB);
        atm.add(withdrawlB);
        atm.add(fastCashB);
        atm.add(statementB);
        atm.add(pinChangeB);
        atm.add(balanceB);
        atm.add(exitB);

        depositB.addActionListener(this);
        withdrawlB.addActionListener(this);
        fastCashB.addActionListener(this);
        statementB.addActionListener(this);
        pinChangeB.addActionListener(this);
        balanceB.addActionListener(this);
        exitB.addActionListener(this);

        setLayout(null);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);


    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == depositB) {
            setVisible(false);
            new Deposit(pin).setVisible(true);
        } else if (ae.getSource() == withdrawlB) {
            setVisible(false);
//            new Withdrawl(pin).setVisible(true);
        } else if (ae.getSource() == fastCashB) {
            setVisible(false);
//            new FastCash(pin).setVisible(true);
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
