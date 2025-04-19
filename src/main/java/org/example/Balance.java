package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Balance extends JFrame implements ActionListener {

    JLabel labelCheckBalance, labelDisplayAmount;
    JButton buttonShowBalance, buttonCancelCheckBalance;
    String cardNo;
    Main mainScreen;

    Balance(String cardNo, Main mainScreen) {

        this.cardNo = cardNo;
        this.mainScreen = mainScreen;

        ImageIcon atm = new ImageIcon(ClassLoader.getSystemResource("icon/atm.png"));
        Image atm2 = atm.getImage().getScaledInstance(1260, 850, Image.SCALE_DEFAULT);
        ImageIcon atm3 = new ImageIcon(atm2);
        JLabel atmImage = new JLabel(atm3);
        atmImage.setBounds(0, 0,1260, 850);
        add(atmImage);

        labelCheckBalance = new JLabel("YOUR ACCOUNT BALANCE IS: ");
        labelCheckBalance.setForeground(Color.white);
        labelCheckBalance.setFont(new Font("System", Font.BOLD, 18));
        labelCheckBalance.setBounds(485, 335, 450, 35);
        atmImage.add(labelCheckBalance);

        labelDisplayAmount = new JLabel("XXXXXXXX");
        labelDisplayAmount.setForeground(Color.white);
        labelDisplayAmount.setBounds(425, 400, 405, 25);
        labelDisplayAmount.setFont(new Font("Raleway", Font.PLAIN, 20));
        labelDisplayAmount.setHorizontalAlignment(JTextField.CENTER);
        atmImage.add(labelDisplayAmount);

        buttonShowBalance = new JButton("SHOW");
        buttonShowBalance.setBounds(645, 470, 100, 35);
        buttonShowBalance.setForeground(Color.BLACK);
        buttonShowBalance.addActionListener(this);
        atmImage.add(buttonShowBalance);

        buttonCancelCheckBalance = new JButton("CANCEL");
        buttonCancelCheckBalance.setBounds(500, 470, 100, 35);
        buttonCancelCheckBalance.setForeground(Color.BLACK);
        buttonCancelCheckBalance.addActionListener(this);
        atmImage.add(buttonCancelCheckBalance);

        setLayout(null);
        setSize(1260, 850);
        setLocation(200, 50);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        try {
            if (e.getSource() == buttonShowBalance && buttonShowBalance.getText().equals("SHOW")) {

                Connect connect = new Connect();
                ResultSet isBalance = connect.statement.executeQuery("SELECT * FROM bank WHERE card_no = '" + cardNo + "'");

                double balance = 0;

                while (isBalance.next()) {
                        if (isBalance.getString("type").equals("Deposit")) {
                            balance += Double.parseDouble(isBalance.getString("amount"));
                        } else {
                            balance -= Double.parseDouble(isBalance.getString("amount"));
                        }
                    labelDisplayAmount.setText("€" + String.format("%.2f", balance));
                    buttonShowBalance.setText("HIDE");
                }

            } else if (e.getSource() == buttonShowBalance && buttonShowBalance.getText().equals("HIDE")) {
                labelDisplayAmount.setText("XXXXXXXX");
                buttonShowBalance.setText("SHOW");

            } else if (e.getSource() == buttonCancelCheckBalance) {
                dispose();
                mainScreen.setVisible(true);
            }
        } catch (Exception E) {
            E.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new Balance("", null);
    }
}
