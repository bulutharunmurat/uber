package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uber.entity.Booking;
import uber.entity.Ticket;
import uber.repository.TicketRepository;

@Service
@RequiredArgsConstructor
public class TicketService {

    private final TicketRepository ticketRepository;

    @Transactional
    public Ticket saveTicket(Ticket ticket){
        return ticketRepository.save(ticket);
    }
}
