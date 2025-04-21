package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Main extends JFrame implements ActionListener {

    String cardNo;
    String userName = "USER";
    JLabel labelWelcomeUser;
    JButton buttonDeposit, buttonWithdraw, buttonCheckBalance, buttonChangePin, buttonGetStatement, buttonExit;


    Main(String cardNo){

        this.cardNo = cardNo;

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        try {

            Connect connect = new Connect();
            ResultSet isUser = connect.statement.executeQuery("SELECT first_name FROM signup WHERE card_no = '"+cardNo+"'");

            if (isUser.next()) {
                userName = isUser.getString("first_name").toUpperCase();
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        labelWelcomeUser = new JLabel("Welcome, " + userName);
        labelWelcomeUser.setBounds(400, 330, 700, 35);
        labelWelcomeUser.setForeground(Color.WHITE);
        labelWelcomeUser.setFont(new Font("Raleway", Font.BOLD, 16));
        atmImage.add(labelWelcomeUser);

        buttonDeposit = new JButton("Deposit");
        buttonDeposit.setBounds(400, 408, 115, 30);
        buttonDeposit.setForeground((Color.BLACK));
        buttonDeposit.setFont(new Font("System", Font.BOLD, 16));
        buttonDeposit.addActionListener(this);
        atmImage.add(buttonDeposit);

        buttonWithdraw = new JButton("Withdraw");
        buttonWithdraw.setBounds(400, 445, 115, 30);
        buttonWithdraw.setForeground((Color.BLACK));
        buttonWithdraw.setFont(new Font("System", Font.BOLD, 16));
        buttonWithdraw.addActionListener(this);
        atmImage.add(buttonWithdraw);

        buttonCheckBalance = new JButton("Balance");
        buttonCheckBalance.setBounds(400, 482, 115, 30);
        buttonCheckBalance.setForeground((Color.BLACK));
        buttonCheckBalance.setFont(new Font("System", Font.BOLD, 16));
        buttonCheckBalance.addActionListener(this);
        atmImage.add(buttonCheckBalance);

        buttonGetStatement = new JButton("Get Statement");
        buttonGetStatement.setBounds(710, 408, 150, 30);
        buttonGetStatement.setForeground((Color.BLACK));
        buttonGetStatement.setFont(new Font("System", Font.BOLD, 16));
        buttonGetStatement.addActionListener(this);
        atmImage.add(buttonGetStatement);

        buttonChangePin = new JButton("Change PIN");
        buttonChangePin.setBounds(710, 445, 150, 30);
        buttonChangePin.setForeground((Color.BLACK));
        buttonChangePin.setFont(new Font("System", Font.BOLD, 16));
        buttonChangePin.addActionListener(this);
        atmImage.add(buttonChangePin);

        buttonExit = new JButton("Exit");
        buttonExit.setBounds(710, 482, 150, 30);
        buttonExit.setForeground((Color.BLACK));
        buttonExit.setFont(new Font("System", Font.BOLD, 16));
        buttonExit.addActionListener(this);
        atmImage.add(buttonExit);

        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setUndecorated(true);
        setVisible(true);

    }

    public void getStatement(String cardNo) {
        this.cardNo = cardNo;

        try {
            Connect connect = new Connect();

            StringBuilder pastTransactions = new StringBuilder();

            ResultSet selectTransactions = connect.statement.executeQuery("SELECT date, type, amount FROM bank WHERE card_no = '" +cardNo+ "' ORDER BY date DESC");

            while (selectTransactions.next()) {

                String date = selectTransactions.getString("date");
                String type = selectTransactions.getString("type");
                String amount = selectTransactions.getString("amount");

                String symbol = "";
                String space = "";

                if (type.equalsIgnoreCase("deposit")){
                    symbol = "+";
                    space = "  ";
                } else if (type.equalsIgnoreCase("withdraw")){
                    symbol = "-";
                };

                pastTransactions.append(date)
                        .append(" | ")
                        .append(type)
                        .append(space)
                        .append(" | € ")
                        .append(symbol)
                        .append(amount)
                        .append("\n");

            }

            if (pastTransactions.isEmpty()) {
                JOptionPane.showMessageDialog(null, "No transactions found.");
            } else {

                JTextArea textArea = new JTextArea(pastTransactions.toString());
                textArea.setEditable(false);
                JScrollPane scrollPane = new JScrollPane(textArea);
                scrollPane.setPreferredSize(new Dimension(500, 300));

                JOptionPane.showMessageDialog(null, scrollPane, "Past Transactions: ", JOptionPane.INFORMATION_MESSAGE);
        }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == buttonDeposit) {
            new Deposit(cardNo, this);
            setVisible(false);

        } else if (e.getSource() == buttonWithdraw) {
            new Withdraw(cardNo, this);
            setVisible(false);

        } else if (e.getSource() == buttonCheckBalance) {
            new Balance(cardNo, this);
            setVisible(false);

        } else if (e.getSource() == buttonGetStatement) {
            getStatement(cardNo);


        } else if (e.getSource() == buttonChangePin) {
            new Changepin(cardNo, this);
            setVisible(false);

        } else {
            dispose();
            new Login();

        }

    }

    public static void main(String[] args) {
        new Main("");
    }
}
