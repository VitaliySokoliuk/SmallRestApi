package ua.lviv.AirCompany.Models;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;
import ua.lviv.AirCompany.Entities.AirCompany;
import ua.lviv.AirCompany.Entities.Airplane;
import ua.lviv.AirCompany.Entities.Flight;
import ua.lviv.AirCompany.Services.AirCompanyService;
import ua.lviv.AirCompany.Services.AirplaneService;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;

public class FlightDto {

    private int airCompanyId;
    private int airplaneId;
    private String departureCity;
    private String destinationCity;
    private int distance;
    @DateTimeFormat(iso = DateTimeFormat.ISO.TIME)
    private LocalTime estimatedFlightTime;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)
    private LocalDateTime arrivesAt;

    public static Flight convertIntoFlight(FlightDto flightDto, AirCompanyService airCompanyService,
                                           AirplaneService airplaneService) {
        Flight flight = new Flight();
        Optional<AirCompany> maybeAirCompany = airCompanyService.findById(flightDto.getAirCompanyId());
        maybeAirCompany.ifPresent(flight::setAirCompany);
        Optional<Airplane> maybeAirplane = airplaneService.findById(flightDto.getAirplaneId());
        maybeAirplane.ifPresent(flight::setAirplane);
        flight.setDepartureCity(flightDto.getDepartureCity());
        flight.setDestinationCity(flightDto.getDestinationCity());
        flight.setDistance(flightDto.getDistance());
        flight.setEstimatedFlightTime(flightDto.getEstimatedFlightTime());
        flight.setArrivesAt(flightDto.getArrivesAt());
        return flight;
    }

    public int getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(int airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getDepartureCity() {
        return departureCity;
    }

    public void setDepartureCity(String departureCity) {
        this.departureCity = departureCity;
    }

    public String getDestinationCity() {
        return destinationCity;
    }

    public void setDestinationCity(String destinationCity) {
        this.destinationCity = destinationCity;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public LocalTime getEstimatedFlightTime() {
        return estimatedFlightTime;
    }

    public void setEstimatedFlightTime(LocalTime estimatedFlightTime) {
        this.estimatedFlightTime = estimatedFlightTime;
    }

    public LocalDateTime getArrivesAt() {
        return arrivesAt;
    }

    public void setArrivesAt(LocalDateTime arrivesAt) {
        this.arrivesAt = arrivesAt;
    }
}
