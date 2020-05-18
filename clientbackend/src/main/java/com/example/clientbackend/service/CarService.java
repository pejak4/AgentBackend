package com.example.clientbackend.service;

import com.example.clientbackend.model.Car;
import com.example.clientbackend.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;

@Service
public class CarService {
    @Autowired
    private CarRepository carRepository;

    public List<Car> findCarSearch(Timestamp startDate, Timestamp endDate, String cityLocation){
        List<Car> listCarSearch = this.carRepository.findCarSearch(startDate, endDate, cityLocation);

        return listCarSearch;
    }

}
