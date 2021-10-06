package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uber.entity.Booking;
import uber.entity.Driver;
import uber.entity.Passenger;
import uber.entity.Ticket;
import uber.repository.BookingRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PassengerService passengerService;
    private final DriverService driverService;
    private final TicketService ticketService;

    @Transactional
    public Booking makeABooking(Long passengerSSID, Long driverSSID){

        Passenger passenger = passengerService.findBySSID(passengerSSID);
        Driver driver = driverService.findBySSID(driverSSID);

        Booking booking = new Booking();
        booking.setBookingDate(LocalDateTime.now());
        booking.setPassenger(passenger);
        booking.setDriver(driver);

        // For test

        booking.setCarModel("TESLA");
        booking.setInitialLocation("KADIKOY");
        booking.setLastLocation("BESIKTAS");
        booking.setTravelStartTime(LocalDateTime.of(2021,10,06,16,15));
        booking.setTravelFinishTime(LocalDateTime.of(2021,10,06,17,15));

        // For ticket

        Ticket ticket = new Ticket();
        ticket.setBooking(booking);
        ticketService.saveTicket(ticket);

        return bookingRepository.save(booking);
    }

    public Booking findById(int id){
        return bookingRepository.findById(id).get();
    }

}
