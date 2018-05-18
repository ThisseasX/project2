package services;

import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import java.util.Properties;

@Service
public class MailService {

    public void sendMail(String from, String subject, String body) throws MessagingException {

        Properties mailServerProperties = System.getProperties();
        mailServerProperties.put("mail.smtp.port", "587");
        mailServerProperties.put("mail.smtp.auth", "true");
        mailServerProperties.put("mail.smtp.starttls.enable", "true");

        Session mailSession = Session.getInstance(mailServerProperties, null);
        MimeMessage myMailMessage = new MimeMessage(mailSession);
        myMailMessage.setSender(new InternetAddress(from));
        myMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("tomdogs.info@gmail.com"));
        myMailMessage.setSubject(subject);

        Multipart multipart = new MimeMultipart();
        MimeBodyPart mimeBodyPartforBody = new MimeBodyPart();

        multipart.addBodyPart(mimeBodyPartforBody);
        mimeBodyPartforBody.setText(body);
        myMailMessage.setContent(multipart);

        Transport transport = mailSession.getTransport("smtp");

        transport.connect("smtp.gmail.com", "tomdogs.info", "Tomdogs1");
        transport.sendMessage(myMailMessage, myMailMessage.getAllRecipients());
        transport.close();
    }
}

