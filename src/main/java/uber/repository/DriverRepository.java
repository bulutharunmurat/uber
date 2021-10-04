package uber.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import uber.entity.Driver;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Integer> {
}
