package bankproject.services2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class SQLiteManager {

	public static Connection con;
	public static boolean hasData = false;	
	
	 public void getConnection() throws ClassNotFoundException, SQLException {
	
		 
		 // sqlite driver
		  Class.forName("org.sqlite.JDBC");
		  // database path, if it's new database, it will be created in the project folder
		  con = DriverManager.getConnection("jdbc:sqlite:JBankProj.db");
		  initialiseAccountDB();
		  
	     if(con == null){
	    	    Class.forName("org.sqlite.JDBC");
	    	    con = DriverManager.getConnection("jdbc:sqlite:JBankProj.db");
	    	    }
	     }

	 

	 
	public void addAccount(String firstname, String lastname, String account_no, int account_sum) throws ClassNotFoundException, SQLException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		  PreparedStatement prep = con
				  .prepareStatement("insert into account values(?,?,?,?,?);");
				  prep.setString(2, firstname);
				  prep.setString(3, lastname);
				  prep.setString(4, account_no);
				  prep.setInt(5, account_sum);
				  
				  prep.execute();
		 
	 }

	
	public void addCustomer(String firstname, String lastname) throws ClassNotFoundException, SQLException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		  PreparedStatement prep = con
				  .prepareStatement("insert into customers values(?,?,?);");
				  prep.setString(2, firstname);
				  prep.setString(3, lastname);
				  
				  prep.execute();
		 
	 }	
	


	
	  public void modAccountBal(String account_no, int account_change) throws ClassNotFoundException, SQLException
	  {
			 if(con == null) {
				 // get connection
				 getConnection();
			 }

		Integer old_balance;
		Integer new_balance;
		String answer;

		// SQLiteManager test = new SQLiteManager();
		// ResultSet rs = new ResultSet();
		
	    String query = ("select accountsum from account where accountno = '"+account_no+"'");

	    System.out.println(account_no);
	      Statement st = con.createStatement();

	      ResultSet rs = st.executeQuery(query);
	      System.out.println(rs);
	        answer = rs.getString("accountsum");
		    old_balance = rs.getInt("accountsum");
		    new_balance = old_balance + account_change;
		    
	        System.out.println("old_balance: " + old_balance);
	        System.out.println("new_balance: " + new_balance);

	    String query1 = ("update account set accountsum = '"
	        +new_balance+"' where accountno = '"+account_no+"'");

	    PreparedStatement preparedStmt = con.prepareStatement(query1);

	    // execute the java preparedstatement
	    preparedStmt.executeUpdate();
	    
	  }	
	
	
	
	
	 public ResultSet displayAccounts() throws SQLException, ClassNotFoundException {
		 if(con == null) {
			 // get connection
			 getConnection();
		 }
		 Statement state = con.createStatement();
		 ResultSet res = state.executeQuery("select fname, lname, accountno, accountsum, id from account");
		 return res;
	 }
	 
	 
	 
	 
	 private void initialiseAccountDB() throws SQLException, ClassNotFoundException {
		 if( !hasData ) {
			 hasData = true;
			 // check for database table
			 Statement state = con.createStatement();
			 ResultSet res = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='account'");


			 if( !res.next()) {
				 // need to build the table
				  Statement state2 = con.createStatement();
				  state2.executeUpdate("create table account(id integer,"
				    + "fName varchar(60)," + "lname varchar(60)," + "accountno varchar(60),"
				    + "accountsum varchar(60)," + "primary key (id));");
			 }
			 
			 
			 ResultSet res2 = state.executeQuery("SELECT name FROM sqlite_master WHERE type='table' AND name='customers'");

			 if( !res2.next()) {
				  Statement state3 = con.createStatement();
				  state3.executeUpdate("create table customers(id integer,"
					+ "fName varchar(60)," + "lname varchar(60)," + "primary key (id));");				  
			 }
				  
         }                                    				 
	 }			 
 }
	  