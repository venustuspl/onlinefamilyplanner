package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.Venustus.OnlineFamilyPlanner.Domain.DayOfMonth;
import pl.Venustus.OnlineFamilyPlanner.Repository.DayOfMonthRepository;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PlannerController {

    DayOfMonth dayOfMonth = new DayOfMonth((long) 1, "WORK", "15:30");

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public String getStartPage() {
        return "start";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loggeduser")
    public String getIndexPage() {
        return "index";
    }

    @Autowired
    private DayOfMonthRepository dayOfMonthRepository;


}

