package com.crm.spring;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.crm.DAO.CustomerDAO;
import com.crm.entity.Customer;
import com.crm.services.CustomerService;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	
	
	//get the Service bean
	@Autowired
	private CustomerService customerService;
	
	
	
	@GetMapping("/list")
	public String getCustomerList(Model model) {
		//excute DAO method to get list
		List<Customer> customers=customerService.getAllCustomers();
		
		model.addAttribute("customers", customers);
		
		//forward to jsp
		return "customer-list";
	}
	
	@RequestMapping("/showFormForAdd")
	public String showForm(Model model) {
		
		//add customer object to bind data
		model.addAttribute("customer", new Customer());
		return "new-customer-form";
	}
	
	@PostMapping("/addcustomer")
	public String addCustomer(@ModelAttribute("customer")Customer theCustomer) {
		try {
			//try to add the customer
			customerService.saveCustomer(theCustomer);
		}catch(Exception e) {
			e.printStackTrace();
			return "error-customer-add";
		}
		
		return "redirect:/customer/list";
	}
	
	//update method
	@GetMapping("/showform")
	public String updateCustomer(@RequestParam("customerId")int customerId, Model model) {
		//get the customer from database
		Customer toUpdateCustomer=customerService.getCustomer(customerId);
		
		//save to the model to prepopulate the update formm
		model.addAttribute("customer", toUpdateCustomer);
		
		//forward to the update form
		
		return "customer-update-form";
		
		
	}
	
	
	//delete method
	@GetMapping("/delete")
	public ModelAndView deleteCustomer(@RequestParam("customerId")int customerId) {
		ModelAndView model=new ModelAndView("redirect:/customer/list");
		System.out.println("THe Requested ID to Delete is:-"+customerId);
		boolean isDelete=customerService.delete(customerId);
		if(isDelete) {
			System.out.println("Deleted");
			model.addObject("message", "Customer with ID "+customerId+"Deleted Successfully");
		}
		else {
			model.addObject("message", "Customer with ID "+customerId+"is unable to delete or does not exist");
			System.out.println("Not Deleted");
		}
		return model;
	}
	
	@PostMapping("/updatecustomer")
	public String updatCustomer(@ModelAttribute("customer")Customer theCustomer) {
		//update the customer
		customerService.updateCustomer(theCustomer);
		
		//return to list page
		return "redirect:/customer/list";
	}
	
	@PostMapping("/search")
	public String searchCustomer(@RequestParam("theSearchName") String name, Model model) {
		//get the result 
		List<Customer> searchList=customerService.searchCustomers(name);
		
		//if found add to the model and show the customers
		if(searchList!=null) {
			model.addAttribute("customers", searchList);
		}
		else {
			System.out.println("NO Customer Found");
		}
		return "customer-list";
	}
}
