package mail;

import javax.mail.Message;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class Mail {
    public void sendMail(String email, String username, String password) {
        String to = email;

        String from = "reimbursement569@gmail.com";

        String host = "smtp.gmail.com";

        Properties properties = System.getProperties();

        properties.put("mail.smtp.host", host);
        properties.put("mail.smtp.port", "465");
        properties.put("mail.smtp.ssl.enable", "true");
        properties.put("mail.smtp.auth", "true");

        Session session = Session.getInstance(properties, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {

                return new PasswordAuthentication(from, "Reimb2468");

            }
        });

        try {
            MimeMessage message = new MimeMessage(session);

            message.setFrom(new InternetAddress(from));

            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            message.setSubject("Account Creation");

            message.setText("An account has been created for you!\n Here are your login credentials\n" +
                    " Username: " + username +
                    " \n Password: " + password);
            System.out.println("Sending....");

            Transport.send(message);

            System.out.println("sent!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
