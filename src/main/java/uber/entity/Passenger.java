package uber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import uber.entity.enums.Gender;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class Passenger extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nationality;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    // FetchType.LAZY means that related entity would call when it's required
    // FetchType.EAGER means everytime entity called related entities would come together with it
    @OneToMany(mappedBy = "passenger", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Booking> passenger_bookings = new ArrayList<>();

    @OneToMany(mappedBy = "passenger")
    private List<Payment> payments = new ArrayList<>();

}
