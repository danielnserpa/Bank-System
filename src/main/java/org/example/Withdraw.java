package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.text.DecimalFormat;
import java.util.Date;

public class Withdraw extends JFrame implements ActionListener {

    JLabel labelWithdrawFastCash, labelWithdrawAmount, atmImage;
    JTextField textWithdrawAmount;
    JButton buttonSubmitWithdraw, buttonCancelWithdraw, button50, button100, button200, button500, button1000, buttonOther;
    String cardNo;
    Main mainScreen;

    Withdraw(String cardNo, Main mainScreen) {

        this.cardNo = cardNo;
        this.mainScreen = mainScreen;

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        labelWithdrawFastCash = new JLabel("SELECT WITHDRAW AMOUNT: ");
        labelWithdrawFastCash.setForeground(Color.white);
        labelWithdrawFastCash.setFont(new Font("System", Font.BOLD, 18));
        labelWithdrawFastCash.setBounds(500, 335, 450, 35);
        atmImage.add(labelWithdrawFastCash);

        labelWithdrawAmount = new JLabel("ENTER THE AMOUNT YOU WISH TO WITHDRAW: ");
        labelWithdrawAmount.setForeground(Color.white);
        labelWithdrawAmount.setFont(new Font("System", Font.BOLD, 18));
        labelWithdrawAmount.setBounds(425, 335, 450, 35);

        textWithdrawAmount = new JTextField();
        textWithdrawAmount.setBounds(425, 385, 405, 25);
        textWithdrawAmount.setFont(new Font("Raleway", Font.PLAIN, 20));
        textWithdrawAmount.setHorizontalAlignment(JTextField.CENTER);

        button50 = new JButton("€50");
        button50.setBounds(400, 408, 75, 27);
        button50.setForeground(Color.BLACK);
        button50.addActionListener(this);
        atmImage.add(button50);

        button100 = new JButton("€100");
        button100.setBounds(400, 445, 75, 27);
        button100.setForeground((Color.BLACK));
        button100.addActionListener(this);
        atmImage.add(button100);

        button200 = new JButton("€200");
        button200.setBounds(400, 482, 75, 27);
        button200.setForeground((Color.BLACK));
        button200.addActionListener(this);
        atmImage.add(button200);

        button500 = new JButton("€500");
        button500.setBounds(790, 408, 75, 27);
        button500.setForeground((Color.BLACK));
        button500.addActionListener(this);
        atmImage.add(button500);

        button1000 = new JButton("€1000");
        button1000.setBounds(790, 445, 75, 27);
        button1000.setForeground((Color.BLACK));
        button1000.addActionListener(this);
        atmImage.add(button1000);

        buttonOther = new JButton("Other");
        buttonOther.setBounds(790, 482, 75, 27);
        buttonOther.setForeground((Color.BLACK));
        buttonOther.addActionListener(this);
        atmImage.add(buttonOther);

        buttonSubmitWithdraw = new JButton("CONFIRM");
        buttonSubmitWithdraw.setBounds(645, 470, 100, 30);
        buttonSubmitWithdraw.setForeground(Color.BLACK);
        buttonSubmitWithdraw.addActionListener(this);

        buttonCancelWithdraw = new JButton("CANCEL");
        buttonCancelWithdraw.setBounds(575, 482, 100, 27);
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

            Date date = new Date();
            double definedWithdrawAmount = 0;
            boolean triggerWithdraw = false;

            if (e.getSource() == button50) {
                definedWithdrawAmount = 50;
                triggerWithdraw = true;
            } else if (e.getSource() == button100) {
                definedWithdrawAmount = 100;
                triggerWithdraw = true;
            } else if (e.getSource() == button200) {
                definedWithdrawAmount = 200;
                triggerWithdraw = true;
            } else if (e.getSource() == button500) {
                definedWithdrawAmount = 500;
                triggerWithdraw = true;
            } else if (e.getSource() == button1000) {
                definedWithdrawAmount = 1000;
                triggerWithdraw = true;
            } else if (e.getSource() == buttonOther) {

                button50.setVisible(false);
                button100.setVisible(false);
                button200.setVisible(false);
                button500.setVisible(false);
                button1000.setVisible(false);
                buttonOther.setVisible(false);
                labelWithdrawFastCash.setVisible(false);

                atmImage.add(labelWithdrawAmount);
                atmImage.add(textWithdrawAmount);
                buttonCancelWithdraw.setBounds(500, 470, 100, 30);
                atmImage.add(buttonSubmitWithdraw);

            } else if (e.getSource() == buttonSubmitWithdraw) {

                // VALIDAR WITHDRAW DA MESMA FORMA QUE O DEPOSIT. TENTAR SEM USAR CHAT GPT

                if (textWithdrawAmount.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter the amount you wish to withdraw  ");
                } else {
                    definedWithdrawAmount = Double.parseDouble(textWithdrawAmount.getText());
                    triggerWithdraw = true;
                }

            } else if (e.getSource() == buttonCancelWithdraw) {
                    dispose();
                    mainScreen.setVisible(true);
            }

            if (triggerWithdraw) {

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

                    if (balance < definedWithdrawAmount) {
                        JOptionPane.showMessageDialog(null, "Insufficient funds");
                        return;
                    }

                    connect.statement.executeUpdate("INSERT INTO bank VALUES (" +
                            "'"+cardNo+"'," +
                            "'"+date+"'," +
                            "'Withdraw'," +
                            "'"+definedWithdrawAmount+"')");

                DecimalFormat format = new DecimalFormat("€#, ##0.##");
                String formattedAmount = format.format(definedWithdrawAmount);

                    JOptionPane.showMessageDialog(null, formattedAmount + "withdrew successfully");
                    dispose();
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
