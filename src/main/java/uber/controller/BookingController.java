package uber.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import uber.entity.Booking;
import uber.service.BookingService;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/booking/{passengerSSID}/{driverSSID}")
    public Booking makeABooking(@PathVariable Long passengerSSID,
                                @PathVariable Long driverSSID){
        return bookingService.makeABooking(passengerSSID, driverSSID);
    }
}
