package bankproject;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import bankproject.services.SrvCustomer;
import bankproject.services.db.SQLiteManager;
import java.sql.DriverManager;


public class Main {

	public static void main(String[] args) throws SQLException {
		SrvCustomer srvCustomer = SrvCustomer.getInstance();
		srvCustomer.setDbManager(SQLiteManager.getInstance());
		Connection connection = srvCustomer.getDbManager().getConnection();
		Statement st = connection.createStatement();
		st.execute(srvCustomer.createTableInDB());
	}

	public static void main1(String[] args) throws Exception {
		// Creation de la ville	
	}
	
}
