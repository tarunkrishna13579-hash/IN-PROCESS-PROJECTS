package com.FoodDelivery.CustomerRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FoodDelivery.Ratings;

public interface RatingsRepository extends JpaRepository<Ratings,Integer>{
	
	@Query("SELECT o FROM Ratings o WHERE o.order.customer.customer_Id = :id")
	List<Ratings> getRatingsByCustomerId(@Param("id") Integer id);
}
