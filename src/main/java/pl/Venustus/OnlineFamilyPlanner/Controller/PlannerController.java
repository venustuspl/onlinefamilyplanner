package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Service.DbService;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PlannerController {
    DayOfMonth dayOfMonth = new DayOfMonth((long) 1, "WORK", "15:30");
    DayOfMonth dayOfMonth1 = new DayOfMonth((long) 2, "FREE", "");
    DayOfMonth dayOfMonth2 = new DayOfMonth((long) 3, "WORK", "07:00");
    @Autowired
    private DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "/getalldayofmonth")
    @ResponseBody
    public List<DayOfMonth> getAllDayOfMonth() {
        dbService.saveDayOfMonth(dayOfMonth);
        dbService.saveDayOfMonth(dayOfMonth1);
        dbService.saveDayOfMonth(dayOfMonth2);

        return dbService.getAllDayOfMonth();

    }


    @RequestMapping(method = RequestMethod.GET, value = "/loggeduser")
    public String getIndexPage() {
        return "";
    }


}

