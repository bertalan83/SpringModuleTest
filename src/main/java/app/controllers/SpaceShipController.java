package app.controllers;

import app.models.Crew;
import app.models.SpaceShip;
import app.models.SpaceShipClass;
import app.repositories.CrewRepo;
import app.repositories.SpaceShipRepo;
import app.services.SpaceShipService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Controller
public class SpaceShipController {

    private final SpaceShipService spaceShipService;

    private final SpaceShipRepo spaceShipRepo;

    private final CrewRepo crewRepo;

    public SpaceShipController(SpaceShipService spaceShipService, SpaceShipRepo spaceShipRepo, CrewRepo crewRepo) {
        this.spaceShipService = spaceShipService;
        this.spaceShipRepo = spaceShipRepo;
        this.crewRepo = crewRepo;
    }

    @GetMapping(value = {"/spaceship"})
    public String saveNewSpaceShip(Model model) {
        model.addAttribute("newShip", new SpaceShip());
        model.addAttribute("shipClasses", SpaceShipClass.values());

        return "spaceship_new";
    }
    @GetMapping(value = {"/see-all-ships"})
    public String seeAllSpaceShips(Model model) {
        List<SpaceShip> ships = spaceShipService.getAllShips();
        model.addAttribute("ships", ships);

        return "spaceships_all";
    }

    @GetMapping(value = {"/see-all-ships/active"})
    public String seeAllActiveSpaceShips(Model model) {
        List<SpaceShip> ships = spaceShipService.getAllActiveShips();
        model.addAttribute("ships", ships);

        return "spaceships_all";
    }

    @GetMapping(value = {"/see-all-ships/inactive"})
    public String seeAllInactiveSpaceShips(Model model) {
        List<SpaceShip> ships = spaceShipService.getAllInactiveShips();
        model.addAttribute("ships", ships);

        return "spaceships_all";
    }

    @GetMapping(value = {"/spaceship/crew/{registration}"})
    public String seeCrewByShip(@PathVariable long registration, Model model) {
        SpaceShip ship = spaceShipRepo.findByRegistrationCode(registration);
        List<Crew> crew = crewRepo.findByDutyShip_RegistrationCode(registration);

        model.addAttribute("ship", ship);
        model.addAttribute("crew", crew);

        return "crew_by_ship";
    }

}
