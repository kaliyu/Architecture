package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
@WebServlet(urlPatterns = "/")
public class Exo2Servlet extends HttpServlet {
    private final String[] options={"Beau","Couvert","Pluie","Neige"};

    //Appel du constructeur pour faire les initialisations
    @Override
    public void init() throws ServletException {
        // Initialiser les compteurs une seule fois (au démarrage du serveur)
        Map<String, Integer> compteur = new HashMap<>();
        for (String opt : options) {
            compteur.put(opt, 0);
        }
        getServletContext().setAttribute("compteur", compteur);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        toJsp(request,response,null);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String meteoChoisie = request.getParameter("meteo");
        if (meteoChoisie != null) {
            Map<String, Integer> compteur = (Map<String, Integer>) getServletContext().getAttribute("compteur");
            if (compteur.containsKey(meteoChoisie)) {
                compteur.put(meteoChoisie, compteur.get(meteoChoisie) + 1);
            }
        }
        toJsp(request,response,meteoChoisie);

    }

    private void toJsp(HttpServletRequest request, HttpServletResponse response,String meteoChoisie) throws ServletException, IOException {
        request.setAttribute("options", options);
        request.setAttribute("selected", meteoChoisie);

        // On récupère le compteur de l'application et on le passe à la JSP
        Map<String, Integer> compteur = (Map<String, Integer>) getServletContext().getAttribute("compteur");
        request.setAttribute("compteur", compteur);

        request.getRequestDispatcher("WEB-INF/meteo.jsp").forward(request, response);
    }
}
