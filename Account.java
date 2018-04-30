import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Account {
	
	double balance;
	double rate;
	
	public Account() {
		

	}


	void setBalance() {	
		//   random generate number from 100-1000
		//   to simulate a real bank account interaction with user
		
		balance = ThreadLocalRandom.current().nextInt(100, 1001);
		
		System.out.println(balance + " balanace generated and set");
	}


	void deposit(double dep) {		
		balance += dep;
	}

	void withdraw(double wit) {		
		balance -= wit;
	}

	double getBalance() {
		return balance;
	}


}