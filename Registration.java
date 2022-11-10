
import java.util.Scanner;

public class Registration {

	static Register register = new Register();

    public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

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
            String sex = scanner.nextLine();
            register.setSex(sex);



    }
}




