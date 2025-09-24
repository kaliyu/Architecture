package services;

import org.springframework.stereotype.Service;

public class Service2 {
    private int nbInvocation;


    public void Service2(){}

    public void incrementNbInvocation(){
        setNbInvocation(getNbInvocation() + 1);
    }


    public int getNbInvocation() {
        return nbInvocation;
    }

    public void setNbInvocation(int nbInvocation) {
        this.nbInvocation = nbInvocation;
    }
}
