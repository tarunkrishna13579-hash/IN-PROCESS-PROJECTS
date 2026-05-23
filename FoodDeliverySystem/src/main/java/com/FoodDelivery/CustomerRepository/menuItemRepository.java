package com.FoodDelivery.CustomerRepository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FoodDelivery.MenuItems;

import jakarta.transaction.Transactional;

public interface menuItemRepository extends JpaRepository<MenuItems, Integer>{

	 @Query("SELECT m FROM MenuItems m WHERE m.restaurant_id.restaurant_id = :id")
	    List<MenuItems> getMenuByRestaurant_id(@Param("id") Integer id);
	 
	  @Modifying
	    @Transactional
	 @Query(value = "DELETE FROM orderitems WHERE item_id = :itemId", nativeQuery = true)
	    void deleteOrderItems(@Param("itemId") int itemId);
}
