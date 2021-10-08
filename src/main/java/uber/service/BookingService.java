package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uber.entity.Booking;
import uber.entity.Driver;
import uber.entity.Passenger;
import uber.entity.Ticket;
import uber.entity.Payment;
import uber.repository.BookingRepository;

import java.time.Instant;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final PassengerService passengerService;
    private final DriverService driverService;
    private final TicketService ticketService;
    private final PaymentService paymentService;

    @Transactional
    public Booking makeABooking(Long passengerSSID, Long driverSSID){

        Passenger passenger = passengerService.findBySSID(passengerSSID);
        Driver driver = driverService.findBySSID(driverSSID);

        Booking booking = new Booking();
        Ticket ticket = new Ticket();
        Payment payment = new Payment();


        booking.setBookingDate(LocalDateTime.now());
//        booking.setPassenger(passenger);
        booking.setDriver(driver);

        // For test

        booking.setCarModel("TESLA");
        booking.setInitialLocation("KADIKOY");
        booking.setLastLocation("BESIKTAS");
        booking.setTravelStartTime(LocalDateTime.of(2021,10,06,16,15));
        booking.setTravelFinishTime(LocalDateTime.of(2021,10,06,17,15));

        // For ticket

        ticket.setBooking(booking);
        ticket.setPayment(payment);
        ticketService.saveTicket(ticket);

        // For payment

        payment.setPaymentType("Credit Card");
        payment.setPaymentDate(LocalDateTime.now());
        payment.setPaymentAmount(100F);

        payment.setTicket(ticket);
        payment.setPassenger(passenger);

        paymentService.savePayment(payment);

        return bookingRepository.save(booking);
    }

    public Booking findById(int id){
        return bookingRepository.findById(id).get();
    }

}
