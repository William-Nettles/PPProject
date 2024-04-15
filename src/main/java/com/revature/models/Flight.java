package com.revature.models;

import jakarta.persistence.*;
import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "flights")
public class Flight {

    @Id //This annotation makes this field the PK
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int depTime;
    private int arrTime;

    private String depCity;
    private String arrCity;

    private String airline;




}
