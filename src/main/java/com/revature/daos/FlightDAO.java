package com.revature.daos;

import com.revature.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightDAO extends JpaRepository<Flight, Integer> {
}
