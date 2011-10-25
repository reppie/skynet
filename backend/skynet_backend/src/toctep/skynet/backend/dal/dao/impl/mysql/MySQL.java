package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

import com.mysql.jdbc.Connection;

public class MySQL {

	private static MySQL instance;
	
	private Connection conn;
	
	private MySQL() {	
		try {
		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/skynet?" + "user=skynet&password=asdasd");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	
	public static MySQL getInstance() {
		if (instance == null) {
			instance = new MySQL();
		}
		return instance;
	}
	
	public Connection getConnection() {
		return conn;
	}
	
}
