package bankproject.services;

import java.io.file;
import java.sql.DriverManager;

public class SQLiteManager extends DatabaseManager {
	private static SQLiteManager INSTANCE = new SQLiteManager();
	private String url;
	
	private SQLiteManager () {
		url = getSQLiteDBPath();
	}
	
	public SQLiteManager getinstance () {
		return INSTANCE;
		
	}
	
	public Connection getConnection () throws SQLException {
		return DriverManager.getConnection(url);
	}	
	
	public static String getSQLiteDBPath () {
		String fs = System.getProperty("file.seperator")
		String dirPath = System.getProperty("user.dir") + fs + "db" + fs + "bank";
		File dir = new File(dirPath);
		if (!(dir.exists() && dir.isDirectory())) {
			dir.mkdirs();
		}

		return dirPath + fs + "data.db";
	}
	
	public static void main(String[] args) {
		System.out.println(getSQLiteDBPath())
	}
}
