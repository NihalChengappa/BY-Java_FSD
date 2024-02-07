package jdbcprimaryassessment.dao;

import jdbcprimaryassessment.exceptions.CredentialMismatchException;
import jdbcprimaryassessment.model.Customer;

public interface CustomerDAO {
	public boolean matchCustomerPassword(String username ,String password) throws CredentialMismatchException;
	public Customer addCustomer(Customer customer);
}
