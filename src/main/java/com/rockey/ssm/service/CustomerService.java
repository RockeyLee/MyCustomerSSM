package main.java.com.rockey.ssm.service;

import java.util.List;

import main.java.com.rockey.ssm.po.Customer;
import main.java.com.rockey.ssm.po.Page;


public interface CustomerService {
	
	
	/**add customer Info into customer table 
	 * @param Customer
	 */
	void addCust(Customer customer)throws Exception;


	/**
	 * find all customer info from customer table
	 * @return List<Customer>
	 */
	List<Customer> findAllCust()throws Exception;


	/**
	 * delete customer according to custId
	 * @param String
	 */
	void deleteCust(String custId)throws Exception;


	/**
	 * find customer from customer table according to id
	 * @param custId String
	 * @return Customer 
	 */
	Customer findCustById(String custId)throws Exception;


	/**
	 * update customer 
	 * @param Customer
	 */
	void updateCust(Customer customer)throws Exception;

	
	/**
	 * batch delete customers according by ids 
	 * @param ids String[]
	 */
	void batchDelCustById(String[] delIds)throws Exception;

	/**
	 * find Customer show in page 
	 * @param thispage
	 * @param object
	 * @return Page
	 */
	Page findCustShowInPage(int targetpage, Object object)throws Exception; 
	
	/**
	 * @param customer
	 * @return List<Customer>
	 * @throws Exception
	 */
	List<Customer> findCustomerByConds(Customer customer)throws Exception; 
}
