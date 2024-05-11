package bank.management.system;

import java.awt.event.*;
import javax.swing.*;

public class SignUpPageTwo extends JFrame implements ActionListener {

    JLabel additionalDetailsHeader, religionL, categoryL, incomeL, educationalL, qualificationL, occupationL, socialNumberL, phoneNumberL, seniorCitizenL, existingAccL, formNoHeaderL, formNoL;
    JButton nextButton;
    JRadioButton seniorCitizenYesR, seniorCitizenNoR, existingAccYesR, existingAccNoR;
    JTextField socialNumberTF, phoneNumberTF, t3;
    JComboBox religionCB, categoryCB, incomeCB, educationCB, occupationCB;
    String formno;

    SignUpPageTwo(String formno) {

        this.formno = formno;

        JLabel logo = JElementsCreator.createLogo();
        logo.setBounds(150, 0, 100, 100);
        add(logo);

        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        additionalDetailsHeader = JElementsCreator.createJLabel("Page 2: Additonal Details", 22, 280, 30, 600, 40);
        add(additionalDetailsHeader);

        religionL = JElementsCreator.createJLabel("Religion:", 18, 100, 120, 100, 30);
        add(religionL);

        categoryL = JElementsCreator.createJLabel("Category:", 18, 100, 170, 100, 30);
        add(categoryL);

        incomeL = JElementsCreator.createJLabel("Income:", 18, 100, 220, 100, 30);
        add(incomeL);

        educationalL = JElementsCreator.createJLabel("Educational", 18, 100, 270, 150, 30);
        add(educationalL);

        qualificationL = JElementsCreator.createJLabel("Qualification:", 18, 100, 290, 150, 30);
        add(qualificationL);

        occupationL = JElementsCreator.createJLabel("Occupation:", 18, 100, 340, 150, 30);
        add(occupationL);

        socialNumberL = JElementsCreator.createJLabel("Social Number:", 18, 100, 390, 150, 30);
        add(socialNumberL);

        phoneNumberL = JElementsCreator.createJLabel("Phone Number:", 18, 100, 440, 180, 30);
        add(phoneNumberL);

        seniorCitizenL = JElementsCreator.createJLabel("Senior Citizen:", 18, 100, 490, 150, 30);
        add(seniorCitizenL);

        existingAccL = JElementsCreator.createJLabel("Existing Account:", 18, 100, 540, 180, 30);
        add(existingAccL);

        formNoHeaderL = JElementsCreator.createJLabel("Form No:", 13, 700, 10, 60, 30);
        add(formNoHeaderL);

        formNoL = JElementsCreator.createJLabel(formno, 13, 760, 10, 60, 30);
        add(formNoL);

        nextButton = JElementsCreator.createJButton("Next", 570, 640, 100, 30, this);
        add(nextButton);


        socialNumberTF = JElementsCreator.createJTextField(350, 390, 320, 30);
        add(socialNumberTF);

        phoneNumberTF = JElementsCreator.createJTextField(350, 440, 320, 30);
        add(phoneNumberTF);


        seniorCitizenYesR = JElementsCreator.createJRadioButton("Yes", 350, 490, 100, 30);
        add(seniorCitizenYesR);

        seniorCitizenNoR = JElementsCreator.createJRadioButton("No", 460, 490, 100, 30);
        add(seniorCitizenNoR);

        JElementsCreator.groupJRadioButtons(new JRadioButton[]{seniorCitizenYesR, seniorCitizenNoR});

        existingAccYesR = JElementsCreator.createJRadioButton("Yes", 350, 540, 100, 30);
        add(existingAccYesR);

        existingAccNoR = JElementsCreator.createJRadioButton("No", 460, 540, 100, 30);
        add(existingAccNoR);

        JElementsCreator.groupJRadioButtons(new JRadioButton[]{existingAccYesR, existingAccNoR});


        String[] religion = {"Hindu", "Muslim", "Buddhist", "Christian", "Other"};
        religionCB = JElementsCreator.createJComboBox(religion, 350, 120, 320, 30);
        add(religionCB);

        String[] category = {"General", "OBC", "SC", "ST", "Other"};
        categoryCB = JElementsCreator.createJComboBox(category, 350, 170, 320, 30);
        add(categoryCB);

        String[] income = {"Null", "<1500$", "<2500$", "<5000$", "Upto 10000$", "Above 10000$"};
        incomeCB = JElementsCreator.createJComboBox(income, 350, 220, 320, 30);
        add(incomeCB);

        String[] education = {"Non-Graduate", "Graduate", "Post-Graduate", "Doctrate", "Others"};
        educationCB = JElementsCreator.createJComboBox(education, 350, 270, 320, 30);
        add(educationCB);

        String[] occupation = {"Salaried", "Self-Employmed", "Business", "Student", "Retired", "Others"};
        occupationCB = JElementsCreator.createJComboBox(occupation, 350, 340, 320, 30);
        add(occupationCB);


        setLayout(null);


        JElementsCreator.setDefaultSettings(this);
        setSize(850, 750);

    }

    public void actionPerformed(ActionEvent ae) {
        String religion = (String) religionCB.getSelectedItem();
        String category = (String) categoryCB.getSelectedItem();
        String income = (String) incomeCB.getSelectedItem();
        String education = (String) educationCB.getSelectedItem();
        String occupation = (String) occupationCB.getSelectedItem();

        String socialNumber = socialNumberTF.getText();
        String phoneNumber = phoneNumberTF.getText();

        String seniorCitizen = "";
        if (seniorCitizenYesR.isSelected()) {
            seniorCitizen = "Yes";
        } else if (seniorCitizenNoR.isSelected()) {
            seniorCitizen = "No";
        }

        String existingAccount = "";
        if (existingAccYesR.isSelected()) {
            existingAccount = "Yes";
        } else if (existingAccNoR.isSelected()) {
            existingAccount = "No";
        }

        try {
            if (GeneralUtils.checkIfAllFieldsFilled(new String[]{religion, category, income, education, occupation, socialNumber, phoneNumber, seniorCitizen, existingAccount})) {
                String query = "insert into signup2 values('" + formno + "','" + religion + "','" + category + "','" + income + "','" + education + "','" + occupation + "','" + socialNumber + "','" + phoneNumber + "','" + seniorCitizen + "','" + existingAccount + "')";
                GeneralUtils.sendQuery(query);

//                new Signup3(formno).setVisible(true);
                setVisible(false);
            } else {
                JOptionPane.showMessageDialog(null, "Fill all the required fields");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpPageTwo("").setVisible(true);
    }
}
