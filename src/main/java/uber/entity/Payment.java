package uber.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Payment extends AbstractBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String paymentType;
    private LocalDateTime paymentDate;
    private Float paymentAmount;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "passenger_id")
    private Passenger passenger;

    @JsonBackReference
    @OneToOne(mappedBy = "payment")
    private Ticket ticket;
}
