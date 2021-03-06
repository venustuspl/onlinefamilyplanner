package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Venustus.OnlineFamilyPlanner.Configuration.AdminConfig;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonthDto;
import pl.Venustus.OnlineFamilyPlanner.Mapper.DayOfMonthMapper;
import pl.Venustus.OnlineFamilyPlanner.Scheduler.EmailScheduler;
import pl.Venustus.OnlineFamilyPlanner.Service.DbService;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PlannerController {
    @Autowired
    private DbService dbService;

    @Autowired
    private DayOfMonthMapper dayOfMonthMapper;

    @Autowired
    private AdminConfig adminConfig;

    @Autowired
    EmailScheduler emailScheduler;

    @RequestMapping(method = RequestMethod.GET, value = "/getalldayofmonth")
    @ResponseBody
    public List<DayOfMonth> getAllDayOfMonth() {
        return dbService.getAllDayOfMonth();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getalldayofmonthbyeach")
    @ResponseBody
    public Optional<DayOfMonth> getAllDayOfMonthByEach(@RequestParam("day") Long id) {
        return dbService.getDayOfMonthByEach(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/save", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public DayOfMonth saveDayOfMonthDto(@RequestBody DayOfMonthDto dayOfMonthDto) {
        return dbService.saveDayOfMonth(dayOfMonthMapper.mapToDaYMonth(dayOfMonthDto));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/clear")
    public void clearMonth() {
        dbService.deletaAllDayOfMonth();
    }

    @RequestMapping(value = "/loggeduser")
    public String getIndexPage() {
        return "/app.html";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getall")
    @ResponseBody
    public List<DayOfMonth> getAll() {
        System.out.println(dbService.getAllDayOfMonth());
        return dbService.getAllDayOfMonth();
    }

    @RequestMapping(value = "/sendemail")
    public void sendEmailSummary() {
        emailScheduler.sendInformationEmail();
    }
}

