package pl.Venustus.OnlineFamilyPlanner.Controller;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
public class PlannerController {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    @ResponseBody
    public String getStartPage() {
        return "start";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/loggeduser")
    public String getIndexPage() {
        return "index";
    }


}

