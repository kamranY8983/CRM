package com.crm.DAO;

import java.util.List;
import com.crm.entity.Customer;


public interface CustomerDAO {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer theCustomer);

	public boolean deleteCustomer(int customerId);

	public Customer getCustomer(int customerId);

	public void updateCustomer(Customer theCustomer);

	public List<Customer> searchCustomers(String name);
}
