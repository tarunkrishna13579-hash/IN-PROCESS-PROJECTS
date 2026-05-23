package com.FoodDelivery.CustomerRepository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.FoodDelivery.Orders;

public interface OrderRepository extends JpaRepository<Orders,Integer>{
	//List<Orders> findByCustomerCustomer_Id(Integer id);
	
	@Query("SELECT o FROM Orders o WHERE o.customer.customer_Id = :id")
	List<Orders> getOrdersByCustomerId(@Param("id") Integer id);
	
	
//	@Query("DELETE FROM OrdersCoupons oc WHERE oc.order.order_id = :orderid")
//	void deleteByOrderId(@Param("orderid") int orderid);
}	
