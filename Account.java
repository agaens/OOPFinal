

public class Account {
	

	String type;
	double balance;
	double rate;

	
	void setType(String accType) {
		type = accType;
	}

	void setBalance(double accBal) {	
		balance = accBal;
	}

	void setRate(double accRate) {		
		rate = accRate;
	}

	void deposit(double dep) {		
		balance += dep;
	}

	void withdraw(double wit) {		
		balance -= wit;
	}

	String getType() {	
		return type;
	}

	double getBalance() {
		return balance;
	}

	double getRate() {		
		return rate;
	}
}