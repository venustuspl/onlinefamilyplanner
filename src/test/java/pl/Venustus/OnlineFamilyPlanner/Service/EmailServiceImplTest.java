package pl.Venustus.OnlineFamilyPlanner.Service;

import org.junit.jupiter.api.Test;

class EmailServiceImplTest {

    @Test
    void sendSimpleMessage() {
        EmailServiceImpl emailService = new EmailServiceImpl();
        emailService.sendSimpleMessage("aa", "bb", "cc");

    }
}