package controllers;

import dtos.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import services.Facade;

import java.util.List;

@Controller
@SessionAttributes({"courant","humeurcourant","compteur"})
@RequestMapping("/")
public class Exercice4Controller {

    @Autowired
    private Facade facade;
    @RequestMapping("")
    public String toLogin(Model model) {
        List<String> humeurs = facade.getHumeurs();
        model.addAttribute("humeurs", humeurs);
        return("login");
    }

    // on passe un objet user en paramètre : mapping automatique des champs du formulaire
    // on joue aussi avec les messages d'erreurs (BindingResult) ...
    @RequestMapping("login")
    public String checkLP(User user, Model model){
        facade.incrementNbInvocation();
        if (facade.checkLP(user.getLogin(),user.getPassword())) {
            // on place courant dans le modèle, mais il s'agit d'un attribut de session, il se retrouve ainsi conservé en session
            model.addAttribute("courant",user.getLogin());
            model.addAttribute("username",user.getLogin());
            model.addAttribute("humeurcourant",user.getHumeur());
            model.addAttribute("compteur",facade.getNbInvocation());
            return "welcome";
        } else {
            // on ajoute un simple message d'erreur au modèle...
            model.addAttribute("error","Les informations saisies ne correspondent pas à un utilisateur connu.");
            return "login";
        }
    }

    @RequestMapping("simplecheck")
    public String simpleCheck(@SessionAttribute("courant") String courant,Model model){
        facade.incrementNbInvocation();
        System.out.println(courant);
        model.addAttribute("username",courant);
        return "welcome";
    }

    @RequestMapping("logout")
    public String logout(SessionStatus status,Model model) {
        facade.incrementNbInvocation();
        List<String> humeurs = facade.getHumeurs();
        model.addAttribute("humeurs", humeurs);
        model.addAttribute("compteur",facade.getNbInvocation());
        status.setComplete();
        return "login";
    }
}
