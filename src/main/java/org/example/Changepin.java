package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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
        labelOldPin.setBounds(400, 380, 100, 25);
        atmImage.add(labelOldPin);

        textOldPin = new JTextField();
        textOldPin.setBounds(515, 380, 300, 25);
        textOldPin.setFont(new Font("Raleway", Font.PLAIN, 16));
        atmImage.add(textOldPin);

        labelNewPin = new JLabel("New PIN: ");
        labelNewPin.setForeground(Color.WHITE);
        labelNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
        labelNewPin.setBounds(400, 415, 100, 25);
        atmImage.add(labelNewPin);

        textNewPin = new JTextField();
        textNewPin.setBounds(515, 415, 300, 25);
        textNewPin.setFont(new Font("Raleway", Font.PLAIN, 16));
        atmImage.add(textNewPin);

        labelConfirmNewPin = new JLabel("Confirm PIN: ");
        labelConfirmNewPin.setForeground(Color.WHITE);
        labelConfirmNewPin.setFont(new Font("Raleway", Font.BOLD, 16));
        labelConfirmNewPin.setBounds(400, 450, 110, 25);
        atmImage.add(labelConfirmNewPin);

        textConfirmNewPin = new JTextField();
        textConfirmNewPin.setBounds(515, 450, 300, 25);
        textConfirmNewPin.setFont(new Font("Raleway", Font.PLAIN, 16));
        atmImage.add(textConfirmNewPin);

        buttonCancelChangePin = new JButton("CANCEL");
        buttonCancelChangePin.setBounds(540, 490, 100, 30);
        buttonCancelChangePin.setForeground(Color.BLACK);
        buttonCancelChangePin.addActionListener(this);
        atmImage.add(buttonCancelChangePin);

        buttonConfirmChangePin = new JButton("CONFIRM");
        buttonConfirmChangePin.setBounds(665, 490, 100, 30);
        buttonConfirmChangePin.setForeground(Color.BLACK);
        buttonConfirmChangePin.addActionListener(this);
        atmImage.add(buttonConfirmChangePin);

        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {

            if (e.getSource() == buttonConfirmChangePin) {

                String oldPin = textOldPin.getText();
                String newPin = textNewPin.getText();
                String confirmPin = textConfirmNewPin.getText();

                if (oldPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null,"Please enter your current PIN.");
                    return;
                }

                if (newPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter your new PIN.");
                    return;
                }

                if (confirmPin.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please confirm your new PIN.");
                    return;
                }

                if (!newPin.equals(confirmPin)) {
                    JOptionPane.showMessageDialog(null, "New PIN doesn't match.");
                    return;
                }

                if (!(newPin.length() == 4)) {
                    JOptionPane.showMessageDialog(null, "Your PIN must contain 4 numbers");
                    return;
                }

                if (!(newPin.matches("^\\d+(\\.\\d+)?$"))) {
                    JOptionPane.showMessageDialog(null, "Your PIN must contain 4 numbers");
                    return;
                }

                Connect connect = new Connect();
                ResultSet changePin = connect.statement.executeQuery("SELECT * FROM login WHERE card_no = '" +cardNo+ "'");

                if (changePin.next()) {
                    String currentPin = changePin.getString("pin");

                    if (!oldPin.equals(currentPin)) {
                        JOptionPane.showMessageDialog(null,"Your current PIN is incorrect.");
                        return;
                    }

                    connect.statement.executeUpdate("UPDATE login SET pin = '" +newPin+ "' WHERE card_no = '" +cardNo+ "'");
                    connect.statement.executeUpdate("UPDATE signup SET pin = '" +newPin+ "' WHERE card_no = '" +cardNo+ "'");
                    JOptionPane.showMessageDialog(null, "Your PIN was updated successfully");

                    dispose();
                    mainScreen.setVisible(true);
                }

            } else if (e.getSource() == buttonCancelChangePin) {
                dispose();
                mainScreen.setVisible(true);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Changepin("", null);

    }

}
