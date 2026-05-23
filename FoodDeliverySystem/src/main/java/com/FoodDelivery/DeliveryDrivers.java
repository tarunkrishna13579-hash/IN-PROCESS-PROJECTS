package com.FoodDelivery;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DeliveryDrivers")
public class DeliveryDrivers {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer driver_id ;
	private String driver_name;
	private Long driver_phone;
	private String driver_vehicle;
	
	DeliveryDrivers(){
		
	}
	
	public DeliveryDrivers(Integer driver_id , String driver_name, long driver_phone, String driver_vehicle) {
		this.driver_id=driver_id;
		this.driver_name=driver_name;
		this.driver_phone=driver_phone;
		this.driver_vehicle=driver_vehicle;
	}
	
	public Integer getDriver_id() {
		return driver_id;
	}
	public void setDriver_id(Integer driver_id) {
		this.driver_id = driver_id;
	}
	public String getDriver_name() {
		return driver_name;
	}
	public void setDriver_name(String driver_name) {
		this.driver_name = driver_name;
	}
	public Long getDriver_phone() {
		return driver_phone;
	}
	public void setDriver_phone(Long driver_phone) {
		this.driver_phone = driver_phone;
	}
	public String getDriver_vehicle() {
		return driver_vehicle;
	}
	public void setDriver_vehicle(String driver_vehicle) {
		this.driver_vehicle = driver_vehicle;
	}
	
	public String toString() {
		return "DeliveryDrivers [driver_id="+driver_id+"driver_name="+driver_name+"driver_phone="+driver_phone+"driver_vehicle="+driver_vehicle;
	}
}
