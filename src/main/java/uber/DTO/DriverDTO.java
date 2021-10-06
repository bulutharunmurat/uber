package uber.DTO;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.NumberFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class DriverDTO {

    @ApiModelProperty(example = "12345678902")
    @NotNull(message = "SSID is mandatory")
    @NumberFormat(style = NumberFormat.Style.NUMBER)
    private Long ssid;

    @ApiModelProperty(example = "Murat")
    @NotBlank(message = "Name is mandatory!!!")
    private String name;

    @ApiModelProperty(example = "Bulut")
    @NotBlank(message = "Surname is mandatory!!!")
    private String surname;

    @ApiModelProperty(example = "bulut@gmail.com")
    private String email;

    @ApiModelProperty(example = "27")
    private Integer age;

    @ApiModelProperty(example = "Bulut123")
    private String password;
}
