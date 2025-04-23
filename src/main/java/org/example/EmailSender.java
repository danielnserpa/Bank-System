package org.example;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class EmailSender {
    public static void main(String[] args) {

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

            message.setRecipient(Message.RecipientType.TO,
                    new InternetAddress("danielnserpa@live.com"));

            message.setSubject("Testing Subject");
            message.setText("Dear Mail Crawler, " + "\n\n No spam to my email, please!");
            Transport.send(message);

            System.out.println("Email sent successfully");

        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
