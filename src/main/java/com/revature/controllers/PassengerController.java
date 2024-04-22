package com.revature.controllers;


import com.revature.daos.FlightDAO;
import com.revature.daos.PassengerDAO;
import com.revature.models.Flight;
import com.revature.models.Passenger;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    PassengerDAO passengerDAO;
    FlightDAO flightDAO;

    @Autowired
    public PassengerController(PassengerDAO passengerDAO, FlightDAO flightDAO) {
        this.passengerDAO = passengerDAO;
        this.flightDAO = flightDAO;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Object> insertPassenger(@RequestBody Passenger passenger, @PathVariable int id){

        Optional<Flight> f = flightDAO.findById(id);
        if(f.isEmpty()){
            return ResponseEntity.status(404).body("Bad Flight ID");
        }
        passenger.setFlight(f.get());

        Passenger p = passengerDAO.save(passenger);
        return ResponseEntity.status(201).body(p);
    }
    @GetMapping("/{id}")
    public ResponseEntity<List<Passenger>> getAllPassengersByflightId( @PathVariable int id){

        if(flightDAO.findById(id).isEmpty()){
            return ResponseEntity.notFound().build();
        }

       List<Passenger> p = passengerDAO.findAllByFlightId(id);
       return ResponseEntity.status(200).body(p);
    }

//    @PutMapping("/{id}")
//    public ResponseEntity <Passenger> updatePassenger(@RequestBody Passenger passenger, @PathVariable int id){
//
//        Flight f = flightDAO.findById(id).get();
//
//        passenger.setFlight(f);
//
//        Passenger p = passengerDAO.save(passenger);
//        return ResponseEntity.ok(p);
//    }

    @DeleteMapping("/{passId}")
    public ResponseEntity<Object> deletePassenger(@PathVariable int passId) {
        Optional<Passenger> p = passengerDAO.findById(passId);

        if (p.isEmpty())
            return ResponseEntity.status(404).body("Bad ID");
        Passenger passenger = p.get();
        passengerDAO.deleteById(passId);

        return ResponseEntity.accepted().body(passenger.getName() + " deleted from flyers list");

    }



}
