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

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        amountL = ATMJElementsCreator.createATMJLabel("SELECT WITHDRAWAL AMOUNT", 235, 400, 700, 35, atm);

        a20B = ATMJElementsCreator.createATMJButton(dollar20 + currencySign, 170, 499, atm, this);
        a50B = ATMJElementsCreator.createATMJButton(dollar50 + currencySign, 390, 499, atm, this);
        a100B = ATMJElementsCreator.createATMJButton(dollar100 + currencySign, 170, 543, atm, this);
        a200B = ATMJElementsCreator.createATMJButton(dollar200 + currencySign, 390, 543, atm, this);
        a500B = ATMJElementsCreator.createATMJButton(dollar500 + currencySign, 170, 588, atm, this);
        a1000B = ATMJElementsCreator.createATMJButton(dollar1000 + currencySign, 390, 588, atm, this);
        backB = ATMJElementsCreator.createATMJButton("BACK", 390, 633, atm, this);

        ATMJElementsCreator.setATMDefaultSettings(this);

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
            default -> 0;
        };

        return String.valueOf(amount);

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
