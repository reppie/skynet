package toctep.skynet.backend.dal.dao.impl.mysql;

import java.io.File;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.ini4j.InvalidFileFormatException;
import org.ini4j.Wini;

import toctep.skynet.backend.Constants;
import toctep.skynet.backend.Log;
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

public final class MySqlUtil {

	private static MySqlUtil instance;
		
	public static MySqlUtil getInstance(String properties) {
		if (instance == null) {
			instance = new MySqlUtil(properties);
		}
		return instance;
	}
	
	public static MySqlUtil getInstance() {
		return MySqlUtil.getInstance(Constants.DB_CONFIG);
	}
	
	private String properties;
	
	private Wini ini;
	
	private String driver;
	private String host;
	private String name;
	private String user;
	private String pass;
	
	private Connection conn;
	
	private MySqlUtil(String properties) {
		this.properties = properties;
		
		initialize();
		connect();
	}
	
	private void initialize() {
		try {
			ini = new Wini(new File(properties));
			
			driver = getIniValue("driver");
	        host = getIniValue("host");
	        name = getIniValue("name");
	        user = getIniValue("user");
	        pass = getIniValue("pass");
		} catch (InvalidFileFormatException e) {
			Log.error(e.getMessage(), e);
		} catch (IOException e) {
			Log.error(e.getMessage(), e);
		}
	}
	
	private String getIniValue(String optionName) {
		return ini.get("jdbc", optionName, String.class);
	}
	
	private void connect() {
		try {
			String url = "jdbc:" + driver + "://" + host + "/" + name;
			conn = (Connection) DriverManager.getConnection(url, user, pass);
		} catch (SQLException e) {
			Log.error(e.getMessage(), e);
		}
	}
	
	public Connection getConnection() {
		return conn;
	}
	
	public int query(String query, Param[] params) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i].getValue(), params[i].getType());
			}
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			Log.error(e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
			}
		}
		
		return result;
	}
		
	public Map<String, Object> selectRow(String query, Param[] params) {
		List<Map<String, Object>> rows = this.select(query, params);
		if (rows.size() > 0) {
			return rows.get(0);
		} else {
			return new LinkedHashMap<String, Object>();
		}
	}
	
	public List<Map<String, Object>> select(String query, Param[] params) {
		List<Map<String, Object>> rows = new ArrayList<Map<String, Object>>();
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i].getValue(), params[i].getType());
			}
			
			rs = pstmt.executeQuery();
			
			ResultSetMetaData rsmd = rs.getMetaData();
		    int numColumns = rsmd.getColumnCount();
			
			while (rs.next()) {
				Map<String, Object> row = new LinkedHashMap<String, Object>();
				for (int i = 0; i < numColumns; ++i) {
					String column = rsmd.getColumnName(i+1);
					Object value = rs.getObject(i+1);
					row.put(column, value);
				}
				rows.add(row);
			}
		} catch (SQLException e) {
			Log.error(e.getMessage(), e);
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
			}
		}
		
		return rows;
	}
	
	public int insert(String query, Param[] params) {
		int id = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
			
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i].getValue(), params[i].getType());
			}
			
			pstmt.executeUpdate();		
			
			rs = pstmt.getGeneratedKeys();
			if (rs.first()) {
				id = rs.getInt(1);
			}
		} catch (SQLException e) {
			Log.error(e.getMessage(), e);
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
			}
		}
		return id;
	}
	
	public int update(String query, Param[] params) {
		return this.query(query, params);
	}
	
	public int delete(String query, Param[] params) {
		return this.query(query, params);
	}
	
	public boolean exists(String tableName, String column, Param param) {
		Map<String, Param> map = new HashMap<String, Param>();
		map.put(column, param);
		return this.exists(tableName, map);
	}
	
	public boolean exists(String tableName, Map<String, Param> params) {
		boolean exists = false;
		
		String query = "SELECT * FROM " + tableName + " WHERE ";
		for (int i = 0; i < params.size(); i++) {
			query += params.keySet().toArray()[i] + "=?";
			if (i < params.size() - 1) {
				query += " AND ";
			}
		}
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(query);
			for (int i = 0; i < params.size(); i++) {
				String key = params.keySet().toArray()[i].toString();
				pstmt.setObject(i+1, params.get(key).getValue(), params.get(key).getType());
			}
			rs = pstmt.executeQuery();
			
			int counter = 0;
			while (rs.next()) {
				counter++;
			}
			if (counter > 0) {
				exists = true;
			}
		} catch (SQLException e) {
			Log.error(e.getMessage(), e);
		} finally {
			try {
				rs.close();
				pstmt.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
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
			Log.error(e.getMessage(), e);
		} finally {
			try {
				stmt.close();
				rs.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
			}
		}
		
		return count;
	}
	
	public void truncateDatabase() {
		PreparedStatement pstmt = null;
		try {
			conn.setAutoCommit(false);
			
			pstmt = conn.prepareStatement("set foreign_key_checks=0");
			pstmt.execute();
			
			this.truncateTable(BoundingBoxDao.TABLE_NAME);
			this.truncateTable(BoundingBoxTypeDao.TABLE_NAME);
			this.truncateTable(CountryDao.TABLE_NAME);
			this.truncateTable(GeoDao.TABLE_NAME);
			this.truncateTable(GeoTypeDao.TABLE_NAME);
			this.truncateTable(HashtagDao.TABLE_NAME);
			this.truncateTable(KeywordDao.TABLE_NAME);
			this.truncateTable(LanguageDao.TABLE_NAME);
			this.truncateTable(PlaceDao.TABLE_NAME);
			this.truncateTable(PlaceTypeDao.TABLE_NAME);
			this.truncateTable(SourceTypeDao.TABLE_NAME);
			this.truncateTable(TimeZoneDao.TABLE_NAME);
			this.truncateTable(TweetContributorDao.TABLE_NAME);
			this.truncateTable(TweetDao.TABLE_NAME);
			this.truncateTable(TweetHashtagDao.TABLE_NAME);
			this.truncateTable(TweetKeywordDao.TABLE_NAME);
			this.truncateTable(TweetMentionDao.TABLE_NAME);
			this.truncateTable(TweetUrlDao.TABLE_NAME);
			this.truncateTable(UrlDao.TABLE_NAME);
			this.truncateTable(UserDao.TABLE_NAME);
			
			pstmt = conn.prepareStatement("set foreign_key_checks=1");
			pstmt.execute();
			
			conn.commit();
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				Log.error(e1.getMessage(), e1);
			}
			Log.error(e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
				conn.setAutoCommit(true);
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
			}
		}
	}
	
	public void truncateTable(String tableName) {
		PreparedStatement pstmt = null;
		try {
			pstmt = conn.prepareStatement("TRUNCATE TABLE " + tableName);
			pstmt.execute();
		} catch (SQLException e) {
			Log.error(e.getMessage(), e);
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				Log.error(e.getMessage(), e);
			}
		}
	}

}
