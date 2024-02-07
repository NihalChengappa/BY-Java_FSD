package jdbcprimaryassessment.service;

import jdbcprimaryassessment.exceptions.CredentialMismatchException;
import jdbcprimaryassessment.model.Customer;

public interface CustomerService {
	public boolean matchCustomerPassword(String username ,String password) throws CredentialMismatchException;
	public Customer addCustomer(Customer customer);
}
