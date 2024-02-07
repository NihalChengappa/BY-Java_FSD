package jdbcprimaryassessment.util;

public interface QueryMapper {
	public static final String ADD_CUSTOMER="insert into customer values(?,?)";
	public static final String FIND_MATCH="SELECT * FROM Customer WHERE username = ? AND password = ?;";
}
