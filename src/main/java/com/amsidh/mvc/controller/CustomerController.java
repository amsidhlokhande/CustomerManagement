/**
 * 
 */
package com.amsidh.mvc.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.amsidh.mvc.entities.Customer;
import com.amsidh.mvc.service.CustomerService;

/**
 * @author amsidhlokhande
 *
 */
@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;

	public CustomerController() {
		System.out.println("Loading CustomerController bean!!!");
	}

	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String getCustomerForm(Map<String, Object> map) {
		map.put("customer", new Customer());
		map.put("customerList", customerService.getAllCustomers());
		return "customer";
	}

	@RequestMapping(value = "/customerAction", method = RequestMethod.POST)
	public String customerAction(@ModelAttribute("customer") Customer customer, BindingResult bindingResult,
			@RequestParam("actionName") String actionName, Map<String, Object> map) {

		Customer customerResult = new Customer();
		switch (actionName) {
		case "Save":
			customerService.addCustomer(customer);
			customerResult = customer;
			break;
		case "Update":
			customerService.updateCustomer(customer);
			customerResult = customer;
			break;
		case "Delete":
			customerService.deleteCustomer(customer);
			customerResult = customer;
			break;

		case "Search":
			Customer searchedCustomer = customerService.getCustomer(customer.getCustomerId());
			customerResult = searchedCustomer != null ? searchedCustomer : new Customer();
			break;
		}
		map.put("customer", customerResult);
		map.put("customerList", customerService.getAllCustomers());

		return "customer";
	}

}
