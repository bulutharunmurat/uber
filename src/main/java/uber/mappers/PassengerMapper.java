package uber.mappers;

import org.mapstruct.Mapper;
import uber.DTO.PassengerDTO;
import uber.entity.Passenger;

@Mapper
public interface PassengerMapper {

    Passenger mapFromPassengerDTOtoPassenger(PassengerDTO passengerDTO);
    PassengerDTO mapFromPassengertoPassengerDTO(Passenger passenger);
}
