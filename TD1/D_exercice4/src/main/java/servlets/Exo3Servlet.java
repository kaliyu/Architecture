package servlets;

import facades.Facade;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private final Facade facade=Facade.getInstance();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWhatever(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doWhatever(request,response);
    }

    private void doWhatever(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String todo=request.getParameter("TODO");

        if(todo==null){
            request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
        } else if ( facade.getNbEssaisRestants() <= 1) {

            request.setAttribute("perdu", "Vous avez perdu !");
            request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
        }else{
            switch (todo){
                case "mot":
                    facade.getaDeviner(request.getParameter("lemot"));
                    request.setAttribute("nbessai", facade.getNbEssaisRestants());
                    request.setAttribute("devine", facade.getDevine());
                    request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request,response);
                    break;
                case "char":
                    char caractere = request.getParameter("lecaractere").charAt(0);
                    facade.gettest(caractere);
                    request.setAttribute("nbessai", facade.getNbEssaisRestants());
                    request.setAttribute("devine", facade.getDevine());
                    if(facade.getDevine().toString().equals(facade.getaDeviner())){
                        request.setAttribute("perdu", "Vous avez Gagné !");
                        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
                    }else {
                        request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request,response);
                    }

            }
        }
    }
}
