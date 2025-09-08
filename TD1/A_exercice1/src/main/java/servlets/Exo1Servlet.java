package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;

@WebServlet(urlPatterns = "/")
public class Exo1Servlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO appeler la jsp de login
        request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//TODO récupérer le login et le mdp et les comparer avec la paire stockée statiquement; appeler la jsp bonjour en cas de succès et la jsp de login sinon
        String id = request.getParameter("id");
        String mdp =  request.getParameter("mdp");
        String mdp_utilisateur = "azerty";
        String id_utilisateur = "tom";
        if (Objects.equals(mdp, mdp_utilisateur) && Objects.equals(id, id_utilisateur)) {
            request.setAttribute("who_is_there", id);
            request.getRequestDispatcher("/WEB-INF/bonjour.jsp").forward(request,response);
        }else{
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request,response);
        }
    }
}
