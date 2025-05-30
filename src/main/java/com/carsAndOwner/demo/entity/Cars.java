package com.carsAndOwner.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "Cars")
@NoArgsConstructor
@AllArgsConstructor
public class Cars {

    @Id
    private String id;

    private String model;
    private String brand;
    private String engine;
    private List<String> features;
    private int year;
    private String transmission;
    private String fuel;
    private long price;

    public String getId() {
        return id;
    }

    public String getModel() {
        return model;
    }

    public String getBrand() {
        return brand;
    }

    public String getEngine() {
        return engine;
    }

    public List<String> getFeatures() {
        return features;
    }

    public int getYear() {
        return year;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getFuel() {
        return fuel;
    }

    public long getPrice() {
        return price;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setEngine(String engine) {
        this.engine = engine;
    }

    public void setFeatures(List<String> features) {
        this.features = features;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public void setPrice(long price) {
        this.price = price;
    }
}
