package com.example.nandini.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Repository;

import com.example.nandini.model.MenuItem;

@Repository
@EnableMongoRepositories
public interface MenuItemRepository extends MongoRepository<MenuItem, UUID>  {

	List<MenuItem> findByRestaurantId(UUID restaurantId);

	 List<MenuItem> findByNameContainingAndPureVeg(String name, boolean pureVeg);

	List<MenuItem> findByNameContainingAndCuisineAndPureVeg(String name, String cuisine, boolean pureVeg);

}
