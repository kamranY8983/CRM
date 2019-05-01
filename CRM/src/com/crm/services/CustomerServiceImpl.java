package com.crm.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crm.DAO.CustomerDAO;
import com.crm.entity.Customer;



@Service
public class CustomerServiceImpl implements CustomerService {

	
	//Now our Service Layer will talk to DAOs instead of controller directly
	@Autowired
	private CustomerDAO customerDAO;
	
	@Override
	@Transactional
	public List<Customer> getAllCustomers() {
		
		return customerDAO.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer theCustomer) {
		customerDAO.saveCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public boolean delete(int customerId) {
		return customerDAO.deleteCustomer(customerId);
		
	}

	@Override
	@Transactional
	public Customer getCustomer(int customerId) {
		return customerDAO.getCustomer(customerId);
	}


	


	@Override
	@Transactional
	public void updateCustomer(Customer theCustomer) {
		customerDAO.updateCustomer(theCustomer);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String name) {
		List<Customer> searchList=customerDAO.searchCustomers(name);
		return searchList;
	}

}
