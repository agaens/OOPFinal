
public class Savings extends Account{

	public Savings() {
		
	}

	double getStudentRate(Student account) {		
		return 0;
	}
	
	double getRate(User account) {
		return 0;
	}
	
	boolean transfer(Checking checking, double amount) {
		if(amount > balance) {
			return false;
		} else {
			withdraw(amount);
			checking.deposit(amount);
			return true;
		}
	}
	
}
