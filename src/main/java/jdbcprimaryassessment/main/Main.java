package jdbcprimaryassessment.main;

import java.sql.SQLException;
import java.util.Scanner;

import jdbcprimaryassessment.model.Customer;
import jdbcprimaryassessment.dao.*;
import jdbcprimaryassessment.exceptions.CredentialMismatchException;
import jdbcprimaryassessment.service.*;

public class Main {
	public static void main(String[] args) throws CredentialMismatchException {
		Scanner myObj=new Scanner(System.in);
		Customer cust1=new Customer("Ram","12345");
		Customer cust2=new Customer("Raj","123456");
		Customer cust3=new Customer("Sam","1234567");
		Customer cust4=new Customer("Tom","12345");
		Customer cust5=new Customer("Sid","123456");
		Customer cust6=new Customer("Eve","123457");
		int choice=-1;
		while(choice!=3) {
			System.out.println("Enter choice:\n1.Add new customer\n2.Login\n3.Quit");
			choice=myObj.nextInt();
			CustomerService service=new CustomerServiceImpl();
			switch (choice) {
			case 1:
				System.out.println("Enter Username :");
				String uname=myObj.next();
				System.out.println("Enter Password :");
				String pwd=myObj.next();
				Customer newobj=new Customer(uname,pwd);
				service.addCustomer(newobj);
				break;
			case 2:
				System.out.println("Enter Username :");
				String un=myObj.next();
				System.out.println("Enter Password :");
				String pw=myObj.next();
//				System.out.println(service.matchCustomerPassword(un,pw));
				try {
				    if(service.matchCustomerPassword(un, pw)) {
				        System.out.println("Login Success");
				    } else {
				        System.out.println("Login Failed");
				    }
				} catch (CredentialMismatchException e) {
					e.printStackTrace();
				}
				break;
			case 3:
				break;

			default:
				break;
			}
		}
	}
}
