package pl.undemy.main.service;

import java.util.List;

import pl.undemy.main.entity.Customer;

public interface CustomerService {
	public List<Customer> getCustomers();

	public void saveCustomer(Customer customer);

	public Customer getCustomerById(Long idCustomer);

	public void deleteCustomer(Long idCustoemr);

	public List<Customer> searchCustomers(String searchText);
}
