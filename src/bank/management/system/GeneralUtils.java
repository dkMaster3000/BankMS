package bank.management.system;

import java.sql.ResultSet;
import javax.swing.*;
import java.util.Date;

public class GeneralUtils {
    public static boolean checkIfAllFieldsFilled(String[] requiredFields) {
        for (String requiredField : requiredFields) {
            if (requiredField.isEmpty()) {
                return false;
            }
        }

        return true;
    }

    public static void sendQuery(String query) {
        try {
            Conn c = new Conn();
            c.s.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    public static int getBalance(String pin) {
        int balance = 0;
        try {
            Conn c = new Conn();

            ResultSet rs = c.s.executeQuery("select * from bank where pin = '" + pin + "'");

            while (rs.next()) {

                int nextAmount = Integer.parseInt(rs.getString(DatabaseStrings.amountColumnS));

                if (rs.getString(DatabaseStrings.typeColumnS).equals(DatabaseStrings.depositTypeS)) {
                    balance += nextAmount;
                } else {
                    balance -= nextAmount;
                }
            }

        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
        return balance;
    }

    public static void handleWithdrawal(String pin, String amount, JFrame activeJFrame) {
        int balance = getBalance(pin);

        if (balance > Integer.parseInt(amount)) {
            Date date = new Date();
            String query = "insert into bank values('" + pin + "', '" + date + "', '" + DatabaseStrings.withdrawalTypeS + "', '" + amount + "')";
            GeneralUtils.sendQuery(query);

            JOptionPane.showMessageDialog(null, amount + ATMJElementsCreator.currencySign + " Debited Successfully");

            ATMJElementsCreator.forwardToTransactions(pin, activeJFrame);
        } else {
            JOptionPane.showMessageDialog(null, "Insufficient Balance");
        }
    }
}
