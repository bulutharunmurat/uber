package uber.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uber.entity.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {

    @Query("SELECT d FROM Driver d where d.ssid=?1")
    Driver findBySSID(long ssid);
}
