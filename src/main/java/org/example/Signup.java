package org.example;



import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Random;
import com.toedter.calendar.JDateChooser;

public class Signup extends JFrame implements ActionListener {

    JLabel signUpTitle, personalDetails, labelFirstName, labelLastName, labelDOB, labelGender, labelEmail, labelPhone, labelAddress, labelPIN,
            labelCardNo;
    JTextField textFirstName, textLastName, textEmail, textPhone, textAddress, textCardNo;
    JPasswordField textPIN;
    JDateChooser chooseDate;
    JRadioButton radioMale, radioFemale, radioOther;
    JButton buttonSubmit, buttonCancel;
    long randomDigits, randomCardNo;
    Login logInScreen;

    Signup(Login logInScreen) {
        super ("APPLICATION FORM");
        this.logInScreen = logInScreen;

        logInScreen.dispose();

        ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image card2 = card1.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
        ImageIcon card3 = new ImageIcon(card2);
        JLabel cardimage = new JLabel(card3);
        cardimage.setBounds(25, 10, 100, 100);
        add(cardimage);

        Random random = new Random();
        randomDigits = Math.abs(random.nextLong() % 9000L + 1000L);

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
        textEmail.setBounds(340, 390, 350, 30);
        add(textEmail);

        labelPhone = new JLabel("Phone: ");
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

        textPIN = new JPasswordField();
        textPIN.setFont(new Font("Raleway", Font.PLAIN, 14));
        textPIN.setBounds(340, 540, 350, 30);
        add(textPIN);

        labelCardNo = new JLabel("Card No: ");
        labelCardNo.setFont(new Font("Raleway", Font.BOLD, 20));
        labelCardNo.setBounds(185, 590, 200, 30);
        add(labelCardNo);

        randomCardNo = 1000000000000000L + (Math.abs(random.nextLong()) % 9000000000000000L);
        String cardNoStr = String.valueOf(randomCardNo);
        String lastFourDigits = cardNoStr.substring(cardNoStr.length() - 4);
        String maskedCardNo = "XXXX XXXX XXXX " + lastFourDigits;

        textCardNo = new JTextField(maskedCardNo);
        textCardNo.setFont(new Font("Raleway", Font.BOLD, 14));
        textCardNo.setBounds(340, 589, 350, 30);
        textCardNo.setEditable(false);
        add(textCardNo);

        buttonSubmit = new JButton("Submit");
        buttonSubmit.setForeground(Color.BLACK);
        buttonSubmit.setBounds(590, 655, 100, 30);
        buttonSubmit.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSubmit.addActionListener(this);
        add(buttonSubmit);

        buttonCancel = new JButton("Cancel");
        buttonCancel.setForeground(Color.BLACK);
        buttonCancel.setBounds(470, 655, 100, 30);
        buttonCancel.setFont(new Font("Arial", Font.BOLD, 14));
        buttonCancel.addActionListener(this);
        add(buttonCancel);

        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setUndecorated(true);
        setVisible(true);

    }

    public boolean validateFields() {

        String firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        String dob = ((JTextField) chooseDate.getDateEditor().getUiComponent()).getText();
        String email = textEmail.getText();
        String phone = textPhone.getText();
        String address = textAddress.getText();
        String pin = Arrays.toString(textPIN.getPassword());
        boolean genderSelected = radioMale.isSelected() || radioFemale.isSelected() || radioOther.isSelected();

        if (firstName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your first name");
            return false;
        } else if (!firstName.matches("[a-zA-Z]+") || firstName.length() < 3) {
            JOptionPane.showMessageDialog(null, "First name must contain only letters and at least 3 characters");
            return false;
        }

        if (lastName.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your last name");
            return false;
        } else if (!lastName.matches("[a-zA-Z+]+") || lastName.length() < 3) {
            JOptionPane.showMessageDialog(null, "Last name must contain only letters and at least 3 characters");
            return false;
        }

        if (dob.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select your Date of Birth.");
            return false;
        }

        if (!genderSelected) {
            JOptionPane.showMessageDialog(null, "Please select your gender");
            return false;
        }

        if (email.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your email");
            return false;
        } else if (!email.matches("^[A-Za-z0-9+_.-]+@(.+)$")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid email address");
            return false;
        }

        if (phone.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter your phone number");
            return false;
        } else if (!phone.matches("\\d{9,10}")) {
            JOptionPane.showMessageDialog(null, "Your phone number must have 9 or 10 numbers");
            return false;
        }

        if (address.isEmpty() || !address.matches("^\\d+\\s+.*")) {
            JOptionPane.showMessageDialog(null, "Please enter a valid address");
            return false;
        }

        if (pin.isEmpty() || !pin.matches("\\d{4}")) {
            JOptionPane.showMessageDialog(null, "Your PIN must have 4 numbers");
            return false;
        }

        return true;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        long formNo = randomDigits;
        String firstName = textFirstName.getText();
        String lastName = textLastName.getText();
        String dob = ((JTextField) chooseDate.getDateEditor().getUiComponent()).getText();
        String gender = null;

        if (radioMale.isSelected()){
            gender = "Male";
        } else if (radioFemale.isSelected()) {
            gender = "Female";
        } else if (radioOther.isSelected()){
            gender = "Other";
        }


        String email = textEmail.getText();
        String phone = textPhone.getText();
        String address = textAddress.getText();
        String cardNo = String.valueOf(randomCardNo);
        String pin = textPIN.getText();


        try {
            if (e.getSource() == buttonCancel) {
                logInScreen.setVisible(true);
                dispose();
                return;
            } else if (!validateFields()) {
                return;
            }
                if (textFirstName.getText().isEmpty() ||
                        textLastName.getText().isEmpty() ||
                        dob.isEmpty() ||
                        gender == null ||
                        textEmail.getText().isEmpty() ||
                        textPhone.getText().isEmpty() ||
                        textAddress.getText().isEmpty() ||
                        textPIN.getText().isEmpty()) {

                    JOptionPane.showMessageDialog(null, "Please fill all fields");

                } else {

                    Connect connect = new Connect();
                    String addUserToSignUpTable = "INSERT INTO signup VALUES (" +
                            "'" + formNo + "'," +
                            " '" + firstName + "'," +
                            " '" + lastName + "'," +
                            " '" + dob + "'," +
                            " '" + gender + "'," +
                            " '" + email + "'," +
                            " '" + phone + "'," +
                            " '" + address + "'," +
                            " '" + cardNo + "'," +
                            " '" + pin + "')";

                    String addUserToLogInTable = "INSERT INTO login VALUES(" +
                            "'" + formNo + "'," +
                            " '" + cardNo + "'," +
                            " '" + pin + "')";

                    connect.statement.executeUpdate(addUserToSignUpTable);
                    connect.statement.executeUpdate(addUserToLogInTable);

                    JOptionPane.showMessageDialog(null, "Your details have been submitted successfully. " +
                            "Use your Card Number and PIN to log in." +
                            "\n" +
                            "\nYour Card Number: " + cardNo +
                            "\nYour PIN: " + pin);

                    EmailSender.sendEmail(firstName, email, cardNo, pin);

                    new Login();
                    dispose();
                }


            } catch(Exception E){
                E.printStackTrace();
            }


            // Exception handler

    }

    public static void main(String[] args) {

        new Signup(new Login());

    }
}
