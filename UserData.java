import java.util.HashMap;

public class UserData {

    HashMap<String,String>  logininfo = new HashMap<String,String>();

   
    public UserData() {

      logininfo.put("Agglasd","123");
      logininfo.put("tzinap","456");

    }
    
   protected HashMap<String,String> getUserData() {

    return logininfo;

   }


}
    

