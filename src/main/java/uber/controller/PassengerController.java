package uber.controller;

import lombok.RequiredArgsConstructor;
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
    public List<Passenger> findAll(){
        return passengerService.findAll();
    }


}
