package ua.lviv.AirCompany.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.lviv.AirCompany.Entities.AirCompany;
import ua.lviv.AirCompany.Repos.AirCompanyRepo;

import java.util.List;
import java.util.Optional;

@Service
public class AirCompanyService {

    private AirCompanyRepo airCompanyRepo;

    @Autowired
    public AirCompanyService(AirCompanyRepo airCompanyRepo) {
        this.airCompanyRepo = airCompanyRepo;
    }

    public Optional<AirCompany> findById(int id){
        return airCompanyRepo.findById(id);
    }

    public List<AirCompany> findAll(){
        return airCompanyRepo.findAll();
    }

    public AirCompany save(AirCompany airCompany){
        return airCompanyRepo.save(airCompany);
    }

    public void deleteById(int id){
        airCompanyRepo.deleteById(id);
    }

}
