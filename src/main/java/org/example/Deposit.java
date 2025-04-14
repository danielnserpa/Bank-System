package org.example;

import javax.swing.*;
import java.awt.*;

public class Deposit extends JFrame {

    String pin;
    JLabel labelDepositAmount;
    JTextField textDepositAmount;

    Deposit(String pin) {
        this.pin = pin;

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        labelDepositAmount = new JLabel("ENTER THE AMOUNT YOU WISH TO DEPOSIT: ");
        labelDepositAmount.setForeground(Color.white);
        labelDepositAmount.setFont(new Font("System", Font.BOLD, 18));
        labelDepositAmount.setBounds(425, 335, 430, 35);
        atmImage.add(labelDepositAmount);

        textDepositAmount = new JTextField();
        textDepositAmount.setBounds(425, 385, 405, 25);
        textDepositAmount.setFont(new Font("Raleway", Font.PLAIN, 20));
        textDepositAmount.setHorizontalAlignment(JTextField.CENTER);
        atmImage.add(textDepositAmount);


        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setVisible(true);

    }

    public static void main(String[] args) {

        new Deposit("");
    }
}
