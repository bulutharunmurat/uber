package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uber.DTO.DriverDTO;
import uber.entity.Driver;
import uber.mappers.DriverMapper;
import uber.repository.DriverRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverMapper driverMapper;

    public Optional<Driver> save(DriverDTO driverDTO){
        Driver driver = driverMapper.mapFromDriverDTOToDriver(driverDTO);
        return Optional.of(driverRepository.save(driver));
    }

    public List<Driver> findAll(){
        List<Driver> drivers = new ArrayList<>();
        Iterable<Driver> driverIterable = driverRepository.findAll();
        driverIterable.iterator().forEachRemaining(drivers::add);
        return drivers;
    }

    public Driver findById(Integer id){
        return driverRepository.findById(id).get();
    }
}
