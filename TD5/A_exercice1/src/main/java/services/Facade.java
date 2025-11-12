package services;

import entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

@Service
public class Facade {
    @PersistenceContext
    EntityManager em;

    public List<Employe> getAllEmployes() {
        return em.createQuery("SELECT e FROM Employe e", Employe.class)
                .getResultList();
    }

    public Employe getEmployeWithAllData(int id) {
        String jpql = """
            SELECT DISTINCT e FROM Employe e
            LEFT JOIN FETCH e.telephones
            LEFT JOIN FETCH e.machine
            LEFT JOIN FETCH e.service
            LEFT JOIN FETCH e.adresse
            LEFT JOIN FETCH e.projetsEnCours
            WHERE e.idEmp = :id
        """;
        return em.createQuery(jpql, Employe.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
