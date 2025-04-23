package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {

    public static void sendEmail(String userFirstName, String toEmail, String cardNo, String pin) {

        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", true);

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("serpadaniel22@gmail.com", "xncf pxni jggv rbhx");
            }
        });

        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("serpadaniel22@gmail.com"));
            message.setRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));
            message.setSubject("Welcome to the ATM System!");
            message.setText("Hello, " + userFirstName + "!" +  "\n\nYour sign up was successful. To log in, please use your card number and PIN.\n\n" +
                    "Your card number is: " + cardNo + "\n" +
                    "Your PIN is: " + pin + "\n\n" +
                    "Best Regards,\nATM System");
            Transport.send(message);
            System.out.println("E-mail sent successfully!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

}
