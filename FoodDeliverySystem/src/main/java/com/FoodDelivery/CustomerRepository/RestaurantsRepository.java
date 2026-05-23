package com.FoodDelivery.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelivery.Restaurants;

public interface RestaurantsRepository extends JpaRepository<Restaurants,Integer>{
	
}
