package jdbcprimaryassessment.dao;

import java.sql.*;

import jdbcprimaryassessment.exceptions.CredentialMismatchException;
import jdbcprimaryassessment.model.Customer;
import jdbcprimaryassessment.util.DBConnectionsUtil;
import jdbcprimaryassessment.util.QueryMapper;
public class CustomerDAOImpl implements CustomerDAO{

	@Override
	public boolean matchCustomerPassword(String username ,String password) throws CredentialMismatchException {
		Connection conn=DBConnectionsUtil.getDbConnection();
		boolean match=false;
		try {
			PreparedStatement pStmt=conn.prepareStatement(QueryMapper.FIND_MATCH);
			pStmt.setString(1,username);
			pStmt.setString(2,password);
			ResultSet rs=pStmt.executeQuery();
//			System.out.println(rs);
			match=rs.next();	
			if (!match) {
	            // Throw CredentialMismatchException if no match found
	            throw new CredentialMismatchException("Login Failed. Credentials provided do not match any records !");
	        }
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return match;
	}

	@Override
	public Customer addCustomer(Customer customer) {
		Connection conn = DBConnectionsUtil.getDbConnection();
        try {
            PreparedStatement pStmt=conn.prepareStatement(QueryMapper.ADD_CUSTOMER);
            pStmt.setString(1,customer.getUsername());
            pStmt.setString(2,customer.getPassword());
            int rows=pStmt.executeUpdate();
            if (rows > 0){
                System.out.println("Successfull Insert!");
                return customer;
            }
        }
        catch (SQLException e){
            throw new RuntimeException(e);
        }
        return null;
	}

}
