package uber.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Entity
public class DriverComments extends AbstractBaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String comment;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
}
