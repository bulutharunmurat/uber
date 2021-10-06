package uber.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uber.entity.Passenger;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, Integer> {

    @Query("select p from Passenger p where p.ssid = ?1")
    Passenger findBySsid(long ssid);
}
