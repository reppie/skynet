package toctep.skynet.backend.dal.dao.impl.mysql;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import com.mysql.jdbc.Connection;

public class MySqlUtil {

	private static MySqlUtil instance;
	
	public static final String JDBC_CONFIG = "conf/mysql.ini";
	
	private String driver;
	private String host;
	private String name;
	private String user;
	private String pass;
	
	private Connection connection;
	
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
		
		connection = (Connection) DriverManager.getConnection(url, user, pass);
		
		System.out.println("Connection established");
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
		return connection;
	}
	
}
