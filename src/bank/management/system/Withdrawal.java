package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawal extends JFrame implements ActionListener {

    JTextField amountTF;
    JButton withdrawB, backB;
    JLabel maxWithdrawalInfoL, amountL;
    String pin;

    Withdrawal(String pin) {
        this.pin = pin;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        maxWithdrawalInfoL = ATMJElementsCreator.createATMJLabel("MAXIMUM WITHDRAWAL IS 10,000$", 190, 350, 400, 20, atm);

        amountL = ATMJElementsCreator.createATMJLabel("PLEASE ENTER YOUR AMOUNT", 190, 400, 400, 20, atm);

        amountTF = new JTextField();
        amountTF.setFont(new Font("Raleway", Font.BOLD, 25));
        amountTF.setBounds(190, 450, 330, 30);
        atm.add(amountTF);

        withdrawB = ATMJElementsCreator.createATMJButton("WITHDRAW", 390, 588, atm, this);
        backB = ATMJElementsCreator.createATMJButton("BACK", 390, 633, atm, this);

        ATMJElementsCreator.setATMDefaultSettings(this);
    }


    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountTF.getText();
            Date date = new Date();
            if (ae.getSource() == withdrawB) {
                if (amountTF.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the Amount to you want to Withdraw");
                } else {
                    Conn c1 = new Conn();

                    ResultSet rs = c1.s.executeQuery("select * from bank where pin = '" + pin + "'");
                    int balance = 0;
                    while (rs.next()) {
                        if (rs.getString("type").equals("Deposit")) {
                            balance += Integer.parseInt(rs.getString("amount"));
                        } else {
                            balance -= Integer.parseInt(rs.getString("amount"));
                        }
                    }
                    if (balance < Integer.parseInt(amount)) {
                        JOptionPane.showMessageDialog(null, "Insuffient Balance");
                        return;
                    }

                    c1.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, amount + "$ Debited Successfully");

                    backToTransactions();
                }
            } else if (ae.getSource() == backB) {
                backToTransactions();
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("error: " + e);
        }

    }

    private void backToTransactions() {
        setVisible(false);
        new Transactions(pin).setVisible(true);
    }


    public static void main(String[] args) {
        new Withdrawal("").setVisible(true);
    }

}
