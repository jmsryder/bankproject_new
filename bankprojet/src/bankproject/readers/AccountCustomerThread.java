package bankproject.readers;

import java.io.File;
import java.util.Scanner;
import java.util.Set;


import com.mysql.jdbc.Connection;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

import bankproject.entities.Account;
import bankproject.entities.Customer;

import java.sql.ResultSet;

import bankproject.services2.SQLiteManager;


// import java.sql.Connection;

public class AccountCustomerThread {
  
    private List<Customer> list;
    public List<Customer> getList() { return list; }
	
	// location of input file on my local machine. This can be changed.
    final static String FILE_NAME = "/Users/James/Desktop/bankproject/input/accounts_customers.txt";
	

	  public void operationReadAccount() {
 
		Connection con;
			
		
		// define local variables	
		String customer_prenom;
		String customer_nom;
		String country_code;
		int account_balance;		        
		        
	    try {
	    		 
	    	
		      Scanner input = new Scanner(FILE_NAME);
		      File file = new File(input.nextLine());
		      input = new Scanner(file);
		      int lineNumber = 1;
		      
		      List<Customer> customerList = new ArrayList<Customer>();
		      List<Account> accountList = new ArrayList<Account>();
		      
		      while (input.hasNextLine()) {
		          String line = input.nextLine();

		               if (lineNumber>1) {
		                	Scanner input2 = new Scanner (line);
		                	country_code = input2.next();
		                	
		                	
		                	// assign proper country code (just selected countries for now)
		                    if (country_code.contains("France")) {
		                        country_code = "FR";
		                    } else if (country_code.contains("Grande-Bretagne")) {
		                        country_code = "GB";
			                } else if (country_code.contains("Royaume-Uni")) {
			                    country_code = "GB";
			                } else if (country_code.contains("Angleterre")) {
			                    country_code = "GB";			                        
		                    } else if (country_code.contains("Allemagne")) {
		                    	country_code = "GR";
		                    } else if (country_code.contains("Pays-Bas")) {
		                    	country_code = "NL";
		                    } else {
		                    	country_code = "??";
		                    }		                	
		      						               
		                	customer_nom = input2.next();
		                	customer_prenom = input2.next();
		                	account_balance = input2.nextInt();	
		                	
		                	// add data to populate the customer list
		                    // customerList.add(new Customer((lineNumber-1), customer_prenom, customer_nom));
		                    customerList.add(new Customer(1, customer_prenom, customer_nom));


		                	String account_no = null;
				            Account fresh_account = null;
				            
				            // clumsy code for fresh account - I need to modify this
		                    fresh_account = new Account(country_code, "12345", customer_prenom, customer_nom, account_balance);
					        account_no = fresh_account.getRandomAccountNo();
		                    
					        // concatenate country code and account number
					        account_no = country_code + account_no;
					        
					        
		                    // add data to populate the account list
		                    accountList.add(new Account(country_code, account_no, customer_prenom, customer_nom, account_balance));             
				                    
		                	}
		               
	                    lineNumber++;

		            	}


		           for(Customer customer : customerList) {
		           }				          
		           
		          input.close();
		       
		          // end of input phase
    		          
		          String account_no = null;
		          Account fresh_account = null;
		              
		          // Confirm account info in command line (for bug checking)
		          
                  System.out.println("Total number of accounts created: " + (lineNumber-2));
		          


		          // remove duplicates from customer lists (this doesn't work, why not?);
		      
		         // List<String> al = new ArrayList<>();
		         // add elements to al, including duplicates
		         Set<Customer> customerList2 = new LinkedHashSet<Customer>(customerList);     
		         customerList2.addAll(customerList);
		         customerList.clear();
		         customerList.addAll(customerList2);      
		         
		         

		         
		          // Confirm account info in command line (for bug checking)
		          

    		          
		          
		          // delete the new account input file
		          file.delete();
		          	          
		          
		          // write all of the details of the new accounts to the SQL file
		          
					SQLiteManager test = new SQLiteManager();
					ResultSet rs;
	
					// check for pre-existing names in SQLite database
					
			         
					
//	                 System.out.println("Total customers list: " + (lineNumber-2));
			          
	                 int customer_list_size = customerList.size();
	                 int account_list_size = accountList.size();			
					
					
	              //   int list_size = customerList.size();
	                 
			          for (int i = 0; i < (account_list_size); i++) {
		                  System.out.print("adding account for customer no.: " + (i+1) + " ");
		                  System.out.print(accountList.get(i).getLastname()+ "\t");
				          System.out.println(accountList.get(i).getFirstname()+ "\t");
			  	  		  test.addAccount(accountList.get(i).getFirstname(), 
			  	  				accountList.get(i).getLastname(), 
			  	  				accountList.get(i).getAccountno(), 
			  	  			    accountList.get(i).getAccountbalance());
				          }			          
			          
			          for (int i = 0; i < (customer_list_size); i++) {
		                  System.out.print("creating new customer no.: " + (i+1) + " ");
		                  System.out.print(customerList.get(i).getLastname()+ "\t");
				          System.out.println(customerList.get(i).getFirstname()+ "\t");
			  	  		  test.addCustomer(customerList.get(i).getFirstname(), 
			  	  				customerList.get(i).getLastname());
				          }
						 			          

			          System.out.println("New customers all processed");				         
    
		          		          
		     }    catch (Exception ex) {
		              ex.printStackTrace();

	    	    
		    }


	  }
	  }
