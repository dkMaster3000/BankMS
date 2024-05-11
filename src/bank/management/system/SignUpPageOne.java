package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpPageOne extends JFrame implements ActionListener {

    JLabel logo, formNoHeaderL, personalDetailsHeaderL, nameL, fatherNameL, birthDateL, genderL, emailL, maritalStatusL, addressL, cityL, pinCodeL, stateL;
    JTextField nameTF, fatherNameTF, emailTF, addressTF, cityTF, pinCodeTF, stateTF;
    JRadioButton maleR, femaleR, marriedR, unmarriedR, otherR;
    JButton nextButton;
    JDateChooser dateChooser;


    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    SignUpPageOne() {

        setTitle("NEW ACCOUNT APPLICATION FORM");

        logo = JElementsCreator.createLogo();
        logo.setBounds(20, 0, 100, 100);
        add(logo);

        setLayout(null);


        formNoHeaderL = JElementsCreator.createJLabel("APPLICATION FORM NO. " + first, 38, 140, 20, 600, 40);
        add(formNoHeaderL);

        personalDetailsHeaderL = JElementsCreator.createJLabel("Page 1: Personal Details", 22, 290, 80, 600, 30);
        add(personalDetailsHeaderL);

        nameL = JElementsCreator.createJLabel("Name:", 20, 100, 140, 100, 30);
        add(nameL);

        fatherNameL = JElementsCreator.createJLabel("Father's Name:", 20, 100, 190, 200, 30);
        add(fatherNameL);

        birthDateL = JElementsCreator.createJLabel("Date of Birth:", 20, 100, 240, 200, 30);
        add(birthDateL);

        genderL = JElementsCreator.createJLabel("Gender:", 20, 100, 290, 200, 30);
        add(genderL);

        emailL = JElementsCreator.createJLabel("Email Address:", 20, 100, 340, 200, 30);
        add(emailL);

        maritalStatusL = JElementsCreator.createJLabel("Marital Status:", 20, 100, 390, 200, 30);
        add(maritalStatusL);

        addressL = JElementsCreator.createJLabel("Address:", 20, 100, 440, 200, 30);
        add(addressL);

        cityL = JElementsCreator.createJLabel("City:", 20, 100, 490, 200, 30);
        add(cityL);

        pinCodeL = JElementsCreator.createJLabel("Pin Code:", 20, 100, 540, 200, 30);
        add(pinCodeL);

        stateL = JElementsCreator.createJLabel("State:", 20, 100, 590, 200, 30);
        add(stateL);


        nameTF = JElementsCreator.createJTextField(300, 140, 400, 30);
        add(nameTF);

        fatherNameTF = JElementsCreator.createJTextField(300, 190, 400, 30);
        add(fatherNameTF);

        emailTF = JElementsCreator.createJTextField(300, 340, 400, 30);
        add(emailTF);

        addressTF = JElementsCreator.createJTextField(300, 440, 400, 30);
        add(addressTF);

        cityTF = JElementsCreator.createJTextField(300, 490, 400, 30);
        add(cityTF);

        pinCodeTF = JElementsCreator.createJTextField(300, 540, 400, 30);
        add(pinCodeTF);

        stateTF = JElementsCreator.createJTextField(300, 590, 400, 30);
        add(stateTF);


        nextButton = JElementsCreator.createJButton("Next", 620, 660, 80, 30, this);
        add(nextButton);


        maleR = JElementsCreator.createJRadioButton("Male", 300, 290, 60, 30);
        add(maleR);
        femaleR = JElementsCreator.createJRadioButton("Female", 450, 290, 90, 30);
        add(femaleR);

        JElementsCreator.groupJRadioButtons(new JRadioButton[]{maleR, femaleR});


        marriedR = JElementsCreator.createJRadioButton("Married", 300, 390, 100, 30);
        add(marriedR);
        unmarriedR = JElementsCreator.createJRadioButton("Unmarried", 450, 390, 100, 30);
        add(unmarriedR);
        otherR = JElementsCreator.createJRadioButton("Other", 635, 390, 100, 30);
        add(otherR);

        JElementsCreator.groupJRadioButtons(new JRadioButton[]{marriedR, unmarriedR, otherR});


        dateChooser = new JDateChooser();
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        dateChooser.setBounds(300, 240, 400, 30);
        add(dateChooser);


        JElementsCreator.setDefaultSettings(this);
        setSize(850, 800);
    }

    //for testing purpose -> delete later
    public static void main(String[] args) {
        new SignUpPageOne();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        String formno = first;
        String name = nameTF.getText();
        String fname = fatherNameTF.getText();
        String dob = ((JTextField) dateChooser.getDateEditor().getUiComponent()).getText();
        String gender = "";
        if (maleR.isSelected()) {
            gender = "Male";
        } else if (femaleR.isSelected()) {
            gender = "Female";
        }

        String email = emailTF.getText();
        String marital = "";
        if (marriedR.isSelected()) {
            marital = "Married";
        } else if (unmarriedR.isSelected()) {
            marital = "Unmarried";
        } else if (otherR.isSelected()) {
            marital = "Other";
        }

        String address = addressTF.getText();
        String city = cityTF.getText();
        String pincode = pinCodeTF.getText();
        String state = stateTF.getText();


        if (GeneralUtils.checkIfAllFieldsFilled(new String[]{formno, name, fname, dob, gender, email, marital, address, city, pincode, state})) {
            String query = "insert into signup values('" + formno + "','" + name + "','" + fname + "','" + dob + "','" + gender + "','" + email + "','" + marital + "','" + address + "','" + city + "','" + pincode + "','" + state + "')";
            GeneralUtils.sendQuery(query);

            setVisible(false);
            new SignUpPageTwo(formno).setVisible(true);
        } else {
            JElementsCreator.showUnfilledFieldMessage();
        }

    }

}
