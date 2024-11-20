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

import com.example.nandini.model.MenuItem;
import com.example.nandini.model.Restaurant;
import com.example.nandini.service.MenuItemService;
import com.example.nandini.service.RestaurantService;

@RestController
@RequestMapping("/menu-items")
public class MenuController {
	
	@Autowired
    private MenuItemService menuItemService;
	
	
	
	
	@PostMapping
    public MenuItem createMenuItem(@RequestBody MenuItem menuItem) {
        return menuItemService.createMenuItem(menuItem);
    }
	
    // get menu by restaurant 
    @GetMapping("/restaurant/{restaurantId}")
    public List<MenuItem> getMenuItemsByRestaurant(@PathVariable UUID restaurantId) {
        return menuItemService.getMenuItemsByRestaurantId(restaurantId);
    }

    //Search for menu items by name and pure veg.
    @GetMapping("/search-menu")
    public List<MenuItem> searchMenuItems(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String cuisine,
            @RequestParam(required = false) Boolean pureVeg) {
        return menuItemService.searchMenuItems(name, cuisine, pureVeg);
    }

    @DeleteMapping("/{id}")
    public void deleteMenuItem(@PathVariable UUID id) {
        menuItemService.deleteMenuItem(id);
    }
    
    //update 
    @PutMapping("/{id}")
    public MenuItem updateMenuItem(@PathVariable UUID id, @RequestBody MenuItem updatedMenuItem) {
        return menuItemService.updateMenuItem(id, updatedMenuItem);
    }
    
    
    @GetMapping("/allmenuitems")
	public List<MenuItem> getAllMenuItems() {
		return menuItemService.getAllMenuItems();
	}
}
