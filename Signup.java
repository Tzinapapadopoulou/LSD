package net.codejava.sql;

import java.util.Scanner;

public class Signup {
	
	static UserEclipse register = new UserEclipse();
	static int i = 1;
	static SQLConnector connector = new SQLConnector();

	public static void main(String[] args) throws Exception {
		
		   try (Scanner scanner = new Scanner(System.in)) {
			System.out.print(" Enter firstName => ");
	        String firstName = scanner.nextLine();
	        register.setFirstName(firstName);

	        System.out.print(" Enter lastName => ");
	        String lastName = scanner.nextLine();           
	        register.setLastName(lastName);

	        System.out.print(" Enter userName => ");
	        String userName = scanner.nextLine();
	        register.setUserName(userName);

	        System.out.print(" Enter password => ");
	        String password = scanner.nextLine();
	        register.setPassword(password);

	        System.out.print(" Enter email => ");
	        String email = scanner.nextLine();
	        register.setEmail(email);

	        System.out.print(" Enter birthDay => ");
	        String birthDay = scanner.nextLine();
	        register.setBirthDay(birthDay);

	        System.out.print(" Enter sex => ");
	        int sex = scanner.nextInt();
	        register.setSex(sex);

	        i++;
	        
	        connector.addUser( firstName, lastName, userName, password, email, birthDay, sex);
		}

	}

}

