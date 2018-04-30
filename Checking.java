
public class Checking extends Account {
	
	
	public Checking() {
		
	}
	
	String getType() {	
		return "checking";
	}
	
	double getRate() {		
		return 0;
	}
	
	double getBalance() {
		return super.balance;
	}
	

}
