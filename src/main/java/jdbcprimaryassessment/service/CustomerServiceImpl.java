package jdbcprimaryassessment.service;

import jdbcprimaryassessment.dao.CustomerDAO;
import jdbcprimaryassessment.dao.CustomerDAOImpl;
import jdbcprimaryassessment.exceptions.CredentialMismatchException;
import jdbcprimaryassessment.model.Customer;

public class CustomerServiceImpl implements CustomerService{
	private CustomerDAO customerDAO=new CustomerDAOImpl();

	@Override
	public Customer addCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerDAO.addCustomer(customer);
	}

	@Override
	public boolean matchCustomerPassword(String username, String password) throws CredentialMismatchException {
		return customerDAO.matchCustomerPassword(username,password);
	}

}
