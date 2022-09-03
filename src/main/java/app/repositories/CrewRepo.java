package app.repositories;

import app.models.Crew;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface CrewRepo extends CrudRepository<Crew, Long> {

    List<Crew> findByDutyShip_RegistrationCode(long dutyShip_registrationCode);

    List<Crew> findBy();

    List<Crew> findByCrewNameContaining(String crewName);
}
