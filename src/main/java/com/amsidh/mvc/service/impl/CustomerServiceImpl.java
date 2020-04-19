/**
 * 
 */
package com.amsidh.mvc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amsidh.mvc.dao.CustomerDao;
import com.amsidh.mvc.entities.Customer;
import com.amsidh.mvc.service.CustomerService;

/**
 * @author amsidhlokhande
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDao customerDao;

	public CustomerServiceImpl() {
		System.out.println("Loading CustomerServiceImpl bean!!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.mvc.service.CustomerService#addCustomer(com.amsidh.mvc.
	 * entities.Customer)
	 */
	@Override
	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amsidh.mvc.service.CustomerService#deleteCustomer(com.amsidh.mvc.
	 * entities.Customer)
	 */
	@Override
	@Transactional
	public void deleteCustomer(Customer customer) {
		customerDao.deleteCustomer(customer);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amsidh.mvc.service.CustomerService#getCustomer(java.lang.Integer)
	 */
	@Override
	@Transactional
	public Customer getCustomer(Integer customerId) {
		return customerDao.getCustomer(customerId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.mvc.service.CustomerService#getAllCustomers()
	 */
	@Override
	@Transactional
	public List getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	@Override
	public void updateCustomer(Customer customer) {
		customerDao.updateCustomer(customer);
		
	}

}
