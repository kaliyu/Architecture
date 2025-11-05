package entities;

import jakarta.persistence.*;

import java.util.List;
import java.util.Set;

@Entity
@Table(name = "GROUPE")
public class Groupe {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDGROUPE")
    private Long id;

    @Column(name = "INTITULE")
    private String intitule;

    // Relation ManyToMany avec Etudiant via la table MEMBRES
    @ManyToMany
    @JoinTable(
            name = "MEMBRES",
            joinColumns = @JoinColumn(name = "IDGROUPE"),           // clé de cette entité
            inverseJoinColumns = @JoinColumn(name = "IDMEMBRE")     // clé de l'autre entité
    )
    private Set<Etudiant> etudiants;

    public Groupe() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    public Set<Etudiant> getEtudiants() {
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
    }

}
