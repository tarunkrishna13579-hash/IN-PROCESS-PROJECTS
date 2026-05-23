package com.FoodDelivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="MenuItems")
public class MenuItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer item_id;
	private String item_name;
	private String item_description;
	private Double item_price;
	
	@ManyToOne
    @JoinColumn(name = "restaurant_id")
    private Restaurants restaurant_id;
	
	public Integer getItem_id() {
		return item_id;
	}
	public void setItem_id(Integer item_id) {
		this.item_id = item_id;
	}
	public String getItem_name() {
		return item_name;
	}
	public void setItem_name(String item_name) {
		this.item_name = item_name;
	}
	public String getItem_description() {
		return item_description;
	}
	public void setItem_description(String item_description) {
		this.item_description = item_description;
	}
	public Double getItem_price() {
		return item_price;
	}
	public void setItem_price(Double item_price) {
		this.item_price = item_price;
	}
	public Restaurants getRestaurant_id() {
	    return restaurant_id;
	}

	public void setRestaurant_id(Restaurants restaurant_id) {
	    this.restaurant_id = restaurant_id;
	}
	
	MenuItems(){
		
	}
	
	public MenuItems(Integer item_id, String item_name, String item_description, Double item_price) {
		this.item_id=item_id;
		this.item_name=item_name;
		this.item_description=item_description;
		this.item_price=item_price;
	}
	
	public String toString() {
		return "menuitems [item_id ="+item_id + ",item_name="+item_name+",item_description="+item_description+",restaurant_id="+ restaurant_id+ ",item_price="+item_price;
	}
	
}
