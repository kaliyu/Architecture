package services;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Facade {
    private static Facade instance=null;

    private Map<String,String> users;

    public List<String> getHumeurs() {
        return Arrays.asList("Content", "Triste", "Joyeux", "Colère");
    }

    private Facade(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }

    public static synchronized Facade getInstance() {
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
    }
}
