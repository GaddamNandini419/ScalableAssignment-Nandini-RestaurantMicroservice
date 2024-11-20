package com.example.nandini.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.example.nandini.model.Restaurant;

@Repository
@EnableMongoRepositories
public interface RestaurantRepository extends MongoRepository<Restaurant, UUID>  {

	void deleteById(UUID id);

	List<Restaurant> findAll();

	Restaurant save(Restaurant restaurant);

	List<Restaurant> findByUserId(UUID userId);

	List<Restaurant> findByNameContaining(String name);

//	List<Restaurant> searchRestaurants(String name, String cuisine, Boolean pureVeg);

}
