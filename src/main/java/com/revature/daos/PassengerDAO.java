package com.revature.daos;

import com.revature.models.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface PassengerDAO extends JpaRepository<Passenger, Integer> {

    public List<Passenger> findAllByFlightId(int id);

}
