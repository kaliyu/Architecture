package servlets;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import facades.MessageFacade;

import java.io.IOException;

@WebServlet(name = "MessageServlet", urlPatterns = {"/messages"})
public class MessageServlet extends HttpServlet {

    private static final String PASSWORD = "admin123";

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action) {
            case "add":
                String message = request.getParameter("message");
                MessageFacade.addMessage(message);
                break;

            case "clear":
                String password = request.getParameter("password");
                if (PASSWORD.equals(password)) {
                    MessageFacade.clearAllMessages();
                    request.setAttribute("success", "Tous les messages ont été supprimés.");
                } else {
                    request.setAttribute("error", "Mot de passe incorrect !");
                }
                break;
        }

        doGet(request, response); // après action, recharger la vue
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");

        switch (action == null ? "" : action) {
            case "showAll":
                request.setAttribute("allMessages", MessageFacade.getAllMessages());
                break;

            case "random":
                request.setAttribute("randomMessage", MessageFacade.getRandomMessage());
                break;
        }

        request.getRequestDispatcher("/WEB-INF/messages.jsp").forward(request, response);
    }
}
