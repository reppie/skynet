package toctep.skynet.backend.dal.dao.impl.mysql;

import java.sql.DriverManager;
import java.sql.SQLException;

import toctep.skynet.backend.dal.dao.DaoConnection;

import com.mysql.jdbc.Connection;

public class DaoConnectionImpl implements DaoConnection {

	private static DaoConnectionImpl instance;
	
	private Connection conn;
	
	private DaoConnectionImpl() {	
		try {
		    conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/skynet?" + "user=skynet&password=asdasd");
		} catch (SQLException e) {
		    e.printStackTrace();
		}
	}
	
	public static DaoConnectionImpl getInstance() {
		if (instance == null) {
			instance = new DaoConnectionImpl();
		}
		return instance;
	}
	
	@Override
	public Connection getConnection() {
		return conn;
	}
	
}
