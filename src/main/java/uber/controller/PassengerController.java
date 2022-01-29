package uber.controller;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uber.DTO.PassengerDTO;
import uber.entity.Passenger;
import uber.service.PassengerService;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class PassengerController {

    private final PassengerService passengerService;
    private final Logger logger = LoggerFactory.getLogger(PassengerController.class);

    @PostMapping("/passengers")
    public ResponseEntity<Passenger> savePassenger(@RequestBody @Valid PassengerDTO passengerDTO){
        Optional<Passenger> passengerOptional = passengerService.save(passengerDTO);
        if(passengerOptional.isPresent()){
            return new ResponseEntity<>(passengerOptional.get(),HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/passengers/{id}")
    public Passenger findById(@PathVariable int id){
        return passengerService.findById(id);
    }

    @GetMapping("/passengers")
    public List<Passenger> findAll(@RequestHeader("correlationId") String correlationId){
        logger.info("findAll() method executed for all passengers, correlationId is: {} ", correlationId);
        return passengerService.findAll();
    }

    @GetMapping("/passenger-by-ssid/{ssid}")
    public Passenger findBySSID(@PathVariable long ssid){
        return passengerService.findBySSID(ssid);
    }

}
