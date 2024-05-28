package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class FastCash extends ATMFrame {

    JLabel amountL;
    JButton a20B, a50B, a100B, a200B, a500B, a1000B, backB;


    private final int dollar20 = 20;
    private final int dollar50 = 50;
    private final int dollar100 = 100;
    private final int dollar200 = 200;
    private final int dollar500 = 500;
    private final int dollar1000 = 1000;


    FastCash(String cardnumber) {
        super(cardnumber);

        amountL = createATMJLabel("SELECT WITHDRAWAL AMOUNT", 235, 400, 700, 35);

        a20B = createATMJButton(dollar20 + ATMDEFAULTVALUES.currencySign, ATMDEFAULTVALUES.buttonColumn1, ATMDEFAULTVALUES.buttonRow1);
        a50B = createATMJButton(dollar50 + ATMDEFAULTVALUES.currencySign, ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow1);
        a100B = createATMJButton(dollar100 + ATMDEFAULTVALUES.currencySign, ATMDEFAULTVALUES.buttonColumn1, ATMDEFAULTVALUES.buttonRow2);
        a200B = createATMJButton(dollar200 + ATMDEFAULTVALUES.currencySign, ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow2);
        a500B = createATMJButton(dollar500 + ATMDEFAULTVALUES.currencySign, ATMDEFAULTVALUES.buttonColumn1, ATMDEFAULTVALUES.buttonRow3);
        a1000B = createATMJButton(dollar1000 + ATMDEFAULTVALUES.currencySign, ATMDEFAULTVALUES.buttonColumn2, ATMDEFAULTVALUES.buttonRow3);
        backB = createATMBackJButton();

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backB) {
            forwardToTransactions();
        } else {
            String amount = getAmount(((JButton) ae.getSource()).getText());

            GeneralUtils.handleWithdrawal(cardnumber, amount);

            forwardToTransactions();
        }
    }

    private String getAmount(String amountString) {
        int amount = switch (amountString) {
            case dollar20 + ATMDEFAULTVALUES.currencySign -> dollar20;
            case dollar50 + ATMDEFAULTVALUES.currencySign -> dollar50;
            case dollar100 + ATMDEFAULTVALUES.currencySign -> dollar100;
            case dollar200 + ATMDEFAULTVALUES.currencySign -> dollar200;
            case dollar500 + ATMDEFAULTVALUES.currencySign -> dollar500;
            case dollar1000 + ATMDEFAULTVALUES.currencySign -> dollar1000;
            default -> 0;
        };

        return String.valueOf(amount);

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
