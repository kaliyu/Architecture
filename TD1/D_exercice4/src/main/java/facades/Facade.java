package facades;

public class Facade {
    public static Facade instance=null;
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants = 10;

    public static synchronized Facade getInstance(){
        if (instance==null) {
            instance=new Facade();
        }
        return instance;
    }

    public void getaDeviner(String Deviner) {
        this.aDeviner=Deviner;
        this.setDevine(new StringBuilder("_".repeat(aDeviner.length())));
    }

    public boolean gettest(char carac){
        boolean res=false;
        int last= getaDeviner().indexOf(carac,0);
        while (last!=-1) {
            res = true;
            getDevine().setCharAt(last, carac);
            last= getaDeviner().indexOf(carac,last+1);
        }
        if (!res) {
            setNbEssaisRestants(getNbEssaisRestants() - 1);
        }
        return getaDeviner().equals(getDevine().toString());
    }

    public String getaDeviner() {
        return aDeviner;
    }

    public StringBuilder getDevine() {
        return devine;
    }

    public void setDevine(StringBuilder devine) {
        this.devine = devine;
    }

    public int getNbEssaisRestants() {
        return nbEssaisRestants;
    }

    public void setNbEssaisRestants(int nbEssaisRestants) {
        this.nbEssaisRestants = nbEssaisRestants;
    }
}
