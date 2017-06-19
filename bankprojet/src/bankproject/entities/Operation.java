package bankproject.entities;

import bankproject.entities.Account;
import bankproject.entities.Customer;
import bankproject.readers.OperationThread;


public class Operation {
	private Integer id;
	private Integer action_amount;
	private String customer_prenom;
    private String customer_nom;
    private String country_code;
    private String account_no;

    public Operation(Integer a, String b, String c, Integer d, String e, String f) {
    	id = a;
    	customer_nom = b;
    	customer_prenom = c; 
     	action_amount = d; 
     	country_code = e; 
 		account_no = f; }

    
    // int action_ammount;
    
    void printAccount() {
        // System.out.println("operation on account: " + country_code + customer_reference_number);
        System.out.println("equals a change of: " + action_amount);
        // System.out.println("New balance: " + serial_num);
    }


    // just to test
    
	public Integer getActionAmount() {
		return action_amount;
	}

	public String getCountryCode() {
		return country_code;
	}	

	public String getAccountNo() {
		return account_no;
	}		

    // return the customer first name
	public String getFirstname() {
		return customer_prenom;
	}
	
    // return the customer last name
	public String getLastname() {
		return customer_nom;
	}	
	
}