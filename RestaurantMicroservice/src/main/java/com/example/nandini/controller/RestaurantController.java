package com.example.nandini.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.nandini.model.Restaurant;
import com.example.nandini.service.RestaurantService;

@RestController
@RequestMapping("/restaurants")
public class RestaurantController {

	@Autowired
	private RestaurantService restaurantService;

	@PostMapping
	public Restaurant createRestaurant(@RequestBody Restaurant restaurant) {
		return restaurantService.createRestaurant(restaurant);
	}

	@GetMapping("/allrestaurants")
	public List<Restaurant> getAllRestaurants() {
		return restaurantService.getAllRestaurants();
	}

	// retrieve all restaurants
	@GetMapping("/owner/{userId}")
	public List<Restaurant> getRestaurantsByUser(@PathVariable UUID userId) {
		return restaurantService.getRestaurantsByUserId(userId);
	}

//	// search by name, menu item name, or cuisine.
	
	 @GetMapping("/search")
	    public List<Restaurant> searchRestaurants(
	            @RequestParam(required = false) String restaurantName,
	            @RequestParam(required = false) String menuItemName,
	            @RequestParam(required = false) String cuisine,
	            @RequestParam(required = false) Boolean pureVeg) {
	        return restaurantService.searchRestaurants(restaurantName, menuItemName, cuisine, pureVeg);
	    }


	@DeleteMapping("/{id}")
	public void deleteRestaurant(@PathVariable UUID id) {
		restaurantService.deleteRestaurant(id);
	}

	@PutMapping("/{id}")
	public Restaurant updateRestaurant(@PathVariable UUID id, @RequestBody Restaurant updatedRestaurant) {
		return restaurantService.updateRestaurant(id, updatedRestaurant);
	}

}
