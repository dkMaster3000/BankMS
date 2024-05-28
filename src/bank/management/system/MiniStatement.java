package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;

public class MiniStatement extends JFrame implements ActionListener {

    JButton exitB;
    DefaultListModel<String> listModel = new DefaultListModel<>(); //to add to the statements
    JList<String> allStatements = new JList<>(listModel); //to present the statements in JScrollPane

    MiniStatement(String cardnumber) {
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

        cardInfoL.setText("Card Number:    " + cardnumber.substring(0, 4) + "XXXXXXXX" + cardnumber.substring(12));

        int balance = GeneralUtils.getBalance(cardnumber);
        totalBalanceL.setText("Your Current Account Balance is " + balance + ATMDEFAULTVALUES.currencySign);

        try {
            Conn c1 = new Conn();
            ResultSet rs = c1.s.executeQuery("SELECT * FROM " + DatabaseStrings.bankTableS + " where " + DatabaseStrings.cardnumberColumnS + " = '" + cardnumber + "'");

            while (rs.next()) {

                String transactionType = rs.getString(DatabaseStrings.typeColumnS);
                String addedSpaces = transactionType.equals(DatabaseStrings.depositTypeS) ? "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" : "";

                String rowText = ("<html>" + rs.getString(DatabaseStrings.dateColumnS) + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        transactionType + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +
                        addedSpaces +
                        rs.getString(DatabaseStrings.amountColumnS) + "<br><br><html>");
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
