package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Changepin extends JFrame implements ActionListener {

    JLabel labelChangePin, labelOldPin, labelNewPin, labelConfirmNewPin;
    JTextField textOldPin, textNewPin, textConfirmNewPin;
    JButton buttonConfirmChangePin, buttonCancelChangePin;
    String cardNo;
    Main mainScreen;

    Changepin(String cardNo, Main mainScreen) {
        this.cardNo = cardNo;
        this.mainScreen = mainScreen;

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        labelChangePin = new JLabel("CHANGE YOUR PIN ");
        labelChangePin.setForeground(Color.white);
        labelChangePin.setFont(new Font("System", Font.BOLD, 18));
        labelChangePin.setBounds(550, 335, 450, 35);
        atmImage.add(labelChangePin);

        labelOldPin = new JLabel("Old PIN: ");
        labelOldPin.setForeground(Color.WHITE);
        labelOldPin.setFont(new Font("Raleway", Font.BOLD, 16));
        labelOldPin.setBounds(400, 400, 100, 25);
        atmImage.add(labelOldPin);

        textOldPin = new JTextField();
        textOldPin.setBounds(525, 400, 250, 25);
        textOldPin.setFont(new Font("Raleway", Font.PLAIN, 20));
        atmImage.add(textOldPin);

        labelNewPin = new JLabel("New PIN: ");
        labelNewPin.setForeground(Color.WHITE);
        labelNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
        labelNewPin.setBounds(400, 440, 100, 25);
        atmImage.add(labelNewPin);

        textNewPin = new JTextField();
        textNewPin.setBounds(525, 440, 250, 25);
        textNewPin.setFont(new Font("Raleway", Font.PLAIN, 20));
        atmImage.add(textNewPin);

        labelConfirmNewPin = new JLabel("Confirm PIN: ");
        labelConfirmNewPin.setForeground(Color.WHITE);
        labelConfirmNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
        labelConfirmNewPin.setBounds(400, 480, 110, 25);
        atmImage.add(labelConfirmNewPin);

        textConfirmNewPin = new JTextField();
        textConfirmNewPin.setBounds(525, 480, 250, 25);
        textConfirmNewPin.setFont(new Font("Raleway", Font.PLAIN, 20));
        atmImage.add(textConfirmNewPin);

        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setUndecorated(true);
        setVisible(true);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {

        new Changepin("", null);

    }

}
