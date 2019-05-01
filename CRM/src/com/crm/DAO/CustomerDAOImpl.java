package com.crm.DAO;

import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.crm.entity.Customer;


@Repository
public class CustomerDAOImpl implements CustomerDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
			
		
		//get the session
		Session currentSession=sessionFactory.getCurrentSession();
				
		//create the query
		Query query=currentSession.createQuery("from Customer");
		
		//get the result
		List<Customer> customers=query.getResultList();
		
		//return the result
		return customers;
	}

	@Override
	public void saveCustomer(Customer theCustomer) {
		//get the session
		Session currentSession=sessionFactory.getCurrentSession();
						
		//create the query
		currentSession.save(theCustomer);
		
	}

	@Override
	public boolean deleteCustomer(int customerId) {
		boolean result=false;
		
		//get the session
		Session currentSession=sessionFactory.getCurrentSession();
		
		//get the customer
		Customer tempCust=currentSession.get(Customer.class, customerId);
		if(tempCust!=null) {
			currentSession.delete(tempCust);
			result=true;
		}
		else {
			System.out.println("Customer not Found!!!");
		}
		
		return result;
	}
	
	
	//to get a single customer details
	@Override
	public Customer getCustomer(int customerId) {
		
		//get the session
		Session session=sessionFactory.getCurrentSession();
		
		//get the result
		//return the result
		return session.get(Customer.class, customerId);
	}

	@Override
	public void updateCustomer(Customer theCustomer) {
		//update the Customer
		Session session=sessionFactory.getCurrentSession();
		session.update(theCustomer);

		
	}
	
	
	//search for customers with the given name and return the List
	@Override
	public List<Customer> searchCustomers(String name) {
		//get the session
		Session session=sessionFactory.getCurrentSession();
		
		//create query to search with the given name
		Query theQuery=session.createQuery("from Customer where firstName=:searchName");
		theQuery.setParameter("searchName", name);
		
		//execute the query
		List<Customer> searchResult=theQuery.getResultList();
		
		//return the result
		return searchResult;
	}

}
