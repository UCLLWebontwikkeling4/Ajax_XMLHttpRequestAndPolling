import java.io.IOException;
import java.util.Locale;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Controller")
public class Controller extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private LectorRepository lectorRepository = new LectorRepository();
    private HandlerFactory handlerFactory = new HandlerFactory();

    public Controller() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String destination = "index.jsp";
        String command = (request.getParameter("command"));

        if (command != null) {
                RequestHandler handler = handlerFactory.getHandler(command, lectorRepository);
                destination = handler.handleRequest(request, response);
        }

        if (destination.contains(".jsp")) {
            RequestDispatcher view = request.getRequestDispatcher(destination);
            view.forward(request, response);
        }
        else {
            response.setContentType("application/json");
            response.getWriter().write(destination);
        }
    }
}
