package com.example.nandini.model;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.UUID;

@Document(collection = "restaurants")
@Getter
@Setter
public class Restaurant {
	
	    @Id
	    private UUID restaurantId;
	    private String name;
	    private String address;
	    private String hoursOfOperation;
	    private String deliveryZone;
	    private UUID userId; // The ID of the restaurant owner
	    private List<MenuItem> menuItems;
	    
	    
	    
	    
	    
	 // Getters, Setters, Constructors
		
		public Restaurant(UUID restaurantId, String name, String address, String hoursOfOperation,
				String deliveryZone, UUID userId) {
			
			
			this.restaurantId = UUID.randomUUID();  // Generate a UUID if not provided
			this.name = name;
			this.address = address;
			this.hoursOfOperation = hoursOfOperation;
			this.deliveryZone = deliveryZone;
			this.userId = userId;
		}
		public UUID getRestaurantId() {
			return restaurantId;
		}
		public void setRestaurantId(UUID restaurantId) {
			this.restaurantId = restaurantId;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public String getHoursOfOperation() {
			return hoursOfOperation;
		}
		public void setHoursOfOperation(String hoursOfOperation) {
			this.hoursOfOperation = hoursOfOperation;
		}
		public String getDeliveryZone() {
			return deliveryZone;
		}
		public void setDeliveryZone(String deliveryZone) {
			this.deliveryZone = deliveryZone;
		}
		
		
		public UUID getUserId() {
			return userId;
		}
		public void setUserId(UUID userId) {
			this.userId = userId;
		}
		public Restaurant() {
			 this.restaurantId = UUID.randomUUID();  // Generate a UUID if not provided
			
		}
		
		public List<MenuItem> getMenuItems() {
	        return menuItems;
	    }

	    public void setMenuItems(List<MenuItem> menuItems) {
	        this.menuItems = menuItems;
	    }

         
	    
	    
	}


