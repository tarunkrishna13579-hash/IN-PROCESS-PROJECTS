package com.FoodDelivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Restaurants")
public class Restaurants {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer restaurant_id;
	private String restaurant_name;
	private String restaurant_address;
	private String restaurant_phone;
	
	public Integer getRestaurant_id() {
		return restaurant_id;
	}

	public void setRestaurant_id(Integer restaurant_id) {
		this.restaurant_id = restaurant_id;
	}

	public String getRestaurant_name() {
		return restaurant_name;
	}

	public void setRestaurant_name(String restaurant_name) {
		this.restaurant_name = restaurant_name;
	}

	public String getRestaurant_address() {
		return restaurant_address;
	}

	public void setRestaurant_address(String restaurant_address) {
		this.restaurant_address = restaurant_address;
	}

	public String getRestaurant_phone() {
		return restaurant_phone;
	}

	public void setRestaurant_phone(String restaurant_phone) {
		this.restaurant_phone = restaurant_phone;
	}

	
	
	Restaurants(){
		
	}
	
	public String toString() {
		return " Restaurants [restaurant_id=" + restaurant_id + ",restaurant_name="+ restaurant_name +",restaurant_address="+ restaurant_address + ",restaurant_phone="+ restaurant_phone +"]";
	}
	
}