package com.revature.controllers;

import com.revature.models.Flight;
import jakarta.persistence.Entity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@RestController //This makes a Class a Bean and also converts request data into JSON automatically
@RequestMapping("/flights") // Any HTTP requests sent to the app ending in /cars will go to this controller
@ResponseBody
public class FlightController {

    @GetMapping
    public ResponseEntity<Flight> getAllFlights() {

        return null;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable int id) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Flight> addFlight(@RequestBody Flight flight) {
        return null;
    }

    @PostMapping("/{id}")
    public ResponseEntity<Flight> updateFlight(@RequestBody Flight flight) {
        return null;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Flight> deleteFlight() {
        return null;
    }


}
