package ua.lviv.AirCompany.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.lviv.AirCompany.Entities.AirCompany;
import ua.lviv.AirCompany.Entities.Airplane;
import ua.lviv.AirCompany.Entities.Enums.FlightStatus;
import ua.lviv.AirCompany.Entities.Flight;
import ua.lviv.AirCompany.Models.AirplaneDto;
import ua.lviv.AirCompany.Models.FlightDto;
import ua.lviv.AirCompany.Qwe;
import ua.lviv.AirCompany.Services.AirCompanyService;
import ua.lviv.AirCompany.Services.AirplaneService;
import ua.lviv.AirCompany.Services.FlightService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
public class MainController {

    private AirplaneService airplaneService;
    private AirCompanyService airCompanyService;
    private FlightService flightService;

    @Autowired
    public MainController(AirplaneService airplaneService,
                          AirCompanyService airCompanyService,
                          FlightService flightService) {
        this.airplaneService = airplaneService;
        this.airCompanyService = airCompanyService;
        this.flightService = flightService;
    }

    @GetMapping(value = "/reassignPlane")
    public ResponseEntity<String> reassignPlane(@RequestParam int airPlaneId,
                                                @RequestParam int newAirCompanyId){
        Optional<Airplane> maybeAirplane = airplaneService.findById(airPlaneId);
        Optional<AirCompany> maybeAirCompany = airCompanyService.findById(newAirCompanyId);

        if(maybeAirplane.isEmpty() || maybeAirCompany.isEmpty()) {
            return new ResponseEntity<>("Reassignment not completed", HttpStatus.BAD_REQUEST);
        }
        airplaneService.reassignPlane(maybeAirplane, maybeAirCompany);
        return new ResponseEntity<>("Reassignment completed", HttpStatus.OK);
    }

    @GetMapping("/compFlByStat")
    public ResponseEntity<List<Flight>> getCompanyFlightsByStatus(@RequestParam String companyName,
                                                                  @RequestParam String status){
        List<Flight> flights = flightService.findByFlightStatusAndAirCompany_Name(status, companyName);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @GetMapping("/activeByStartedAt")
    public ResponseEntity<List<Flight>> getActiveByStartedAt(@RequestParam byte hours,
                                                             @RequestParam byte minutes){
        List<Flight> flights = flightService.findActiveByStartedAt(hours, minutes);
        return new ResponseEntity<>(flights, HttpStatus.OK);
    }

    @PostMapping(value = "/addAirplane")
    public ResponseEntity<Airplane> addAirplane(@ModelAttribute AirplaneDto airplaneDto){
        Airplane airplane = AirplaneDto.convertIntoAirplane(airplaneDto, airCompanyService);
        airplaneService.save(airplane);
        return new ResponseEntity<>(airplane, HttpStatus.OK);
    }

    @PostMapping(value = "/addFlight")
    public ResponseEntity<Flight> addFlight(@ModelAttribute FlightDto flightDto){
        Flight flight = FlightDto.convertIntoFlight(flightDto, airCompanyService, airplaneService);
        flightService.save(flight);
        return new ResponseEntity<>(flight, HttpStatus.OK);
    }

    @GetMapping(value = "/changeStatus")
    public ResponseEntity<String> changeStatus(@RequestParam int flightId,
                                               @RequestParam String status){
        Optional<Flight> maybeFlight = flightService.findById(flightId);
        if(maybeFlight.isEmpty()){
            new ResponseEntity<>("Status hasn't changed", HttpStatus.OK);
        }
        flightService.changeStatus(maybeFlight.get(), status);
        return new ResponseEntity<>("Status has changed", HttpStatus.OK);
    }

    //Only form-data
    @PostMapping(value = "/home2", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public String get(@ModelAttribute Qwe qwe){
        System.out.println(qwe.getAge() + " --- " + qwe.getName());
        return qwe.toString();
    }

    // Only JSON
    @PostMapping(value = "/home3")
    public String get2(@RequestBody Qwe qwe){
        System.out.println(qwe.getAge() + " --- " + qwe.getName());
        return qwe.toString();
    }

}
