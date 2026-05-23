package com.FoodDelivery;

import java.util.List;

import org.hibernate.annotations.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Orders")
public class Orders {
		
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int order_id;
	private String order_date;
	private int restaurant_id;
	private int delivery_driver_id;
	private String order_status;
	
//	@OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
//	private List<OrdersCoupons> ordersCoupons;
	
	@ManyToOne
	@JoinColumn(name="customer_Id")
	private Customers customer;
	
	public Customers getCustomer() {
		return customer;
	}
	public void setCustomer(Customers customer) {
		this.customer = customer;
	}
	Orders(){
		
	}
	public int getOrder_id() {
		return order_id;
	}
	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}
	public String getOrder_date() {
		return order_date;
	}
	public void setOrder_date(String order_date) {
		this.order_date = order_date;
	}
	public int getRestaurant_id() {
		return restaurant_id;
	}
	public void setRestaurant_id(int restaurant_id) {
		this.restaurant_id = restaurant_id;
	}
	public int getDelivery_driver_id() {
		return delivery_driver_id;
	}
	public void setDelivery_driver_id(int delivery_driver_id) {
		this.delivery_driver_id = delivery_driver_id;
	}
	public String getOrder_status() {
		return order_status;
	}
	public void setOrder_status(String order_status) {
		this.order_status = order_status;
	}
	
	public String toString() {
		return "Orders [ order_id ="+order_id+",order_date="+order_date+",restaurant_id="+restaurant_id+",delivery_driver_id="+delivery_driver_id+",order_status="+order_status;
	}
	
	
}
