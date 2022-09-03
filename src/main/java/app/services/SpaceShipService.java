package app.services;

import app.models.SpaceShip;
import app.repositories.SpaceShipRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SpaceShipService {

    private final SpaceShipRepo spaceShipRepo;

    public SpaceShipService(SpaceShipRepo spaceShipRepo) {
        this.spaceShipRepo = spaceShipRepo;
    }

    public List<SpaceShip> getAllShips() {
        return spaceShipRepo.findBy();
    }

    public List<SpaceShip> getAllActiveShips() {
        return spaceShipRepo.findByisActive(true);
    }

    public List<SpaceShip> getAllInactiveShips() {
        return spaceShipRepo.findByisActive(false);
    }

    public void saveNewSpaceShip(SpaceShip spaceShip) {
        spaceShipRepo.save(spaceShip);
    }

}
