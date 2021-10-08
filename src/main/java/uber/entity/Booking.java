package uber.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Booking extends AbstractBaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer bookingId;
    private LocalDateTime bookingDate;
    private String carModel;
    private String initialLocation;
    private String lastLocation;
    private LocalDateTime travelStartTime;
    private LocalDateTime travelFinishTime;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @JsonBackReference
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    @OneToOne(mappedBy = "booking")
    private Ticket ticket;
}
