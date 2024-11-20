package com.example.nandini.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Document(collection = "menuitems")
@Getter
@Setter
public class MenuItem {
	

	    @Id
	    private UUID menuItemId;
	    private String name;
	    private String description;
	    private String cuisine;
	    private String menuCategory; // Beverages, Salads, Soups, etc.
	    private int price;
	    private boolean available;
	    private boolean pureVeg;
	    private UUID restaurantId; // Ensure this field exists
	    
	    
	    
		public UUID getMenuItemId() {
			return menuItemId;
		}
		public void setMenuItemId(UUID menuItemId) {
			this.menuItemId = menuItemId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getCuisine() {
			return cuisine;
		}
		public void setCuisine(String cuisine) {
			this.cuisine = cuisine;
		}
		public String getMenuCategory() {
			return menuCategory;
		}
		public void setMenuCategory(String menuCategory) {
			this.menuCategory = menuCategory;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
		public boolean isAvailable() {
			return available;
		}
		public void setAvailable(boolean available) {
			this.available = available;
		}
		public boolean isPureVeg() {
			return pureVeg;
		}
		public void setPureVeg(boolean pureVeg) {
			this.pureVeg = pureVeg;
		}
		public UUID getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(UUID restaurantId) {
			this.restaurantId = restaurantId;
		}
		

	    // Getters, Setters, Constructors
	


}
