package com.carsAndOwner.demo.repository;

import com.carsAndOwner.demo.entity.Cars;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarsRepository extends MongoRepository<Cars, String> {
}
