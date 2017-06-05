package bankproject.readers;

import java.io.File;
import java.util.Scanner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import bankproject.entities.Account;
import bankproject.entities.Customer;
import bankproject.entities.Operation;


public class AccountCustomerThread {
  
	// location of input file on my local machine. This can be changed.
    final static String FILE_NAME = "/Users/James/Desktop/bankproject/input/accounts_customers.txt";
	
		public static void main(String[] args) {

		// define local variables	
		String customer_prenom;
		String customer_nom;
		String country_code;
		int serial_num;		        
		        
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
		                        country_code = "UK";
			                } else if (country_code.contains("Royaume-Uni")) {
			                    country_code = "UK";
			                } else if (country_code.contains("Angleterre")) {
			                    country_code = "UK";			                        
		                    } else if (country_code.contains("Allemagne")) {
		                    	country_code = "GR";
		                    } else if (country_code.contains("Pays-Bas")) {
		                    	country_code = "NL";
		                    } else {
		                    	country_code = "??";
		                    }		                	
		      				
		               
		                	customer_nom = input2.next();
		                	customer_prenom = input2.next();
		                	serial_num = input2.nextInt();	
		                	
		                	// add data to populate the customer list
		                    customerList.add(new Customer((lineNumber-1), customer_prenom, customer_nom));

		  		            String account_no = null;
				            Account fresh_account = null;
				            
				            // clumsy code for fresh account - I need to modify this
		                    fresh_account = new Account(country_code, "12345", customer_prenom, customer_nom);
					        account_no = fresh_account.getRandomAccountNo();
		                    
		                    // add data to populate the account list
		                    accountList.add(new Account(country_code, account_no, customer_prenom, customer_nom));             
				                    
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
		          
                  System.out.println("Total accounts created: " + (lineNumber-2));
		          
		          for (int i = 0; i < (lineNumber-2); i++) {
	                  System.out.print("New account no.: " + (i+1) + " ");
			          System.out.print(accountList.get(i).getLastname()+ "\t");
			          System.out.print(accountList.get(i).getFirstname()+ "\t");
			          System.out.print(accountList.get(i).getCountrycode());
			          System.out.println(accountList.get(i).getAccountno()+ " ");

			          }		 
		          
		          System.out.println("--------");

		          // delete the input file (removed for now)
		          // file.delete();
		          
		          		          
		     }    catch (Exception ex) {
		              ex.printStackTrace();
		     }
		    }
		}