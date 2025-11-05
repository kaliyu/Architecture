package entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Formation {

    @Id @GeneratedValue
    @Column(name = "IDFORM")
    private String idForm;

    @Column(name = "INTITULEFORM")
    private String intituleForm;

    @ManyToMany(mappedBy = "formations")
    private List<Etudiant> inscrits;

    public Formation() {
    }

    public Formation(String idForm, String intituleForm) {
        this.idForm = idForm;
        this.intituleForm = intituleForm;
    }

    public String getIdForm() {
        return idForm;
    }

    public void setIdForm(String idForm) {
        this.idForm = idForm;
    }

    public String getIntituleForm() {
        return intituleForm;
    }

    public void setIntituleForm(String intituleForm) {
        this.intituleForm = intituleForm;
    }


    public List<Etudiant> getInscrits() {
        return inscrits;
    }

    public void setInscrits(List<Etudiant> inscrits) {
        this.inscrits = inscrits;
    }
}
