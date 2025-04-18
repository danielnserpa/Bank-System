package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    String cardNo;
    JLabel labelWithdrawAmount;
    JTextField textWithdrawAmount;
    JButton buttonSubmitWithdraw, buttonCancelWithdraw;
    Main mainScreen;

    Withdraw(String cardNo, Main mainScreen) {

        this.cardNo = cardNo;
        this.mainScreen = mainScreen;

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        labelWithdrawAmount = new JLabel("ENTER THE AMOUNT YOU WISH TO WITHDRAW: ");
        labelWithdrawAmount.setForeground(Color.white);
        labelWithdrawAmount.setFont(new Font("System", Font.BOLD, 18));
        labelWithdrawAmount.setBounds(425, 335, 450, 35);
        atmImage.add(labelWithdrawAmount);

        textWithdrawAmount = new JTextField();
        textWithdrawAmount.setBounds(425, 385, 405, 25);
        textWithdrawAmount.setFont(new Font("Raleway", Font.PLAIN, 20));
        textWithdrawAmount.setHorizontalAlignment(JTextField.CENTER);
        atmImage.add(textWithdrawAmount);

        buttonSubmitWithdraw = new JButton("CONFIRM");
        buttonSubmitWithdraw.setBounds(645, 470, 100, 35);
        buttonSubmitWithdraw.setForeground(Color.BLACK);
        buttonSubmitWithdraw.addActionListener(this);
        atmImage.add(buttonSubmitWithdraw);

        buttonCancelWithdraw = new JButton("CANCEL");
        buttonCancelWithdraw.setBounds(500, 470, 100, 35);
        buttonCancelWithdraw.setForeground(Color.BLACK);
        buttonCancelWithdraw.addActionListener(this);
        atmImage.add(buttonCancelWithdraw);

        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            String amount = textWithdrawAmount.getText();
            Date date = new Date();

            // ADD A CONDITION TO ALLOW WITHDRAWS UP TO MAXIMUM 1500


            if (e.getSource() == buttonSubmitWithdraw) {
                if (textWithdrawAmount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you wish to withdraw  ");
                } else {
                    Connect connect = new Connect();

                    ResultSet selectTransactions = connect.statement.executeQuery("SELECT * FROM bank WHERE card_no = '"+cardNo+"'");

                    double balance = 0;

                    while (selectTransactions.next()) {
                        if (selectTransactions.getString("type").equals("Deposit")) {
                            balance += Double.parseDouble(selectTransactions.getString("amount"));
                        } else {
                            balance -= Double.parseDouble(selectTransactions.getString("amount"));
                        }
                    }

                    if (balance < Double.parseDouble(amount)) {
                        JOptionPane.showMessageDialog(null, "Insufficient funds");
                        return;
                    }

                    connect.statement.executeUpdate("INSERT INTO bank VALUES (" +
                            "'"+cardNo+"'," +
                            "'"+date+"'," +
                            "'Withdraw'," +
                            "'"+amount+"')");

                    JOptionPane.showMessageDialog(null, "€" + amount + " withdrew successfully");
                    setVisible(false);
                    mainScreen.setVisible(true);

                }
            } else if (e.getSource() == buttonCancelWithdraw) {
                setVisible(false);
                mainScreen.setVisible(true);
            }

        } catch (Exception E) {
            E.printStackTrace();
        }

    }

    public static void main(String[] args) {

        new Withdraw("", null);

    }
}
