package com.example.clientbackend.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int doors;
    private String description;
    private String image;
    private String brand;
    private String model;
    private String fuelType;
    private String transmission;
    private String classCar;
    private double price;
    private int mileage;
    private int plannedMileage;
    private Boolean CDW;
    private int capacitySeats;
    private int capacitySeatsForKids;
    private int cubicCapacity;
    private int horsePower;
    private Boolean usb;
    private Boolean gps;
    private double fuelTankCapacity;
    private String cityLocation;

    @OneToMany(mappedBy = "car", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<CarRentalDate> dateList;


}
