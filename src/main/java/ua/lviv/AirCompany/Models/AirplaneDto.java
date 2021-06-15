package ua.lviv.AirCompany.Models;

import org.springframework.format.annotation.DateTimeFormat;
import ua.lviv.AirCompany.Entities.AirCompany;
import ua.lviv.AirCompany.Entities.Airplane;
import ua.lviv.AirCompany.Entities.Enums.AirplaneType;
import ua.lviv.AirCompany.Services.AirCompanyService;

import java.time.LocalDate;
import java.util.Optional;

public class AirplaneDto {
    private String name;
    private String factorySerialNumber;
    private int airCompanyId;
    private int fuelCapacity;
    private AirplaneType airplaneType;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate createdAt;

    public static Airplane convertIntoAirplane(AirplaneDto airplaneDto, AirCompanyService airCompanyService){
        Airplane airplane = new Airplane();
        airplane.setName(airplaneDto.getName());
        airplane.setFactorySerialNumber(airplaneDto.getFactorySerialNumber());
        airplane.setFuelCapacity(airplaneDto.getFuelCapacity());
        airplane.setAirplaneType(airplaneDto.getAirplaneType());
        airplane.setCreatedAt(airplaneDto.getCreatedAt());
        Optional<AirCompany> maybeCompany = airCompanyService.findById(airplaneDto.getAirCompanyId());
        maybeCompany.ifPresent(airplane::setAirCompany);
        return airplane;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFactorySerialNumber() {
        return factorySerialNumber;
    }

    public void setFactorySerialNumber(String factorySerialNumber) {
        this.factorySerialNumber = factorySerialNumber;
    }

    public int getAirCompanyId() {
        return airCompanyId;
    }

    public void setAirCompanyId(int airCompanyId) {
        this.airCompanyId = airCompanyId;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public AirplaneType getAirplaneType() {
        return airplaneType;
    }

    public void setAirplaneType(AirplaneType airplaneType) {
        this.airplaneType = airplaneType;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    @Override
    public String toString() {
        return "AirplaneDto{" +
                "name='" + name + '\'' +
                ", factorySerialNumber='" + factorySerialNumber + '\'' +
                ", airCompanyId=" + airCompanyId +
                ", fuelCapacity=" + fuelCapacity +
                ", airplaneType=" + airplaneType +
                ", createdAt=" + createdAt +
                '}';
    }
}
