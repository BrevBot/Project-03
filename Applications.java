import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.Random;
public class Applications {
	/*
	 * Brevin Blalock 
	 * CS 160 – 02/03/04, Spring Semester 2019
	 * Project 3: At the ATM Machine
	 *
	 * Description. <Summarize the purpose of the class here.>
	 *
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String title = "Client Window";
		Account acc = new Account();
		ATM atm = null;
		atm = new ATM();
		boolean client = true;
		boolean transactionRequired;
		
		while (client) {
			transactionRequired = true;
			
			int question = JOptionPane.showConfirmDialog(null, "Would you like to open an account?\n"
					+ "The minimum deposit is 100 dollars.\n"
					+ "If you have an account please click Cancel", title, JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(question == JOptionPane.YES_OPTION) {
				
				String depoAm = JOptionPane.showInputDialog(null, "Please enter the amount for deposit\n"
						+ "Please take note a PIN code will be issued for you");
				acc.account();
				
			} else if (question == JOptionPane.NO_OPTION) {
				
				System.out.println("THe process terminates\nGood Bye!");
				System.exit(0);
				
			} else if (acc == null) {
				
				JOptionPane.showMessageDialog(null, "Sorry, you do not have an account");
				client = false;
				
			} 
			
			while (transactionRequired) {
				
				int TrQuestion = JOptionPane.showConfirmDialog(null, "Please click YES for a transaction\nClick No to exit current Process", title, JOptionPane.YES_NO_OPTION);
				
				if(TrQuestion == JOptionPane.NO_OPTION) {
					
					transactionRequired = false;
					
				} 
				
				if (TrQuestion == JOptionPane.YES_OPTION) {
					
					
					atm.transaction();
					
				}
			}
		}
		
		
	}
}

	  class Account {
		 
		  
		 int pin;
		 double balance;
		 String title = "Client Window";
		 
		 @SuppressWarnings("unused")
		private ATM atm = null;
		 
		 
		public void createPin() {
			
			
			
			Random randomNumbers = new Random();
			
			pin = randomNumbers.nextInt(9999)+0;
			
			
		}
		
		public int getPin() {
			
			return pin;
		}
		
		public void setBalance() {
			
			Random randomNumbers = new Random();
			balance = randomNumbers.nextInt(999)+1;
			
		}
		
		public void showBalance() {
			
			JOptionPane.showMessageDialog(null, "Your current balance is " + balance);
			System.out.println("Enter the bills here");
		}
		
		public void deposit(int billTotal) {
			
			atm = new ATM();
			balance = balance + billTotal;
			
			
		}
		
		public void withdraw(String withDraw) {
			
			balance = balance - Double.parseDouble(withDraw);
			
		}
		
		public void account() {
			
			createPin();
			
			JOptionPane.showMessageDialog(null, "Take note of your PIN:\n" + pin);
				
			
		}
	 }
	  
	  class ATM {
		  
		  String fig5;
		  
		  Account acc = null;
		  int billCalc;
		  int billTotal;
		  
		  
		  public void transaction() {
			  
			acc = new Account();
			
			String pinCheck;
			
			
			String billRead = null;
			
			
			
			
			  
			fig5 = JOptionPane.showInputDialog("Please enter W or w to withdraw\nEnter D or d for deposit");
			
			@SuppressWarnings("resource")
			Scanner keyboard = new Scanner(System.in);
			
			//IF statement for a withdrawl 
			if (fig5.equals("W") || fig5.equals("w")) {
				
			//Displays figure 7
			System.out.println("Please enter your PIN code here:");
			pinCheck = keyboard.nextLine();
			int Pinchek = Integer.parseInt(pinCheck);
			
				if (acc.getPin() == Pinchek) {
					String withDraw = JOptionPane.showInputDialog("Please Enter the amount you want to withdraw");
					
					acc.withdraw(withDraw);
					acc.showBalance();
				} else {
					System.out.println("Wrong PIN, transaction aborted");
				}
			}
			
			//IF statement for a deposit
			if (fig5.equals("D") || fig5.equals("d")) {
				
				//Displays figure 11
				JOptionPane.showMessageDialog(null, "We accept the following dollar bills:\n"
						+ "1, 5, 10, 20, 50, 100\n"
						+ "Please insert the bill on the console\n"
						+ "Enter any other number to stop depositing");
				acc.showBalance();
				billRead = keyboard.nextLine();
				
				while (billRead.equals("1") || billRead.equals("5") || billRead.equals("10") || billRead.equals("20") || billRead.equals("50") || billRead.equals("100")) {
					
					billCalc = keyboard.nextInt();
					
					if (billRead != "1" || billRead != "5" || billRead != "10" || billRead != "20" || billRead != "50" || billRead != "100") {
						
						break;

					}
					
					
				} 
				
				billTotal += billCalc;
				
				acc.deposit(billTotal);
			
				
				
				
			}
					
			
		  }
	  }
	
