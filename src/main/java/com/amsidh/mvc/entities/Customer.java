package com.amsidh.mvc.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Customer {

	@Id
	@SequenceGenerator(name = "CUST_SEQ", allocationSize = 25, initialValue = 1, sequenceName = "CUST_SEQ")
	@GeneratedValue(generator = "CUST_SEQ")
	@Column(name = "ID")
	private Integer customerId;

	@Column(name = "NAME")
	private String customerName;

	@Column(name = "ADDRESS")
	private String address;

	public Customer() {
	}

	public Customer(Integer customerId, String customerName, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
	}

	public Customer(String customerName, String address) {
		super();
		this.customerName = customerName;
		this.address = address;
	}

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Customer Id: " + customerId + "  Name: " + customerName + "   Address: " + address;
	}
}
