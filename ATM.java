import java.text.NumberFormat;
import java.util.Scanner;

public class ATM  {


	public static void main(String[] args) {

		
		//formats numbers
		NumberFormat formatter = NumberFormat.getCurrencyInstance();
		Scanner sc = new Scanner(System.in);
		
		//get name and id 
		System.out.println("Enter name");
		String name = sc.next();
		System.out.println("Enter ID");
		int id = sc.nextInt();
		
		System.out.println("Welcome " +  name + ".");
		
		//randomly decide what kind of user 
		Student user = new Student(name,id);
		
		//Constructs accounts and sets their balance (see account.java)
		Checking checking = new Checking();
		checking.setBalance();
		Savings savings = new Savings();
		savings.setBalance();
		
		boolean session = true;
		while (session) {
			System.out.print("========================\n"
							 +"Welcome to the Bank! \n \n"
							 +"Menu: \n \n"
							 + "1. Deposit Money \n"
							 + "2. Withdraw Money \n"
							 + "3. Transfer Funds \n"
							 + "4. Check Account Balance\n"
							 + "5. Check Rate\n"
							 + "6. End Session\n"
							 + "========================\n"
							 + "\nEnter selection: ");

			int selection = sc.nextInt(); 
			
			while(selection < 1 || selection > 6) {
				System.out.println("Invalid input, please put in a number from 1-6");
				selection = sc.nextInt();
			}
			
			switch (selection) {
				case 1:
					System.out.print("Enter (1) for Savings or (2) for Checking: ");
					int depAccount = sc.nextInt();
					if (depAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

						System.out.println("How much money would you like to deposit?");
						double deposit = sc.nextDouble();

						savings.deposit(deposit);

						System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
					}
					else if (depAccount == 2) {
						
						System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

						System.out.println("How much money would you like to deposit?");
						double deposit = sc.nextDouble();

						checking.deposit(deposit);

						System.out.println("\nChecking balance is now: " + formatter.format(checking.getBalance()) + "\n");
					}
					break;

				case 2: //Withdrawal 
					System.out.print("\nEnter (1) for Savings or (2) for Checking: ");
					int witAccount = sc.nextInt();

					if (witAccount == 1) {

						System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

						System.out.println("How much money would you like to withdraw?");
						double withdraw = sc.nextDouble();

						boolean success = savings.withdraw(withdraw);
						while(!success) {
							System.err.println("Insufficient funds. Your balance is " + formatter.format(savings.getBalance()) + "\n");
							withdraw = sc.nextDouble();
							success = savings.withdraw(withdraw);
						}
						System.out.println("\nYour Savings balance is now: " + formatter.format(savings.getBalance()) + "\n");
					}
					else if (witAccount == 2) {
						
						System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

						System.out.println("How much money would you like to withdraw?");
						double withdraw = sc.nextDouble();
						checking.withdraw(withdraw);
						boolean success = checking.withdraw(withdraw);
						while(!success) {
							System.err.println("Insufficient funds. Your balance is " + formatter.format(checking.getBalance()) + "\n");
							withdraw = sc.nextDouble();
							success = checking.withdraw(withdraw);
						}

						System.out.println("\nYour Checking balance is now: " + formatter.format(checking.getBalance()) + "\n");
					}
					break;

				case 3:
					System.out.print("\nWhich account do you wish to transfer funds from? (1) for Savings or (2) for Checking: ");
					int tranAccount = sc.nextInt();
					if (tranAccount == 1) {
						System.out.println("\nYour current Savings balance is: " + formatter.format(savings.getBalance()) + "\n");

						System.out.print("How much money do you wish to transfer from Savings to Checking?: ");
						double tranAmount = sc.nextDouble();
					
						boolean success = checking.transfer(savings, tranAmount);
						
						while(!success) {
							System.err.println("Insufficient funds. Your balance is " + formatter.format(savings.getBalance()));
							tranAmount = sc.nextDouble();
							success = savings.transfer(checking, tranAmount);
						}
						
						if(success) {
							System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Checking to Savings");
						}
						
	
						System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Savings to Checking");

						System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
						System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");

					}
					else if (tranAccount == 2) {

						System.out.println("\nYour current Checking balance is: " + formatter.format(checking.getBalance()) + "\n");

						System.out.print("How much money do you wish to transfer from Checking to Saving?: ");
						double tranAmount = sc.nextDouble();

						boolean success = checking.transfer(savings, tranAmount);
						
						while(!success) {
							System.err.println("Insufficient funds. Your balance is " + formatter.format(checking.getBalance()));
							tranAmount = sc.nextDouble();
							success = checking.transfer(savings, tranAmount);
							
						}
						
						if(success) {
							System.out.println("\nYou successfully transferred " + formatter.format(tranAmount) + " from Checking to Savings");
						}
						
						System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
						System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");
				}
					break;
								
				case 4:
					System.out.println("\nChecking Balance: " + formatter.format(checking.getBalance()));
					System.out.println("Savings Balance: " + formatter.format(savings.getBalance()) + "\n");	
					break;

				case 5:
					System.out.println("Enter 1 for Savings Rate, 2 for Checking Rate");
					int inp = sc.nextInt();
					double rate;
					while(!(inp == 1 || inp == 2)) {
						System.err.println("Invalid input \n");
						inp = sc.nextInt();
					}
					if(inp == 1) {
						rate = user.getSavingsRate();
					} else {
						rate= user.getCheckingRate();
					}
					System.out.println("Rate is " + rate);
					break;
				case 6:
					session = false;
					break;

			}				 	
			

		}

		System.out.println("\nThank you for banking with us, " + name + " have a great day!\n");

	}
}
