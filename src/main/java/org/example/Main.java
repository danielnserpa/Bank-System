package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame implements ActionListener {

    JLabel labelWelcomeUser;
    JButton buttonDeposit, buttonWithdraw, buttonCheckBalance, buttonChangePin, buttonPrintStatement, buttonExit;

    Main(){

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        labelWelcomeUser = new JLabel("Welcome, " + "USER");
        labelWelcomeUser.setBounds(400, 330, 700, 35);
        labelWelcomeUser.setForeground(Color.WHITE);
        labelWelcomeUser.setFont(new Font("Raleway", Font.BOLD, 16));
        atmImage.add(labelWelcomeUser);

        buttonDeposit = new JButton("Deposit");
        buttonDeposit.setBounds(400, 408, 115, 27);
        buttonDeposit.setForeground((Color.BLACK));
        buttonDeposit.setFont(new Font("System", Font.BOLD, 16));
        atmImage.add(buttonDeposit);

        buttonWithdraw = new JButton("Withdraw");
        buttonWithdraw.setBounds(400, 445, 115, 27);
        buttonWithdraw.setForeground((Color.BLACK));
        buttonWithdraw.setFont(new Font("System", Font.BOLD, 16));
        atmImage.add(buttonWithdraw);

        buttonCheckBalance = new JButton("Balance");
        buttonCheckBalance.setBounds(400, 482, 115, 27);
        buttonCheckBalance.setForeground((Color.BLACK));
        buttonCheckBalance.setFont(new Font("System", Font.BOLD, 16));
        atmImage.add(buttonCheckBalance);

        buttonPrintStatement = new JButton("Get Statement");
        buttonPrintStatement.setBounds(710, 408, 150, 27);
        buttonPrintStatement.setForeground((Color.BLACK));
        buttonPrintStatement.setFont(new Font("System", Font.BOLD, 16));
        atmImage.add(buttonPrintStatement);

        buttonChangePin = new JButton("Change PIN");
        buttonChangePin.setBounds(710, 445, 150, 27);
        buttonChangePin.setForeground((Color.BLACK));
        buttonChangePin.setFont(new Font("System", Font.BOLD, 16));
        atmImage.add(buttonChangePin);

        buttonExit = new JButton("Exit");
        buttonExit.setBounds(710, 482, 150, 27);
        buttonExit.setForeground((Color.BLACK));
        buttonExit.setFont(new Font("System", Font.BOLD, 16));
        atmImage.add(buttonExit);

        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setVisible(true);



    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        new Main();
    }
}
