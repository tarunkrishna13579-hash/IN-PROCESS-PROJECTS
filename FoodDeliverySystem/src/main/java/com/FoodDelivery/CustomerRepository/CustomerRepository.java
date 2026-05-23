package com.FoodDelivery.CustomerRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FoodDelivery.Customers;

public interface CustomerRepository extends JpaRepository<Customers, Integer>{

}
