package uber.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@Data
@MappedSuperclass
public abstract class BaseEntity extends AbstractBaseEntity{

    @Column(nullable = false, length = 100, unique = true)
    private Long ssid;
    private String name;
    private String surname;
    private String email;
    private Integer age;
    private String password;
}
