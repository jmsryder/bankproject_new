package bankproject.writers;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimerTask;

import bankproject.entities.Account;
import bankproject.services2.SQLiteManager;



public class BankStatementThread extends TimerTask {

	// public static void main(String[] args) {

		public void countrySort() {

    	
    	// location of output files on my local machine
    	final String FILE_NAME1 = "/Users/James/Desktop/bankproject/output/out_par_country_";

    	
        BufferedWriter writer = null;
        try {

            String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
    		String country_code;
    		String account_no;
    		String customer_prenom;
    		String customer_nom;
    		Integer account_balance;
    		
		    List<Account> frenchAccountList = new ArrayList<Account>();
		    List<Account> britishAccountList = new ArrayList<Account>();
		    List<Account> germanAccountList = new ArrayList<Account>();
		    List<Account> dutchAccountList = new ArrayList<Account>();
		    List<Account> otherAccountList = new ArrayList<Account>();

		   		    
        	// output_par_country
        	
	        // write all of the details of the new accounts to the SQL file
	          
		    SQLiteManager test = new SQLiteManager();
			ResultSet rs;
                        
//			try {
            System.out.print("J display users");

				  rs = test.displayAccounts();
		            
					while (rs.next()) {

	                    country_code = rs.getString("accountno").substring(0, Math.min(rs.getString("accountno").length(), 2));
	                    account_no = rs.getString("accountno");
	                    customer_prenom = rs.getString("fname");
	                    customer_nom = rs.getString("lname");
	                    account_balance = rs.getInt("accountsum");
				  
              	// assign proper country code (just selected countries for now)
                  if (country_code.contains("FR")) {
	                    frenchAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             

                  } else if (country_code.contains("GB")) {
	                    britishAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             
		                        
                  } else if (country_code.contains("GR")) {
	                    germanAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             
	
                  } else if (country_code.contains("NL")) {
	                    dutchAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             

                  } else {
	                    otherAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             

                  }		
					}

					
		            File logFile1 = new File(FILE_NAME1 + timeLog + "_FR.txt");
		            
	                int french_list_size = frenchAccountList.size();
		            
		            writer = new BufferedWriter(new FileWriter(logFile1));
		            writer.write("Output per country");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("------------------");
		            writer.write(System.getProperty("line.separator"));
		            writer.write(" ");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		            writer.write(System.getProperty("line.separator"));
		            
			        for (int i = 0; i < (french_list_size); i++) {
			          writer.write(frenchAccountList.get(i).getLastname()+ "\t");
			          writer.write(frenchAccountList.get(i).getFirstname()+ "\t");
			          writer.write(frenchAccountList.get(i).getAccountno()+ "\t");
			          writer.write(frenchAccountList.get(i).getAccountbalance()+ " ");
			          writer.write(System.getProperty("line.separator"));
			          }		 
		          
		            writer.close();

			        
		            File logFile2 = new File(FILE_NAME1 + timeLog + "_GR.txt");
		            
	                int german_list_size = germanAccountList.size();
		            
		            writer = new BufferedWriter(new FileWriter(logFile2));
		            writer.write("Output per country");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("------------------");
		            writer.write(System.getProperty("line.separator"));
		            writer.write(" ");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		            writer.write(System.getProperty("line.separator"));
		            
			        for (int i = 0; i < (german_list_size); i++) {
			          writer.write(germanAccountList.get(i).getLastname()+ "\t");
			          writer.write(germanAccountList.get(i).getFirstname()+ "\t");
			          writer.write(germanAccountList.get(i).getAccountno()+ "\t");
			          writer.write(germanAccountList.get(i).getAccountbalance()+ " ");
			          writer.write(System.getProperty("line.separator"));
			          }				        
			        
		            writer.close();

			        
			        
		            File logFile3 = new File(FILE_NAME1 + timeLog + "_BR.txt");
		            
	                int british_list_size = britishAccountList.size();
		            
		            writer = new BufferedWriter(new FileWriter(logFile3));
		            writer.write("Output per country");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("------------------");
		            writer.write(System.getProperty("line.separator"));
		            writer.write(" ");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		            writer.write(System.getProperty("line.separator"));
		            
			        for (int i = 0; i < (british_list_size); i++) {
			          writer.write(britishAccountList.get(i).getLastname()+ "\t");
			          writer.write(britishAccountList.get(i).getFirstname()+ "\t");
			          writer.write(britishAccountList.get(i).getAccountno()+ "\t");
			          writer.write(britishAccountList.get(i).getAccountbalance()+ " ");
			          writer.write(System.getProperty("line.separator"));
			          }				    			        

		            writer.close();
			        
			        
			        
		            File logFile4 = new File(FILE_NAME1 + timeLog + "_NL.txt");
		            
	                int dutch_list_size = dutchAccountList.size();
		            
		            writer = new BufferedWriter(new FileWriter(logFile4));
		            writer.write("Output per country");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("------------------");
		            writer.write(System.getProperty("line.separator"));
		            writer.write(" ");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		            writer.write(System.getProperty("line.separator"));
		            
			        for (int i = 0; i < (dutch_list_size); i++) {
			          writer.write(dutchAccountList.get(i).getLastname()+ "\t");
			          writer.write(dutchAccountList.get(i).getFirstname()+ "\t");
			          writer.write(dutchAccountList.get(i).getAccountno()+ "\t");
			          writer.write(dutchAccountList.get(i).getAccountbalance()+ " ");
			          writer.write(System.getProperty("line.separator"));
			          }			
			        
		            writer.close();

			        
			        
			        
		            File logFile5 = new File(FILE_NAME1 + timeLog + "_??.txt");
		            
	                int other_list_size = otherAccountList.size();
		            
		            writer = new BufferedWriter(new FileWriter(logFile5));
		            writer.write("Output per country");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("------------------");
		            writer.write(System.getProperty("line.separator"));
		            writer.write(" ");
		            writer.write(System.getProperty("line.separator"));
		            writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		            writer.write(System.getProperty("line.separator"));
		            
			        for (int i = 0; i < (other_list_size); i++) {
			          writer.write(otherAccountList.get(i).getLastname()+ "\t");
			          writer.write(otherAccountList.get(i).getFirstname()+ "\t");
			          writer.write(otherAccountList.get(i).getAccountno()+ "\t");
			          writer.write(otherAccountList.get(i).getAccountbalance()+ " ");
			          writer.write(System.getProperty("line.separator"));
			          }				        

		            writer.close();
			        
		 } catch (Exception e) {
	            e.printStackTrace();
	        } finally {
	            try {
	                // Close the writer regardless of what happens...
	                writer.close();
	            } catch (Exception e) {
	            }
	        }
	    }			        

	
	
	
	
	
	
