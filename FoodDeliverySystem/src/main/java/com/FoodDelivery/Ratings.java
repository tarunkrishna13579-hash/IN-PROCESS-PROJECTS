package com.FoodDelivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Ratings")
public class Ratings {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rating_id;
	private int rating;
	private String review;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private Restaurants restaurant;
	
	@ManyToOne
	@JoinColumn(name="order_Id")
	private Orders order;
	Ratings(){
		
	}
	
	public int getRating_id() {
		return rating_id;
	}
	public void setRating_id(int rating_id) {
		this.rating_id = rating_id;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public Restaurants getRestaurant() {
		return restaurant;
	}
	public void setRestaurant(Restaurants restaurant) {
		this.restaurant = restaurant;
	}
	public Orders getOrder() {
		return order;
	}
	public void setOrder(Orders order) {
		this.order = order;
	}
	
	public String toString() {
		return " Ratings [rating_id=" + rating_id + ",rating="+ rating +",review="+ review+"]";
	}
	
	
}
