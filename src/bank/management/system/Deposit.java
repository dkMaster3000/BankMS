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

        JLabel atm = JElementsCreator.createATM();
        add(atm);

        amountL = new JLabel("ENTER AMOUNT YOU WANT TO DEPOSIT");
        amountL.setForeground(Color.WHITE);
        amountL.setFont(new Font("System", Font.BOLD, 16));
        amountL.setBounds(190, 350, 400, 35);
        atm.add(amountL);

        amountTF = new JTextField();
        amountTF.setFont(new Font("Raleway", Font.BOLD, 22));
        amountTF.setBounds(190, 420, 320, 25);
        atm.add(amountTF);

        depositB = new JButton("DEPOSIT");
        backB = new JButton("BACK");

        depositB.setBounds(390, 588, 150, 35);

        backB.setBounds(390, 633, 150, 35);

        atm.add(depositB);
        atm.add(backB);

        depositB.addActionListener(this);
        backB.addActionListener(this);


        setLayout(null);

        setSize(960, 1080);
        setUndecorated(true);
        setLocation(500, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountTF.getText(); //todo only numbers allowed
            Date date = new Date();
            if (ae.getSource() == depositB) {
                if (amountTF.getText().equals("")) {
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

    private void backToTransactions() {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }

    public static void main(String[] args) {
        new Deposit("").setVisible(true);
    }
}
