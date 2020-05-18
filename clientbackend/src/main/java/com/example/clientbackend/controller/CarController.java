package com.example.clientbackend.controller;

import com.example.clientbackend.dto.CarSearchDTO;
import com.example.clientbackend.dto.UserLoginDto;
import com.example.clientbackend.model.Car;
import com.example.clientbackend.repository.CarRepository;
import com.example.clientbackend.service.CarService;
import com.example.clientbackend.view.UserTokenState;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarController {
    @Autowired
    private CarService carService;

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/searchCars")
    public ResponseEntity<?> searchCars(@RequestBody CarSearchDTO csd){
        return new ResponseEntity<>(this.carService.findCarSearch(csd.getStartDate(), csd.getEndDate(), csd.getStartCity()), HttpStatus.OK);
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE, path = "/getAllCars")
    public ResponseEntity<?> getAllCars() {
        return new ResponseEntity<>(this.carService.findAll(), HttpStatus.OK);
    }
}
