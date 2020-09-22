package project;

import java.util.Scanner;
import java.util.ArrayList; 

public class Main {

	static Scanner scanner = new Scanner(System.in);

	static ArrayList<Employee> storeEmployee = new ArrayList <Employee>();
	
	public static void main(String[] args) {
		MainMenu();
	}

	public static void MainScreen() {
		System.out.println("Main Menu");
		System.out.println(
				"Welcome to DART, your good old games rental system. \nThe competition has no steam to keep up!");
		System.out.println("Please specify your role by entering one of the options given");
		System.out.println("1. Enter ”M” for Manager");
		System.out.println("2. Enter ”E” for Employee");
		System.out.println("3. Enter ”C” for Customer");
		System.out.println("4. Enter ”X” to exit system");
	}

	public static void ManagerScreen() {
		System.out.println("Manager Screen - Type one of the options below");
		System.out.println("1. Add an employee");
		System.out.println("2. View all employees");
		System.out.println("3. Remove employee");
		System.out.println("4. Return to Main Menu");
	}

	public static void EmployeeScreen() {
		System.out.println("Employee Screen - Type one of the options below:");
		System.out.println("1. Register a game");
		System.out.println("2. Remove a game");
		System.out.println("3. Register a customer");
		System.out.println("4. Remove a customer");
		System.out.println("5. Show total rent profit");
		System.out.println("6. View all games");
		System.out.println("7. Return to Main Menu");
	}

	public static void CustomerScreen() {
		System.out.println("Customer Screen - Type one of the options below:");
		System.out.println("1. Rent a game");
		System.out.println("2. Return a game");
		System.out.println("3. Return to Main Menu");
	}

	public static void MainMenu() {
		String choice = "";
		
		while (!choice.equals("X")) {
			MainScreen();
			choice = scanner.nextLine();
			System.out.println(storeEmployee);

			switch (choice.toUpperCase()) {
			case "M":
				System.out.println("Please enter password");
				String password = scanner.nextLine();
				if (password.contentEquals("admin1234")) {
					ManagerScreen();
					// else "invalid password and return to main screen? 
					
					int option = scanner.nextInt();
					scanner.nextLine(); // next.Line gäller för nextint och nextdouble
					
					if (option == 1) { // add employee
						addEmployee();

					} else if (option == 2) { // view all employee
						System.out.println(storeEmployee);
					} else if (option == 3) { // remove employee
						removeEmployee();
						
					} else if (option == 4) { // return to main menu
						break;
					}

				}
			}
		}
	}
	private static void addEmployee() {
		System.out.println(
				"Please type the Employee's: \nID: \nName: \nBirth year: \nAddress: \nMonthly gross salary:");
		int id = scanner.nextInt(); 
		scanner.nextLine();
		String name = scanner.nextLine();
		int birthYear = scanner.nextInt();
		scanner.nextLine();
		String address = scanner.nextLine();
		double salary = scanner.nextDouble();
		scanner.nextLine();
		System.out.println(id + " " + name +" " + birthYear + " " + address + " " + salary);
		
	
		Employee person = new Employee(id, name, birthYear, address, salary);
		System.out.println(person.getAddress());
		storeEmployee.add(person);
	}
	private static void removeEmployee() {
		System.out.println("Please enter Employee's ID in order to remove employee:");
		int removeId = scanner.nextInt();
		boolean foundId = false;
		for(Employee person : storeEmployee) {
			if (person.getId() == removeId)			
				storeEmployee.remove(person);
			foundId = true;
			break;
		}
	
	if(!foundId) {
		System.out.println("Employee with" + removeId + "was not found");
	}
}
}		
	