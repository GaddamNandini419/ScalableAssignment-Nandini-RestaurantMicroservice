package com.example.nandini.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.nandini.model.MenuItem;
import com.example.nandini.repository.MenuItemRepository;

@Service
public class MenuItemService {

	
	@Autowired
    private MenuItemRepository menuItemRepository;
	
	
	//create menu
	 public MenuItem createMenuItem(MenuItem menuItem) {
	        menuItem.setMenuItemId(UUID.randomUUID());
	        return menuItemRepository.save(menuItem);
	    }
	 
	 //get menu items by restaurantid
	 public List<MenuItem> getMenuItemsByRestaurantId(UUID restaurantId) {
	        return menuItemRepository.findByRestaurantId(restaurantId);
	    }
	 
	 public List<MenuItem> searchMenuItems(String name, String cuisine, boolean pureVeg) {
		    // Filtering by name, pureVeg, and cuisine (assuming 'name' is the menu item name)
		    return menuItemRepository.findByNameContainingAndCuisineAndPureVeg(name, cuisine, pureVeg);
		}

	 
	 //delete menuitem
	 public void deleteMenuItem(UUID id) {
	        menuItemRepository.deleteById(id);
	    }

	 public MenuItem updateMenuItem(UUID id, MenuItem updatedMenuItem) {
		    MenuItem existingMenuItem = menuItemRepository.findById(id)
		            .orElseThrow(() -> new RuntimeException("MenuItem not found with id: " + id));
		    
		    existingMenuItem.setName(updatedMenuItem.getName());
		    existingMenuItem.setDescription(updatedMenuItem.getDescription());
		    existingMenuItem.setCuisine(updatedMenuItem.getCuisine());
		    existingMenuItem.setMenuCategory(updatedMenuItem.getMenuCategory());
		    existingMenuItem.setPrice(updatedMenuItem.getPrice());
		    existingMenuItem.setAvailable(updatedMenuItem.isAvailable());
		    existingMenuItem.setPureVeg(updatedMenuItem.isPureVeg());
		    
		    return menuItemRepository.save(existingMenuItem);
		}

	public List<MenuItem> getAllMenuItems() {
		// TODO Auto-generated method stub
		return menuItemRepository.findAll();
	}
}
