package bankproject.readers;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

import bankproject.entities.Operation;
import bankproject.services2.SQLiteManager;
import java.sql.ResultSet;


public class OperationThread {
  
	    // set input location for operations
        final static String FILE_NAME = "/Users/James/Desktop/bankproject/input/operation.txt";

        public static void main(String[] args) {

		String customer_prenom;
		String customer_nom;
		String country_code;
		String customer_reference;
		// String numerical_customer_reference;		
		String account_no;

		// int serial_num;		        
		int action_amount;		        
		
		   try {

		      Scanner input = new Scanner(FILE_NAME);

		      File file = new File(input.nextLine());

		      input = new Scanner(file);
		      int lineNumber = 1;

		      List<Operation> operationList = new ArrayList<Operation>();

		      
		      while (input.hasNextLine()) {
		         String line = input.nextLine();
		          
		            if (lineNumber>1) {		            	   
		                 Scanner input2 = new Scanner (line);
		                 action_amount = input2.nextInt();
		                 customer_reference = input2.next();

		                 country_code = customer_reference.substring(0, Math.min(customer_reference.length(), 2));
		                 account_no = customer_reference.substring(customer_reference.length() - 6);
		                	
		                 customer_nom = input2.next();
		                 customer_prenom = input2.next();		                	
		                	
					     // concatenate country code and account number
					     account_no = country_code + account_no;
		                 
		                 
		                 operationList.add(new Operation((lineNumber-1), customer_prenom, customer_nom, action_amount, country_code, account_no));		                    		                    

				         input2.close();

		                 }

		             lineNumber++;
		             }
		          
		          input.close();

		          // Confirm account info in command line (for bug checking)
		          
		          // write all of the details of the new accounts to the SQL file
		          
					SQLiteManager test1 = new SQLiteManager();
					ResultSet rs;		          
		          
                  // System.out.println("Total commands processed: " + (lineNumber-2));
		          
		          for (int i = 0; i < (lineNumber-2); i++) {
//	                  System.out.print("New command no.: " + (i+1) + " ");
//			          System.out.print(operationList.get(i).getLastname()+ "\t");
//			          System.out.print(operationList.get(i).getFirstname()+ "\t");
//
//	                  System.out.print(operationList.get(i).getActionAmount()+ "\t");
//			          System.out.println(operationList.get(i).getAccountNo()+ " ");
			          
			          test1.modAccountBal(operationList.get(i).getAccountNo(), 
			        		  operationList.get(i).getActionAmount());

			          
			          }		 
		          
		          System.out.println("--------");
		          
		          // delete the input file
		          // file.delete();
		          
		          
		     } catch (Exception ex) {
		            ex.printStackTrace();
		     }
		   }

		}