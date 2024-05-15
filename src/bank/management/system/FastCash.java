package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JLabel amountL;
    JButton a20B, a50B, a100B, a200B, a500B, a1000B, backB;
    String pin;

    private final int dollar20 = 20;
    private final int dollar50 = 50;
    private final int dollar100 = 100;
    private final int dollar200 = 200;
    private final int dollar500 = 500;
    private final int dollar1000 = 1000;

    private final String currencySign = "$";

    FastCash(String pin) {
        this.pin = pin;

        JLabel atm = JElementsCreator.createATM();
        add(atm);

        amountL = new JLabel("SELECT WITHDRAWL AMOUNT");
        amountL.setForeground(Color.WHITE);
        amountL.setFont(new Font("System", Font.BOLD, 16));
        amountL.setBounds(235, 400, 700, 35);
        atm.add(amountL);

        a20B = new JButton(dollar20 + currencySign);
        a50B = new JButton(dollar50 + currencySign);
        a100B = new JButton(dollar100 + currencySign);
        a200B = new JButton(dollar200 + currencySign);
        a500B = new JButton(dollar500 + currencySign);
        a1000B = new JButton(dollar1000 + currencySign);
        backB = new JButton("BACK");

        setLayout(null);


        a20B.setBounds(170, 499, 150, 35);
        atm.add(a20B);

        a50B.setBounds(390, 499, 150, 35);
        atm.add(a50B);

        a100B.setBounds(170, 543, 150, 35);
        atm.add(a100B);

        a200B.setBounds(390, 543, 150, 35);
        atm.add(a200B);

        a500B.setBounds(170, 588, 150, 35);
        atm.add(a500B);

        a1000B.setBounds(390, 588, 150, 35);
        atm.add(a1000B);

        backB.setBounds(390, 633, 150, 35);
        atm.add(backB);

        a20B.addActionListener(this);
        a50B.addActionListener(this);
        a100B.addActionListener(this);
        a200B.addActionListener(this);
        a500B.addActionListener(this);
        a1000B.addActionListener(this);
        backB.addActionListener(this);

        setSize(960, 1080);
        setLocation(500, 0);
        setUndecorated(true);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backB) {
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        } else {
            try {
                String amount = getAmount(((JButton) ae.getSource()).getText());
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");
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
                } else {
                    Date date = new Date();
                    c.s.executeUpdate("insert into bank values('" + pin + "', '" + date + "', 'Withdrawl', '" + amount + "')");
                    JOptionPane.showMessageDialog(null, amount + currencySign + " Debited Successfully");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }


            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }

    private String getAmount(String amountString) {
        int amount = switch (amountString) {
            case dollar20 + currencySign -> dollar20;
            case dollar50 + currencySign -> dollar50;
            case dollar100 + currencySign -> dollar100;
            case dollar200 + currencySign -> dollar200;
            case dollar500 + currencySign -> dollar500;
            case dollar1000 + currencySign -> dollar1000;
            default -> dollar20;
        };

        return String.valueOf(amount);

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
