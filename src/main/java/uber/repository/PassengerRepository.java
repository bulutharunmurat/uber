package uber.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uber.entity.Passenger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {
}
