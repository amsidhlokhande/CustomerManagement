package com.amsidh.mvc.service;

import java.util.List;

import com.amsidh.mvc.entities.Customer;

public interface CustomerService {

	public void addCustomer(Customer customer);

	public void updateCustomer(Customer customer);
	
	public void deleteCustomer(Customer customer);

	public Customer getCustomer(Integer customerId);

	public List getAllCustomers();
}
