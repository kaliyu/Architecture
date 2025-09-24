package services;

import java.util.List;


public class Facade {

    private Service2 service2;
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

    public void setService2(Service2 service2) {
        this.service2 = service2;
    }

    public void setService1(Service1 service1) {
        this.service1 = service1;
    }
}
