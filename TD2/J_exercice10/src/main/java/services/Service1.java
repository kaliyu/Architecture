package services;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Service1 {

    private Map<String,String> users;

    public Service1(){
        users=new HashMap<>();
        users.put("alice","alice");
        users.put("bob","bob");
    }


    public boolean checkLP(String login,String password) {
        String pwd=users.get(login);
        return ((pwd!=null) && (pwd.equals(password)));
    }

}

