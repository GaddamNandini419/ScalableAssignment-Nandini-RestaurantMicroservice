package com.example.nandini.service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nandini.model.MenuItem;
import com.example.nandini.model.Restaurant;
import com.example.nandini.repository.MenuItemRepository;
import com.example.nandini.repository.RestaurantRepository;

@Service
public class RestaurantService {

	@Autowired
	private RestaurantRepository restaurantRepository;
	
	@Autowired
	private MenuItemRepository menuItemRepository;

	// create Restaurant
	public Restaurant createRestaurant(Restaurant restaurant) {
		restaurant.setRestaurantId(UUID.randomUUID());
		return restaurantRepository.save(restaurant);
	}

	// get all Restaurants
	public List<Restaurant> getAllRestaurants() {
		return restaurantRepository.findAll();
	}

	// delete restaurant
	public void deleteRestaurant(UUID id) {
		restaurantRepository.deleteById(id);
	}

	// ..get restaurants by userid
	public List<Restaurant> getRestaurantsByUserId(UUID userId) {
		return restaurantRepository.findByUserId(userId);
	}

//	// search restaurants by name
      public List<Restaurant> searchRestaurantsByName(String name) {
		return restaurantRepository.findByNameContaining(name);
	}


	public Restaurant updateRestaurant(UUID id, Restaurant updatedRestaurant) {
		Restaurant existingRestaurant = restaurantRepository.findById(id)
				.orElseThrow(() -> new RuntimeException("Restaurant not found with id: " + id));

		existingRestaurant.setName(updatedRestaurant.getName());
		existingRestaurant.setAddress(updatedRestaurant.getAddress());
		existingRestaurant.setHoursOfOperation(updatedRestaurant.getHoursOfOperation());
		existingRestaurant.setDeliveryZone(updatedRestaurant.getDeliveryZone());

		return restaurantRepository.save(existingRestaurant);
	}

	public List<Restaurant> searchRestaurants(String restaurantName, String menuItemName, String cuisine, Boolean pureVeg) {
	    List<Restaurant> restaurants = restaurantRepository.findAll();

	    // Filter restaurants by name
	    if (restaurantName != null) {
	        restaurants = restaurants.stream()
	                .filter(r -> r.getName().toLowerCase().contains(restaurantName.toLowerCase()))
	                .collect(Collectors.toList());
	    }

	    // Fetch menu items for restaurants
	    for (Restaurant restaurant : restaurants) {
	        List<MenuItem> menuItems = menuItemRepository.findByRestaurantId(restaurant.getRestaurantId());
	        restaurant.setMenuItems(menuItems);
	    }

	    // Filter by menu item name
	    if (menuItemName != null) {
	        restaurants = restaurants.stream()
	                .filter(r -> r.getMenuItems().stream()
	                        .anyMatch(item -> item.getName().toLowerCase().contains(menuItemName.toLowerCase())))
	                .collect(Collectors.toList());
	    }

	    // Filter by cuisine
	    if (cuisine != null) {
	        restaurants = restaurants.stream()
	                .filter(r -> r.getMenuItems().stream()
	                        .anyMatch(item -> item.getCuisine().equalsIgnoreCase(cuisine)))
	                .collect(Collectors.toList());
	    }

	    // Filter by pureVeg
	    if (pureVeg != null) {
	        restaurants = restaurants.stream()
	                .filter(r -> r.getMenuItems().stream() // Stream through MenuItems of each restaurant
	                        .anyMatch(menuItem -> menuItem.isPureVeg() == pureVeg)) // Check if any MenuItem matches the pureVeg condition
	                .collect(Collectors.toList());
	    }

	    return restaurants;
	}

}
