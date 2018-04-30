
public class Student extends User{

	public Student(String name, int id) {
		// TODO Auto-generated constructor stub
		super(name,id);
	}
	
	String getType() {
		return "student";
	}
	
	double getCheckingRate() {
		return 0;
	}
	
	double getSavingsRate() {
		return 1.5;
	}
	

}
