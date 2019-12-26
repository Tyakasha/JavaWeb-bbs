package akm;

import java.sql.*;

public class Mydbc {
	private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String DB_URL = "jdbc:mysql://localhost:3306/";

	private static final String default_database = "bbs";
	private static final String default_username = "jsp";
	private static final String default_password = "123456";

	private String db_name;
	private String db_username;
	private String db_password;

	public Mydbc() { this(default_username, default_password); }
	public Mydbc(String username, String password) {
		this(username, password, default_database);
	}
	public Mydbc(String username, String password, String database) {
		db_username = username;
		db_password = password;
		db_name = database;
	}

	public void setDatabase(String database) { db_name = database; }
	public String getDatabase() { return db_name; }

	public interface MydbcExecute{
		public String execute(Connection conn) throws Exception;
	}

	public String query(MydbcExecute mydbcExecute) {
		String s = "";
		Connection conn = null;
		try {
			Class.forName(JDBC_DRIVER);
			//conn = DriverManager.getConnection(DB_URL+db_name+"?useSSL=false&serverTimezone=UTC", db_username, db_password);
			conn = DriverManager.getConnection(DB_URL+db_name+"?serverTimezone=UTC&characterEncoding=utf8", db_username, db_password);
			s = mydbcExecute.execute(conn);
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return s;
	}

}

