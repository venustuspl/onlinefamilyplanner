package pl.Venustus.OnlineFamilyPlanner.Scheduler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;

@Component
public class EmailScheduler {

    private static final String SUBJECT = "Plan snapshot.";

    @Autowired
    private AdminConfig adminConfig;

    //@Scheduled(cron = "*/10 * * * * *")
    public void sendInformationEmail() {

    }
}