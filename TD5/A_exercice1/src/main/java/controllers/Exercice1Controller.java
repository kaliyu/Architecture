package controllers;

import entities.Employe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import services.Facade;

import java.util.List;

@Controller
public class Exercice1Controller {

    @Autowired
    private Facade facade;

    // Racine : redirige vers /employes
    @GetMapping("/")
    public String rootRedirect() {
        return "redirect:/employes";
    }

    // Liste de tous les employés
    @GetMapping("/employes")
    public String listeEmployes(Model model) {
        List<Employe> employes = facade.getAllEmployes();
        model.addAttribute("employes", employes);
        return "listeEmployes"; // JSP dans /WEB-INF/views/
    }

    // Détails d’un employé
    @GetMapping("/employes/{id}")
    public String afficherEmploye(@PathVariable("id") int id, Model model) {
        Employe employe = facade.getEmployeWithAllData(id);
        model.addAttribute("employe", employe);
        return "employeDetails"; // JSP dans /WEB-INF/views/
    }
}
