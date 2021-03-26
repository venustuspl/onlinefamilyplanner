package pl.Venustus.OnlineFamilyPlanner.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Domain.Mail;
import pl.Venustus.OnlineFamilyPlanner.Service.DbService;
import pl.Venustus.OnlineFamilyPlanner.Service.SimpleEmailService;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.stream.Collectors;

@Component
public class EmailScheduler {
    private static final String SUBJECT = "OnlineFamillyPlannerDatabaseSnapshot";

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    private DbService dbService;


    public String makeMailText() {
        String header = "Hello, \n we are sending daily update from http://onlinefamilyplanner.herokuapp.com: \n\n ";
        String footer = "\n\n List was made on " + LocalDateTime.now();

        return header +
                dbService.getAllDayOfMonth().stream()
                        .sorted(Comparator.comparing(DayOfMonth::getId))
                        .map(d -> d.toString() + "\n\n")
                        .collect(Collectors.toList()).toString()
                + footer;
    }

    @Scheduled(cron = "0 0/10 11,13 * * *")
    public void sendInformationEmail() {
        simpleEmailService.send(new Mail(
                        adminConfig.getAdminMail(),
                        SUBJECT, makeMailText()
                )
        );
        System.out.println("Email was send.");
    }
}