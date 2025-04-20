package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JLabel labelLogInTitle, labelCardNumber, labelPin;
    JTextField textInsertCardNumber;
    JPasswordField passwordInsertPin;
    JButton buttonSignIn, buttonClear, buttonSignUp, buttonExit;

    Login() {

        super("ATM System");

        ImageIcon card1 = new ImageIcon(ClassLoader.getSystemResource("icon/card.png"));
        Image card2 = card1.getImage().getScaledInstance(125, 125, Image.SCALE_DEFAULT);
        ImageIcon card3 = new ImageIcon(card2);
        JLabel cardimage = new JLabel(card3);
        cardimage.setBounds(318, 10, 100, 100);
        add(cardimage);

        labelLogInTitle = new JLabel("WELCOME TO THE ATM SYSTEM");
        labelLogInTitle.setForeground(Color.WHITE);
        labelLogInTitle.setFont(new Font("AvantGarde", Font.BOLD, 23));
        labelLogInTitle.setBounds(185, 125, 450, 40);
        add(labelLogInTitle);

        labelCardNumber = new JLabel("Card No: ");
        labelCardNumber.setForeground(Color.WHITE);
        labelCardNumber.setFont(new Font("Raleway", Font.BOLD, 18));
        labelCardNumber.setBounds(185, 190, 375, 30);
        add(labelCardNumber);

        labelPin = new JLabel("PIN: ");
        labelPin.setForeground(Color.WHITE);
        labelPin.setFont(new Font("Raleway", Font.BOLD, 18));
        labelPin.setBounds(185, 250, 375, 30);
        add(labelPin);

        textInsertCardNumber = new JTextField(15);
        textInsertCardNumber.setBounds(318, 190, 230, 30);
        textInsertCardNumber.setFont(new Font("Arial", Font.BOLD, 14));
        add(textInsertCardNumber);

        passwordInsertPin = new JPasswordField(15);
        passwordInsertPin.setBounds(318, 250, 230, 30);
        passwordInsertPin.setFont(new Font("Arial", Font.BOLD, 14));
        add(passwordInsertPin);

        buttonSignIn = new JButton("SIGN IN");
        buttonSignIn.setForeground(Color.BLACK);
        buttonSignIn.setBounds(250, 305, 100, 30);
        buttonSignIn.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignIn.addActionListener(this);
        add(buttonSignIn);

        buttonClear = new JButton("CLEAR");
        buttonClear.setForeground(Color.BLACK);
        buttonClear.setBounds(379, 305, 100, 30);
        buttonClear.setFont(new Font("Arial", Font.BOLD, 14));
        buttonClear.addActionListener(this);
        add(buttonClear);

        buttonSignUp = new JButton("SIGN UP");
        buttonSignUp.setForeground(Color.BLACK);
        buttonSignUp.setBounds(250, 355, 230, 30);
        buttonSignUp.setFont(new Font("Arial", Font.BOLD, 14));
        buttonSignUp.addActionListener(this);
        add(buttonSignUp);

        buttonExit = new JButton("EXIT");
        buttonExit.setForeground(Color.BLACK);
        buttonExit.setBounds(575, 526, 100, 30);
        buttonExit.setFont(new Font("Arial", Font.BOLD, 14));
        buttonExit.addActionListener(this);
        add(buttonExit);

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/bankbg.jpg"));
        Image bank2 = bank1.getImage().getScaledInstance(736, 582, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bankimage = new JLabel(bank3);
        bankimage.setBounds(0, 0, 736, 552);
        add(bankimage);

        setLayout(null);
        setSize(736, 582);
        setLocation(450, 200);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        String cardNumber = textInsertCardNumber.getText();
        String pinNumber = passwordInsertPin.getText();

        try {
            if (e.getSource() == buttonSignIn) {

                if (cardNumber.isEmpty() && pinNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your card and PIN numbers");
                } else if (cardNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your card number");
                } else if (pinNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your PIN number");
                } else {
                    try {

                        Connect connect = new Connect();
                        String searchForUser = "SELECT * FROM signup WHERE card_no = '" + cardNumber + "' AND pin = '" + pinNumber + "'";
                        ResultSet logInAttempt = connect.statement.executeQuery(searchForUser);

                        if (logInAttempt.next()) {
                            JOptionPane.showMessageDialog(null, "Login Successful");
                            new Main(cardNumber);
                            setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null,"Invalid Card Number or PIN");
                        }
                    } catch (Exception ex){
                        ex.printStackTrace();
                    }
                }

            } else if (e.getSource() == buttonClear) {
                textInsertCardNumber.setText("");
                passwordInsertPin.setText("");

            } else if (e.getSource() == buttonSignUp) {
                Signup signup = new Signup(this);
                signup.setVisible(true);
                this.setVisible(false);
            } else if (e.getSource() == buttonExit) {
                System.exit(0);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Login();

    }
}
