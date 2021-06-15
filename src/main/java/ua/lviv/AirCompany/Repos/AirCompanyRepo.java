package ua.lviv.AirCompany.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.AirCompany.Entities.AirCompany;

@Repository
public interface AirCompanyRepo extends JpaRepository<AirCompany, Integer> {

}
