package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uber.entity.Booking;
import uber.repository.BookingRepository;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    public Booking makeABooking(Long passengerSSID){

        Booking booking = new Booking();
        booking.setBookingDate(LocalDateTime.now());

        //For test

        booking.setCarModel("TESLA");
        booking.setInitialLocation("KADIKOY");
        booking.setLastLocation("BESIKTAS");
        booking.setTravelStartTime(LocalDateTime.of(2021,10,06,16,15));
        booking.setTravelFinishTime(LocalDateTime.of(2021,10,06,17,15));
        return bookingRepository.save(booking);
    }

}
