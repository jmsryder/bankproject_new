package bankproject.entities;

// import bankproject.readers.AccountCustomerThread;
// import java.util.ArrayList;
// import java.util.Arrays;
// import java.util.List;



public class Customer extends AbstractEntity {
	private Integer id;
	private String customer_prenom;
    private String customer_nom;
    public Customer(Integer a, String b, String c) {
    	id = a;
    	customer_nom = b;
    	customer_prenom = c; }
    
    
    public void printCustomer() {
        System.out.println("Customer name: " + customer_nom);
        System.out.println("Customer first name: " + customer_prenom);
    }
    
    
    // obtain customer ID
	public Integer getId() {
		return id;
	}
	
    // set the customer ID
	public void setId(Integer id) {
		this.id = id;
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
	
	// return the full name of the customer
	public String getFullName() {
		return customer_prenom + " " + customer_nom;
	}    
    
}