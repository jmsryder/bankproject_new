package bankproject.services2;

import java.sql.ResultSet;

import bankproject.services2.SQLiteManager;

public class App {

	public static void main(String[] args) {
		
		SQLiteManager test = new SQLiteManager();
		ResultSet rs;
		
		try {
			  rs = test.displayAccounts();
			  	  
			  while (rs.next()) {
				     System.out.println(rs.getString("fname") + " abc " + rs.getString("lname")
				     + rs.getString("accountno") + rs.getString("accountsum"));
				   				     
				  }
			  
		  } catch (Exception e) {
			  e.printStackTrace();
		  }

	}	
	
}
