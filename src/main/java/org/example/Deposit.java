package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

public class Deposit extends JFrame implements ActionListener {

    String pin;
    JLabel labelDepositAmount;
    JTextField textDepositAmount;
    JButton buttonSubmitDeposit, buttonCancelDeposit;

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

        textDepositAmount = new JTextField("€");
        textDepositAmount.setBounds(425, 385, 405, 25);
        textDepositAmount.setFont(new Font("Raleway", Font.PLAIN, 20));
        textDepositAmount.setHorizontalAlignment(JTextField.CENTER);
        atmImage.add(textDepositAmount);

        buttonSubmitDeposit = new JButton("DEPOSIT");
        buttonSubmitDeposit.setBounds(645, 470, 100, 35);
        buttonSubmitDeposit.setForeground(Color.BLACK);
        buttonSubmitDeposit.addActionListener(this);
        atmImage.add(buttonSubmitDeposit);

        buttonCancelDeposit = new JButton("CANCEL");
        buttonCancelDeposit.setBounds(500, 470, 100, 35);
        buttonCancelDeposit.setForeground(Color.BLACK);
        buttonCancelDeposit.addActionListener(this);
        atmImage.add(buttonCancelDeposit);


        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String amount = textDepositAmount.getText();
            Date date = new Date();

            if (e.getSource() == buttonSubmitDeposit) {
                if (textDepositAmount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you wish to deposit");
                } else {
                    Connect connect = new Connect();
                    String addInfoToBankTable = "INSERT INTO bank VALUES (" +
                            "'"+pin+"'," +
                            "'"+date+"'," +
                            "'"+amount+"')";

                    connect.statement.executeUpdate(addInfoToBankTable);

                    JOptionPane.showMessageDialog(null, "Your deposit was successful");

                }
            }

        } catch (Exception E) {
            E.printStackTrace();;
        }


    }

    public static void main(String[] args) {

        new Deposit("");
    }
}
