package com.crm.services;

import java.util.List;

import com.crm.entity.Customer;

public interface CustomerService {
	
	public List<Customer> getAllCustomers();

	public void saveCustomer(Customer theCustomer);

	public boolean delete(int customerId);

	public Customer getCustomer(int customerId);

	public void updateCustomer(Customer theCustomer);

	public List<Customer> searchCustomers(String name);

}
