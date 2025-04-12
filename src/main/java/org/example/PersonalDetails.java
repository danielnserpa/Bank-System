package org.example;

import javax.swing.*;
import java.awt.*;

public class PersonalDetails extends JFrame {

    public PersonalDetails(){

        ImageIcon bank1 = new ImageIcon(ClassLoader.getSystemResource("icon/bankbg-cut.png"));
        Image bank2 = bank1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank3 = new ImageIcon(bank2);
        JLabel bankimage = new JLabel(bank3);
        bankimage.setBounds(350, 50, 100, 100);
        add(bankimage);

        getContentPane().setBackground(new Color(230, 228, 63));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    public static void main(String[] args) {

        new PersonalDetails();


    }
}
