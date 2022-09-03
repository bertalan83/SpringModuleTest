package app.repositories;

import app.models.Crew;
import app.models.SpaceShip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface SpaceShipRepo extends CrudRepository<SpaceShip, Long> {

    List<SpaceShip> findBy();

    List<SpaceShip> findByisActive(boolean active);

    SpaceShip findByRegistrationCode(long registrationCode);


}
