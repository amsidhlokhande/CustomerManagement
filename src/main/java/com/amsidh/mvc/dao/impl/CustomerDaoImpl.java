/**
 * 
 */
package com.amsidh.mvc.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.amsidh.mvc.dao.CustomerDao;
import com.amsidh.mvc.entities.Customer;

/**
 * @author amsidhlokhande
 *
 */
@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	public CustomerDaoImpl() {
		System.out.println("Loading CustomerDaoImpl bean!!!");
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.mvc.dao.CustomerDao#addCustomer(com.amsidh.mvc.entities.
	 * Customer)
	 */
	@Override
	public void addCustomer(Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(customer);
		session.getTransaction().commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.amsidh.mvc.dao.CustomerDao#deleteCustomer(com.amsidh.mvc.entities.
	 * Customer)
	 */
	@Override
	public void deleteCustomer(Customer customer) {

		Serializable serializableCustomerId = customer.getCustomerId();
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Customer persistentCustomer = session.get(Customer.class, serializableCustomerId);
		 if(persistentCustomer!=null){
			 session.delete(persistentCustomer);
		 }
		session.getTransaction().commit();

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.mvc.dao.CustomerDao#getCustomer(java.lang.Integer)
	 */
	@Override
	public Customer getCustomer(Integer customerId) {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		Customer customer = session.get(Customer.class, customerId);
		session.getTransaction().commit();
		return customer;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.amsidh.mvc.dao.CustomerDao#getAllCustomers()
	 */
	@Override
	public List getAllCustomers() {
		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		List list = session.createQuery("from Customer").list();
		session.getTransaction().commit();
		return list;
	}

	@Override
	public void updateCustomer(Customer customer) {

		Session session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.saveOrUpdate(customer);
		session.getTransaction().commit();

	}

}
