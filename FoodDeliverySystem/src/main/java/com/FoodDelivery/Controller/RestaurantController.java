package com.FoodDelivery.Controller;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoodDelivery.Restaurants;
import com.FoodDelivery.CustomerRepository.RestaurantsRepository;

@RestController
public class RestaurantController {

	@Autowired
	RestaurantsRepository resRepo;
	
	@GetMapping("/restaurants")
	public ResponseEntity<?> getAllRestaurants(){
	
		List<Restaurants>restaurants=resRepo.findAll();
		Map<String,Object>res=new  HashMap<>();
		res.put("message", "Successfully   fetched");
		res.put("data", restaurants);
		return  ResponseEntity.ok(res);
	}
	
	@PostMapping("/restaurants/add")
	public ResponseEntity<?>createRestaurants(@RequestBody Restaurants restaurant){
		Restaurants restaurants=resRepo.save(restaurant);
		Map<String,Object>mp=new HashMap<>();
		mp.put("Message","Restaurant Created Successfully");
		mp.put("data",restaurants);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(mp);
	}
	
	@GetMapping("/restaurants/id/{restaurant_id}")
	public ResponseEntity<?> getRestaurantById(@PathVariable int restaurant_id){
		Restaurants restaurant=resRepo.findById(restaurant_id).get();
		Map<String,Object>mp=new HashMap<>();
		mp.put("Message", "record feteched by customerid");
		mp.put("data", restaurant);
		return ResponseEntity.ok(mp);
	}
	
	@PutMapping("/restaurants/update/{restaurant_id}")
	public ResponseEntity<?>updaterestaurantvalues(@PathVariable int restaurant_id, @RequestBody Restaurants uprestaurant){
		Restaurants restaurant=resRepo.findById(restaurant_id).get();
		restaurant.setRestaurant_address(uprestaurant.getRestaurant_address());
		restaurant.setRestaurant_name(uprestaurant.getRestaurant_name());
		restaurant.setRestaurant_phone(uprestaurant.getRestaurant_phone());
		resRepo.save(restaurant);
		Map<String,Object>mp=new HashMap<>();
		mp.put("message", "updated data successfully");
		mp.put("data", mp);
		
		return ResponseEntity.ok(restaurant);
	}
	
	@DeleteMapping("/restaurants/delete/{restaurant_id}")
	public String deletetheRecord(@PathVariable int restaurant_id){
		Restaurants restaurant=resRepo.findById(restaurant_id).get();
			resRepo.delete(restaurant);
		return "Record Deleted";
	}
}
