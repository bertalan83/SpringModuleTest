package app.controllers;

import app.models.Crew;
import app.services.CrewService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class CrewController {

    public final CrewService crewService;

    public CrewController(CrewService crewService) {
        this.crewService = crewService;
    }

    @GetMapping(value = "/see-all-crew")
    public String seeAllCrew(Model model) {
        List<Crew> crew = crewService.getAllCrew();
        model.addAttribute("crew", crew);

        return "crew_all";
    }
}
