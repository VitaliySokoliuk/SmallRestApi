package ua.lviv.AirCompany.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.AirCompany.Entities.AirCompany;
import ua.lviv.AirCompany.Entities.Airplane;
import ua.lviv.AirCompany.Repos.AirplaneRepo;

import java.util.Optional;

@Service
public class AirplaneService {

    private AirplaneRepo airplaneRepo;

    @Autowired
    public AirplaneService(AirplaneRepo airplaneRepo) {
        this.airplaneRepo = airplaneRepo;
    }

    public Optional<Airplane> findById(int id){
        return airplaneRepo.findById(id);
    }

    public Airplane save(Airplane airplane){
        return airplaneRepo.save(airplane);
    }

    public void reassignPlane(Optional<Airplane> maybeAirplane, Optional<AirCompany> maybeAirCompany) {
        Airplane airplane = maybeAirplane.get();
        airplane.setAirCompany(maybeAirCompany.get());
        save(airplane);
    }

}
