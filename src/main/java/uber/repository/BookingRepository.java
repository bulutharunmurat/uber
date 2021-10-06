package uber.repository;

import org.springframework.data.repository.CrudRepository;
import uber.entity.Booking;

public interface BookingRepository extends CrudRepository<Booking, Integer> {
}
