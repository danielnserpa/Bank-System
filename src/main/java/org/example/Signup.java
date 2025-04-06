package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame {

    JLabel signUpTitle, personalDetails, labelFirstName, labelLastName, labelDOB, labelGender, labelEmail, labelPhone, labelAddress, labelPIN;
    JTextField textFirstName, textLastName, textEmail, textPhone, textAddress, textPIN;
    JDateChooser chooseDate;
    JRadioButton radioMale, radioFemale, radioOther;

    Signup() {
        super ("APPLICATION FORM");

        ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image card2 = card1.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
        ImageIcon card3 = new ImageIcon(card2);
        JLabel cardimage = new JLabel(card3);
        cardimage.setBounds(25, 10, 100, 100);
        add(cardimage);

        Random random = new Random();
        long randomDigits = Math.abs(random.nextLong() % 9000L + 1000L);

        signUpTitle = new JLabel("APPLICATION FORM NO. " + randomDigits);
        signUpTitle.setBounds(185, 20, 600, 40);
        signUpTitle.setFont(new Font("Raleway", Font.BOLD, 38));
        add(signUpTitle);

        personalDetails = new JLabel("Personal Details");
        personalDetails.setFont(new Font("Raleway", Font.BOLD, 22));
        personalDetails.setBounds(330, 80, 600, 30);
        add(personalDetails);

        labelFirstName = new JLabel("First Name: ");
        labelFirstName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelFirstName.setBounds(185, 190, 150, 30);
        add(labelFirstName);

        textFirstName = new JTextField();
        textFirstName.setFont(new Font("Raleway", Font.BOLD, 14));
        textFirstName.setBounds(340, 190, 350, 30);
        add(textFirstName);

        labelLastName = new JLabel("Last Name: ");
        labelLastName.setFont(new Font("Raleway", Font.BOLD, 20));
        labelLastName.setBounds(185, 240, 150, 30);
        add(labelLastName);

        textLastName = new JTextField();
        textLastName.setFont(new Font("Raleway", Font.BOLD, 14));
        textLastName.setBounds(340, 243, 350, 30);
        add(textLastName);

        labelDOB = new JLabel("Date of Birth: ");
        labelDOB.setFont(new Font("Raleway", Font.BOLD, 20));
        labelDOB.setBounds(185, 290, 200, 30);
        add(labelDOB);

        chooseDate = new JDateChooser();
        chooseDate.setForeground(new Color(105, 105, 105));
        chooseDate.setBounds(340, 290,370, 30);
        add(chooseDate);

        labelGender = new JLabel("Gender: ");
        labelGender.setFont(new Font("Raleway", Font.BOLD, 20));
        labelGender.setBounds(185, 340, 200, 30);
        add(labelGender);

        radioMale = new JRadioButton("Male");
        radioMale.setFont(new Font("Raleway", Font.BOLD, 14));
        radioMale.setBounds(340, 340, 60, 30);
        radioMale.setBackground(new Color(222, 255, 228));
        add(radioMale);

        radioFemale = new JRadioButton("Female");
        radioFemale.setFont(new Font("Raleway", Font.BOLD, 14));
        radioFemale.setBounds(420, 340, 80, 30);
        radioFemale.setBackground(new Color(222, 255, 228));
        add(radioFemale);

        radioOther = new JRadioButton("Other");
        radioOther.setFont(new Font("Raleway", Font.BOLD, 14));
        radioOther.setBounds(510, 340, 70, 30);
        radioOther.setBackground(new Color(222, 255, 228));
        add(radioOther);

        ButtonGroup group = new ButtonGroup();
        group.add(radioMale);
        group.add(radioFemale);
        group.add(radioOther);

        labelEmail = new JLabel("Email: ");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 20));
        labelEmail.setBounds(185, 390, 200, 30);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.PLAIN, 14));
        textEmail.setBounds(340, 391, 350, 30);
        add(textEmail);

        labelPhone = new JLabel("Phone");
        labelPhone.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPhone.setBounds(185, 440, 200, 30);
        add(labelPhone);

        textPhone = new JTextField();
        textPhone.setFont(new Font("Raleway", Font.PLAIN, 14));
        textPhone.setBounds(340, 440, 350, 30);
        add(textPhone);

        labelAddress = new JLabel("Address: ");
        labelAddress.setFont(new Font("Raleway", Font.BOLD, 20));
        labelAddress.setBounds(185, 490, 200, 30);
        add(labelAddress);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.PLAIN, 14));
        textAddress.setBounds(340, 490, 350, 30);
        add(textAddress);

        labelPIN = new JLabel("PIN: ");
        labelPIN.setFont(new Font("Raleway", Font.BOLD, 20));
        labelPIN.setBounds(185, 540, 200, 30);
        add(labelPIN);

        textPIN = new JTextField();
        textPIN.setFont(new Font("Raleway", Font.PLAIN, 14));
        textPIN.setBounds(340, 540, 350, 30);
        add(textPIN);








        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);

    }

    public static void main(String[] args) {

        new Signup();

    }
}
