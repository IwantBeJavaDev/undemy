package pl.undemy.main.dao;

import java.util.List;

import pl.undemy.main.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);
}
