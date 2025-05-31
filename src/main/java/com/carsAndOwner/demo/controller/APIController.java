package com.carsAndOwner.demo.controller;

import com.carsAndOwner.demo.entity.Cars;
import com.carsAndOwner.demo.repository.CarsRepository;
import com.carsAndOwner.demo.service.CarsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class APIController {

    private static final org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(APIController.class);

    @Autowired
    CarsRepository carsRepository;

    @Autowired
    CarsService carsService;

    @GetMapping("/cars")
    public ResponseEntity<List<Cars>> getAllCars() {
        List<Cars> cars = carsRepository.findAll();
        return new ResponseEntity<>(cars, HttpStatus.OK);
    }

    @PostMapping("/postCars")
    public ResponseEntity<String> postCars(@RequestBody Cars cars) {
        carsRepository.save(cars);
        return new ResponseEntity<>(cars.toString(), HttpStatus.OK);
    }

    @PostMapping("/searchTextFromAnyWhereInPayload/{text}")
    public ResponseEntity<List<Cars>> searchTextFromAnyWhereInPayload(@PathVariable String text) {
        return new ResponseEntity<>(carsService.findAnyWhereInPayload(text), HttpStatus.OK);
    }
}
