package com.carsAndOwner.demo.service;

import com.carsAndOwner.demo.entity.Cars;
import com.carsAndOwner.demo.repository.CustomCarRepository;
import com.mongodb.client.AggregateIterable;
import org.springframework.beans.factory.annotation.Autowired;
import org.bson.Document;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MongoConverter;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CarsService implements CustomCarRepository {

    @Autowired
    private MongoConverter mongoConverter;

    @Autowired
    private MongoTemplate mongoTemplate;

    //MongoDb atlas Aggregation from MongoDb Atlas WebUI Tool
    @Override
    public List<Cars> findAnyWhereInPayload(String text) {
        List<Cars> cars = new ArrayList<>();

        // Define the aggregation pipeline for Atlas Search
        List<Document> pipeline = Arrays.asList(
                new Document("$search",
                        new Document("text",
                                new Document("query", text)  // Use dynamic input instead of hardcoded "petrol"
                                        .append("path", "fuel"))),
                new Document("$limit", 5),
                new Document("$sort", new Document("price", -1))
        );

        // Execute aggregation using the raw pipeline
        AggregateIterable<Document> results = mongoTemplate
                .getDb()
                .getCollection("Cars")  // Use correct collection name
                .aggregate(pipeline);

        // Convert Document to Cars objects
        for (Document doc : results) {
            Cars car = mongoConverter.read(Cars.class, doc);
            cars.add(car);
        }

        return cars;
    }


    //Criteria API
    @Override
    public Cars findAllFeaturesFromAllCars() {
        Query query = new Query();
        Criteria criteria1 = new Criteria("features").exists(true);
        query.addCriteria(criteria1.andOperator(
                Criteria.where("features").is("Alloys")));
        List<Cars> cars = mongoTemplate.find(query, Cars.class);
        return cars.get(0);
    }
}
