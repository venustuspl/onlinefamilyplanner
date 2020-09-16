package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Service.DbService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PlannerController {
    DayOfMonth dayOfMonth = new DayOfMonth((long) 1, "WORK1", "15:30");
    DayOfMonth dayOfMonth1 = new DayOfMonth((long) 2, "FREE2", "");
    DayOfMonth dayOfMonth2 = new DayOfMonth((long) 3, "WORK3", "07:00");
    @Autowired
    private DbService dbService;

    @RequestMapping(method = RequestMethod.GET, value = "/getalldayofmonth")
    @ResponseBody
    public List<DayOfMonth> getAllDayOfMonth() {


        return dbService.getAllDayOfMonth();

    }

    @RequestMapping(method = RequestMethod.GET, value = "/getalldayofmonthbyeach")
    @ResponseBody
    public Optional<DayOfMonth> getAllDayOfMonthByEach(@RequestParam("day") Long id) {
        dbService.saveDayOfMonth(dayOfMonth);
        dbService.saveDayOfMonth(dayOfMonth1);
        dbService.saveDayOfMonth(dayOfMonth2);

        return dbService.getDayOfMonthByEach(id);

    }

    @RequestMapping(method = RequestMethod.GET, value = "/loggeduser")
    public String getIndexPage() {
        return "";
    }


}

