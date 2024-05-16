package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton exitB;
    DefaultListModel<String> listModel = new DefaultListModel<String>(); //to add the statements
    JList<String> allStatements = new JList<>(listModel); //to present the statements in JScrollPane

    MiniStatement(String pin) {
        super("Mini Statement");

        getContentPane().setBackground(Color.WHITE);
        setSize(400, 600);
        setLocation(20, 20);
        setLayout(null);

        JLabel bankNameL = new JLabel("Rich Bank");
        bankNameL.setBounds(150, 20, 100, 20);
        add(bankNameL);

        JLabel cardInfoL = new JLabel();
        cardInfoL.setBounds(20, 60, 300, 20);
        add(cardInfoL);

        JScrollPane scroller = new JScrollPane(allStatements);
        scroller.setBounds(20, 100, 350, 320);
        scroller.setBackground(Color.WHITE);
        add(scroller);

        JLabel totalBalanceL = new JLabel();
        totalBalanceL.setBounds(20, 450, 300, 20);
        add(totalBalanceL);

        exitB = new JButton("Exit");
        exitB.setBounds(20, 500, 100, 25);
        exitB.addActionListener(this);
        add(exitB);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from " + DatabaseStrings.loginTableS + " where pin = '" + pin + "'");
            if (rs.next()) {
                cardInfoL.setText("Card Number:    " + rs.getString(DatabaseStrings.cardnumberColumnS).substring(0, 4) + "XXXXXXXX" + rs.getString(DatabaseStrings.cardnumberColumnS).substring(12));
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }

        int balance = GeneralUtils.getBalance(pin);
        totalBalanceL.setText("Your Current Account Balance is " + balance + ATMJElementsCreator.currencySign);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM " + DatabaseStrings.bankTableS + " where pin = '" + pin + "'");
            while (rs.next()) {
                String rowText = "<html>" + rs.getString(DatabaseStrings.dateColumnS) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString(DatabaseStrings.typeColumnS) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        rs.getString(DatabaseStrings.amountColumnS) + "<br><br><html>";
                listModel.addElement(rowText);
            }
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public void actionPerformed(ActionEvent ae) {
        this.setVisible(false);
    }

    public static void main(String[] args) {
        new MiniStatement("").setVisible(true);
    }

}
