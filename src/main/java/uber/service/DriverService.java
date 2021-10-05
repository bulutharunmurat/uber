package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uber.entity.Driver;
import uber.repository.DriverRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DriverService {

    DriverRepository driverRepository;

    public Driver save(Driver driver){
        return driverRepository.save(driver);
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
