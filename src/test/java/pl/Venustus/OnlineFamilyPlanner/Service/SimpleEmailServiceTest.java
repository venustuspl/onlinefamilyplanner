package pl.Venustus.OnlineFamilyPlanner.Service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;
import pl.Venustus.OnlineFamilyPlanner.Domain.Mail;

import java.time.LocalDateTime;

class SimpleEmailServiceTest {

    @Autowired
    private AdminConfig adminConfig;

    @Test
    void isValidEmailAddress() {
    }

    @Test
    void send() {
        SimpleEmailService simpleEmailService = new SimpleEmailService();
        simpleEmailService.send(new Mail(
                "venustus.pl@gmail.com",
                //adminConfig.getAdminMail(),
                "Temacik",
                "Changes was made on" + LocalDateTime.now()));
        System.out.println("Message send.");
    }
}