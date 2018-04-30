
public class Checking extends Account {
	
	
	public Checking() {
		
	}
	
	String getType() {	
		return "checking";
	}
	
	double getStudentRate(Student account) {		
		return 0;
	}
	
	double getRate(User account) {
		return 0;
	}
	
	double getBalance() {
		return super.balance;
	}
	
	boolean transfer(Savings savings, double amount) {
		if(amount > balance) {
			return false;
		} else {
			withdraw(amount);
			savings.deposit(amount);
			return true;
		}
	}
	
	
	

}
