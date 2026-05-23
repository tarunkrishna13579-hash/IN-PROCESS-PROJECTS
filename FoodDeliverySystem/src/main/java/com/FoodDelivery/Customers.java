package com.FoodDelivery;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="Customers")
public class Customers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@JsonProperty("customer_Id")
	private Integer customer_Id;
	private String customer_name;
	private String customer_Email;
	private String customer_Phone;
	
	public Integer getCustomer_Id() {
		return customer_Id;
	}

	public void setCustomer_Id(int customer_Id) {
		this.customer_Id = customer_Id;
	}

	public String getCustomer_name() {
		return customer_name;
	}

	public void setCustomer_name(String customer_name) {
		this.customer_name = customer_name;
	}

	public String getCustomer_Email() {
		return customer_Email;
	}

	public void setCustomer_Email(String customer_Email) {
		this.customer_Email = customer_Email;
	}

	public String getCustomer_Phone() {
		return customer_Phone;
	}

	public void setCustomer_Phone(String customer_Phone) {
		this.customer_Phone = customer_Phone;
	}

	
	
	Customers(){
		
	}
	
	public Customers(Integer customer_Id, String customer_name,String customer_Email,String customer_Phone) {
		super();
		this.customer_Id=customer_Id;
		this.customer_name=customer_name;
		this.customer_Email=customer_Email;
		this.customer_Phone=customer_Phone;
	}
	
	public String toString() {
		return " Customers [customer_Id=" + customer_Id + ",customer_name="+ customer_name +",customer_Email="+ customer_Email + ",customer_Phone="+ customer_Phone +"]";
	}
	
}
