package com.carsAndOwner.demo.repository;

import com.carsAndOwner.demo.entity.Cars;

import java.util.List;

public interface CustomCarRepository {

    public List<Cars> findAnyWhereInPayload(String text);

    public Cars findAllFeaturesFromAllCars();
}
