package bankproject;


import java.sql.SQLException;


import bankproject.readers.AccountCustomerThread;
import bankproject.readers.OperationThread;
import bankproject.writers.BankStatementThread;

// This is the top level of the code, from which the other routines
// are launched.

public class Main {

	public static void main(String[] args) throws SQLException {

		// read new account details from a text file (every 7 minutes)
		AccountCustomerThread test3 = new AccountCustomerThread();		
			test3.operationReadAccount();			
		
		
		// process operations on accounts in database (every 11 minutes)
		OperationThread test2 = new OperationThread();		
			test2.operationReadOperation();

			
	
		// produce a readout of bank statements by country and by credit/debit status (every 13 minutes)
		BankStatementThread test1 = new BankStatementThread();		
			test1.countrySort();
			test1.creditDebt();
	
		
	}
	
}
