package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class FastCash extends JFrame implements ActionListener {

    JLabel amountL;
    JButton a20B, a50B, a100B, a200B, a500B, a1000B, backB;
    String cardnumber;

    private final int dollar20 = 20;
    private final int dollar50 = 50;
    private final int dollar100 = 100;
    private final int dollar200 = 200;
    private final int dollar500 = 500;
    private final int dollar1000 = 1000;


    FastCash(String cardnumber) {
        this.cardnumber = cardnumber;

        JLabel atm = ATMJElementsCreator.createATM();
        add(atm);

        amountL = ATMJElementsCreator.createATMJLabel("SELECT WITHDRAWAL AMOUNT", 235, 400, 700, 35, atm);

        a20B = ATMJElementsCreator.createATMJButton(dollar20 + ATMJElementsCreator.currencySign, ATMJElementsCreator.buttonColumn1, ATMJElementsCreator.buttonRow1, atm, this);
        a50B = ATMJElementsCreator.createATMJButton(dollar50 + ATMJElementsCreator.currencySign, ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow1, atm, this);
        a100B = ATMJElementsCreator.createATMJButton(dollar100 + ATMJElementsCreator.currencySign, ATMJElementsCreator.buttonColumn1, ATMJElementsCreator.buttonRow2, atm, this);
        a200B = ATMJElementsCreator.createATMJButton(dollar200 + ATMJElementsCreator.currencySign, ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow2, atm, this);
        a500B = ATMJElementsCreator.createATMJButton(dollar500 + ATMJElementsCreator.currencySign, ATMJElementsCreator.buttonColumn1, ATMJElementsCreator.buttonRow3, atm, this);
        a1000B = ATMJElementsCreator.createATMJButton(dollar1000 + ATMJElementsCreator.currencySign, ATMJElementsCreator.buttonColumn2, ATMJElementsCreator.buttonRow3, atm, this);
        backB = ATMJElementsCreator.createATMBackJButton(atm, this);

        ATMJElementsCreator.setATMDefaultSettings(this);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == backB) {
            ATMJElementsCreator.forwardToTransactions(cardnumber, this);
        } else {
            String amount = getAmount(((JButton) ae.getSource()).getText());

            GeneralUtils.handleWithdrawal(cardnumber, amount, this);
        }
    }

    private String getAmount(String amountString) {
        int amount = switch (amountString) {
            case dollar20 + ATMJElementsCreator.currencySign -> dollar20;
            case dollar50 + ATMJElementsCreator.currencySign -> dollar50;
            case dollar100 + ATMJElementsCreator.currencySign -> dollar100;
            case dollar200 + ATMJElementsCreator.currencySign -> dollar200;
            case dollar500 + ATMJElementsCreator.currencySign -> dollar500;
            case dollar1000 + ATMJElementsCreator.currencySign -> dollar1000;
            default -> 0;
        };

        return String.valueOf(amount);

    }

    public static void main(String[] args) {
        new FastCash("").setVisible(true);
    }
}
