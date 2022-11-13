public class Main {
    public static void main(String[] args) {

        UserData userdata = new UserData();

        Login login = new Login(userdata.getUserData());

        login.random();


    }
}
