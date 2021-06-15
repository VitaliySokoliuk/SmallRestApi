package ua.lviv.AirCompany.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.AirCompany.Entities.Enums.FlightStatus;
import ua.lviv.AirCompany.Entities.Flight;
import ua.lviv.AirCompany.Repos.FlightRepo;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FlightService {

    private FlightRepo flightRepo;

    @Autowired
    public FlightService(FlightRepo flightRepo) {
        this.flightRepo = flightRepo;
    }

    public List<Flight> findByFlightStatusAndAirCompany_Name(String flightStatus, String companyName){
        Optional<FlightStatus> status = Stream.of(FlightStatus.values())
                .filter(s -> flightStatus.equalsIgnoreCase(s.toString())).findFirst();
        if(status.isEmpty()){
            return new ArrayList<>();
        }else{
            return flightRepo.findByFlightStatusAndAirCompany_Name(status.get(), companyName);
        }
    }

    public List<Flight> findActiveByStartedAt(byte hours, byte minutes){
        LocalDateTime timeDiff = LocalDateTime.now().minusHours(hours).minusMinutes(minutes);
        return flightRepo.findByFlightStatusAndStartedAtGreaterThan(FlightStatus.ACTIVE, timeDiff);
    }

    public Optional<Flight> findById(int id){
        return flightRepo.findById(id);
    }

    public Flight save(Flight flight){
        flight.setFlightStatus(FlightStatus.PENDING);
        flight.setCreatedAt(LocalDateTime.now());
        return flightRepo.save(flight);
    }

    public void changeStatus(Flight flight, String status){
        if(status.equalsIgnoreCase(FlightStatus.DELAYED.toString())){
            flight.setFlightStatus(FlightStatus.DELAYED);
            flight.setDelayStartedAt(LocalDateTime.now());
            flightRepo.save(flight);
        }
        if(status.equalsIgnoreCase(FlightStatus.ACTIVE.toString())){
            flight.setFlightStatus(FlightStatus.ACTIVE);
            flight.setStartedAt(LocalDateTime.now());
            flightRepo.save(flight);
        }
        if(status.equalsIgnoreCase(FlightStatus.COMPLETED.toString())){
            flight.setFlightStatus(FlightStatus.COMPLETED);
            flight.setEndedAt(LocalDateTime.now());
            flightRepo.save(flight);
        }
    }

}
