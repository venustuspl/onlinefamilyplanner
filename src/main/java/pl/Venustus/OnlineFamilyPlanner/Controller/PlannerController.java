package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PlannerController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    public String getIndexPage() {
        return "index";
    }

}

