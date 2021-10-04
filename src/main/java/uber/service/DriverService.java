package uber.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uber.entity.Driver;
import uber.repository.DriverRepository;

@Service
public class DriverService {

    @Autowired
    DriverRepository driverRepository;

    public Driver save(Driver driver){
        return driverRepository.save(driver);
    }
}
