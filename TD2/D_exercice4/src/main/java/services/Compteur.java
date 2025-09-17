package services;

import org.springframework.stereotype.Service;

@Service
public class Compteur {
    private int nbInvocation;


    public Compteur(){}

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
