package servlets;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = {"/"})
public class Exo3Servlet extends HttpServlet {
    private String aDeviner=null;
    private StringBuilder devine=null;
    private int nbEssaisRestants = 10;
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
        } else if (nbEssaisRestants <=1) {

            request.setAttribute("perdu", "Vous avez perdu !");
            request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
        }else{
            switch (todo){
                case "mot":
                    setaDeviner(request.getParameter("lemot"));
                    request.setAttribute("nbessai", nbEssaisRestants);
                    request.setAttribute("devine", devine);
                    request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request,response);
                    break;
                case "char":
                    char caractere = request.getParameter("lecaractere").charAt(0);
                    test(caractere);
                    request.setAttribute("nbessai", nbEssaisRestants);
                    request.setAttribute("devine", devine);
                    if(devine.toString().equals(aDeviner)){
                        request.setAttribute("perdu", "Vous avez Gagné !");
                        request.getRequestDispatcher("/WEB-INF/pendu.jsp").forward(request,response);
                    }else {
                        request.getRequestDispatcher("/WEB-INF/essai.jsp").forward(request,response);
                    }

            }
        }
    }


    private void setaDeviner(String Deviner) {
        this.aDeviner=Deviner;
        this.devine=new StringBuilder("_".repeat(aDeviner.length()));
    }

    private boolean test(char carac){
        boolean res=false;
        int last=aDeviner.indexOf(carac,0);
        while (last!=-1) {
            res = true;
            devine.setCharAt(last, carac);
            last=aDeviner.indexOf(carac,last+1);
        }
        if (!res) {
            nbEssaisRestants--;
        }
        return aDeviner.equals(devine.toString());
    }
}
