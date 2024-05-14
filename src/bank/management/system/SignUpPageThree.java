package bank.management.system;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;

public class SignUpPageThree extends JFrame implements ActionListener {

    JLabel accDetailsHeaderL, accTypeL, cardNumberTextL, cardNumberL, cardNumberInfoL, cardNumberInfo2L, pinTextL, pinL, pinInfoL, servicesL, formNoTextL, formNoL;
    JRadioButton savingAccR, fixedDepositAccR, currentAccR, recurringDepositAccR;
    JButton submitButton, cancelButton;
    JCheckBox atmCardCB, internatBankCB, mobileBankCB, emailAlertsCB, chequeBookCB, estatementCB, declarationCB;
    String formno;

    SignUpPageThree(String formno) {
        this.formno = formno;

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel logo = JElementsCreator.createLogo();
        logo.setBounds(150, 0, 100, 100);
        add(logo);

        accDetailsHeaderL = JElementsCreator.createJLabel("Page 3: Account Details", 22, 280, 40, 400, 40);
        add(accDetailsHeaderL);

        accTypeL = JElementsCreator.createJLabel("Account Type:", 18, 100, 140, 200, 30);
        add(accTypeL);

        cardNumberTextL = JElementsCreator.createJLabel("Card Number:", 18, 100, 300, 200, 30);
        add(cardNumberTextL);

        cardNumberL = JElementsCreator.createJLabel("XXXX-XXXX-XXXX-4184", 18, 330, 300, 250, 30);
        add(cardNumberL);

        cardNumberInfoL = JElementsCreator.createJLabel("(Your 16-digit Card number)", 12, 100, 330, 200, 20);
        add(cardNumberInfoL);

        cardNumberInfo2L = JElementsCreator.createJLabel("It would appear on ATM Card/Cheque Book and Statements", 12, 330, 330, 500, 20);
        add(cardNumberInfo2L);

        pinTextL = JElementsCreator.createJLabel("PIN:", 18, 100, 370, 200, 30);
        add(pinTextL);

        pinL = JElementsCreator.createJLabel("XXXX", 18, 330, 370, 200, 30);
        add(pinL);

        pinInfoL = JElementsCreator.createJLabel("(4-digit password)", 12, 100, 400, 200, 20);
        add(pinInfoL);

        servicesL = JElementsCreator.createJLabel("Services Required:", 18, 100, 450, 200, 30);
        add(servicesL);

        formNoTextL = JElementsCreator.createJLabel("Form No:", 14, 700, 10, 70, 30);
        add(formNoTextL);

        formNoL = JElementsCreator.createJLabel(formno, 14, 770, 10, 40, 30);
        add(formNoL);


        submitButton = JElementsCreator.createJButton("Submit", 250, 720, 100, 30, this);
        add(submitButton);

        cancelButton = JElementsCreator.createJButton("Cancel", 420, 720, 100, 30, this);
        add(cancelButton);


        atmCardCB = JElementsCreator.createJCheckBox("ATM CARD", 16, 100, 500, 200, 30);
        add(atmCardCB);

        internatBankCB = JElementsCreator.createJCheckBox("Internet Banking", 16, 350, 500, 200, 30);
        add(internatBankCB);

        mobileBankCB = JElementsCreator.createJCheckBox("Mobile Banking", 16, 100, 550, 200, 30);
        add(mobileBankCB);

        emailAlertsCB = JElementsCreator.createJCheckBox("EMAIL Alerts", 16, 350, 550, 200, 30);
        add(emailAlertsCB);

        chequeBookCB = JElementsCreator.createJCheckBox("Cheque Book", 16, 100, 600, 200, 30);
        add(chequeBookCB);

        estatementCB = JElementsCreator.createJCheckBox("E-Statement", 16, 350, 600, 200, 30);
        add(estatementCB);

        declarationCB = JElementsCreator.createJCheckBox("I hereby declares that the above entered details correct to th best of my knowledge.", 12, 100, 680, 600, 20);
        add(declarationCB);

        savingAccR = JElementsCreator.createJRadioButton("Saving Account", 16, 100, 180, 150, 30);
        add(savingAccR);

        fixedDepositAccR = JElementsCreator.createJRadioButton("Fixed Deposit Account", 16, 350, 180, 300, 30);
        add(fixedDepositAccR);

        currentAccR = JElementsCreator.createJRadioButton("Current Account", 16, 100, 220, 250, 30);
        add(currentAccR);

        recurringDepositAccR = JElementsCreator.createJRadioButton("Recurring Deposit Account", 16, 350, 220, 250, 30);
        add(recurringDepositAccR);

        JElementsCreator.groupJRadioButtons(new JRadioButton[]{savingAccR, fixedDepositAccR, currentAccR, recurringDepositAccR});

        setLayout(null);


        JElementsCreator.setDefaultSettings(this);
        setSize(850, 850);

    }

    public void actionPerformed(ActionEvent ae) {
        String atype;
        if (savingAccR.isSelected()) {
            atype = "Saving Account";
        } else if (fixedDepositAccR.isSelected()) {
            atype = "Fixed Deposit Account";
        } else if (currentAccR.isSelected()) {
            atype = "Current Account";
        } else if (recurringDepositAccR.isSelected()) {
            atype = "Recurring Deposit Account";
        } else {
            atype = "";
        }

        Random ran = new Random();
        long first7 = (ran.nextLong() % 90000000L) + 5040936000000000L;
        String cardno = "" + Math.abs(first7);

        long first3 = (ran.nextLong() % 9000L) + 1000L;
        String pin = "" + Math.abs(first3);

        ArrayList<String> chosenFacility = new ArrayList<String>();
        if (atmCardCB.isSelected()) {
            chosenFacility.add(" ATM Card");
        }
        if (internatBankCB.isSelected()) {
            chosenFacility.add(" Internet Banking");
        }
        if (mobileBankCB.isSelected()) {
            chosenFacility.add(" Mobile Banking");
        }
        if (emailAlertsCB.isSelected()) {
            chosenFacility.add(" EMAIL Alerts");
        }
        if (chequeBookCB.isSelected()) {
            chosenFacility.add(" Cheque Book");
        }
        if (estatementCB.isSelected()) {
            chosenFacility.add(" E-Statement");
        }
        String facility = String.join(",", chosenFacility);

        String declaration = declarationCB.isSelected() ? "selected" : "";

        if (ae.getSource() == submitButton) {
            if (GeneralUtils.checkIfAllFieldsFilled(new String[]{atype, cardno, pin, declaration})) {

                String query1 = "insert into signup3 values('" + formno + "','" + atype + "','" + cardno + "','" + pin + "','" + facility + "')";
                GeneralUtils.sendQuery(query1);

                String query2 = "insert into login values('" + formno + "','" + cardno + "','" + pin + "')";
                GeneralUtils.sendQuery(query2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\n Pin:" + pin);

                new Deposit(pin).setVisible(true);
                setVisible(false);
            } else {
                JElementsCreator.showUnfilledFieldMessage();
            }

        } else if (ae.getSource() == cancelButton) {
            setVisible(false); //TODO every page should have a cancel button
            new Login().setVisible(true);
        }

    }

    public static void main(String[] args) {
        new SignUpPageThree("").setVisible(true);
    }
}
