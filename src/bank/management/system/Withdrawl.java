package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Date;
import java.sql.*;

public class Withdrawl extends JFrame implements ActionListener {

    JTextField amountTF;
    JButton withdrawB, backB;
    JLabel maxWithdrawlInfoL, amountL;
    String pin;

    Withdrawl(String pin) {
        this.pin = pin;

        JLabel atm = JElementsCreator.createATM();
        add(atm);

        maxWithdrawlInfoL = new JLabel("MAXIMUM WITHDRAWAL IS 10,000$");
        maxWithdrawlInfoL.setForeground(Color.WHITE);
        maxWithdrawlInfoL.setFont(new Font("System", Font.BOLD, 16));
        maxWithdrawlInfoL.setBounds(190, 350, 400, 20);
        atm.add(maxWithdrawlInfoL);

        amountL = new JLabel("PLEASE ENTER YOUR AMOUNT");
        amountL.setForeground(Color.WHITE);
        amountL.setFont(new Font("System", Font.BOLD, 16));
        amountL.setBounds(190, 400, 400, 20);
        atm.add(amountL);

        amountTF = new JTextField();
        amountTF.setFont(new Font("Raleway", Font.BOLD, 25));
        amountTF.setBounds(190, 450, 330, 30);
        atm.add(amountTF);

        withdrawB = new JButton("WITHDRAW");
        backB = new JButton("BACK");


        withdrawB.setBounds(390, 588, 150, 35);

        backB.setBounds(390, 633, 150, 35);

        atm.add(withdrawB);
        atm.add(backB);

        withdrawB.addActionListener(this);
        backB.addActionListener(this);

        setLayout(null);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);
    }


    public void actionPerformed(ActionEvent ae) {
        try {
            String amount = amountTF.getText();
            Date date = new Date();
            if (ae.getSource() == withdrawB) {
                if (amountTF.getText().equals("")) {
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
        new Withdrawl("").setVisible(true);
    }

}
