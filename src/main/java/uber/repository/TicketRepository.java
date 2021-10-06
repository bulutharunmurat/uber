package uber.repository;

import org.springframework.data.repository.CrudRepository;
import uber.entity.Ticket;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
}
