package com.revature.controllers;

import com.revature.daos.FlightDAO;
import com.revature.models.Flight;
import jakarta.persistence.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController //This makes a Class a Bean and also converts request data into JSON automatically
@RequestMapping("/flights") // Any HTTP requests sent to the app ending in /cars will go to this controller
public class FlightController {

    private FlightDAO flightDAO;

    //we need to inject the FlightDAO bean into this Controller. We need to build a contructor
    @Autowired
    public FlightController(FlightDAO flightDAO) {
        this.flightDAO = flightDAO;
    }


    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights() {

        return ResponseEntity.ok(flightDAO.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getFlightById(@PathVariable int id) {

        Optional<Flight> flight = flightDAO.findById(id);
        return flight.<ResponseEntity<Object>>map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.badRequest().body("No flight with this ID exists."));
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return ResponseEntity.status(201).body(flightDAO.save(flight));
    }

    @PutMapping()
    public ResponseEntity<Object> updateFlight(@RequestBody Flight flight) {
        return ResponseEntity.status(202).body(flightDAO.save(flight));
    }


}
