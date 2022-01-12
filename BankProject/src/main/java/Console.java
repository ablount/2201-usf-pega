
public class Console {

	public static void main(String[] args) {
		
		
		
		/*while (true){
		
			Menu.welcomeMenu();
			System.out.println();
			System.out.println("__________________________________");
			System.out.println();
		}*/

		

		BankAccount myTestAccount = new BankAccount ("Allison Blount", "23432", 100000);
		
		
		myTestAccount.viewAccountDetails();
		myTestAccount.checkBalance();
		myTestAccount.withdraw();
		myTestAccount.deposit();
		myTestAccount.transfer();
	}

}
