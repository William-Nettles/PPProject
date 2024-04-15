package com.revature.models;

import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "flights")
public class Flight {

    @Id //This annotation makes this field the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    private int depTime;
    @Column(nullable = false)
    private int arrTime;

    @Column(nullable = false)
    private String depCity;
    @Column(nullable = false)
    private String arrCity;
    @Column(nullable = false)
    private String airline;

    public Flight() {
    }

    public Flight(int id, int depTime, int arrTime, String depCity, String arrCity, String airline) {
        this.id = id;
        this.depTime = depTime;
        this.arrTime = arrTime;
        this.depCity = depCity;
        this.arrCity = arrCity;
        this.airline = airline;
    }

    public int getId() {
        return id;
    }

    public int getDepTime() {
        return depTime;
    }

    public int getArrTime() {
        return arrTime;
    }

    public String getDepCity() {
        return depCity;
    }

    public String getArrCity() {
        return arrCity;
    }

    public String getAirline() {
        return airline;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDepTime(int depTime) {
        this.depTime = depTime;
    }

    public void setArrTime(int arrTime) {
        this.arrTime = arrTime;
    }

    public void setDepCity(String depCity) {
        this.depCity = depCity;
    }

    public void setArrCity(String arrCity) {
        this.arrCity = arrCity;
    }

    public void setAirline(String airline) {
        this.airline = airline;
    }

    @Override
    public String toString() {
        return "Flight{" +
                "id=" + id +
                ", depTime=" + depTime +
                ", arrTime=" + arrTime +
                ", depCity='" + depCity + '\'' +
                ", arrCity='" + arrCity + '\'' +
                ", airline='" + airline + '\'' +
                '}';
    }
}