	public void creditDebt() {

    	final String FILE_NAME2 = "/Users/James/Desktop/bankproject/output/out_creditors_";
    	final String FILE_NAME3 = "/Users/James/Desktop/bankproject/output/out_debtors_";	
		
		List<Account> creditAccountList = new ArrayList<Account>();
		List<Account> debitAccountList = new ArrayList<Account>();

		SQLiteManager test = new SQLiteManager();
		ResultSet rs;

		String timeLog = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
		String country_code;
		String account_no;
		String customer_prenom;
		String customer_nom;
		Integer account_balance;
		    			
		BufferedWriter writer = null;

		        		
		// output_par_country
		            	
		// write all of the details of the new accounts to the SQL file
		    	          
		//    SQLiteManager test = new SQLiteManager();
		//	ResultSet rs;
		                            
		try {

		    rs = test.displayAccounts();
		    		            
		    while (rs.next()) {

		    	country_code = rs.getString("accountno").substring(0, Math.min(rs.getString("accountno").length(), 2));
		    	account_no = rs.getString("accountno");
		    	customer_prenom = rs.getString("fname");
		    	customer_nom = rs.getString("lname");
		    	account_balance = rs.getInt("accountsum");
		    				  
		    // assign proper country code (just selected countries for now)
		    if (account_balance < 0) {
		    	    debitAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             

		            } else if (account_balance > -1) {
		    	          creditAccountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             
		    		                        
		            }		
		    		}

		    					
		    		File logFile6 = new File(FILE_NAME2 + timeLog + ".txt");
		    		            
		    	    int credit_list_size = creditAccountList.size();
		    		            
		    		writer = new BufferedWriter(new FileWriter(logFile6));
		    		writer.write("Accounts in credit");
		    	    writer.write(System.getProperty("line.separator"));
		    		writer.write("------------------");
		    		writer.write(System.getProperty("line.separator"));
		    		writer.write(" ");
		    		writer.write(System.getProperty("line.separator"));
		    		writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		    		writer.write(System.getProperty("line.separator"));
		    		            
		    		for (int i = 0; i < (credit_list_size); i++) {
		    			 writer.write(creditAccountList.get(i).getLastname()+ "\t");
		    			 writer.write(creditAccountList.get(i).getFirstname()+ "\t");
		    			 writer.write(creditAccountList.get(i).getAccountno()+ "\t");
		    			 writer.write(creditAccountList.get(i).getAccountbalance()+ " ");
		    			 writer.write(System.getProperty("line.separator"));
		    			 }		 
		    		          
		    		writer.close();

		    			        
		    		File logFile7 = new File(FILE_NAME3 + timeLog + ".txt");
		    		            
		    	    int debit_list_size = debitAccountList.size();
		    		            
		    		writer = new BufferedWriter(new FileWriter(logFile7));
		    		writer.write("Accounts in debit");
		    		writer.write(System.getProperty("line.separator"));
		    		writer.write("------------------");
		    		writer.write(System.getProperty("line.separator"));
		    		writer.write(" ");
		    		writer.write(System.getProperty("line.separator"));
		    		writer.write("Lastname \t Firstname \t Accountno \t Accountbalance ");
		    		writer.write(System.getProperty("line.separator"));
		    		            
		    		for (int i = 0; i < (debit_list_size); i++) {
		    			 writer.write(debitAccountList.get(i).getLastname()+ "\t");
		    			 writer.write(debitAccountList.get(i).getFirstname()+ "\t");
		    			 writer.write(debitAccountList.get(i).getAccountno()+ "\t");
		    			 writer.write(debitAccountList.get(i).getAccountbalance()+ " ");
		    			 writer.write(System.getProperty("line.separator"));
		    			 }				        
		    			        
		    	    writer.close();

					} catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // Close the writer regardless of what happens...
                writer.close();
            } catch (Exception e) {
            }
        }
    }


	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
}
