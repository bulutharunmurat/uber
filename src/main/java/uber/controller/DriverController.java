package uber.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uber.DTO.DriverDTO;
import uber.entity.Driver;
import uber.service.DriverService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class DriverController {

    private final DriverService driverService;

    @PostMapping("/drivers")
    public ResponseEntity<Driver> saveDriver(@RequestBody @Valid DriverDTO driverDTO){
        Optional<Driver> optionalDriver = driverService.save(driverDTO);

        if(optionalDriver.isPresent()){
            return new ResponseEntity<>(optionalDriver.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
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
