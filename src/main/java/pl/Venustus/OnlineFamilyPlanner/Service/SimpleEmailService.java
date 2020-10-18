package pl.Venustus.OnlineFamilyPlanner.Service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import pl.Venustus.OnlineFamilyPlanner.Domain.Mail;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

@Service
public class SimpleEmailService {

    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleMailMessage.class);

    @Autowired
    private JavaMailSender javaMailSender;

    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        if (email != null) {
            try {
                InternetAddress emailAddr = new InternetAddress(email);
                emailAddr.validate();
            } catch (AddressException ex) {
                result = false;
            }
        }
        return result;
    }

    public void send(final Mail mail) {
        LOGGER.info("Starting email preparation... ");
        try {
            SimpleMailMessage mailMessage = createMailMessage(mail);
            javaMailSender.send(createMimeMessage(mail));
            LOGGER.info("Email has been sent.");
        } catch (MailException e) {
            LOGGER.error("Failed to process email sending: ", e.getMessage(), e);
        }
    }

    private MimeMessagePreparator createMimeMessage(final Mail mail) {
        return mimeMessage -> {
            MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage);
            messageHelper.setTo(mail.getMailTo());
            messageHelper.setSubject(mail.getSubject());
            messageHelper.setText(mail.getMessage());
        };
    }

    private SimpleMailMessage createMailMessage(final Mail mail) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(mail.getMailTo());
        mailMessage.setSubject(mail.getSubject());
        mailMessage.setText("testowy text");
        return mailMessage;
    }
}