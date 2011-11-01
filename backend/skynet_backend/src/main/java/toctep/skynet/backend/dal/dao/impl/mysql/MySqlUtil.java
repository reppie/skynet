package toctep.skynet.backend.dal.dao.impl.mysql;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import toctep.skynet.backend.Main;
import toctep.skynet.backend.dal.dao.BoundingBoxDao;
import toctep.skynet.backend.dal.dao.BoundingBoxTypeDao;
import toctep.skynet.backend.dal.dao.CountryDao;
import toctep.skynet.backend.dal.dao.GeoDao;
import toctep.skynet.backend.dal.dao.GeoTypeDao;
import toctep.skynet.backend.dal.dao.HashtagDao;
import toctep.skynet.backend.dal.dao.KeywordDao;
import toctep.skynet.backend.dal.dao.LanguageDao;
import toctep.skynet.backend.dal.dao.PlaceDao;
import toctep.skynet.backend.dal.dao.PlaceTypeDao;
import toctep.skynet.backend.dal.dao.SourceTypeDao;
import toctep.skynet.backend.dal.dao.TimeZoneDao;
import toctep.skynet.backend.dal.dao.TweetContributorDao;
import toctep.skynet.backend.dal.dao.TweetDao;
import toctep.skynet.backend.dal.dao.TweetHashtagDao;
import toctep.skynet.backend.dal.dao.TweetKeywordDao;
import toctep.skynet.backend.dal.dao.TweetMentionDao;
import toctep.skynet.backend.dal.dao.TweetUrlDao;
import toctep.skynet.backend.dal.dao.UrlDao;
import toctep.skynet.backend.dal.dao.UserDao;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.Statement;

public class MySqlUtil {

	private static MySqlUtil instance;
	
	private String driver;
	private String host;
	private String name;
	private String user;
	private String pass;
	
	private Connection conn;
	
	private MySqlUtil() {
		try {
		    Wini ini = new Wini(new File(Main.DB_PROPERTIES));
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
	
	public int query(String query) {
		int result = 0;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			result = stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
	
	public int insert(String query) {
		int id = 0;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
			ResultSet rs = stmt.getGeneratedKeys();
			if(rs.next())
				id = rs.getInt(1);
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
	
	public ResultSet select(String query) {
		ResultSet rs = null;
		
		Statement stmt = null;
		
		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery(query);
			rs.first();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public int update(String query) {
		return this.query(query);
	}
	
	public int delete(String query) {
		return this.query(query);
	}
	
	public boolean exists(String tableName, String where) {
		boolean exists = false;
		
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT * FROM " + tableName + " WHERE " + where);
			
			int counter = 0;
			while (rs.next()) {
				counter++;
			}
			if (counter > 0) {
				exists = true;
			}
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

		return exists;
	}
	
	public int count(String tableName) {
		int count = 0;

		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = (Statement) conn.createStatement();
			rs = stmt.executeQuery("SELECT COUNT(*) as rows FROM " + tableName);
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
	
	public void truncateDatabase() {
		try {
			Statement stmt = (Statement) conn.createStatement();
			stmt.executeQuery("set foreign_key_checks=0");
			stmt.executeQuery("TRUNCATE TABLE " + TweetKeywordDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + UserDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + PlaceDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + CountryDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + GeoDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + GeoTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + HashtagDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + LanguageDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + PlaceTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + SourceTypeDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TimeZoneDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetContributorDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetHashtagDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetMentionDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + TweetUrlDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + UrlDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + KeywordDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + BoundingBoxDao.TABLE_NAME);
			stmt.executeQuery("TRUNCATE TABLE " + BoundingBoxTypeDao.TABLE_NAME);
			stmt.executeQuery("set foreign_key_checks=1");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static String escape(String str) {
		str = "\"" + (str != null ? str.replace("\"", "\\\"") : "") + "\"";
		return str;
	}
}
