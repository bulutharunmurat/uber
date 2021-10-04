package uber.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uber.entity.Driver;
import uber.service.DriverService;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DriverController {

    @Autowired
    DriverService driverService;

    @PostMapping("/drivers")
    public Driver saveDriver(@RequestBody Driver driver){
        return driverService.save(driver);
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers(){
        return driverService.findAll();
    }

    @GetMapping("/drivers/{id}")
    public ResponseEntity<Driver> findStudentById(@PathVariable Integer id){
        return new ResponseEntity<>(driverService.findById(id), HttpStatus.OK);
    }
}
