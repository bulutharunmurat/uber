package uber.mappers;

import org.mapstruct.Mapper;
import uber.DTO.DriverDTO;
import uber.entity.Driver;

@Mapper
public interface DriverMapper {

    Driver mapFromDriverDTOToDriver(DriverDTO driverDTO);
    DriverDTO mapFromDriverToDriverDTO(Driver driver);

}
