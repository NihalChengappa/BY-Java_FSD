package jdbcprimaryassessment.util;

import java.sql.*;

public class DBConnectionsUtil {
	private static final String URL = "jdbc:postgresql://localhost:5432/loginportal";

    public static Connection getDbConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, "postgres", "postgres");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
}
