package toctep.skynet.backend.dal.dao.impl.mysql;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySqlUtil {

	private static MySqlUtil instance;
	
	public static final String JDBC_CONFIG = "conf/mysql.ini";
	
	private String driver;
	private String host;
	private String name;
	private String user;
	private String pass;
	
	private Connection conn;
	
	private MySqlUtil() {
		try {
		    Wini ini = new Wini(new File("conf/jdbc.ini"));
	        driver = ini.get("jdbc", "driver", String.class);
	        host = ini.get("jdbc", "host", String.class);
	        name = ini.get("jdbc", "name", String.class);
	        user = ini.get("jdbc", "user", String.class);
	        pass = ini.get("jdbc", "pass", String.class);
		    
	        connect();
		} catch (SQLException e) {
		    e.printStackTrace();
		} catch (InvalidFileFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private MySqlUtil(String driver, String host, String name, String user, String pass) {
		try {	        
			this.driver = driver;
			this.host = host;
			this.name = name;
			this.user = user;
			this.pass = pass;
			
			connect();
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	
	private void connect() throws SQLException {
		String url = "jdbc:" + driver + "://" + host + "/" + name;
		
		conn = (Connection) DriverManager.getConnection(url, user, pass);
	}
	
	public static MySqlUtil getInstance(String driver, String host, String name, String user, String pass) {
		if (instance == null) {
			instance = new MySqlUtil(driver, host, name, user, pass);
		}
		return instance;
	}
	
	public static MySqlUtil getInstance() {
		if (instance == null) {
			instance = new MySqlUtil();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public void query(String query) {
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public int insert(String query) {
		int id = 0;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			id = stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return id;
	}
	
	public boolean exists(String tableName, String where) {
		// TODO
		return false;
	}
	
	public int count(String tableName) {
		int count = 0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) FROM " + tableName);
			rs.next();
			count = rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return count;
	}
}
