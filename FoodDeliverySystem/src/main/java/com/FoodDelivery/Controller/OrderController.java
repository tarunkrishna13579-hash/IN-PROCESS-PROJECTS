package com.FoodDelivery.Controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FoodDelivery.Customers;
import com.FoodDelivery.Orders;
import com.FoodDelivery.CustomerRepository.CustomerRepository;
import com.FoodDelivery.CustomerRepository.OrderRepository;



@RestController
public class OrderController {
	@Autowired
	OrderRepository orderrepo;
	@Autowired
	CustomerRepository cusrepo;
	
	@GetMapping("/orders/{order_id}")
	public ResponseEntity<?>getOrders(@PathVariable int order_id){
		Orders order=orderrepo.findById(order_id).get();
		Map<String,Object>mp=new HashMap<>();
		
		mp.put("Success", "Fetched records");
		mp.put("Data", order);
		
		return ResponseEntity.ok(mp);
	}
	
	@PostMapping("/orders/createorder")
	public ResponseEntity<?>CreateOrder(@RequestBody Orders order){
		
		//THIS WE ARE USING TO FETCH CUSTOMER NAME,EMAIL & PHN in our response based on customer_id
		Integer customerId = order.getCustomer().getCustomer_Id();
	    Customers customer = cusrepo.findById(customerId)
	            .orElseThrow(() -> new RuntimeException("Customer not found"));
	    order.setCustomer(customer);
	    //if we have not used this it will run , but we will get NULL values in the response
	    
		Orders orderr=orderrepo.save(order);
		Map<String,Object>mp=new HashMap<>();
		mp.put("Message", "Inserted Suceesfully");
		mp.put("success", orderr);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(mp);
	}
	
	@PutMapping("/orders/{order_id}/updateorder")
	public ResponseEntity<?>UpdateOrder(@PathVariable int order_id, @RequestBody Orders updateorder){
		Orders order=orderrepo.findById(order_id).get();
		order.setOrder_status(updateorder.getOrder_status());
		orderrepo.save(order);
		
		Map<String,Object>mp=new HashMap<>();
		mp.put("Updated Order", order);
		
		return ResponseEntity.ok(mp);
	}
	
//	@DeleteMapping("/orders/{order_id}/deleteorder")
//	public String deleteorder(@PathVariable int order_id) {
//		Orders order=orderrepo.findById(order_id).get();
//		orderrepo.delete(order);
//		
//		return "Deleted Order Successfully"+order;
//	}
}
