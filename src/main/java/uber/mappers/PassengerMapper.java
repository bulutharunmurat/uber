package uber.mappers;

import lombok.RequiredArgsConstructor;
import org.mapstruct.Mapper;
import uber.DTO.PassengerDTO;
import uber.entity.Passenger;

@Mapper(componentModel = "spring")
public interface PassengerMapper {

    Passenger mapFromPassengerDTOtoPassenger(PassengerDTO passengerDTO);
    PassengerDTO mapFromPassengertoPassengerDTO(Passenger passenger);
}
