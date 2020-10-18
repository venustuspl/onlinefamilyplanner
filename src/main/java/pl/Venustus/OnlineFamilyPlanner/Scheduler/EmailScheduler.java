package pl.Venustus.OnlineFamilyPlanner.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;
import pl.Venustus.OnlineFamilyPlanner.Domain.Mail;
import pl.Venustus.OnlineFamilyPlanner.Service.DbService;
import pl.Venustus.OnlineFamilyPlanner.Service.SimpleEmailService;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "OnlineFamillyPlannerDatabaseSnapshot";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private DbService dbService;

    //@Scheduled(cron = "0 0 18 * * *")

    @Scheduled(cron = "*/10 * * * * *")
    public void sendInformationEmail() {
        System.out.println("before Email " + adminConfig.getAdminMail());
        simpleEmailService.send(new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT, dbService.getAllDayOfMonth().toString()
                )
        );
        System.out.println(dbService.getAllDayOfMonth().toString());
    }

}