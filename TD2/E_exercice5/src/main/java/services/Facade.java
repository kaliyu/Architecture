package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class Facade {
    @Autowired
    private Service2 service2;

    @Autowired
    private Service1 service1;

    public boolean checkLP(String login,String password) {
        return service1.checkLP(login,password);
    }
    public List<String> getHumeurs() {
        return service1.getHumeurs();
    }

    public int getNbInvocation() {
        return service2.getNbInvocation();
    }

    public void incrementNbInvocation(){
        service2.incrementNbInvocation();
    }

}
