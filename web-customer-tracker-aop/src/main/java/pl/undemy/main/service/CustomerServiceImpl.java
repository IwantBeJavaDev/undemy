package pl.undemy.main.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pl.undemy.main.dao.CustomerDao;
import pl.undemy.main.entity.Customer;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public List<Customer> getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	@Transactional
	public void saveCustomer(Customer customer) {
		customerDao.saveCustomer(customer);
		
	}

	@Override
	@Transactional //I don't have to use begin end close transaction :-)
	public Customer getCustomerById(Long idCustomer) {
		return customerDao.getCustomerById(idCustomer);
	}

	@Override
	@Transactional
	public void deleteCustomer(Long idCustomer) {
		customerDao.deleteCustomer(idCustomer);
		
	}

	@Override
	@Transactional
	public List<Customer> searchCustomers(String searchText) {
		return customerDao.searchCustomers(searchText);
	}

}
