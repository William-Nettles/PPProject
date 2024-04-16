package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Table(name = "passenger")
@Entity
public class Passenger {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int passId;
    private String name;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "id")
    private Flight flight; //FK from flight table


    public Passenger() {
    }

    public Passenger(int passId, String name, Flight flight) {
        this.passId = passId;
        this.name = name;
        this.flight = flight;
    }

    public int getPassId() {
        return passId;
    }

    public String getName() {
        return name;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setPassId(int passId) {
        this.passId = passId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passId=" + passId +
                ", name='" + name + '\'' +
                ", flight=" + flight +
                '}';
    }
}
