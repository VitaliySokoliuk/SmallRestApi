package ua.lviv.AirCompany.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.AirCompany.Entities.Enums.FlightStatus;
import ua.lviv.AirCompany.Entities.Flight;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Integer> {

    List<Flight> findByFlightStatusAndAirCompany_Name(FlightStatus flightStatus, String companyName);

    List<Flight> findByFlightStatusAndStartedAtGreaterThan(FlightStatus flightStatus, LocalDateTime startedAt);
}
