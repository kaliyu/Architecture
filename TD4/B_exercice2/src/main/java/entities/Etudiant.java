package entities;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "ETUDIANT")
public class Etudiant {

    @Id
    @Column(name = "NUMETU")
    private Long numEtu;

    @Column(name = "PRENOMETU")
    private String prenom;

    @Column(name = "NOMETU")
    private String nom;

    @ManyToMany(mappedBy = "etudiants")
    private Set<Groupe> groupes;

    @ManyToMany
    @JoinTable(
            name = "INSCRITS", // nom de la table de jointure
            joinColumns = @JoinColumn(name = "NUMETU"), // clé étrangère vers Etudiant
            inverseJoinColumns = @JoinColumn(name = "IDFORM") // clé étrangère vers Formation
    )
    private Set<Formation> formations;

    public Etudiant() {}

    public Long getNumEtu() {
        return numEtu;
    }

    public void setNumEtu(Long numEtu) {
        this.numEtu = numEtu;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Set<Formation> getFormations() {
        return formations;
    }

    public void setFormations(Set<Formation> formations) {
        this.formations = formations;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Groupe> getGroupes() {
        return groupes;
    }

    public void setGroupes(Set<Groupe> groupes) {
        this.groupes = groupes;
    }
}
