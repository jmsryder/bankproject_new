package bankproject.entities;

// import bankproject.readers.AccountCustomerThread;

public class Account extends AbstractEntity {
        String country_code;
        String account_no;
        String customer_prenom;
        String customer_nom;
        int account_balance;
        public Account(String a, String b, String c, String d, int e) {
            country_code = a;
            account_no = b;
    		customer_prenom = c;
    		customer_nom = d;
     		account_balance = e;}

        
        public void printAccount() {
            System.out.println("New account country code: " + country_code);
            System.out.println("New account serial number: " + account_no);
            System.out.println("New account first name: " + customer_prenom);
            System.out.println("New account second name: " + customer_nom);
            System.out.println("New account balance: " + account_balance);
        }
 
        // just to test
        
    	public String getRandomAccountNo() {
    		int account_no_int = (int) (Math.random() * 1000000);
    		account_no = String.format("%06d", account_no_int);
    		return account_no;
    	}

        // return the customer first name
    	public String getFirstname() {
    		return customer_prenom;
    	}
    	
        // set the customer first name
    	public void setFirstname(String customer_prenom) {
    		this.customer_prenom = customer_prenom;
    	}
    	
        // return the customer last name
    	public String getLastname() {
    		return customer_nom;
    	}

        // set the customer last name
    	public void setLastname(String customer_nom) {
    		this.customer_nom = customer_nom;
    	}
  
        // return the account number
    	public String getAccountno() {
    		return account_no;
    	}    	
    	
        // return the account number
    	public String getCountrycode() {
    		return country_code;
    	}        	
    	
        // return the account balance
    	public int getAccountbalance() {
    		return account_balance;
    	}    	
}