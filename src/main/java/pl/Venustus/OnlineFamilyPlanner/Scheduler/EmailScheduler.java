package pl.Venustus.OnlineFamilyPlanner.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;
import pl.Venustus.OnlineFamilyPlanner.Domain.Mail;
import pl.Venustus.OnlineFamilyPlanner.Service.SimpleEmailService;

import java.time.LocalDateTime;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Offers details.";
    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail() {

        simpleEmailService.send(new Mail(
                //"venustus.pl@gmail.com",
                adminConfig.getAdminMail(),
                SUBJECT,
                "Changes was made on" + LocalDateTime.now()));

    }
}