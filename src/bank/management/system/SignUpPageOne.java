package bank.management.system;

import java.awt.*;
import javax.swing.*;
import java.util.*;

import com.toedter.calendar.JDateChooser;

public class SignUpPageOne extends JFrame {

    JLabel formNoHeaderL, personalDetailsHeaderL, nameL, fatherNameL, birthDateL, genderL, emailL, maritalStatusL, addressL, cityL, l11, stateL, l13, l14, l15;
    JTextField nameTF, fatherNameTF, emailTF, addressTF, cityTF, pinCodeTF, stateTF;
    JRadioButton maleR, femaleR, marriedR, unmarriedR, otherR;
    JButton b;
    JDateChooser dateChooser;


    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = "" + Math.abs(first4);

    SignUpPageOne() {

        setTitle("NEW ACCOUNT APPLICATION FORM");

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/logo.jpg"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel pinCodeL = new JLabel(i3);
        pinCodeL.setBounds(20, 0, 100, 100);
        add(pinCodeL);


        formNoHeaderL = createJLabel("APPLICATION FORM NO. " + first, 38, 140, 20, 600, 40);
        add(formNoHeaderL);

        personalDetailsHeaderL = createJLabel("Page 1: Personal Details", 22, 290, 80, 600, 30);
        add(personalDetailsHeaderL);

        nameL = createJLabel("Name:", 20, 100, 140, 100, 30);
        add(nameL);

        fatherNameL = createJLabel("Father's Name:", 20, 100, 190, 200, 30);
        add(fatherNameL);

        birthDateL = createJLabel("Date of Birth:", 20, 100, 240, 200, 30);
        add(birthDateL);

        genderL = createJLabel("Gender:", 20, 100, 290, 200, 30);
        add(genderL);

        emailL = createJLabel("Email Address:", 20, 100, 340, 200, 30);
        add(emailL);

        maritalStatusL = createJLabel("Marital Status:", 20, 100, 390, 200, 30);
        add(maritalStatusL);

        addressL = createJLabel("Address:", 20, 100, 440, 200, 30);
        add(addressL);

        cityL = createJLabel("City:", 20, 100, 490, 200, 30);
        add(cityL);

        pinCodeL = createJLabel("Pin Code:", 20, 100, 540, 200, 30);
        add(pinCodeL);

        stateL = createJLabel("State:", 20, 100, 590, 200, 30);
        add(stateL);

        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));

        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));

        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));


        nameTF = createJTextField(300, 140, 400, 30);
        add(nameTF);

        fatherNameTF = createJTextField(300, 190, 400, 30);
        add(fatherNameTF);

        emailTF = createJTextField(300, 340, 400, 30);
        add(emailTF);

        addressTF = createJTextField(300, 440, 400, 30);
        add(addressTF);

        cityTF = createJTextField(300, 490, 400, 30);
        add(cityTF);

        pinCodeTF = createJTextField(300, 540, 400, 30);
        add(pinCodeTF);

        stateTF = createJTextField(300, 590, 400, 30);
        add(stateTF);


        b = new JButton("Next");
        b.setFont(new Font("Raleway", Font.BOLD, 14));
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(620, 660, 80, 30);
        add(b);

        maleR = createJRadioButton("Male");
        femaleR = createJRadioButton("Female");

        ButtonGroup groupgender = new ButtonGroup();
        groupgender.add(maleR);
        groupgender.add(femaleR);

        marriedR = createJRadioButton("Married");
        unmarriedR = createJRadioButton("Unmarried");
        otherR = createJRadioButton("Other");


        ButtonGroup groupstatus = new ButtonGroup();
        groupstatus.add(marriedR);
        groupstatus.add(unmarriedR);
        groupstatus.add(otherR);

        dateChooser = new JDateChooser();
        //dateChooser.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
        dateChooser.setForeground(new Color(105, 105, 105));
        dateChooser.setBounds(137, 337, 200, 29);
        add(dateChooser);

        setLayout(null);


        dateChooser.setBounds(300, 240, 400, 30);


        maleR.setBounds(300, 290, 60, 30);
        add(maleR);

        femaleR.setBounds(450, 290, 90, 30);
        add(femaleR);


        marriedR.setBounds(300, 390, 100, 30);
        add(marriedR);

        unmarriedR.setBounds(450, 390, 100, 30);
        add(unmarriedR);

        otherR.setBounds(635, 390, 100, 30);
        add(otherR);


//        b.addActionListener(this);

        getContentPane().setBackground(Color.WHITE);

        setSize(850, 800);
        setLocation(500, 120);
        setVisible(true);
    }


    public static void main(String[] args) {
        new SignUpPageOne();
    }

    private JLabel createJLabel(String text, int fontSize, int x, int y, int width, int height) {
        JLabel jLabelToReturn = new JLabel(text);
        jLabelToReturn.setFont(new Font("Raleway", Font.BOLD, fontSize));
        jLabelToReturn.setBounds(x, y, width, height);

        return jLabelToReturn;
    }

    private JTextField createJTextField(int x, int y, int width, int height) {
        JTextField jTextFieldToReturn = new JTextField();
        jTextFieldToReturn.setFont(new Font("Raleway", Font.BOLD, 14));
        jTextFieldToReturn.setBounds(x, y, width, height);

        return jTextFieldToReturn;
    }

    private JRadioButton createJRadioButton(String text) {
        JRadioButton jRadioButtonToReturn = new JRadioButton(text);
        jRadioButtonToReturn.setFont(new Font("Raleway", Font.BOLD, 14));
        jRadioButtonToReturn.setBackground(Color.WHITE);

        return jRadioButtonToReturn;
    }


}
