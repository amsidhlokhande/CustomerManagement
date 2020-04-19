package com.amsidh.mvc.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.amsidh.mvc.entities.Customer;
import com.amsidh.mvc.service.CustomerService;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("classpath:spring-beans.xml");

		CustomerService customerService = context.getBean(CustomerService.class);
		List allCustomers = customerService.getAllCustomers();
		for (Object object : allCustomers) {
			if(object instanceof Customer){
				Customer customer=(Customer)object;
				System.out.println(customer.toString());
			}
			
		}

	}

}
