package pl.undemy.main.dao;

import java.util.List;

import pl.undemy.main.entity.Customer;

public interface CustomerDao {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(Long idCustomer);

	public void deleteCustomer(Long idCustomer);

	public List<Customer> searchCustomers(String searchText);
}
