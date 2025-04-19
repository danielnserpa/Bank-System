package org.example;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Changepin extends JFrame implements ActionListener {

    JLabel labelCheckBalance, labelDisplayAmount;
    JButton buttonShowBalance, buttonCancelCheckBalance;
    String cardNo;
    Main mainScreen;

    Changepin(String cardNo, Main mainScreen) {
        this.cardNo = cardNo;
        this.mainScreen = mainScreen;


    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    public static void main(String[] args) {

        new Changepin("", null);

    }

}
