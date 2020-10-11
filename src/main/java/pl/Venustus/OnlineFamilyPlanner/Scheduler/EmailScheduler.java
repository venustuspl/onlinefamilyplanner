package pl.Venustus.OnlineFamilyPlanner.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;
import pl.Venustus.OnlineFamilyPlanner.Domain.Mail;
import pl.Venustus.OnlineFamilyPlanner.Service.SimpleEmailService;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Plan snapshot.";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    //https://crontab.guru/#*_*_*_*_*
    @Scheduled(cron = "*/30 * * * * *")
    public void sendInformationEmail() {
        System.out.println("before Email");
        simpleEmailService.send(new Mail(
                adminConfig.getAdminMail(),
                SUBJECT,
                "Currently in database you got: ")
        );
        System.out.println("AferEmail");
    }

}