import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends RequestHandler {

    @Override
    public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
        Lector lector = new Lector(request.getParameter("name"), request.getParameter("firstname"));
        getService().add(lector);
        return "OK";
    }

}
