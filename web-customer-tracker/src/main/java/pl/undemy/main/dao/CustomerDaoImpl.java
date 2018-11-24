package pl.undemy.main.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import pl.undemy.main.entity.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getCustomers() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Customer> query = currentSession.createQuery("from Customer order by lastName", Customer.class);
		List<Customer> customers = query.getResultList();
		return customers;
	}

	@Override
	public void saveCustomer(Customer customer) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(customer);
		
	}

	@Override
	public Customer getCustomerById(Long idCustomer) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Customer.class, idCustomer);
	}

	@Override
	public void deleteCustomer(Long idCustomer) {
		Session session = sessionFactory.getCurrentSession();
		Customer customer = session.get(Customer.class, idCustomer);
		session.delete(customer);
	}

	@Override
	public List<Customer> searchCustomers(String searchText) {
		Session session = sessionFactory.getCurrentSession();
		
		Query query = null;
		
		if(StringUtils.isEmpty(searchText)) {
			query = session.createQuery("from Customer", Customer.class);
		} else {
			query = session.createQuery("from Customer c where upper(c.firstName) like upper(:firstName) or upper(c.lastName) like upper(:lastName)", Customer.class);
			query.setParameter("firstName", "%" + searchText + "%");
			query.setParameter("lastName", "%" + searchText + "%");
		}
		
		return query.getResultList();
	}

}
