package uber.service;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uber.DTO.PassengerDTO;
import uber.controller.PassengerController;
import uber.entity.Passenger;
import uber.mappers.PassengerMapper;
import uber.repository.PassengerRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PassengerService {

    private final PassengerRepository passengerRepository;
    private final PassengerMapper passengerMapper;
    private final Logger logger = LoggerFactory.getLogger(PassengerService.class);


    @Transactional
    public Optional<Passenger> save(PassengerDTO passengerDTO){
        Passenger passenger = passengerMapper.mapFromPassengerDTOtoPassenger(passengerDTO);
        return Optional.of(passengerRepository.save(passenger));
    }

    public Passenger findById(int id){
        return passengerRepository.findById(id).get();
    }

    public List<Passenger> findAll(){
        Iterable<Passenger> passengerIterable = passengerRepository.findAll();
        List<Passenger> passengers = new ArrayList<>();

        passengerIterable.iterator().forEachRemaining(passengers::add);
        return passengers;
    }

    public Passenger findBySSID(long ssid){
        return passengerRepository.findBySsid(ssid);
    }
}
