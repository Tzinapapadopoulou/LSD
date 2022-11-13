import java.util.Scanner;
import java.util.HashMap;

public class Login {

        HashMap<String,String> logininfo = new HashMap<String,String>();

        public Login(HashMap<String,String> loginInfoOriginal) {

          logininfo = loginInfoOriginal;
        }

        public void random() {

            boolean done = false;

            Scanner input = new Scanner(System.in);

            while (done == false) {

            System.out.println("Username:");
            String username = input.nextLine();
            System.out.println("Password");
            String password = input.nextLine();

            if(logininfo.containsKey(username)) {
                if(logininfo.get(username).equals(password)) {
                    System.out.println("login succesful");
                    done = true;
                } else {
                    System.out.println("Wrong password");
                }
            } else {
                System.out.println("invalid username");
            }

            }    
        }

    
}