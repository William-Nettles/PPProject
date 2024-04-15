package com.revature.daos;

import com.revature.models.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightDAO extends JpaRepository<Flight, Integer> {

}
