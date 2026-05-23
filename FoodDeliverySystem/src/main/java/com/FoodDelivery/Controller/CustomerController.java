package com.FoodDelivery.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FoodDelivery.Customers;
import com.FoodDelivery.Orders;
import com.FoodDelivery.Ratings;
import com.FoodDelivery.CustomerRepository.CustomerRepository;
import com.FoodDelivery.CustomerRepository.OrderRepository;
import com.FoodDelivery.CustomerRepository.RatingsRepository;

import org.springframework.web.bind.annotation.RequestBody; 

@RestController
public class CustomerController {
	
	@Autowired
	CustomerRepository repo;
	
	@Autowired
	OrderRepository orderRepo;
	@Autowired
	RatingsRepository ratingrepo;
	
	@GetMapping("/customers")
	public ResponseEntity<?> getAllCustomers() {
	    List<Customers> customer = repo.findAll();
	    Map<String, Object> res = new HashMap<>();
	    res.put("message", "Successfully fetched");
	    res.put("data", customer);

	    return ResponseEntity.ok(res);
	}
	
	@GetMapping("/customers/id/{customer_Id}")
	public ResponseEntity<?> getById(@PathVariable int customer_Id) {
	    Customers cust = repo.findById(customer_Id).get();
	    Map<String, Object> res = new HashMap<>();
	    res.put("message", "Successfully fetched by ID");
	    res.put("data", cust);

	    return ResponseEntity.ok(res);
	}
	
	@PostMapping("/customers/add")
	public ResponseEntity<?> createCustomer(@RequestBody Customers customer) {
	    Customers savedCustomer = repo.save(customer);
	    Map<String, Object> res = new HashMap<>();
	    res.put("message", "Customer created successfully");
	    res.put("data", savedCustomer);

	    return ResponseEntity.status(HttpStatus.CREATED).body(res);
	}
	
	@PutMapping("/customers/update/{customer_Id}")
	public ResponseEntity<?> updateCustomer(@PathVariable int customer_Id, @RequestBody Customers updatecustomer){
		Customers customer=repo.findById(customer_Id).get();
		customer.setCustomer_Email(updatecustomer.getCustomer_Email());
		customer.setCustomer_name(updatecustomer.getCustomer_name());
		customer.setCustomer_Phone(updatecustomer.getCustomer_Phone());
		repo.save(customer);
		Map<String, Object> mp=new HashMap<>();
		mp.put("message","customer record modified");
		mp.put("data", customer);
		return ResponseEntity.ok(mp);
	}
	
	@DeleteMapping("/customers/delete/{customer_Id}")
	public ResponseEntity<?> deleteCustomer(@PathVariable int customer_Id){
		Customers customer=repo.findById(customer_Id).get();
		repo.delete(customer);
		Map<String, Object>mp=new HashMap<>();
		mp.put("message", "deleted record successfully");
		//mp.put("data", mp);
		
		return ResponseEntity.ok(mp);
	}
	
	//Linked with Orders -> query in Orders Repo.
	@GetMapping("/customers/{id}/orders")
	public List<Orders> getOrders(@PathVariable Integer id) {
	    return orderRepo.getOrdersByCustomerId(id);
	}
	
	@GetMapping("/customers/{id}/reviews")
	public List<Ratings>getRatings(@PathVariable Integer id){
		return ratingrepo.getRatingsByCustomerId(id);
	}
	
}
