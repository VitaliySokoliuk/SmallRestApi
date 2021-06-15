package ua.lviv.AirCompany.Repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.lviv.AirCompany.Entities.Airplane;

@Repository
public interface AirplaneRepo extends JpaRepository<Airplane, Integer> {

}
